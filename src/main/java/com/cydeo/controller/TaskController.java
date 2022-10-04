package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("task", new TaskDTO());
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
        model.addAttribute("tasks", taskService.findAll());
        return "/task/update";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute("task") TaskDTO task){

        taskService.update(task);

        return "redirect:/task/create";
    }


    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id){
        taskService.deleteById(id);
        return "redirect:/task/create";
    }
}
