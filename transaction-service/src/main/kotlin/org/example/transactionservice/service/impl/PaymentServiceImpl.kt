package org.example.transactionservice.service.impl

import com.google.gson.Gson
import org.example.transactionservice.dto.*
import org.example.transactionservice.mapper.PaymentMapper
import org.example.transactionservice.model.ExternalPayment
import org.example.transactionservice.model.InternalPayment
import org.example.transactionservice.model.Payment
import org.example.transactionservice.model.PaymentStatus
import org.example.transactionservice.repository.PaymentRepository
import org.example.transactionservice.service.PaymentService
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.*

@Service
class PaymentServiceImpl(
    @Value("\${transactions.required.routing.key}")
    private val TRANSACTION_ROUTING_KEY: String,
    @Value("\${transactions.required.exchange}")
    private val TRANSACTION_EXCHANGE: String,
    private val paymentRepository: PaymentRepository,
    private val paymentMapper: PaymentMapper,
    private val rabbitTemplate: RabbitTemplate,
    private val userServiceRestTemplate: RestTemplate,
    private val gson: Gson,
) :
    PaymentService {
    override fun createInternalPayment(internalPaymentCreateDTO: InternalPaymentCreateDTO): InternalPaymentDTO {
        val internalPayment: InternalPayment =
            paymentRepository.save(paymentMapper.internalPaymentCreateDTOtoInternalPayment(internalPaymentCreateDTO))
        val paymentBrokerDTO: PaymentBrokerDTO =
            paymentMapper.paymentToPaymentBrokerDto(internalPayment, "INTERNAL", null)

        rabbitTemplate.convertAndSend(TRANSACTION_EXCHANGE, TRANSACTION_ROUTING_KEY, gson.toJson(paymentBrokerDTO))
        return paymentMapper.internalPaymentToInternalPaymentDTO(internalPayment)
    }

    override fun createExternalPayment(externalPaymentCreateDTO: ExternalPaymentCreateDTO): ExternalPaymentDTO {
        val externalPayment: ExternalPayment =
            paymentRepository.save(paymentMapper.externalPaymentCreateDTOtoExternalPayment(externalPaymentCreateDTO))

        val paymentBrokerDTO: PaymentBrokerDTO =
            paymentMapper.paymentToPaymentBrokerDto(externalPayment, "EXTERNAL", externalPaymentCreateDTO.code)

        val validCode = userServiceRestTemplate.exchange(
            "/user/kotlin/" + paymentBrokerDTO.email +
                    "/code/" + paymentBrokerDTO.paymentCode,
            HttpMethod.GET, null, Boolean::class.java
        ).body

        if (validCode == null || !validCode) {
            throw RuntimeException()
        }

        rabbitTemplate.convertAndSend(TRANSACTION_EXCHANGE, TRANSACTION_ROUTING_KEY, gson.toJson(paymentBrokerDTO))
        return paymentMapper.externalPaymentToExternalPaymentDTO(externalPayment)
    }

    override fun getAllPaymentsByAccountNumber(accountNumber: Long): List<PaymentDTO> {
        return paymentRepository.findAllBySenderAccountNumber(accountNumber).stream()
            .map(paymentMapper::paymentToPaymentDTO).toList()
    }

    override fun getPaymentDetails(id: Long): Any {
        val optionalPayment: Optional<Payment> = paymentRepository.findById(id)

        if (optionalPayment.isPresent) {
            val payment: Payment = optionalPayment.get()

            if (payment is InternalPayment) {
                return paymentMapper.internalPaymentToInternalPaymentDTO(payment)
            }
            if (payment is ExternalPayment) {
                return paymentMapper.externalPaymentToExternalPaymentDTO(payment)
            }
        }

        throw RuntimeException()
    }

    override fun updatePaymentStatus(id: Long, paymentStatus: PaymentStatus) {
        val optionalPayment: Optional<Payment> = paymentRepository.findById(id)

        if (optionalPayment.isEmpty) {
            throw RuntimeException()
        }

        val payment: Payment = optionalPayment.get()
        payment.paymentStatus = paymentStatus
        payment.transactionExecutionTime = System.currentTimeMillis()
        paymentRepository.save(payment)
    }

}