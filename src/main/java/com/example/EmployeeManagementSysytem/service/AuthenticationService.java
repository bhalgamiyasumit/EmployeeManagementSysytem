package com.example.EmployeeManagementSysytem.service;

import com.example.EmployeeManagementSysytem.constants.MessageConstants;
import com.example.EmployeeManagementSysytem.exception.DataNotFoundException;
import com.example.EmployeeManagementSysytem.model.Employee;
import com.example.EmployeeManagementSysytem.model.request.LoginReq;
import com.example.EmployeeManagementSysytem.repository.DepartmentRepository;
import com.example.EmployeeManagementSysytem.repository.EmployeeRepository;
import com.example.EmployeeManagementSysytem.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author sumit bhalgamiya on date 10/04/2022
 */
@Service
public class AuthenticationService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     *
     * @return String
     * @throws DataNotFoundException
     */
    public String registration(Employee employee) {
        List<Employee> employees = employeeRepository.findAll();
/*
         System.out.println("New Employee: " + employee.toString());
        for (Employee emp : employees) {
            System.out.println("Registered Employee: " + employee.toString());
            if (emp.equals(employee)) {
                System.out.println("User Already exists!");
                return MessageConstants.USER_ALREADY_EXISTS;
            }
       }
 */
        employeeRepository.save(employee);
        return MessageConstants.SUCCESS1;
    }

    /**
     *
     * @return MessageResponse
     */
    public MessageResponse Login(LoginReq loginReq) {
        Employee emp = employeeRepository.findByEmailIdAndPassword(loginReq.getEmailId(), loginReq.getPassword());
        if (emp != null) {
            return new MessageResponse(MessageConstants.LOGINSUCCESS + " Department is:" +
                    emp.getDepartmentMaster().getDeptName());
        } else {
            return new MessageResponse(MessageConstants.LOGINFAILURE);
        }
    }


}

