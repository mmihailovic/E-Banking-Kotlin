package org.example.bankservice.mapper

import org.example.bankservice.dto.CountryDTO
import org.example.bankservice.dto.CountryCreateDTO
import org.example.bankservice.model.Country
import org.springframework.stereotype.Component

@Component
class CountryMapper {
    fun countryCreateDTOtoCountry(countryCreateDTO: CountryCreateDTO): Country {
        return Country(null, countryCreateDTO.name)
    }

    fun countryToCountryDTO(country: Country): CountryDTO {
        return CountryDTO(country.id, country.name)
    }
}