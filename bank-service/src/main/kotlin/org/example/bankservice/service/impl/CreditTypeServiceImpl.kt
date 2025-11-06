package org.example.bankservice.service.impl

import org.example.bankservice.dto.CreditTypeCreateDTO
import org.example.bankservice.dto.CreditTypeDTO
import org.example.bankservice.exception.CreditTypeNotFoundException
import org.example.bankservice.mapper.CreditTypeMapper
import org.example.bankservice.model.credit.CreditType
import org.example.bankservice.repository.CreditTypeRepository
import org.example.bankservice.service.CreditTypeService
import org.springframework.stereotype.Service

@Service
class CreditTypeServiceImpl(
    private val creditTypeRepository: CreditTypeRepository,
    private val creditTypeMapper: CreditTypeMapper
):CreditTypeService {
    override fun createCreditType(creditTypeCreateDTO: CreditTypeCreateDTO): CreditTypeDTO {
        return creditTypeMapper.creditTypeToCreditTypeDTO(
            creditTypeRepository.save(
                creditTypeMapper.creditTypeCreateDTOtoCreditType(
                    creditTypeCreateDTO
                )
            )
        )
    }

    override fun getAllCreditTypes(): List<CreditTypeDTO> {
        return creditTypeRepository.findAll().stream().map(creditTypeMapper::creditTypeToCreditTypeDTO).toList()
    }

    override fun deleteCreditType(id: Long) {
        val creditType: CreditType = creditTypeRepository.findById(id)
            .orElseThrow { CreditTypeNotFoundException(id) }

        creditTypeRepository.delete(creditType)
    }
}