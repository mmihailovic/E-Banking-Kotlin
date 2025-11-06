package org.example.bankservice.mapper

import org.example.bankservice.dto.CurrencyDTO
import org.example.bankservice.dto.CurrencyCreateDTO
import org.example.bankservice.model.Currency
import org.example.bankservice.repository.CountryRepository
import org.springframework.stereotype.Component

@Component
class CurrencyMapper(private val countryMapper: CountryMapper, private val countryRepository: CountryRepository) {
    fun currencyCreateDTOtoCurrency(currencyCreateDTO: CurrencyCreateDTO): Currency {
        val country = countryRepository.findById(currencyCreateDTO.countryId).orElseThrow()
        return Currency(null, currencyCreateDTO.name, currencyCreateDTO.code, currencyCreateDTO.symbol, country)
    }

    fun currencyToCurrencyDTO(currency: Currency): CurrencyDTO {
        return CurrencyDTO(
            currency.id,
            currency.name,
            currency.code,
            currency.symbol,
            countryMapper.countryToCountryDTO(currency.country)
        )
    }
}