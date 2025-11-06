package org.example.stockmarketservice.repository

import org.example.stockmarketservice.model.StockHistoricalData
import org.springframework.data.repository.CrudRepository

interface StockHistoricalDataRepository:CrudRepository<StockHistoricalData, String> {
}