package com.payhere.housekeepingbook.domain.user.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.payhere.housekeepingbook.domain.model.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "user")
class User(
    @Column
    @field:NotBlank
    val email: String,

    @field:NotBlank
    var password: String,

    @JsonIgnore
    val authorities: String = "User",

    @field:NotBlank
    var accessToken: String,
) : BaseEntity()
