package com.bomoon.bankoss.domain.book.model

import com.bomoon.bankoss.domain.bookLog.model.BookLog
import com.bomoon.bankoss.domain.model.BaseTimeEntity
import com.bomoon.bankoss.domain.user.model.User
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "book")
class Book(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [])
    var user: User? = null,

    @field:NotBlank
    var title: String = "",

    @field:NotBlank
    var memo: String = "",

    @Column
    var balance: Int = 0,

    @Column
    var type: String = "",

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    var logs: MutableList<BookLog> = mutableListOf(),

) : BaseTimeEntity()
