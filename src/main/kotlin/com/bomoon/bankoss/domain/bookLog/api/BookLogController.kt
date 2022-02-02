package com.bomoon.bankoss.domain.bookLog.api

import com.bomoon.bankoss.domain.book.dto.BookDto
import com.bomoon.bankoss.domain.book.service.BookService
import com.bomoon.bankoss.domain.bookLog.dto.BookLogDto
import com.bomoon.bankoss.domain.bookLog.service.BookLogService
import com.bomoon.bankoss.domain.user.model.User
import com.bomoon.bankoss.global.auth.CurrentUser
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/book_log")
class BookLogController(
    private val bookService: BookService,
    private val bookLogService: BookLogService,
) {
    @PostMapping("/create_log/book/{book_id}/")
    @ResponseStatus(HttpStatus.CREATED)
    fun addLog(
        @PathVariable("book_id") bookId: Long,
        @CurrentUser user: User,
        @Valid @RequestBody addLogRequest: BookLogDto.AddLogRequest,
    ): BookDto.BookResponse {
        val thisBook = bookService.getThisBook(bookId)
        return bookLogService.addLog(addLogRequest, thisBook)
    }

    @PutMapping("/edit_log/book/{book_id}/log/{log_id}/")
    @ResponseStatus(HttpStatus.OK)
    fun editLog(
        @PathVariable("book_id") bookId: Long,
        @PathVariable("log_id") logId: Long,
        @CurrentUser user: User,
        @Valid @RequestBody modifyLogRequest: BookLogDto.ModifyLogRequest
    ): BookDto.BookResponse {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        return bookLogService.editLog(modifyLogRequest, thisLog, thisBook)
    }

    @DeleteMapping("/delete_log/book/{book_id}/log/{log_id}/")
    @ResponseStatus(HttpStatus.OK)
    fun deleteLog(
        @PathVariable("book_id") bookId: Long,
        @PathVariable("log_id") logId: Long,
        @CurrentUser user: User,
    ): BookDto.BookResponse {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        return bookLogService.deleteLog(thisLog, thisBook)
    }

    @PutMapping("/restore/book/{book_id}/log/{log_id/")
    @ResponseStatus(HttpStatus.OK)
    fun restoreLog(
        @PathVariable("book_id") bookId: Long,
        @PathVariable("log_id") logId: Long,
        @CurrentUser user: User,
    ): BookDto.BookResponse {
        val thisBook = bookService.getThisBook(bookId)
        val thisLog = bookLogService.getThisLog(logId)
        return bookLogService.restoreLog(thisLog, thisBook)
    }
}
