package com.example.EmployeeManagementSysytem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author-sumit bhalgamiya on Date 07/10/2022
 * @Definition: Exception for notfound api
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public DataNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s is not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

