package org.example.transactionservice.listener

import org.example.transactionservice.model.PaymentStatus
import org.example.transactionservice.service.PaymentService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitMQListener(private val paymentService: PaymentService) {
    @RabbitListener(queues = ["\${transactions.success.queue}"])
    fun successTransaction(message: String) {
        val id = message.toLong()
        println("Transaction with ID: $id success!")
        paymentService.updatePaymentStatus(id, PaymentStatus.SUCCESS)
    }

    @RabbitListener(queues = ["\${transactions.failed.queue}"])
    fun failedTransaction(message: String) {
        val id = message.toLong()
        println("Transaction with ID: $id failed!")
        paymentService.updatePaymentStatus(id, PaymentStatus.FAILED)
    }
}