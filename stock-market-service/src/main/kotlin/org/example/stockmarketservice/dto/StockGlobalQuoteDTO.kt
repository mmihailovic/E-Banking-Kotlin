package org.example.stockmarketservice.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class StockGlobalQuoteDTO(
    @JsonProperty("Global Quote")
    val globalQuote: GlobalQuoteDTO
)
