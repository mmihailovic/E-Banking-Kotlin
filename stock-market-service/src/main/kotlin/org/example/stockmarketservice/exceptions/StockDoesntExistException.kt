package org.example.stockmarketservice.exceptions

import org.springframework.http.HttpStatus

data class StockDoesntExistException(val ticker: String) :
    CustomException("Ticker $ticker doesn't exist!", HttpStatus.NOT_FOUND)
