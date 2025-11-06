package org.example.bankservice.dto

import java.math.BigDecimal

data class ListingOrderQueueDTO(
    val buyerId: Long,
    val sellerId: Long,
    val buyPrice: BigDecimal,
    val sellPrice: BigDecimal
)
