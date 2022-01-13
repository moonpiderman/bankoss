package com.bomoon.bankoss.domain.user.service

import com.bomoon.bankoss.domain.user.dto.UserDto
import com.bomoon.bankoss.domain.user.exception.UserAlreadyExistsException
import com.bomoon.bankoss.domain.user.model.User
import com.bomoon.bankoss.domain.user.repository.UserRepository
import com.bomoon.bankoss.global.auth.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    fun signup(signupRequest: UserDto.SignupRequest): User {
        if (userRepository.existsUserByEmail(signupRequest.email)) {
            throw UserAlreadyExistsException("User Already exists.")
        }
        val email = signupRequest.email
        val encodedPassword = passwordEncoder.encode(signupRequest.password)

        return userRepository.save(
            User(
                email = email,
                password = encodedPassword,
                accessToken = jwtTokenProvider.generateToken(email)
            )
        )
    }
}
