package com.example.EmployeeManagementSysytem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author sumit bhalgamiya on date 03/04/2022
 * @Definition: Department Main class
 */
@Validated
@Entity
@Table(name = "departmentMaster")
@Setter
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;

    @NotNull
    @Column(name = "DeptName")
    private String deptName;

}
