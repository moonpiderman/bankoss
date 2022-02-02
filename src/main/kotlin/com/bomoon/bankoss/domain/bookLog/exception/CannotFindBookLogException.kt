package com.bomoon.bankoss.domain.bookLog.exception

import com.bomoon.bankoss.global.exception.DataNotFoundException
import com.bomoon.bankoss.global.exception.ErrorType

class CannotFindBookLogException(detail: String = "") :
    DataNotFoundException(ErrorType.CANNOT_FIND_BOOKLOG, detail)
