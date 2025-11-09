package org.example.transactionservice.dto

import java.math.BigDecimal

data class PaymentDTO(
    val id: Long?,
    val senderAccountNumber: Long,
    val receiverAccountNumber: Long,
    val amount: BigDecimal,
    val paymentStatus: String,
    val transactionCreationTime: Long,
    val transactionExecutionTime: Long?
)
