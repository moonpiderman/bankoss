package com.bomoon.bankoss.domain.user.repository

import com.bomoon.bankoss.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long?> {
    fun findByEmail(email: String): User?
    fun existsUserByEmail(email: String): Boolean
}
