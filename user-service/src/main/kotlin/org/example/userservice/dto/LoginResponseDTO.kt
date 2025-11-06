package org.example.userservice.dto

data class LoginResponseDTO(val loggedUser: LoggedUserDTO, val token: String)
