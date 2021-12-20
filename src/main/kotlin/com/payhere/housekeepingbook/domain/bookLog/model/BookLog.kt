package com.payhere.housekeepingbook.domain.bookLog.model

import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.model.BaseTimeEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name = "book_log")
class BookLog(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], optional = true)
    var book: Book? = null,

    @field:NotBlank
    var category: String,

    // true : 입금, false : 소비
    @field:NotNull
    var moneyType: Boolean = false,

    @field:NotNull
    var money: Float = 0.toFloat(),

    @field:NotNull
    var memo: String = "",
) : BaseTimeEntity()
