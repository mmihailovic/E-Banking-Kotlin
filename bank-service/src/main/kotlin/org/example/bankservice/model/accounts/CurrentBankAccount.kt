package org.example.bankservice.model.accounts

import jakarta.persistence.Entity
import org.example.bankservice.model.Currency
import java.math.BigDecimal

@Entity
class CurrentBankAccount(
    id: Long?,
    accountNumber: Long?,
    owner: Long?,
    balance: BigDecimal,
    availableBalance: BigDecimal,
    creator: Long, // employee who created account
    creationDate: Long,
    currency: Currency,
    active: Boolean,
    val type: CurrentBankAccountType,
    val maintenancePrice: BigDecimal
) : BankAccount(id, accountNumber, owner, balance, availableBalance, creator, creationDate, currency, active) {
}