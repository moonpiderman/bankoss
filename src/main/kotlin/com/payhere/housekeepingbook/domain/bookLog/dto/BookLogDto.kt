package com.payhere.housekeepingbook.domain.bookLog.dto

import com.payhere.housekeepingbook.domain.bookLog.model.BookLog
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class BookLogDto {
    data class LogResponse(
        val category: String,
        val moneyType: Boolean,
        val money: Int,
        val memo: String,
        val isActive: Boolean,
    ) {
        constructor(bookLog: BookLog) : this(
            category = bookLog.category,
            moneyType = bookLog.moneyType,
            money = bookLog.money,
            memo = bookLog.memo,
            isActive = bookLog.isActive,
        )
    }

    data class AddLogRequest(
        @field:NotBlank
        val category: String,

        @field:NotNull
        val moneyType: Boolean,

        @field:NotNull
        val money: Int,

        val memo: String,
    )

    data class ModifyLogRequest(
        val category: String? = null,

        val moneyType: Boolean? = null,

        val money: Int? = null,

        val memo: String? = null,
    )

    data class RestoreLogRequest(
        @field:NotBlank
        val isActive: Boolean,
    )
}
