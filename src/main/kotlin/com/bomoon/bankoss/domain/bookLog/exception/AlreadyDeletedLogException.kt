package com.bomoon.bankoss.domain.bookLog.exception

import com.bomoon.bankoss.global.exception.ConflictException
import com.bomoon.bankoss.global.exception.ErrorType

class AlreadyDeletedLogException(detail: String = "") :
    ConflictException(ErrorType.ALREADY_DELETED, detail)
