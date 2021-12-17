package com.payhere.housekeepingbook.domain.user.api

import com.payhere.housekeepingbook.domain.user.dto.UserDto
import com.payhere.housekeepingbook.domain.user.service.UserService
import com.payhere.housekeepingbook.global.auth.jwt.JwtTokenProvider
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
class UserController(
    private val jwtTokenProvider: JwtTokenProvider,
    private val userService: UserService,
) {
}