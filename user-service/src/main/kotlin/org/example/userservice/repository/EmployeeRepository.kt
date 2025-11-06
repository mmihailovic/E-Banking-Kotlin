package org.example.userservice.repository

import org.example.userservice.model.user.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long> {
    fun findAllByActiveIsTrue(): List<Employee>
    fun findByEmailAndActiveIsTrue(email: String): Optional<Employee>
}