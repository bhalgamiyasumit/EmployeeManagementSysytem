package com.example.EmployeeManagementSysytem.service;

import com.example.EmployeeManagementSysytem.exception.DataNotFoundException;
import com.example.EmployeeManagementSysytem.model.Employee;
import com.example.EmployeeManagementSysytem.repository.DepartmentRepository;
import com.example.EmployeeManagementSysytem.repository.EmployeeRepository;
import com.example.EmployeeManagementSysytem.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author sumit bhalgamiya on date 02/04/2022
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     *
     * @return Message Response
     */
    public MessageResponse createEmp(Employee employee) {
            Employee newemp = new Employee();
            newemp.setDepartmentMaster(employee.getDepartmentMaster());
            newemp.setEmailId(employee.getEmailId());
            newemp.setEmpAdress(employee.getEmpAdress());
            newemp.setEmpName(employee.getEmpName());
            newemp.setMobileNumber(employee.getMobileNumber());
            newemp.setPassword(employee.getPassword());
            newemp.setSalary(employee.getSalary());
            employeeRepository.save(newemp);
            return new MessageResponse("Employee Added Successfully !!!");
        }
    /**
     *
     * @param empId
     * @return
     * @throws DataNotFoundException
     */
    public Optional<Employee> updateEmployee(Employee employee, Integer empId) throws DataNotFoundException {
            Optional<Employee> updateEmployee = employeeRepository.findById(empId);
            if (updateEmployee.isEmpty()) {
                throw new DataNotFoundException("Employee ", "id", empId);
            }
            else {
                updateEmployee.get().setEmpId(employee.getEmpId());
                updateEmployee.get().setSalary(employee.getSalary());
                updateEmployee.get().setMobileNumber(employee.getMobileNumber());
                updateEmployee.get().setEmpName(employee.getEmpName());
                updateEmployee.get().setEmpAdress(employee.getEmpAdress());
                updateEmployee.get().setEmailId(employee.getEmailId());
                updateEmployee.get().setDepartmentMaster(employee.getDepartmentMaster());
                updateEmployee.get().setPassword(employee.getPassword());
                employeeRepository.save(updateEmployee.get());
                return updateEmployee;
            }
        }

    /**
     *
     * @param empId
     * @return
     */
    public Employee getempById(Integer empId) {
            return employeeRepository.findByEmpId(empId);
        }

    /**
     *
     * @param empId
     * @return Message Response
     * @throws DataNotFoundException
     */
    public MessageResponse deleteEmp(Integer empId) throws DataNotFoundException {
            if (employeeRepository.getById(empId).getEmpId().equals(empId))
            {
                employeeRepository.deleteById(empId);
                return new MessageResponse("Employee Deleted Successfully !!!");
            }
            else {
                throw new DataNotFoundException("Employee ", " Id", empId);
            }
        }

    /**
     *
     * @return
     */
    public List<Employee> getAllemployees() {
        return employeeRepository.findAll();
    }

}
