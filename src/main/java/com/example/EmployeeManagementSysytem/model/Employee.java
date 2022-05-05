package com.example.EmployeeManagementSysytem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author sumit bhalgamiya on date 02/04/2022
 */

@Validated
@Entity
@Table(name = "employees")
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @OneToOne
    private Department departmentMaster;

    @NotBlank(message = "empName is mandatory")
    @Column(name = "empName")
    private String empName;

    @NotNull(message = "salary is mandatory")
    @Column(name = "salary")
    private long salary;

    @NotBlank(message = "empAddress is mandatory")
    @Column(name = "empAddress")
    private String empAdress;

    @Column(name = "mobileNumber", unique = true)
    private long mobileNumber;

    @Email
    @NotEmpty
    @Column(name = "emailId", unique = true)
    private String emailId;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", departmentMaster=" + departmentMaster +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", empAdress='" + empAdress + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
