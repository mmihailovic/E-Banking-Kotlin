package org.example.userservice.service.impl

import org.example.userservice.dto.FavouriteRecipientCreateDTO
import org.example.userservice.dto.FavouriteRecipientDTO
import org.example.userservice.mapper.FavouriteRecipientMapper
import org.example.userservice.model.user.Client
import org.example.userservice.repository.FavouriteRecipientRepository
import org.example.userservice.security.JwtUtil
import org.example.userservice.service.FavouriteRecipientService
import org.springframework.stereotype.Service

@Service
class FavouriteRecipientServiceImpl(
    val favouriteRecipientRepository: FavouriteRecipientRepository,
    val favouriteRecipientMapper: FavouriteRecipientMapper,
    val jwtUtil: JwtUtil
) : FavouriteRecipientService {

    override fun addFavouriteClient(favouriteRecipientCreateDTO: FavouriteRecipientCreateDTO): FavouriteRecipientDTO {
        return favouriteRecipientMapper.favouriteRecipientToFavouriteRecipientDTO(
            favouriteRecipientRepository.save(
                favouriteRecipientMapper.favouriteRecipientRequestDTOtoFavouriteRecipient(
                    favouriteRecipientCreateDTO,
                    jwtUtil.getCurrentUser() as Client
                )
            )
        )
    }

    override fun editFavouriteClient(favouriteRecipientCreateDTO: FavouriteRecipientCreateDTO): FavouriteRecipientDTO {
        return favouriteRecipientMapper.favouriteRecipientToFavouriteRecipientDTO(
            favouriteRecipientRepository.save(
                favouriteRecipientMapper.favouriteRecipientRequestDTOtoFavouriteRecipient(
                    favouriteRecipientCreateDTO,
                    jwtUtil.getCurrentUser() as Client
                )
            )
        )
    }

    override fun deleteFavouriteClient(id: Long?) {
        favouriteRecipientRepository.deleteById(id!!)
    }

    override fun findFavouriteClientsForClient(): List<FavouriteRecipientDTO> {
        return favouriteRecipientRepository.findByClient_Id(jwtUtil.getCurrentUser().id!!)
            .map { favouriteRecipient ->
                favouriteRecipientMapper.favouriteRecipientToFavouriteRecipientDTO(
                    favouriteRecipient
                )
            }.toList()
    }
}