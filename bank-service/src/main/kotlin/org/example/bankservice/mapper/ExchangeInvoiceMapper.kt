package org.example.bankservice.mapper

import org.example.bankservice.dto.BankAccountDTO
import org.example.bankservice.dto.CurrencyDTO
import org.example.bankservice.dto.ExchangeInvoiceDTO
import org.example.bankservice.model.ExchangeInvoice
import org.springframework.stereotype.Component

@Component
class ExchangeInvoiceMapper(
    private val bankAccountMapper: BankAccountMapper, private val currencyMapper: CurrencyMapper
) {

    fun exchangeInvoiceToExchangeInvoiceDTO(exchangeInvoice: ExchangeInvoice): ExchangeInvoiceDTO {
        val senderAccount: BankAccountDTO = bankAccountMapper.bankAccountToBankAccountDTO(exchangeInvoice.senderAccount)
        val receiverAccount: BankAccountDTO =
            bankAccountMapper.bankAccountToBankAccountDTO(exchangeInvoice.receiverAccount)
        val senderCurrency: CurrencyDTO = currencyMapper.currencyToCurrencyDTO(exchangeInvoice.senderCurrency)
        val receiverCurrency: CurrencyDTO = currencyMapper.currencyToCurrencyDTO(exchangeInvoice.receiverCurrency)

        return ExchangeInvoiceDTO(
            exchangeInvoice.id,
            senderAccount,
            receiverAccount,
            exchangeInvoice.senderAmount,
            senderCurrency,
            receiverCurrency,
            exchangeInvoice.exchangeRate,
            exchangeInvoice.profit,
            exchangeInvoice.dateAndTime
        )
    }
}