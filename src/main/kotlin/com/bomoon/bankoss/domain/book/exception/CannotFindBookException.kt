package com.bomoon.bankoss.domain.book.exception

import com.bomoon.bankoss.global.exception.DataNotFoundException
import com.bomoon.bankoss.global.exception.ErrorType

class CannotFindBookException(detail: String = "") :
    DataNotFoundException(ErrorType.CANNOT_FIND_BOOK, detail)
