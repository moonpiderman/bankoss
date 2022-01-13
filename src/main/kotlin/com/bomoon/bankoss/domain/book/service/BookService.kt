package com.bomoon.bankoss.domain.book.service

import com.payhere.housekeepingbook.domain.book.dto.BookDto
import com.payhere.housekeepingbook.domain.book.exception.CannotFindBookException
import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.book.repository.BookRepository
import com.payhere.housekeepingbook.domain.user.model.User
import com.payhere.housekeepingbook.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
) {
    fun createBook(user: User, createRequest: BookDto.CreateRequest): Book {
        val title = createRequest.title
        val memo = createRequest.memo

        val newBook = bookRepository.save(Book(title = title, memo = memo))
        user.addBook(newBook)
        newBook.user = user
        userRepository.save(user)
        return newBook
    }

    fun calculateBalance(bookBalance: Int, moneyType: Boolean, money: Int): Int {
        val newBalance: Int
        if (moneyType) newBalance = bookBalance + money
        else newBalance = bookBalance - money
        return newBalance
    }

    fun getThisBook(id: Long): Book {
        return bookRepository.findByIdOrNull(id) ?: throw CannotFindBookException()
    }
}
