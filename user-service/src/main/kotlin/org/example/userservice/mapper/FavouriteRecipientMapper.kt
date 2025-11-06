package org.example.userservice.mapper

import org.example.userservice.dto.FavouriteRecipientCreateDTO
import org.example.userservice.dto.FavouriteRecipientDTO
import org.example.userservice.model.FavouriteRecipient
import org.example.userservice.model.user.Client
import org.springframework.stereotype.Component

@Component
class FavouriteRecipientMapper(val clientMapper: ClientMapper) {
    fun favouriteRecipientToFavouriteRecipientDTO(source: FavouriteRecipient): FavouriteRecipientDTO {
        return FavouriteRecipientDTO(
            source.id,
            clientMapper.clientToClientDTO(source.client),
            source.recipientName,
            source.recipientAccountNumber
        )
    }

    fun favouriteRecipientRequestDTOtoFavouriteRecipient(
        source: FavouriteRecipientCreateDTO,
        client: Client
    ): FavouriteRecipient {
        return FavouriteRecipient(null, client, source.recipientName, source.recipientAccountNumber)
    }
}