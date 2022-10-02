package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @GetMapping("/project/create")
    public String projectCreatePage(){

        return "/create";
    }
}
