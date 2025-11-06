package org.example.bankservice.repository

import org.example.bankservice.model.Currency
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CurrencyRepository: JpaRepository<Currency, Long> {
    fun findByCode(code: String): Optional<Currency>
}