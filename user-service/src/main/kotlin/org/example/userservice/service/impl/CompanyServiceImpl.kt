package org.example.userservice.service.impl

import org.example.userservice.dto.CompanyCreateDTO
import org.example.userservice.dto.CompanyDTO
import org.example.userservice.mapper.CompanyMapper
import org.example.userservice.model.user.Company
import org.example.userservice.repository.CompanyRepository
import org.example.userservice.service.CompanyService
import org.example.userservice.exception.CompanyNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyServiceImpl(val companyRepository: CompanyRepository, val companyMapper: CompanyMapper) : CompanyService {
    override fun createCompany(companyCreateDTO: CompanyCreateDTO): CompanyDTO {
        return companyMapper.companyToCompanyDTO(
            companyRepository.save(
                companyMapper.companyCreateDTOtoCompany(
                    companyCreateDTO
                )
            )
        )
    }

    override fun findCompanyById(id: Long): CompanyDTO {
        return companyMapper.companyToCompanyDTO(
            companyRepository.findById(id)
                .orElseThrow { CompanyNotFoundException("Company with ID $id not found!") })
    }

    override fun getAllCompanies(): List<CompanyDTO> {
        return companyRepository.findAll().stream().map(companyMapper::companyToCompanyDTO).toList()
    }

    override fun addBankAccountToCompany(TIN: Int, bankAccountNumber: Long): Long? {
        val optionalCompany: Optional<Company> = companyRepository.findByTIN(TIN)

        if (optionalCompany.isEmpty()) {
            return null
        }

        val company: Company = optionalCompany.get()

        if (company.accountNumbers == null) {
            company.accountNumbers = bankAccountNumber.toString()
            companyRepository.save(company)
            return company.id
        }

        if (company.accountNumbers!!.contains(bankAccountNumber.toString())) {
            return null
        }

        company.accountNumbers = company.accountNumbers + "," + bankAccountNumber
        companyRepository.save(company)
        return company.id
    }
}