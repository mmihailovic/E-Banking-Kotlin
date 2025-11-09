package org.example.notificationservice.service

import org.example.notificationservice.dto.NotificationDTO

interface NotificationService {
    /**
     * Sends notification to user
     * @param notificationDTO information about notification
     */
    fun sendNotification(notificationDTO: NotificationDTO)
}