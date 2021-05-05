package com.demo.controller;


import com.demo.bean.Department;
import com.demo.bean.Employee;
import com.demo.mapper.DepartmentMapper;
import com.demo.mapper.EmployeeMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    final DepartmentMapper departmentMapper;

    final EmployeeMapper employeeMapper;

    public DeptController(DepartmentMapper departmentMapper, EmployeeMapper employeeMapper) {
        this.departmentMapper = departmentMapper;
        this.employeeMapper = employeeMapper;
    }


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    @Transactional
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        System.err.println("Inserted successfully");
        System.err.println("---> 1/0 = " + (1 / 0));
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }


}
