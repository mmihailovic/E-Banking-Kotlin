package org.example.stockmarketservice.model.order

import jakarta.persistence.Entity

@Entity
class MarkerOrder(id: Long?, orderAction: OrderAction, ticker: String, quantity: Int, orderCreator: Long) :
    Order(id, orderAction, ticker, quantity, orderCreator) {
}