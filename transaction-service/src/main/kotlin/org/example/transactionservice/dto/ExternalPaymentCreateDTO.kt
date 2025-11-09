package org.example.transactionservice.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal


data class ExternalPaymentCreateDTO(
    @NotNull val senderAccountNumber: Long,
    @NotNull val receiverAccountNumber: Long,
    @Positive val amount: BigDecimal,
    @NotNull @NotEmpty val recipientName: String,
    @NotNull val paymentReferenceNumber: Int,
    @NotNull val paymentCode: Int,
    @NotNull val paymentPurpose: String,
    @NotNull val code: String
)
