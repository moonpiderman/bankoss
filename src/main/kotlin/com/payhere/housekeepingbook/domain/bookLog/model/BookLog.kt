package com.payhere.housekeepingbook.domain.bookLog.model

import com.payhere.housekeepingbook.domain.book.model.Book
import com.payhere.housekeepingbook.domain.model.BaseTimeEntity
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "book_log")
class BookLog(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val book: Book,

    @field:NotBlank
    var title: String,

    // true : 입금, false : 소비
    @field:NotBlank
    var moneyType: Boolean = false,

    @field:NotBlank
    var money: Float = 0.toFloat(),

    @field:NotBlank
    var memo: String = "",
) : BaseTimeEntity()
