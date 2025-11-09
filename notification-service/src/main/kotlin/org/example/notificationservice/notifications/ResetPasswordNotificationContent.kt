package org.example.notificationservice.notifications

import org.example.notificationservice.dto.NotificationDTO
import org.springframework.stereotype.Component

@Component("resetPassword")
class ResetPasswordNotificationContent : NotificationContent {
    override fun getContent(notificationDTO: NotificationDTO): String {
        return ("""
     Dear Sir/Madam ${notificationDTO.lastName}
     
     We are sending you a code to change your password.
     Verification code: ${notificationDTO.code}
     
     Your Bank.
     """.trimIndent())
    }

    override fun getSubject(notificationDTO: NotificationDTO): String {
        return "Verification code"
    }
}