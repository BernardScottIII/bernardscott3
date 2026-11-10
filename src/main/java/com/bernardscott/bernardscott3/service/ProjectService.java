package com.bernardscott.bernardscott3.service;

import com.bernardscott.bernardscott3.model.Project;
import com.bernardscott.bernardscott3.model.TechnologyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final TechnologyService technologyService;
    private final List<Project> projects;

    public ProjectService(TechnologyService technologyService) {
        this.technologyService = technologyService;

        this.projects = List.of(
                new Project(
                        1L,
                        "BeerList",
                        "beerlist",
                        "An iPadOS application for managing shared beer lists.",
                        "https://github.com/yourusername/beerlist",
                        false,
                        1,
                        List.of(
                                technologyService.getTechnology(TechnologyType.SWIFT),
                                technologyService.getTechnology(TechnologyType.FIRESTORE)
                        )
                ),
                new Project(
                        2L,
                        "Portfolio",
                        "portfolioWebsite",
                        "A personal portfolio application built with Java and Spring Boot.",
                        "https://github.com/yourusername/portfolio",
                        false,
                        2,
                        List.of(
                                technologyService.getTechnology(TechnologyType.JAVA),
                                technologyService.getTechnology(TechnologyType.SPRING_BOOT),
                                technologyService.getTechnology(TechnologyType.POSTGRESQL)
                        )
                ),
                new Project(
                        3L,
                        "Mock FiA F1 Relational Database",
                        "mockfiaf1relationaldatabase",
                        "Relational database developed to supply historical statistics of previous races.",
                        "https://github.com/BernardScottIII/FIA-Mock-F1-Relational-Database",
                        false,
                        3,
                        List.of(
                                technologyService.getTechnology(TechnologyType.POSTGRESQL)
                        )
                )
        );
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project getProjectById(Long id) {
        return projects.stream()
                .filter(project -> project.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
