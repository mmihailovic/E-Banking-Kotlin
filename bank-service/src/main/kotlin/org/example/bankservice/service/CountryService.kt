package org.example.bankservice.service

import org.example.bankservice.dto.CountryCreateDTO
import org.example.bankservice.dto.CountryDTO

interface CountryService {
    /**
     * Creates country
     * @param countryCreateDTO DTO which contains information about country
     * @return [CountryDTO] object representing created country
     */
    fun createCountry(countryCreateDTO: CountryCreateDTO): CountryDTO

    /**
     * Gets all countries
     * @return List of [CountryDTO] representing countries
     */
    fun getAllCountries(): List<CountryDTO>

    /**
     * Deletes country
     * @param id the id of the country to be deleted
     */
    fun deleteCountry(id: Long)
}