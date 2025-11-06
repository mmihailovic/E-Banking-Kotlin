package org.example.bankservice.controller

import jakarta.validation.Valid
import org.example.bankservice.dto.CountryCreateDTO
import org.example.bankservice.dto.CountryDTO
import org.example.bankservice.service.CountryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin/country")
class CountryController(private val countryService: CountryService) {
    @GetMapping
    fun getAllCountries(): ResponseEntity<List<CountryDTO>> {
        return ResponseEntity<List<CountryDTO>>(countryService.getAllCountries(), HttpStatus.OK)
    }

    @PostMapping
    fun createCurrency(@RequestBody countryCreateDTO: @Valid CountryCreateDTO): ResponseEntity<CountryDTO> {
        return ResponseEntity<CountryDTO>(countryService.createCountry(countryCreateDTO), HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteCountry(@PathVariable("id") id: Long): ResponseEntity<*> {
        countryService.deleteCountry(id)
        return ResponseEntity<Any>(HttpStatus.OK)
    }

}