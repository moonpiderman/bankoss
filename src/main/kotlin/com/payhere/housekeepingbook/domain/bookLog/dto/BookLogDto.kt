package com.payhere.housekeepingbook.domain.bookLog.dto

import com.payhere.housekeepingbook.domain.bookLog.model.BookLog

class BookLogDto {
    data class LogResponse(
        val moneyType: Boolean,
        val money: Float,
        val memo: String,
    ) {
        constructor(bookLog: BookLog) : this(
            moneyType = bookLog.moneyType,
            money = bookLog.money,
            memo = bookLog.memo,
        )
    }
}
