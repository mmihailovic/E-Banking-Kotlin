package org.example.notificationservice.listener

import jakarta.jms.JMSException
import jakarta.jms.Message
import org.example.notificationservice.dto.NotificationDTO
import org.example.notificationservice.service.NotificationService
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class NotificationListener(
    private val notificationService: NotificationService,
    private val messageHelper: MessageHelper) {

    @JmsListener(destination = "\${notifications.destination}")
    @Throws(JMSException::class)
    fun handleNotifications(message: Message) {
        val notificationDTO: NotificationDTO =
            messageHelper.convertMessageToObject(message, NotificationDTO::class.java)

        notificationService.sendNotification(notificationDTO)
    }

}