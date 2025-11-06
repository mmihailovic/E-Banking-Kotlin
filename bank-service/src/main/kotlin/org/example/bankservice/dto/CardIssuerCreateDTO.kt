package org.example.bankservice.dto

import jakarta.validation.constraints.NotNull

data class CardIssuerCreateDTO(@NotNull val name: String, val MII: Int, val BIN: Int)
