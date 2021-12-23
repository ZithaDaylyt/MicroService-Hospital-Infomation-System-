package com.springproject.hrservice.resources;

import com.springproject.hrservice.model.Employee;
import com.springproject.hrservice.model.EmployeeList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hr")
public class HrResources {

    List<Employee> employees = Arrays.asList(
            new Employee("e1", "Sibusiso", "Nkosi", "Meditech"),
            new Employee("e2", "Lila", "Hardcastle", "Surgery"),
            new Employee("e3", "Prince", "Chucks", "Dentistry")
    );

    @RequestMapping("/employees")
    public EmployeeList getEmployees(){
        EmployeeList employeeList = new EmployeeList();
        employeeList.setEmployees(employees);
        return employeeList;
    }

    @RequestMapping("/employees/{Id}")
    public Employee getEmployeeById(@PathVariable("Id") String Id){
        Employee e = employees.stream()
                .filter(employee -> Id.equals(employee.getId()))
                .findAny()
                .orElse(null);
        return e;
    }
}
