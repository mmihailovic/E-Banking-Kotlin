package org.example.bankservice.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class CountryCreateDTO(@NotNull @NotEmpty val name: String)
