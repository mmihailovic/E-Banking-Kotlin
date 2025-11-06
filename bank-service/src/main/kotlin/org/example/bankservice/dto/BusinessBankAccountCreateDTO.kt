package org.example.bankservice.dto

import jakarta.validation.constraints.NotNull

data class BusinessBankAccountCreateDTO(@NotNull val TIN: Int)
