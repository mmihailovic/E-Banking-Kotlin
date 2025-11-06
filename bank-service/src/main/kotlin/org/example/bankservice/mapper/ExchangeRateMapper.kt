package org.example.bankservice.mapper

import org.example.bankservice.dto.ExchangeRateDTO
import org.example.bankservice.model.ExchangeRate
import org.springframework.stereotype.Component

@Component
class ExchangeRateMapper {
    fun exchangeRateToExchangeRateResponseDto(exchangeRate: ExchangeRate): ExchangeRateDTO {
        return ExchangeRateDTO(exchangeRate.currencyCode, exchangeRate.rate)
    }
}