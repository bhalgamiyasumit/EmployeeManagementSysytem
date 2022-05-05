package com.example.EmployeeManagementSysytem.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sumit bhalgamiya on date 10/04/2022
 * @Definition: Loginreq class
 */
@Getter
@Setter
public class LoginReq {

    public int empId;
    public String emailId;
    public String password;

}
