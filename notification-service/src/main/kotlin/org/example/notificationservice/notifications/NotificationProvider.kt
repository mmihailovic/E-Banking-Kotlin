package org.example.notificationservice.notifications

import org.example.notificationservice.dto.NotificationDTO
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component

@Component
class NotificationProvider(
    @Qualifier("registration") private val registrationNotificationContent: NotificationContent,
    @Qualifier("resetPassword") private val resetPasswordNotificationContent: NotificationContent,
    @Qualifier("paymentCode") private val paymentCodeNotificationContent: NotificationContent
) {
    fun getNotificationContent(notificationDTO: NotificationDTO): NotificationContent {
        return when (notificationDTO.notificationType) {
            "REGISTRATION" -> registrationNotificationContent
            "PASSWORD_RESET" -> resetPasswordNotificationContent
            "PAYMENT_CODE" -> paymentCodeNotificationContent
            else -> throw UnsupportedOperationException()
        }
    }
}