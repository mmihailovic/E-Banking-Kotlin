package org.example.stockmarketservice.strategy

import org.example.stockmarketservice.model.order.Order

interface OrderProcessStrategy {
    /**
     * Process single order
     * @param order the order to process
     */
    fun processOrder(order: Order)
}