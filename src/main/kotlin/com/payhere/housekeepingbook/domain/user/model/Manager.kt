package com.payhere.housekeepingbook.domain.user.model

import com.payhere.housekeepingbook.domain.model.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "manager")
class Manager() : BaseEntity()
