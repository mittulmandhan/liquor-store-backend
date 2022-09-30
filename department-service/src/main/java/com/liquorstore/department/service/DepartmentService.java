package com.liquorstore.department.service;

import com.liquorstore.department.entity.Department;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public Department findDepartmentById(Long departmentId);
}
