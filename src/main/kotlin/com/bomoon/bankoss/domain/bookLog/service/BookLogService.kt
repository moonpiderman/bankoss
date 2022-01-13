package com.bomoon.bankoss.domain.bookLog.service

import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.book.repository.BookRepository
import com.payhere.housekeepingbook.domain.book.service.BookService
import com.payhere.housekeepingbook.domain.bookLog.dto.BookLogDto
import com.payhere.housekeepingbook.domain.bookLog.exception.AlreadyDeletedLogException
import com.payhere.housekeepingbook.domain.bookLog.exception.CannotFindBookLogException
import com.payhere.housekeepingbook.domain.bookLog.exception.DidNotDeleteLogException
import com.payhere.housekeepingbook.domain.bookLog.model.BookLog
import com.payhere.housekeepingbook.domain.bookLog.repository.BookLogRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.math.abs

@Service
class BookLogService(
    private val bookLogRepository: BookLogRepository,
    private val bookRepository: BookRepository,
    private val bookService: BookService,
) {
    fun addLog(addLogRequest: BookLogDto.AddLogRequest, book: Book) {
        if (book != null) {
            val category = addLogRequest.category
            val moneyType = addLogRequest.moneyType
            val money = addLogRequest.money
            val memo = addLogRequest.memo

            val newLog = bookLogRepository.save(
                BookLog(
                    category = category, moneyType = moneyType, money = money, memo = memo
                )
            )
            book.addLog(newLog)
            newLog.book = book
            book.balance = bookService.calculateBalance(book.balance, moneyType, money)
            bookRepository.save(book)
        }
    }

    fun editLog(modifyLogRequest: BookLogDto.ModifyLogRequest, log: BookLog, book: Book) {
        var type: Boolean = log.moneyType
        var moneyForBal: Int = log.money
        if (modifyLogRequest.category != null) log.category = modifyLogRequest.category
        if (modifyLogRequest.moneyType != null) {
            type = !(modifyLogRequest.moneyType xor log.moneyType)
            log.moneyType = modifyLogRequest.moneyType
        }
        if (modifyLogRequest.money != null) {
            if (type) moneyForBal += modifyLogRequest.money
            else moneyForBal -= modifyLogRequest.money
            log.money = modifyLogRequest.money
        }
        if (modifyLogRequest.memo != null) log.memo = modifyLogRequest.memo

        val newBalance = bookService.calculateBalance(book.balance, type, abs(moneyForBal))
        book.balance = newBalance
        bookLogRepository.save(log)
    }

    fun deleteLog(log: BookLog, book: Book) {
        if (!log.isDeleted) throw AlreadyDeletedLogException()
        log.isDeleted = false

        val newBalance = bookService.calculateBalance(book.balance, !log.moneyType, log.money)
        book.balance = newBalance
        bookLogRepository.save(log)
    }

    fun restoreLog(log: BookLog, book: Book) {
        if (log.isDeleted) throw DidNotDeleteLogException()
        log.isDeleted = true

        val newBalance = bookService.calculateBalance(book.balance, log.moneyType, log.money)
        book.balance = newBalance
        bookLogRepository.save(log)
    }

    fun getThisLog(id: Long): BookLog {
        return bookLogRepository.findByIdOrNull(id) ?: throw CannotFindBookLogException()
    }
}
