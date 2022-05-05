package com.example.EmployeeManagementSysytem.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sumit bhalgamiya on date 12/04/2022
 */
public class MessageResponse {

    @Getter
    @Setter
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }


}
