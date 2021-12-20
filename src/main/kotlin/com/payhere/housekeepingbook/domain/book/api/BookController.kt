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
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @PostMapping("/{bookId}/log/")
    fun addLog(
        @PathVariable("bookId") bookId: Long,
        @CurrentUser user: User,
        @Valid @RequestBody addLogRequest: BookLogDto.AddLogRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        bookLogService.addLog(addLogRequest, thisBook)
        return ResponseEntity(BookDto.BookResponse(thisBook, bookLogRepository), HttpStatus.CREATED)
    }

    @PutMapping("/{bookId}/{logId}/")
    fun modifyLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
        @Valid @RequestBody modifyLogRequest: BookLogDto.ModifyLogRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.editLog(modifyLogRequest, thisLog)
        return ResponseEntity(BookDto.BookResponse(thisBook, bookLogRepository), HttpStatus.OK)
    }

    @DeleteMapping("/{bookId}/{logId}/")
    fun deleteLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.deleteLog(thisLog)
        return ResponseEntity(BookDto.BookResponse(thisBook, bookLogRepository), HttpStatus.OK)
    }
}
