package com.bomoon.bankoss.domain.user.dto

import com.payhere.housekeepingbook.domain.book.dto.BookDto
import com.payhere.housekeepingbook.domain.user.model.User
import javax.validation.constraints.NotBlank

class UserDto {
    data class Response(
        val id: Long,
        val email: String,
    ) {
        constructor(user: User) : this(
            id = user.id,
            email = user.email
        )
    }

    data class UserBooksResponse(
        val id: Long,
        val email: String,
        val books: List<BookDto.BookSummaryResponse>
    ) {
        constructor(user: User) : this(
            id = user.id,
            email = user.email,
            books = user.books.map { BookDto.BookSummaryResponse(it) },
        )
    }

    data class SignupRequest(
        @field:NotBlank
        val email: String,

        @field:NotBlank
        val password: String,
    )
}
