package org.example.userservice.exception

import org.springframework.http.HttpStatus

data class CompanyNotFoundException(override val message: String): CustomException(message, HttpStatus.NOT_FOUND)
