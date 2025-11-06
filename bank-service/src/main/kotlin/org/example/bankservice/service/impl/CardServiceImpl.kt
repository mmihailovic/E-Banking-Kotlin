package org.example.bankservice.service.impl

import org.example.bankservice.dto.CardDTO
import org.example.bankservice.dto.CreateCardDTO
import org.example.bankservice.exception.CardDeactivatedException
import org.example.bankservice.exception.CardNotFoundException
import org.example.bankservice.mapper.CardMapper
import org.example.bankservice.model.card.Card
import org.example.bankservice.model.card.CardStatus
import org.example.bankservice.repository.CardRepository
import org.example.bankservice.service.CardService
import org.springframework.stereotype.Service

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository,
    private val cardMapper: CardMapper
): CardService {
    override fun createCard(createCardDto: CreateCardDTO): CardDTO {
        return cardMapper.cardToCardDto(cardRepository.save(cardMapper.createCartDtoToCart(createCardDto)))
    }

    override fun deleteCard(cardNumber: String) {
        val card: Card = cardRepository.findByNumber(cardNumber)
            .orElseThrow { CardNotFoundException(cardNumber) }
        cardRepository.delete(card)
    }

    override fun blockCard(cardNumber: String) {
        val card: Card = cardRepository.findByNumber(cardNumber)
            .orElseThrow { CardNotFoundException(cardNumber) }

        if (card.cardStatus == CardStatus.DEACTIVATED) throw CardDeactivatedException(cardNumber)

        card.cardStatus = CardStatus.BLOCKED
        cardRepository.save(card)
    }

    override fun unblockCard(cardNumber: String) {
        val card: Card = cardRepository.findByNumber(cardNumber)
            .orElseThrow { CardNotFoundException(cardNumber) }

        if (card.cardStatus == CardStatus.DEACTIVATED) throw CardDeactivatedException(cardNumber)

        card.cardStatus = CardStatus.ACTIVE
        cardRepository.save(card)
    }

    override fun deactivateCard(cardNumber: String) {
        val card: Card = cardRepository.findByNumber(cardNumber)
            .orElseThrow { CardNotFoundException(cardNumber) }

        card.cardStatus = CardStatus.DEACTIVATED
        cardRepository.save(card)
    }

    override fun getAllCards(): List<CardDTO> {
        return cardRepository.findAll().stream().map(cardMapper::cardToCardDto).toList()
    }

    override fun getAllCardsForUser(userId: Long): List<CardDTO> {
        return cardRepository.findByBankAccount_Owner(userId).stream().map(cardMapper::cardToCardDto).toList()
    }
}