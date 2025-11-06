package org.example.stockmarketservice.scheduler

import org.example.stockmarketservice.service.OrderService
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class OrderProcessScheduler(private val orderService: OrderService) {
    @Scheduled(fixedDelay = 60000)
    fun processOrders() {
        orderService.processOrders()
    }
}