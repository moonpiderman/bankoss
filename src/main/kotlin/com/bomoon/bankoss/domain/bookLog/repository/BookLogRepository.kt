package com.bomoon.bankoss.domain.bookLog.repository

import com.bomoon.bankoss.domain.book.model.Book
import com.bomoon.bankoss.domain.bookLog.model.BookLog
import org.springframework.data.jpa.repository.JpaRepository

interface BookLogRepository : JpaRepository<BookLog, Long?> {
    fun findBookLogByBookOrderByCreatedAt(book: Book): BookLog
}
