package com.payhere.housekeepingbook.domain.bookLog.dto

import com.payhere.housekeepingbook.domain.bookLog.model.BookLog
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class BookLogDto {
    data class LogResponse(
        val category: String,
        val moneyType: Boolean,
        val money: Float,
        val memo: String,
    ) {
        constructor(bookLog: BookLog) : this(
            category = bookLog.category,
            moneyType = bookLog.moneyType,
            money = bookLog.money,
            memo = bookLog.memo,
        )
    }

    data class AddLogRequest(
        @field:NotBlank
        val category: String,

        @field:NotNull
        val moneyType: Boolean,

        @field:NotNull
        val money: Float,

        val memo: String,
    )
}
