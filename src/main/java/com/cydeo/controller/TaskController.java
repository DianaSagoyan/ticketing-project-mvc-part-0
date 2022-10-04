package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;

    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("task", new TaskDTO());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());
        return "task/create";
    }

    @PostMapping("/create")
    public String projectSave(@ModelAttribute("task") TaskDTO task){


        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    public String editTask(Model model, @PathVariable("taskId") Long taskId){

        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }

//    @PostMapping("/update")
//    public String updateTask( @PathVariable("taskId") Long taskId, @ModelAttribute("task") TaskDTO task){
//
//        task.setId(taskId);
//
//        taskService.save(task);
//
//        return "redirect:/task/create";
//    }

    @PostMapping("/update/{id}")
    public String updateTask(@ModelAttribute("task") TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";
    }
}
