package org.example.userservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import org.example.userservice.model.user.Client

@Entity
class FavouriteRecipient(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @ManyToOne val client: Client,
    val recipientName: String,
    val recipientAccountNumber: String
)
