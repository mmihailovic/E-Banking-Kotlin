package org.example.bankservice.repository

import org.example.bankservice.model.card.CardIssuer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardIssuerRepository : JpaRepository<CardIssuer, Long> {
}