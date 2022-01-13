package com.bomoon.bankoss.domain.book.api

import com.bomoon.bankoss.domain.book.dto.BookDto
import com.bomoon.bankoss.domain.book.service.BookService
import com.bomoon.bankoss.domain.bookLog.dto.BookLogDto
import com.bomoon.bankoss.domain.bookLog.service.BookLogService
import com.bomoon.bankoss.domain.user.model.User
import com.bomoon.bankoss.global.auth.CurrentUser
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
) {
    @PostMapping("/")
    fun createBook(
        @CurrentUser user: User,
        @Valid @RequestBody createRequest: BookDto.CreateRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val newBook = bookService.createBook(user, createRequest)
        return ResponseEntity(BookDto.BookResponse(newBook), HttpStatus.CREATED)
    }

    @PostMapping("/createBook/{bookId}/log/")
    fun addLog(
        @PathVariable("bookId") bookId: Long,
        @CurrentUser user: User,
        @Valid @RequestBody addLogRequest: BookLogDto.AddLogRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        bookLogService.addLog(addLogRequest, thisBook)
        return ResponseEntity(BookDto.BookResponse(thisBook), HttpStatus.CREATED)
    }

    @PutMapping("/editLog/{bookId}/{logId}/")
    fun modifyLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
        @Valid @RequestBody modifyLogRequest: BookLogDto.ModifyLogRequest
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.editLog(modifyLogRequest, thisLog, thisBook)
        return ResponseEntity(BookDto.BookResponse(thisBook), HttpStatus.OK)
    }

    @DeleteMapping("/deleteLog/{bookId}/{logId}/")
    fun deleteLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.deleteLog(thisLog, thisBook)
        return ResponseEntity(BookDto.BookResponse(thisBook), HttpStatus.OK)
    }

    @PutMapping("/restore/{bookId}/{logId}/")
    fun restoreLog(
        @PathVariable("bookId") bookId: Long,
        @PathVariable("logId") logId: Long,
        @CurrentUser user: User,
    ): ResponseEntity<BookDto.BookResponse> {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        bookLogService.restoreLog(thisLog, thisBook)
        return ResponseEntity(BookDto.BookResponse(thisBook), HttpStatus.OK)
    }
}
