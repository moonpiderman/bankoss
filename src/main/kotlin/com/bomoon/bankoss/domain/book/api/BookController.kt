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
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import javax.validation.Valid

@RestController
@RequestMapping("/api/book")
class BookController(
    private val bookService: BookService,
    private val bookLogService: BookLogService,
) {
    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun createBook(
        @CurrentUser user: User,
        @Valid @RequestBody createRequest: BookDto.CreateRequest
    ): BookDto.BookResponse {
        val newBook = bookService.createBook(user, createRequest)
        return BookDto.BookResponse(newBook)
    }

    @DeleteMapping("/deleteLog/{bookId}/{logId}/")
    @ResponseStatus(HttpStatus.OK)
    fun deleteLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
    ): BookDto.BookResponse {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.deleteLog(thisLog, thisBook)
        return BookDto.BookResponse(thisBook)
    }

    @PutMapping("/restore/{bookId}/{logId}/")
    @ResponseStatus(HttpStatus.OK)
    fun restoreLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
    ): BookDto.BookResponse {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.restoreLog(thisLog, thisBook)
        return BookDto.BookResponse(thisBook)
    }
}
