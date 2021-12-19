package com.payhere.housekeepingbook.domain.bookLog.service

import com.payhere.housekeepingbook.domain.bookLog.repository.BookLogRepository
import org.springframework.stereotype.Service

@Service
class BookLogService(
    private val bookLogRepository: BookLogRepository,
)
