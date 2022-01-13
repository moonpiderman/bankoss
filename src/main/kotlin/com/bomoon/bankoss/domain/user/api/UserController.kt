package com.bomoon.bankoss.domain.user.api

import com.bomoon.bankoss.domain.user.dto.UserDto
import com.bomoon.bankoss.domain.user.model.User
import com.bomoon.bankoss.domain.user.service.UserService
import com.bomoon.bankoss.global.auth.CurrentUser
import com.bomoon.bankoss.global.auth.jwt.JwtTokenProvider
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping("/api/user")
class UserController(
    private val jwtTokenProvider: JwtTokenProvider,
    private val userService: UserService,
) {
    @PostMapping("/signup/")
    fun userSignup(
        @Valid @RequestBody signupRequest: UserDto.SignupRequest,
        response: HttpServletResponse,
    ): ResponseEntity<UserDto.Response> {
        val user = userService.signup(signupRequest)
        response.addHeader("Authentication", user.accessToken)
        return ResponseEntity(UserDto.Response(user), HttpStatus.CREATED)
    }

    @PostMapping("/logout/")
    fun userLogout(
        request: HttpServletRequest,
        response: HttpServletResponse,
    ): ResponseEntity<UserDto.Response> {
        val auth: Authentication = SecurityContextHolder.getContext().authentication
        if (auth != null) SecurityContextLogoutHandler().logout(request, response, auth)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/me/")
    fun viewBooks(
        @CurrentUser user: User,
    ): ResponseEntity<UserDto.UserBooksResponse> {
        return ResponseEntity(UserDto.UserBooksResponse(user), HttpStatus.OK)
    }
}
