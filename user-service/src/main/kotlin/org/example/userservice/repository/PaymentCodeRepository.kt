package org.example.userservice.repository

import org.example.userservice.model.PaymentCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentCodeRepository : JpaRepository<PaymentCode, Long> {
}