package com.payhere.housekeepingbook.domain.bookLog.exception

import com.payhere.housekeepingbook.global.exception.ConflictException
import com.payhere.housekeepingbook.global.exception.ErrorType

class AlreadyDeletedLogException(detail: String = "") :
    ConflictException(ErrorType.ALREADY_DELETED, detail)
