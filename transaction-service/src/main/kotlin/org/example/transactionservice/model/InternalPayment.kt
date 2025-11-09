package org.example.transactionservice.model

import jakarta.persistence.Entity
import java.math.BigDecimal

@Entity
class InternalPayment(
    id: Long?,
    senderAccountNumber: Long,
    receiverAccountNumber: Long,
    amount: BigDecimal,
    paymentStatus: PaymentStatus,
    transactionCreationTime: Long,
    transactionExecutionTime: Long?
) : Payment(
    id,
    senderAccountNumber,
    receiverAccountNumber,
    amount,
    paymentStatus,
    transactionCreationTime,
    transactionExecutionTime
) {}