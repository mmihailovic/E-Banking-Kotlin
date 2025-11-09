package org.example.notificationservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

@Configuration
class MailConfiguration {
    @Bean
    fun getJavaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = "localhost"
        mailSender.port = 1025

        val props: Properties = mailSender.javaMailProperties
        props["mail.transport.protocol"] = "smtp"

        return mailSender
    }
}