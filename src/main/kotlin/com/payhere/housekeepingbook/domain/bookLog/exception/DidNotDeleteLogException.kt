package com.payhere.housekeepingbook.domain.bookLog.exception

import com.payhere.housekeepingbook.global.exception.ConflictException
import com.payhere.housekeepingbook.global.exception.ErrorType

class DidNotDeleteLogException(detail: String = "") :
    ConflictException(ErrorType.DID_NOT_DELETED, detail)
