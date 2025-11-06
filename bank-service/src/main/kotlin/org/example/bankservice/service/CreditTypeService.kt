package org.example.bankservice.service

import org.example.bankservice.dto.CreditTypeCreateDTO
import org.example.bankservice.dto.CreditTypeDTO

interface CreditTypeService {
    /**
     * Creates credit type
     * @param creditTypeCreateDTO DTO which contains information about credit type
     * @return [CreditTypeDTO] object representing created credit type
     */
    fun createCreditType(creditTypeCreateDTO: CreditTypeCreateDTO): CreditTypeDTO

    /**
     * Gets all credit types
     * @return List of [CreditTypeDTO] representing credit types
     */
    fun getAllCreditTypes(): List<CreditTypeDTO>

    /**
     * Deletes credit type
     * @param id the id of the credit type to be deleted
     */
    fun deleteCreditType(id: Long)
}