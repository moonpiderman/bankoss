package com.payhere.housekeepingbook.domain.bookLog.service

import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.book.repository.BookRepository
import com.payhere.housekeepingbook.domain.bookLog.dto.BookLogDto
import com.payhere.housekeepingbook.domain.bookLog.exception.AlreadyDeletedLogException
import com.payhere.housekeepingbook.domain.bookLog.exception.CannotFindBookLogException
import com.payhere.housekeepingbook.domain.bookLog.exception.DidNotDeleteLogException
import com.payhere.housekeepingbook.domain.bookLog.model.BookLog
import com.payhere.housekeepingbook.domain.bookLog.repository.BookLogRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookLogService(
    private val bookLogRepository: BookLogRepository,
    private val bookRepository: BookRepository,
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
            bookRepository.save(book)
        }
    }

    fun editLog(modifyLogRequest: BookLogDto.ModifyLogRequest, log: BookLog) {
        if (modifyLogRequest.category != null) log.category = modifyLogRequest.category
        if (modifyLogRequest.moneyType != null) log.moneyType = modifyLogRequest.moneyType
        if (modifyLogRequest.money != null) log.money = modifyLogRequest.money
        if (modifyLogRequest.memo != null) log.memo = modifyLogRequest.memo

        bookLogRepository.save(log)
    }

    fun deleteLog(log: BookLog) {
        if (!log.isActive) throw AlreadyDeletedLogException()
        log.isActive = false
        bookLogRepository.save(log)
    }

    // fun restoreLog(restoreLogRequest: BookLogDto.RestoreLogRequest, log: BookLog) {
    //     if (log.isActive) throw DidNotDeleteLogException()
    //     log.isActive = restoreLogRequest.isActive
    //     bookLogRepository.save(log)
    // }
    fun restoreLog(log: BookLog) {
        if (log.isActive) throw DidNotDeleteLogException()
        log.isActive = true
        bookLogRepository.save(log)
    }

    fun getThisLog(id: Long): BookLog {
        return bookLogRepository.findByIdOrNull(id) ?: throw CannotFindBookLogException()
    }
}
