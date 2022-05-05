package com.example.EmployeeManagementSysytem.controller;

import com.example.EmployeeManagementSysytem.model.Employee;
import com.example.EmployeeManagementSysytem.model.request.LoginReq;
import com.example.EmployeeManagementSysytem.response.MessageResponse;
import com.example.EmployeeManagementSysytem.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


/**
 *@author sumit Bhalgamiya on date 10/04/2022
 *@Definition: Authentications Api
 */

@RestController
@RequestMapping("/employee")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public String registerEmp(@Valid @RequestBody Employee employee) {
        return authenticationService.registration(employee);
    }

    @PostMapping("/login")
    public ResponseEntity<MessageResponse> loginEmp(@RequestBody LoginReq loginReq) {
        MessageResponse response = authenticationService.Login(loginReq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

