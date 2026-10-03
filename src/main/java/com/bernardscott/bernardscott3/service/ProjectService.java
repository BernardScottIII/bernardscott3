package com.bernardscott.bernardscott3.service;

import com.bernardscott.bernardscott3.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    public List<Project> getProjects() {
        return List.of(
                new Project(
                        1L,
                        "BeerList",
                        "beerlist",
                        "An iPadOS application for managing shared beer lists.",
                        "https://github.com/yourusername/beerlist",
                        false,
                        1
                ),
                new Project(
                        2L,
                        "Portfolio",
                        "portfolioWebsite",
                        "A personal portfolio application built with Java and Spring Boot.",
                        "https://github.com/yourusername/portfolio",
                        false,
                        2
                )
        );
    }
}
