package org.example.bankservice.service.impl

import org.example.bankservice.dto.ExchangeInvoiceDTO
import org.example.bankservice.mapper.ExchangeInvoiceMapper
import org.example.bankservice.model.ExchangeInvoice
import org.example.bankservice.model.accounts.BankAccount
import org.example.bankservice.repository.ExchangeInvoiceRepository
import org.example.bankservice.service.ExchangeInvoiceService
import org.example.bankservice.service.ExchangeRateService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class ExchangeInvoiceServiceImpl(
    private val exchangeInvoiceRepository: ExchangeInvoiceRepository,
    private val exchangeInvoiceMapper: ExchangeInvoiceMapper,
    private val exchangeRateService: ExchangeRateService
) : ExchangeInvoiceService {
    override fun createInvoiceForExchange(sender: BankAccount, receiver: BankAccount, amount: BigDecimal) {
        val exchangeRate = exchangeRateService.exchangeRate(
            sender.currency.code,
            receiver.currency.code
        )
        val exchangeInvoice = ExchangeInvoice(
            null,
            sender,
            receiver,
            amount,
            sender.currency,
            receiver.currency,
            exchangeRate,
            amount.multiply(BigDecimal("0.005")),
            System.currentTimeMillis()
        )
        exchangeInvoiceRepository.save(exchangeInvoice)
    }

    override fun listInvoicesByCurrency(currency: String): List<ExchangeInvoiceDTO> {
        return exchangeInvoiceRepository.findAllBySenderCurrency_Code(currency)
            .stream()
            .map(exchangeInvoiceMapper::exchangeInvoiceToExchangeInvoiceDTO)
            .toList()
    }
}