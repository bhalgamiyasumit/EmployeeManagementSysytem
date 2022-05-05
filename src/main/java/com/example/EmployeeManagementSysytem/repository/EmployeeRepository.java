package com.example.EmployeeManagementSysytem.repository;

import com.example.EmployeeManagementSysytem.exception.DataNotFoundException;
import com.example.EmployeeManagementSysytem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sumit bhalgamiya on date 02/04/2022
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /**
     *
     * @param emailId
     * @param password
     */
    Employee findByEmailIdAndPassword(String emailId, String password);

    /**
     *
     * @param empId
     */
    Employee findByEmpId(Integer empId);

}