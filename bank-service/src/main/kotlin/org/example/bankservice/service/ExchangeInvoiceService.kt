package org.example.bankservice.service

import org.example.bankservice.dto.ExchangeInvoiceDTO
import org.example.bankservice.model.accounts.BankAccount
import java.math.BigDecimal

interface ExchangeInvoiceService {
    /**
     * This method creates invoice for exchange
     * @param sender [BankAccount] object representing source account
     * @param receiver [BankAccount] object representing receiver account
     * @param amount amount of money which is exchanged from source
     */
    fun createInvoiceForExchange(sender: BankAccount, receiver: BankAccount, amount: BigDecimal)

    /**
     * This method returns all invoices for currency
     * @param currency code of the currency
     * @return List of [ExchangeInvoiceDTO] objects representing invoices
     */
    fun listInvoicesByCurrency(currency: String): List<ExchangeInvoiceDTO>
}