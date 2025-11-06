package org.example.userservice.controller

import org.example.userservice.dto.CompanyCreateDTO
import org.example.userservice.dto.CompanyDTO
import org.example.userservice.service.CompanyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kotlin/company")
class CompanyController(val companyService: CompanyService) {
    @GetMapping
    fun getAllCompanies(): ResponseEntity<List<CompanyDTO>> {
        return ResponseEntity<List<CompanyDTO>>(companyService.getAllCompanies(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getCompanyById(@PathVariable("id") id: Long): ResponseEntity<CompanyDTO> {
        return ResponseEntity<CompanyDTO>(companyService.findCompanyById(id), HttpStatus.OK)
    }

    @PostMapping
    fun createCompany(@RequestBody companyCreateDTO: CompanyCreateDTO): ResponseEntity<CompanyDTO> {
        return ResponseEntity<CompanyDTO>(companyService.createCompany(companyCreateDTO), HttpStatus.CREATED)
    }

    @PutMapping("/{TIN}/account/{accountNumber}")
    fun addAccountToCompany(
        @PathVariable("TIN") TIN: Int,
        @PathVariable("accountNumber") accountNumber: Long
    ): ResponseEntity<Long> {
        return ResponseEntity<Long>(companyService.addBankAccountToCompany(TIN, accountNumber), HttpStatus.OK)
    }
}