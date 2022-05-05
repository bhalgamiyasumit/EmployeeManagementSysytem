package com.example.EmployeeManagementSysytem.repository;

import com.example.EmployeeManagementSysytem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sumit bhalgamiya on date 03/04/2022
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    /**
     *
     * @param deptId
     */
    Department findByDeptId(int deptId);

}
