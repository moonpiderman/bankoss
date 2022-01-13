package com.bomoon.bankoss.domain.bookLog.exception

import com.bomoon.bankoss.global.exception.ConflictException
import com.bomoon.bankoss.global.exception.ErrorType

class DidNotDeleteLogException(detail: String = "") :
    ConflictException(ErrorType.DID_NOT_DELETED, detail)
