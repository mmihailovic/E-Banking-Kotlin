package org.example.transactionservice.dto

import java.math.BigDecimal

data class ExternalPaymentDTO(
    val id: Long?,
    val senderAccountNumber: Long,
    val receiverAccountNumber: Long,
    val amount: BigDecimal,
    val paymentStatus: String,
    val transactionCreationTime: Long,
    val transactionExecutionTime: Long?,
    val recipientName: String,
    val paymentReferenceNumber: Int,
    val paymentCode: Int,
    val paymentPurpose: String
)
