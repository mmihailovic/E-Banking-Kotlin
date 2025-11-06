package org.example.bankservice.service

import org.example.bankservice.dto.CardIssuerCreateDTO
import org.example.bankservice.dto.CardIssuerDTO

interface CardIssuerService {
    /**
     * Creates card issuer
     * @param cardIssuerCreateDTO DTO which contains information about card issuer
     * @return [CardIssuerDTO] object representing created card issuer
     */
    fun createCardIssuer(cardIssuerCreateDTO: CardIssuerCreateDTO): CardIssuerDTO

    /**
     * Gets all card issuers
     * @return List of [CardIssuerDTO] representing card issuers
     */
    fun getAllCardIssuers(): List<CardIssuerDTO>

    /**
     * Deletes card issuer
     * @param id the id of the cart issuer to be deleted
     */
    fun deleteCardIssuer(id: Long)
}