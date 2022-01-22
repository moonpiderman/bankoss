package com.bomoon.bankoss.domain.bookLog.model

import com.bomoon.bankoss.domain.book.model.Book
import com.bomoon.bankoss.domain.model.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "book_log")
class BookLog(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [], optional = true)
    var book: Book? = null,

    @field:NotBlank
    var category: String,

    // true : 입금, false : 소비
    @field:NotNull
    var moneyType: Boolean = false,

    @field:NotNull
    var money: Int = 0,

    @field:NotNull
    var memo: String = "",

    @field:NotNull
    var isDeleted: Boolean = true,
) : BaseTimeEntity()
