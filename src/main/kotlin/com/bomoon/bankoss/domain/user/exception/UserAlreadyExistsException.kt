package com.bomoon.bankoss.domain.user.exception

import com.bomoon.bankoss.global.exception.ConflictException
import com.bomoon.bankoss.global.exception.ErrorType

class UserAlreadyExistsException(detail: String = "") :
    ConflictException(ErrorType.USER_ALREADY_EXISTS, detail)
