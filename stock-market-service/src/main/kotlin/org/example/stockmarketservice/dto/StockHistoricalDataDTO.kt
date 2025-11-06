package org.example.stockmarketservice.dto

data class StockHistoricalDataDTO(val ticker: String, val historicalData: List<StockDataDTO>)
