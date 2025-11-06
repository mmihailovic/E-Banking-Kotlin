package org.example.bankservice.service.impl

import org.example.bankservice.dto.CountryCreateDTO
import org.example.bankservice.dto.CountryDTO
import org.example.bankservice.exception.CountryNotFoundException
import org.example.bankservice.mapper.CountryMapper
import org.example.bankservice.model.Country
import org.example.bankservice.repository.CountryRepository
import org.example.bankservice.service.CountryService
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
    private val countryMapper: CountryMapper): CountryService {
    override fun createCountry(countryCreateDTO: CountryCreateDTO): CountryDTO {
        return countryMapper.countryToCountryDTO(
            countryRepository.save(
                countryMapper.countryCreateDTOtoCountry(
                    countryCreateDTO
                )
            )
        )
    }

    override fun getAllCountries(): List<CountryDTO> {
        return countryRepository.findAll().stream().map(countryMapper::countryToCountryDTO).toList()
    }

    override fun deleteCountry(id: Long) {
        val country: Country = countryRepository.findById(id)
            .orElseThrow { CountryNotFoundException(id) }

        countryRepository.delete(country)
    }
}