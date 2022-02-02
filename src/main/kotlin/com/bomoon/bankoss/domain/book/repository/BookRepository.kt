package com.bomoon.bankoss.domain.book.repository

import com.bomoon.bankoss.domain.book.model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long?>
