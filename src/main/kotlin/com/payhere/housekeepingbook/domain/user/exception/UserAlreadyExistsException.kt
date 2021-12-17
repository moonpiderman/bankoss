package com.payhere.housekeepingbook.domain.user.exception

import com.payhere.housekeepingbook.global.exception.ConflictException
import com.payhere.housekeepingbook.global.exception.ErrorType

class UserAlreadyExistsException(detail: String = "") :
    ConflictException(ErrorType.USER_ALREADY_EXISTS, detail)
