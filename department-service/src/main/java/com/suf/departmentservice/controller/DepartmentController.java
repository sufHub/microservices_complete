package com.suf.departmentservice.controller;

import com.suf.departmentservice.entity.Department;
import com.suf.departmentservice.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@Log4j2
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController");System.out.println("DEpartment ID : "+departmentId);
        return departmentService.findDepartmentById(departmentId);
    }

}
