package com.bomoon.bankoss.global.exception

enum class ErrorType(
    val code: Int
) {
    INVALID_REQUEST(0),

    NOT_ALLOWED(3000),

    DATA_NOT_FOUND(4000),
    BAD_REQUEST(4001),
    CANNOT_FIND_BOOK(4002),
    CANNOT_FIND_BOOKLOG(4003),
    CANNOT_FIND_DELETED_BOOKLOG(4004),

    CONFLICT(9000),
    USER_ALREADY_EXISTS(9001),
    ALREADY_DELETED(9002),
    DID_NOT_DELETED(9003),

    SERVER_ERROR(10000)
}
