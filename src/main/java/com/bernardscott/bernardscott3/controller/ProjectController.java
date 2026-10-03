package com.bernardscott.bernardscott3.controller;

import com.bernardscott.bernardscott3.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projectService.getProjects());

        return "projects";
    }
}
