package com.payhere.housekeepingbook.domain.bookLog.repository

import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.bookLog.model.BookLog
import org.springframework.data.jpa.repository.JpaRepository

interface BookLogRepository : JpaRepository<BookLog, Long?> {
    fun findBookLogByBookOrderByCreatedAt(book: Book): BookLog
}
