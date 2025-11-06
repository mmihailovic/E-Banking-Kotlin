package org.example.userservice.service.impl

import org.example.userservice.dto.EditEmployeeDTO
import org.example.userservice.dto.EmployeeCreateDTO
import org.example.userservice.dto.EmployeeDTO
import org.example.userservice.exception.UserNotFoundException
import org.example.userservice.mapper.EmployeeMapper
import org.example.userservice.model.user.Employee
import org.example.userservice.repository.EmployeeRepository
import org.example.userservice.repository.RoleRepository
import org.example.userservice.service.EmployeeService
import org.example.userservice.util.JMBGValidator
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    val employeeRepository: EmployeeRepository,
    val employeeMapper: EmployeeMapper,
    val roleRepository: RoleRepository,
    val bCryptPasswordEncoder: BCryptPasswordEncoder
) : EmployeeService {
    override fun createNewEmployee(employeeCreateDTO: EmployeeCreateDTO): EmployeeDTO {
        val employee: Employee = employeeMapper.employeeCreateDTOtoEmployee(employeeCreateDTO)

        JMBGValidator.validateJMBG(employee.dateOfBirth, employee.JMBG)

        return employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employee))
    }

    override fun editEmployee(editEmployeeDTO: EditEmployeeDTO): EmployeeDTO {
        val employee: Employee = employeeRepository.findById(editEmployeeDTO.id)
            .orElseThrow { UserNotFoundException("Employee with id " + editEmployeeDTO.id + " not found!") }

        updateIfPresent({ employee.lastName = it }, editEmployeeDTO.lastName)
        updateIfPresent({ employee.gender = it }, editEmployeeDTO.gender)
        updateIfPresent({ employee.phoneNumber = it }, editEmployeeDTO.phoneNumber)
        updateIfPresent({ employee.userPassword = it }, bCryptPasswordEncoder.encode(editEmployeeDTO.password))
        updateIfPresent({ employee.position = it }, editEmployeeDTO.position)
        updateIfPresent({ employee.address = it }, editEmployeeDTO.address)
        updateIfPresent({ employee.department = it }, editEmployeeDTO.department)
        employee.active = editEmployeeDTO.active

        employee.roles = editEmployeeDTO.roles.map { role ->
            roleRepository.findByName(role)
                .orElseThrow()
        }.toMutableList()

        return employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employee))
    }

    override fun getAllActiveEmployees(): List<EmployeeDTO> {
        return employeeRepository.findAllByActiveIsTrue().stream().map(employeeMapper::employeeToEmployeeDTO).toList()
    }

    override fun findActiveEmployeeByEmail(email: String): EmployeeDTO {
        return employeeMapper.employeeToEmployeeDTO(
            employeeRepository
                .findByEmailAndActiveIsTrue(email)
                .orElseThrow { UserNotFoundException("Employee with email $email not found!") })
    }

    override fun findActiveEmployeeById(id: Long): EmployeeDTO {
        return employeeMapper.employeeToEmployeeDTO(
            employeeRepository
                .findById(id)
                .orElseThrow { UserNotFoundException("Employee with ID $id not found!") })
    }

    fun updateIfPresent(setter: (String) -> Unit, value: String?) {
        if (!value.isNullOrBlank()) setter(value)
    }
}