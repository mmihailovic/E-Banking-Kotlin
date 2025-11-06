package org.example.stockmarketservice.repository

import org.example.stockmarketservice.model.Stock
import org.springframework.data.repository.CrudRepository

interface StockRepository: CrudRepository<Stock, String> {
}