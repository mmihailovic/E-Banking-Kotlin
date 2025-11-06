package org.example.userservice.repository

import org.example.userservice.model.user.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyRepository : JpaRepository<Company, Long> {
    fun findByTIN(TIN: Int): Optional<Company>
}