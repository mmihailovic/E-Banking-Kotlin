package org.example.notificationservice.service.impl

import org.example.notificationservice.dto.NotificationDTO
import org.example.notificationservice.notifications.NotificationContent
import org.example.notificationservice.notifications.NotificationProvider
import org.example.notificationservice.service.NotificationService
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.MailException
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class NotificationServiceImpl(
    private val emailSender: JavaMailSender,
    private val notificationProvider: NotificationProvider,
    @Value("\${sender.email}")
    private val SENDER_EMAIL: String
) : NotificationService {
    override fun sendNotification(notificationDTO: NotificationDTO) {
        try {
            val notificationContent: NotificationContent = notificationProvider.getNotificationContent(notificationDTO)

            val message = SimpleMailMessage()
            message.from = SENDER_EMAIL
            message.setTo(notificationDTO.email)
            message.subject = notificationContent.getSubject(notificationDTO)
            message.text = notificationContent.getContent(notificationDTO)
            emailSender.send(message)
        } catch (exception: MailException) {
            exception.printStackTrace()
        }
    }
}