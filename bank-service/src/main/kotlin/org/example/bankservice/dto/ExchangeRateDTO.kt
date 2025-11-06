package org.example.bankservice.dto

import java.math.BigDecimal

data class ExchangeRateDTO(val currencyCode: String, val rate: BigDecimal)
