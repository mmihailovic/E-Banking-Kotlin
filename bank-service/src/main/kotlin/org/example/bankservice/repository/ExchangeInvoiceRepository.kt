package org.example.bankservice.repository

import org.example.bankservice.model.ExchangeInvoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExchangeInvoiceRepository: JpaRepository<ExchangeInvoice, Long> {
    fun findAllBySenderCurrency_Code(curr: String): List<ExchangeInvoice>
    fun findAllByReceiverCurrency_Code(curr: String): List<ExchangeInvoice>
}