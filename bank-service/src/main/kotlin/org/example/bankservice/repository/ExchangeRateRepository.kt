package org.example.bankservice.repository

import org.example.bankservice.model.ExchangeRate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExchangeRateRepository:JpaRepository<ExchangeRate, Long> {
    fun findByCurrencyCode(currencyCode: String): Optional<ExchangeRate>
}