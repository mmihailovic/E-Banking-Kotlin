package org.example.bankservice.service.impl

import org.example.bankservice.dto.CurrencyCreateDTO
import org.example.bankservice.dto.CurrencyDTO
import org.example.bankservice.exception.CurrencyNotFoundException
import org.example.bankservice.mapper.CurrencyMapper
import org.example.bankservice.model.Currency
import org.example.bankservice.repository.CurrencyRepository
import org.example.bankservice.service.CurrencyService
import org.springframework.stereotype.Service

@Service
class CurrencyServiceImpl(
    private val currencyRepository: CurrencyRepository,
    private val currencyMapper: CurrencyMapper
): CurrencyService {
    override fun createCurrency(currencyCreateDTO: CurrencyCreateDTO): CurrencyDTO {
        return currencyMapper.currencyToCurrencyDTO(
            currencyRepository.save(
                currencyMapper.currencyCreateDTOtoCurrency(
                    currencyCreateDTO
                )
            )
        )
    }

    override fun getAllCurrencies(): List<CurrencyDTO> {
        return currencyRepository.findAll().stream().map(currencyMapper::currencyToCurrencyDTO).toList()
    }

    override fun deleteCurrency(id: Long) {
        val currency: Currency = currencyRepository.findById(id)
            .orElseThrow { CurrencyNotFoundException(id) }

        currencyRepository.delete(currency)
    }
}