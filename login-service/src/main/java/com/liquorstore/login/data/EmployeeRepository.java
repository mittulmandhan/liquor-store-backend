package com.liquorstorebackend.login.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liquorstorebackend.login.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
