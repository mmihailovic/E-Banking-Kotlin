package org.example.stockmarketservice.mapper

import org.example.stockmarketservice.dto.ListingOwnerDTO
import org.example.stockmarketservice.model.ListingOwner
import org.springframework.stereotype.Component

@Component
class ListingOwnerMapper {
    fun listingOwnerToListingOwnerDTO(listingOwner: ListingOwner): ListingOwnerDTO {
        return ListingOwnerDTO(
            listingOwner.id, listingOwner.owner, listingOwner.ticker, listingOwner.quantity
        )
    }
}