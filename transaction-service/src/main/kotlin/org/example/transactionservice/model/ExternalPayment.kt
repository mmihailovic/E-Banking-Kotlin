package org.example.transactionservice.model

import jakarta.persistence.Entity
import java.math.BigDecimal

@Entity
class ExternalPayment(
    id: Long?,
    senderAccountNumber: Long,
    receiverAccountNumber: Long,
    amount: BigDecimal,
    paymentStatus: PaymentStatus,
    transactionCreationTime: Long,
    transactionExecutionTime: Long?,
    val recipientName: String,
    val paymentReferenceNumber: Int,
    val paymentCode: Int,
    val paymentPurpose: String
) : Payment(
    id,
    senderAccountNumber,
    receiverAccountNumber,
    amount,
    paymentStatus,
    transactionCreationTime,
    transactionExecutionTime
) {}