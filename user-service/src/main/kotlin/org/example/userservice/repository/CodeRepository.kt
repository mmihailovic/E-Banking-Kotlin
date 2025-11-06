package org.example.userservice.repository

import org.example.userservice.model.code.Code
import org.example.userservice.model.code.CodeType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CodeRepository : JpaRepository<Code, Long> {
    fun findByUserEmailAndCodeType(email: String, codeType: CodeType): Optional<Code>
}