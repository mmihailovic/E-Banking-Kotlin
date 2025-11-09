package org.example.transactionservice.model

import jakarta.persistence.*
import java.io.Serializable
import java.math.BigDecimal

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Payment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long?,
    val senderAccountNumber: Long,
    val receiverAccountNumber: Long,
    val amount: BigDecimal,
    @Enumerated(value = EnumType.STRING) var paymentStatus: PaymentStatus,
    val transactionCreationTime: Long,
    var transactionExecutionTime: Long?,
) : Serializable {}