package org.example.notificationservice.notifications

import org.example.notificationservice.dto.NotificationDTO

interface NotificationContent {
    /**
     * Notification content
     * @param notificationDTO DTO object contains information about notification
     * @return Notification content
     */
    fun getContent(notificationDTO: NotificationDTO): String

    /**
     * Notification subject
     * @param notificationDTO DTO object contains information about notification
     * @return Notification subject
     */
    fun getSubject(notificationDTO: NotificationDTO): String
}