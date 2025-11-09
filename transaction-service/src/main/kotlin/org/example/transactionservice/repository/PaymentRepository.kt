package org.example.transactionservice.repository

import org.example.transactionservice.model.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository: JpaRepository<Payment, Long> {
    fun findAllBySenderAccountNumber(senderAccountNumber: Long): List<Payment>
}