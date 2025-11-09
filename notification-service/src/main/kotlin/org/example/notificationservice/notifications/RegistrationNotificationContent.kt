package org.example.notificationservice.notifications

import org.example.notificationservice.dto.NotificationDTO
import org.springframework.stereotype.Component

@Component("registration")
class RegistrationNotificationContent : NotificationContent {
    override fun getContent(notificationDTO: NotificationDTO): String {
        return ("""
     Dear Sir/Madam ${notificationDTO.lastName}
     
     You have successfully created your account!
     We are sending you the activation code for your account.
     Activation code: ${notificationDTO.code}
     
     Your Bank
     """.trimIndent())
    }

    override fun getSubject(notificationDTO: NotificationDTO): String {
        return "Activation code"
    }
}