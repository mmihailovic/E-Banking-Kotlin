package org.example.notificationservice.listener

import com.google.gson.Gson
import jakarta.jms.JMSException
import jakarta.jms.Message
import jakarta.jms.TextMessage
import org.springframework.stereotype.Component

@Component
class MessageHelper(private val gson: Gson) {
    @Throws(JMSException::class)
    fun <T> convertMessageToObject(message: Message, classObject: Class<T>): T {
        val textMessage = message as TextMessage
        return gson.fromJson(textMessage.text, classObject)
    }
}