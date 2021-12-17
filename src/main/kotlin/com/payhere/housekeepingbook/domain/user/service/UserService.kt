package com.payhere.housekeepingbook.domain.user.service

import com.payhere.housekeepingbook.domain.user.dto.UserDto
import com.payhere.housekeepingbook.domain.user.model.User
import com.payhere.housekeepingbook.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) {

}