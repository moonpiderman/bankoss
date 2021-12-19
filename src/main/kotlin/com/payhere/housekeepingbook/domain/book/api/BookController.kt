package com.payhere.housekeepingbook.domain.book.api

import com.payhere.housekeepingbook.domain.book.repository.BookRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/book")
class BookController(
    private val bookRepository: BookRepository,
)
