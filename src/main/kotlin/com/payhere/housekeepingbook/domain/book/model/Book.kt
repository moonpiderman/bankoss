package com.payhere.housekeepingbook.domain.book.model

import com.payhere.housekeepingbook.domain.model.BaseTimeEntity
import com.payhere.housekeepingbook.domain.user.model.User
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "book")
class Book(
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val user: User,

    @field:NotBlank
    var title: String = "",

    @field:NotBlank
    var memo: String? = null,

    @field:NotBlank
    var balance: Float = 0.toFloat(),

) : BaseTimeEntity()
