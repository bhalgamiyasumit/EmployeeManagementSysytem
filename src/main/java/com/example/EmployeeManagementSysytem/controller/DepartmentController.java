package com.example.EmployeeManagementSysytem.controller;


import com.example.EmployeeManagementSysytem.model.Department;
import com.example.EmployeeManagementSysytem.service.DepartmentService;
import com.example.EmployeeManagementSysytem.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author sumit bhalgamiya on date 03/04/2022
 */
@Validated
@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> saveDept(@Valid @RequestBody Department department) {
        MessageResponse responseMsg = departmentService.saveDepartment(department);
        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

    @PutMapping("/update/{deptId}")
    public Optional<Department> updateDept(@Valid @RequestBody Department department, @PathVariable Integer deptId) {
        return departmentService.updateDepartment(department, deptId);
    }

    @GetMapping("/getall")
    public List<Department> getAll() {
        return departmentService.getAllDepartment();
    }

    @DeleteMapping("/delete/{deptId}")
    public void deletedepartment(@PathVariable Integer deptId) {
        departmentService.deleteDept(deptId);
    }
}
