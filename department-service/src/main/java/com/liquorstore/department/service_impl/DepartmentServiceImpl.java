package com.liquorstore.department.service_impl;

import com.liquorstore.department.entity.Department;
import com.liquorstore.department.repository.DepartmentRepository;
import com.liquorstore.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside saveDepartment of DepartmentService");



        return departmentRepository.findByDepartmentId(departmentId);
    }

}
