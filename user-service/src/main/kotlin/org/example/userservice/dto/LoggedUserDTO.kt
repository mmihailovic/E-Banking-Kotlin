package org.example.userservice.dto

data class LoggedUserDTO(val id: Long?, val username: String, val companyId: Long?, val roles: List<String>)
