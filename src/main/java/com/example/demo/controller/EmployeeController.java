package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/findAll")
    public String findAll(Model model){
        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "findAll";
    }

    @GetMapping("/creat")
    public String createEmployeeHTML(){
        return "creat";
    }

    @PostMapping(path = "/creatEmployee", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })

    public String createEmployee( EmployeeDTO employeeDTO){
        employeeService.createEmployee(employeeDTO);
        return "redirect:/findAll";
    }
}
