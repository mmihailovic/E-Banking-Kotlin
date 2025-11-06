package org.example.bankservice.repository.accounts

import org.example.bankservice.model.accounts.ForeignCurrencyBankAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ForeignCurrencyBankAccountRepository:JpaRepository<ForeignCurrencyBankAccount, Long> {
}