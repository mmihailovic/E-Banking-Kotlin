package org.example.bankservice.repository

import org.example.bankservice.model.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository : JpaRepository<Country, Long> {
}