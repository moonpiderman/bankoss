package com.payhere.housekeepingbook.domain.model

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

open class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
)