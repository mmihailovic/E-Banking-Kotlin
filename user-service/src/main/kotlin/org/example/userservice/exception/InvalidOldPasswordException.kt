package org.example.userservice.exception

import org.springframework.http.HttpStatus

data class InvalidOldPasswordException(override val message: String = "Current password isn't correct!") :
    CustomException(message, HttpStatus.BAD_REQUEST)
