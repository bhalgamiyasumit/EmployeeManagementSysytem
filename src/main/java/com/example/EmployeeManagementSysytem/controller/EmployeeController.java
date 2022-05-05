package com.example.EmployeeManagementSysytem.controller;

import com.example.EmployeeManagementSysytem.model.Employee;
import com.example.EmployeeManagementSysytem.repository.DepartmentRepository;
import com.example.EmployeeManagementSysytem.response.MessageResponse;
import com.example.EmployeeManagementSysytem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/**
 * @author sumit bhalgamiya on date 02/04/2022
 */
@Validated
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> saveEmp(@Valid @RequestBody Employee employee) {
        MessageResponse responseMsg = employeeService.createEmp(employee);
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public Optional<Employee> updateDept(@Valid @RequestBody Employee employee, @PathVariable Integer empId ){
        return employeeService.updateEmployee(employee, empId);
    }


    @GetMapping("/get/{empId}")
    public Employee getbyId(@PathVariable("empId") Integer empId) {
        return employeeService.getempById(empId);
    }


    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<MessageResponse> delete(@PathVariable("empId") Integer empId) {
        MessageResponse responseMsg = employeeService.deleteEmp(empId);
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public List<Employee> getAll() {
        return employeeService.getAllemployees();
    }
}
