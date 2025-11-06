package org.example.stockmarketservice.dto

data class OrderDTO(val id: Long?, val orderAction: String, val quantity: Int, val ticker: String)
