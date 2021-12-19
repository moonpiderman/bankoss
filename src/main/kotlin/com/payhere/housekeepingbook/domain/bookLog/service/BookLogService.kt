package com.payhere.housekeepingbook.domain.bookLog.service

import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.book.repository.BookRepository
import com.payhere.housekeepingbook.domain.bookLog.dto.BookLogDto
import com.payhere.housekeepingbook.domain.bookLog.model.BookLog
import com.payhere.housekeepingbook.domain.bookLog.repository.BookLogRepository
import org.springframework.stereotype.Service

@Service
class BookLogService(
    private val bookLogRepository: BookLogRepository,
    private val bookRepository: BookRepository,
) {
    fun addLog(addLogRequest: BookLogDto.AddLogRequest, book: Book) {
        if (book != null) {
            val title = addLogRequest.title
            val moneyType = addLogRequest.moneyType
            val money = addLogRequest.money
            val memo = addLogRequest.memo

            val newLog = bookLogRepository.save(
                BookLog(
                    title = title, moneyType = moneyType, money = money, memo = memo
                )
            )
            book.addLog(newLog)
            newLog.book = book
            bookRepository.save(book)
        }
    }
}
