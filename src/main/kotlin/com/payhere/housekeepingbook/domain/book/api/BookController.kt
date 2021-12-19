package com.payhere.housekeepingbook.domain.book.api

import com.payhere.housekeepingbook.domain.book.dto.BookDto
import com.payhere.housekeepingbook.domain.book.service.BookService
import com.payhere.housekeepingbook.domain.bookLog.dto.BookLogDto
import com.payhere.housekeepingbook.domain.bookLog.repository.BookLogRepository
import com.payhere.housekeepingbook.domain.bookLog.service.BookLogService
import com.payhere.housekeepingbook.domain.user.model.User
import com.payhere.housekeepingbook.global.auth.CurrentUser
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/book")
class BookController(
    private val bookService: BookService,
    private val bookLogService: BookLogService,
    private val bookLogRepository: BookLogRepository,
) {
    @PostMapping("/")
    fun createBook(
        @CurrentUser user: User,
        @Valid @RequestBody createRequest: BookDto.CreateRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val newBook = bookService.createBook(user, createRequest)
        return ResponseEntity(BookDto.BookResponse(newBook, bookLogRepository), HttpStatus.CREATED)
    }

    @PostMapping("/{id}/log/")
    fun addLog(
        @PathVariable("id") id: Long,
        @CurrentUser user: User,
        @Valid @RequestBody addLogRequest: BookLogDto.AddLogRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(id)
        bookLogService.addLog(addLogRequest, thisBook)
        return ResponseEntity(BookDto.BookResponse(thisBook, bookLogRepository), HttpStatus.CREATED)
    }
}
