package org.example.bankservice.dto

data class CurrencyDTO(
    val id: Long?,
    val name: String,
    val code: String,
    val symbol: String,
    val countryDTO: CountryDTO
)
