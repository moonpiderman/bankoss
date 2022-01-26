package com.bomoon.bankoss.domain.bookLog.api

import com.bomoon.bankoss.domain.book.dto.BookDto
import com.bomoon.bankoss.domain.book.service.BookService
import com.bomoon.bankoss.domain.bookLog.dto.BookLogDto
import com.bomoon.bankoss.domain.bookLog.service.BookLogService
import com.bomoon.bankoss.domain.user.model.User
import com.bomoon.bankoss.global.auth.CurrentUser
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
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
}
