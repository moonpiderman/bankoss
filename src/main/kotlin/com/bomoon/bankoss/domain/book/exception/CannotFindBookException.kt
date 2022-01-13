package com.bomoon.bankoss.domain.book.exception

import com.payhere.housekeepingbook.global.exception.DataNotFoundException
import com.payhere.housekeepingbook.global.exception.ErrorType

class CannotFindBookException(detail: String = "") :
    DataNotFoundException(ErrorType.CANNOT_FIND_BOOK, detail)
