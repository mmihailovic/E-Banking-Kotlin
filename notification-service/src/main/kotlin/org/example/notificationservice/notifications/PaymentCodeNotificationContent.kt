package org.example.notificationservice.notifications

import org.example.notificationservice.dto.NotificationDTO
import org.springframework.stereotype.Component

@Component("paymentCode")
class PaymentCodeNotificationContent : NotificationContent {
    override fun getContent(notificationDTO: NotificationDTO): String {
        return ("""
     Dear Sir/Madam ${notificationDTO.lastName}
     
     We are sending you the code for your payment.
     Code: ${notificationDTO.code}
     
     If you did not initiate this payment, please contact your bank directly and refrain from providing any personal 
     or payment information.
     
     Your Bank
     """.trimIndent())
    }

    override fun getSubject(notificationDTO: NotificationDTO): String {
        return "Payment code"
    }
}