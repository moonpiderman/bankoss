package com.payhere.housekeepingbook.domain.user.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.model.BaseTimeEntity
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user")
class User(
    @Column
    @field:NotBlank
    val email: String,

    @field:NotBlank
    var password: String,

    @JsonIgnore
    val authorities: String = "User",

    @field:NotBlank
    var accessToken: String,

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    var books: MutableList<Book> = mutableListOf(),
) : BaseTimeEntity() {
    fun addBook(book: Book) {
        books.add(book)
    }
}
