package com.bomoon.bankoss.domain.book.dto

import com.bomoon.bankoss.domain.book.model.Book
import com.bomoon.bankoss.domain.bookLog.dto.BookLogDto
import javax.validation.constraints.NotBlank

class BookDto {
    data class BookResponse(
        val id: Long,
        val title: String,
        val memo: String,
        val balance: Int,
        val logs: List<BookLogDto.LogResponse>,
    ) {
        constructor(book: Book) : this(
            id = book.id,
            title = book.title,
            memo = book.memo,
            balance = book.balance,
            logs = book.logs.map {
                BookLogDto.LogResponse(it)
            },
        )
    }

    data class BookSummaryResponse(
        val id: Long,
        val title: String,
        val balance: Int,
        val memo: String,
    ) {
        constructor(book: Book) : this(
            id = book.id,
            title = book.title,
            balance = book.balance,
            memo = book.memo,
        )
    }

    data class CreateRequest(
        @field:NotBlank
        val title: String,

        @field:NotBlank
        val memo: String = "",
    )
}
