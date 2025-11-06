package org.example.stockmarketservice.dto

import jakarta.validation.constraints.NotNull

data class MarketOrderCreateDTO(
    @NotNull val orderAction: String,
    @NotNull val ticker: String,
    @NotNull val quantity: Int
)
