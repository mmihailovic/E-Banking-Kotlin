package org.example.bankservice.mapper

import org.example.bankservice.dto.CardIssuerCreateDTO
import org.example.bankservice.dto.CardIssuerDTO
import org.example.bankservice.model.card.CardIssuer
import org.springframework.stereotype.Component

@Component
class CardIssuerMapper {
    fun cardIssuerCreateDTOtoCardIssuer(cardIssuerCreateDTO: CardIssuerCreateDTO): CardIssuer {
        return CardIssuer(null, cardIssuerCreateDTO.name, cardIssuerCreateDTO.MII, cardIssuerCreateDTO.BIN, null)
    }

    fun cardIssuerToCardIssuerDTO(cardIssuer: CardIssuer): CardIssuerDTO {
        return CardIssuerDTO(cardIssuer.id, cardIssuer.name, cardIssuer.MII, cardIssuer.BIN)
    }
}