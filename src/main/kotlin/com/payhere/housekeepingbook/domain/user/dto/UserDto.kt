package com.payhere.housekeepingbook.domain.user.dto

import com.payhere.housekeepingbook.domain.user.model.User
import javax.validation.constraints.NotBlank

class UserDto {
    data class Response(
        val id: Long,
        val email: String,
    ) {
        constructor(user: User): this(
            id = user.id,
            email = user.email
        )
    }

    data class SignupRequest(
        @field:NotBlank
        val email: String,

        @field:NotBlank
        val password: String,
    )
}