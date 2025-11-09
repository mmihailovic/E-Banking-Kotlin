package org.example.transactionservice.controller

import jakarta.validation.Valid
import org.example.transactionservice.dto.*
import org.example.transactionservice.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/payment")
class PaymentController(private val paymentService: PaymentService) {
    @PostMapping("/internal")
    fun createInternalPayment(@RequestBody internalPaymentCreateDT0: @Valid InternalPaymentCreateDTO)
    : ResponseEntity<InternalPaymentDTO> {
        return ResponseEntity<InternalPaymentDTO>(
            paymentService.createInternalPayment(internalPaymentCreateDT0), HttpStatus.CREATED
        )
    }

    @PostMapping("/external")
    fun createExternalPayment(@RequestBody externalPaymentCreateDTO: @Valid ExternalPaymentCreateDTO)
    : ResponseEntity<ExternalPaymentDTO> {
        return ResponseEntity<ExternalPaymentDTO>(
            paymentService.createExternalPayment(externalPaymentCreateDTO), HttpStatus.CREATED
        )
    }

    @GetMapping("/account/{accountNumber}")
    fun getAllPaymentsForBankAccountNumber(@PathVariable("accountNumber") accountNumber: Long)
    : ResponseEntity<List<PaymentDTO>> {
        return ResponseEntity<List<PaymentDTO>>(
            paymentService.getAllPaymentsByAccountNumber(accountNumber), HttpStatus.OK
        )
    }

    @GetMapping("/{id}")
    fun getPaymentDetailsByID(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(paymentService.getPaymentDetails(id), HttpStatus.OK)
    }
}