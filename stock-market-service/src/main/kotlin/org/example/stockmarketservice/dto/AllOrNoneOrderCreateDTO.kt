package org.example.stockmarketservice.dto

import jakarta.validation.constraints.NotNull

data class AllOrNoneOrderCreateDTO(
    @NotNull val orderAction: String,
    @NotNull val ticker: String,
    @NotNull val quantity: Int
)
