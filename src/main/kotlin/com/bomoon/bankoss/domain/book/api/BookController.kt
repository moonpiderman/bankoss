package com.bomoon.bankoss.domain.book.api

import com.bomoon.bankoss.domain.book.dto.BookDto
import com.bomoon.bankoss.domain.book.service.BookService
import com.bomoon.bankoss.domain.bookLog.service.BookLogService
import com.bomoon.bankoss.domain.user.model.User
import com.bomoon.bankoss.global.auth.CurrentUser
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

@RestController
@RequestMapping("/api/book")
class BookController(
    private val bookService: BookService,
    private val bookLogService: BookLogService,
) {
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(
        @CurrentUser user: User,
        @Valid @RequestBody createRequest: BookDto.CreateRequest
    ): BookDto.BookResponse {
        return bookService.createBook(user, createRequest)
    }
}
