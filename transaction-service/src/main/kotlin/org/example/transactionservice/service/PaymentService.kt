package org.example.transactionservice.service

import org.example.transactionservice.dto.*
import org.example.transactionservice.model.PaymentStatus

interface PaymentService {
    /**
     * Creates internal payment
     * @param internalPaymentCreateDTO DTO object contains information about internal payment
     * @return [InternalPaymentDTO] object representing created internal payment
     */
    fun createInternalPayment(internalPaymentCreateDTO: InternalPaymentCreateDTO): InternalPaymentDTO

    /**
     * Creates external payment
     * @param externalPaymentCreateDTO DTO object contains information about external payment
     * @return [ExternalPaymentDTO] object representing created external payment
     */
    fun createExternalPayment(externalPaymentCreateDTO: ExternalPaymentCreateDTO): ExternalPaymentDTO

    /**
     * Get all payments for specified bank account number
     * @param accountNumber the bank account number
     * @return List of [PaymentDTO] objects represents payments
     */
    fun getAllPaymentsByAccountNumber(accountNumber: Long): List<PaymentDTO>

    /**
     * Get payment details
     * @param id ID of the payment
     * @return DTO object contains payment details
     */
    fun getPaymentDetails(id: Long): Any

    /**
     * Update payment status
     * @param id ID of the payment
     * @param paymentStatus new payment status
     */
    fun updatePaymentStatus(id: Long, paymentStatus: PaymentStatus)
}