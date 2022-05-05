package com.example.EmployeeManagementSysytem.service;

import com.example.EmployeeManagementSysytem.exception.DataNotFoundException;
import com.example.EmployeeManagementSysytem.model.Department;
import com.example.EmployeeManagementSysytem.repository.DepartmentRepository;
import com.example.EmployeeManagementSysytem.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


/**
 * @author sumit bhalgamiya on date 03/04/2022
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     *
     * @return Message Response
     */
    public MessageResponse saveDepartment(Department department) {
        Department newDept = new Department();
        newDept.setDeptName(department.getDeptName());
        departmentRepository.save(newDept);
        return new MessageResponse("Department Added Successfully !!!");
    }

    /**
     *
     * @param deptId
     * @return Message Response
     * @throws DataNotFoundException
     */
    public Optional<Department> updateDepartment(Department department, Integer deptId) throws DataNotFoundException {
        Optional<Department> updateDepartment = departmentRepository.findById(deptId);
        if (updateDepartment.isEmpty()) {
            throw new DataNotFoundException("Department ", "id", deptId);
        }
        else {
            updateDepartment.get().setDeptName(department.getDeptName());
            departmentRepository.save(updateDepartment.get());
            System.out.println(new MessageResponse("Department updated successfully!!!"));
            return updateDepartment;
        }
    }

    /**
     *
     * @return
     */
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    /**
     *
     * @param deptId
     * @return Message Response
     * @throws DataNotFoundException
     */
    public void deleteDept(Integer deptId) throws DataNotFoundException {
        if (departmentRepository.getById(deptId).getDeptId().equals(deptId)) {

            departmentRepository.deleteById(deptId);
            System.out.println(new MessageResponse("Department deleted successfully!!!"));
        }
        else {
            throw new DataNotFoundException("Department ", " Id", deptId);
        }
    }

}
