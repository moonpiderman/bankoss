package com.bomoon.bankoss.domain.bookLog.exception

import com.payhere.housekeepingbook.global.exception.DataNotFoundException
import com.payhere.housekeepingbook.global.exception.ErrorType

class CannotFindBookLogException(detail: String = "") :
    DataNotFoundException(ErrorType.CANNOT_FIND_BOOKLOG, detail)
