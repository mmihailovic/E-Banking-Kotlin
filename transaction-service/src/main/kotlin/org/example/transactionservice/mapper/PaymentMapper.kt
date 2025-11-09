package org.example.transactionservice.mapper

import org.example.transactionservice.dto.*
import org.example.transactionservice.model.ExternalPayment
import org.example.transactionservice.model.InternalPayment
import org.example.transactionservice.model.Payment
import org.example.transactionservice.model.PaymentStatus
import org.example.transactionservice.security.JwtUtil
import org.springframework.stereotype.Component

@Component
class PaymentMapper(private val jwtUtil: JwtUtil) {
    fun externalPaymentCreateDTOtoExternalPayment(externalPaymentCreateDTO: ExternalPaymentCreateDTO): ExternalPayment {
        return ExternalPayment(
            null,
            externalPaymentCreateDTO.senderAccountNumber,
            externalPaymentCreateDTO.receiverAccountNumber,
            externalPaymentCreateDTO.amount,
            PaymentStatus.PENDING,
            System.currentTimeMillis(),
            null,
            externalPaymentCreateDTO.recipientName,
            externalPaymentCreateDTO.paymentReferenceNumber,
            externalPaymentCreateDTO.paymentCode,
            externalPaymentCreateDTO.paymentPurpose
        )
    }

    fun internalPaymentCreateDTOtoInternalPayment(internalPaymentCreateDTO: InternalPaymentCreateDTO): InternalPayment {
        return InternalPayment(
            null,
            internalPaymentCreateDTO.senderAccountNumber,
            internalPaymentCreateDTO.receiverAccountNumber,
            internalPaymentCreateDTO.amount,
            PaymentStatus.PENDING,
            System.currentTimeMillis(),
            null
        )
    }

    fun internalPaymentToInternalPaymentDTO(internalPayment: InternalPayment): InternalPaymentDTO {
        return InternalPaymentDTO(
            internalPayment.id,
            internalPayment.senderAccountNumber,
            internalPayment.receiverAccountNumber,
            internalPayment.amount,
            internalPayment.paymentStatus.toString(),
            internalPayment.transactionCreationTime,
            internalPayment.transactionExecutionTime
        )
    }

    fun externalPaymentToExternalPaymentDTO(externalPayment: ExternalPayment): ExternalPaymentDTO {
        return ExternalPaymentDTO(
            externalPayment.id,
            externalPayment.senderAccountNumber,
            externalPayment.receiverAccountNumber,
            externalPayment.amount,
            externalPayment.paymentStatus.toString(),
            externalPayment.transactionCreationTime,
            externalPayment.transactionExecutionTime,
            externalPayment.recipientName,
            externalPayment.paymentReferenceNumber,
            externalPayment.paymentCode,
            externalPayment.paymentPurpose
        )
    }

    fun paymentToPaymentDTO(payment: Payment): PaymentDTO {
        return PaymentDTO(
            payment.id,
            payment.senderAccountNumber,
            payment.receiverAccountNumber,
            payment.amount,
            payment.paymentStatus.toString(),
            payment.transactionCreationTime,
            payment.transactionExecutionTime
        )
    }

    fun paymentToPaymentBrokerDto(payment: Payment, type: String, code: String?): PaymentBrokerDTO {
        val email = jwtUtil.extractUsername(jwtUtil.extractToken()!!)
        return PaymentBrokerDTO(
            payment.id,
            email,
            payment.senderAccountNumber,
            payment.receiverAccountNumber,
            payment.amount,
            jwtUtil.getIDForLoggedUser()!!,
            type,
            code
        )
    }
}