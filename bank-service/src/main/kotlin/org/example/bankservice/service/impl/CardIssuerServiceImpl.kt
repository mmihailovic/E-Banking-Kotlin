package org.example.bankservice.service.impl

import org.example.bankservice.dto.CardIssuerCreateDTO
import org.example.bankservice.dto.CardIssuerDTO
import org.example.bankservice.exception.CardIssuerNotFoundException
import org.example.bankservice.mapper.CardIssuerMapper
import org.example.bankservice.model.card.CardIssuer
import org.example.bankservice.repository.CardIssuerRepository
import org.example.bankservice.service.CardIssuerService
import org.springframework.stereotype.Service

@Service
class CardIssuerServiceImpl(
    private val cardIssuerRepository: CardIssuerRepository,
    private val cardIssuerMapper: CardIssuerMapper
): CardIssuerService {
    override fun createCardIssuer(cardIssuerCreateDTO: CardIssuerCreateDTO): CardIssuerDTO {
        return cardIssuerMapper.cardIssuerToCardIssuerDTO(
            cardIssuerRepository.save(
                cardIssuerMapper.cardIssuerCreateDTOtoCardIssuer(
                    cardIssuerCreateDTO
                )
            )
        )
    }

    override fun getAllCardIssuers(): List<CardIssuerDTO> {
        return cardIssuerRepository.findAll().stream().map(cardIssuerMapper::cardIssuerToCardIssuerDTO).toList()
    }

    override fun deleteCardIssuer(id: Long) {
        val cardIssuer: CardIssuer = cardIssuerRepository.findById(id)
            .orElseThrow { CardIssuerNotFoundException(id) }

        cardIssuerRepository.delete(cardIssuer)
    }
}