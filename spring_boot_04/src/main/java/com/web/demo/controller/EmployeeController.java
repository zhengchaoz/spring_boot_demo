package com.web.demo.controller;

import com.web.demo.dao.DepartmentDao;
import com.web.demo.dao.EmployeeDao;
import com.web.demo.entities.Department;
import com.web.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 郑超
 * @date 2021-05-03 21:26
 */
@Controller
public class EmployeeController {

    final EmployeeDao employeeDao;

    final DepartmentDao departmentDao;

    public EmployeeController(EmployeeDao employeeDao, DepartmentDao departmentDao) {
        this.employeeDao = employeeDao;
        this.departmentDao = departmentDao;
    }

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps", all);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "/emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
