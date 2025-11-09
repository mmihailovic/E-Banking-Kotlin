package org.example.transactionservice.dto

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class InternalPaymentCreateDTO(
    @NotNull val senderAccountNumber: Long,
    @NotNull val receiverAccountNumber: Long,
    @NotNull @Positive val amount: BigDecimal
)
