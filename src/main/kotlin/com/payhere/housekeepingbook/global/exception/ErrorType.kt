package com.payhere.housekeepingbook.global.exception

enum class ErrorType(
    val code: Int
) {
    INVALID_REQUEST(0),

    NOT_ALLOWED(3000),

    DATA_NOT_FOUND(4000),
    BAD_REQUEST(4001),
    CANNOT_FIND_BOOK(4002),
    CANNOT_FIND_BOOKLOG(4003),

    CONFLICT(9000),
    USER_ALREADY_EXISTS(9001),

    SERVER_ERROR(10000)
}
