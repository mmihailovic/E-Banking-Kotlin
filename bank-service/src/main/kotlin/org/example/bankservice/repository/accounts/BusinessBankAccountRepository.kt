package org.example.bankservice.repository.accounts

import org.example.bankservice.model.accounts.BusinessBankAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BusinessBankAccountRepository: JpaRepository<BusinessBankAccount, Long> {
}