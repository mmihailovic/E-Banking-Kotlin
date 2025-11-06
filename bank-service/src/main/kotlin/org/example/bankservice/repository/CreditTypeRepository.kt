package org.example.bankservice.repository

import org.example.bankservice.model.credit.CreditType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditTypeRepository:JpaRepository<CreditType, Long> {

}