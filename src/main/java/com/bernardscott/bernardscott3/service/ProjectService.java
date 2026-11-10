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
                        2L,
                        "Portfolio",
                        "portfolio-website",
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
                        "mock-fia-f1-relational-database",
                        "Relational database developed to supply historical statistics of previous races.",
                        "https://github.com/BernardScottIII/FIA-Mock-F1-Relational-Database",
                        false,
                        3,
                        List.of(
                                technologyService.getTechnology(TechnologyType.POSTGRESQL)
                        )
                ),
                new Project(
                        4L,
                        "Patent Document Generation Using Fine-Tuned Large Language Models",
                        "patent-document-generation-llm",
                        "A machine learning research project exploring fine-tuned language models for generating technically accurate patent specifications and claims from minimal inventor input. The work includes a patent-data collection and preprocessing pipeline, parameter-efficient model fine-tuning, cloud-based experimentation, and quantitative and qualitative evaluation of generated outputs.",
                        "https://github.com/elugos/LLM9010-patents",
                        false,
                        4,
                        List.of(
                                technologyService.getTechnology(TechnologyType.JAVA),
                                technologyService.getTechnology(TechnologyType.SPRING_BOOT),
                                technologyService.getTechnology(TechnologyType.PYTORCH),
                                technologyService.getTechnology(TechnologyType.JUPYTER_NOTEBOOK)
                        )
                ),
                new Project(
                        5L,
                        "Stack Overflow Language & Tool Recommender System",
                        "stack-overflow-recommender-system",
                        "A machine learning project analyzing Stack Overflow's 2025 Developer Survey to recommend programming tools and languages, estimate salary impact, and explore developer career trends. It combines a supervised Random Forest salary prediction model with a neural network recommender that finds developers with similar backgrounds, supported by survey data processing, feature engineering, and model evaluation.",
                        "https://github.com/BernardScottIII/stack-overflow-recommender-system",
                        false,
                        5,
                        List.of(
                                technologyService.getTechnology(TechnologyType.PYTHON),
                                technologyService.getTechnology(TechnologyType.SCIKIT_LEARN),
                                technologyService.getTechnology(TechnologyType.PYTORCH),
                                technologyService.getTechnology(TechnologyType.NUMPY),
                                technologyService.getTechnology(TechnologyType.PANDAS),
                                technologyService.getTechnology(TechnologyType.MATPLOTLIB),
                                technologyService.getTechnology(TechnologyType.JUPYTER_NOTEBOOK)
                        )
                ),
                new Project(
                        6L,
                        "Professional Impact of Mid-Career Team Transition",
                        "nfl-trade-impact",
                        "A sports analytics research project using NFL player data from 1920 to 2016 to study how changing teams relates to career longevity, playing opportunities, postseason participation, and performance. It combines historical data cleaning and exploratory analysis with classification, principal component analysis, and clustering to investigate player transitions and career outcomes.",
                        "https://github.com/BernardScottIII/nfl-trade-impact",
                        false,
                        6,
                        List.of(
                                technologyService.getTechnology(TechnologyType.PYTHON),
                                technologyService.getTechnology(TechnologyType.PANDAS),
                                technologyService.getTechnology(TechnologyType.NUMPY),
                                technologyService.getTechnology(TechnologyType.MATPLOTLIB),
                                technologyService.getTechnology(TechnologyType.SEABORN),
                                technologyService.getTechnology(TechnologyType.SCIKIT_LEARN)
                        )
                ),
                new Project(
                        7L,
                        "Goalympians",
                        "goalympians",
                        "A native iOS fitness application for recording workouts, managing exercises, synchronizing training data through Firebase, and exploring exercise trends with analytics. Built as a capstone project, it combines SwiftUI mobile development, local and cloud persistence, account authentication, Apple Health integration, and workout data visualization.",
                        "https://github.com/BernardScottIII/Golympians",
                        false,
                        7,
                        List.of(
                                technologyService.getTechnology(TechnologyType.SWIFT),
                                technologyService.getTechnology(TechnologyType.SWIFT_UI),
                                technologyService.getTechnology(TechnologyType.SWIFT_DATA),
                                technologyService.getTechnology(TechnologyType.CORE_DATA),
                                technologyService.getTechnology(TechnologyType.FIREBASE_AUTHENTICATION),
                                technologyService.getTechnology(TechnologyType.FIRESTORE),
                                technologyService.getTechnology(TechnologyType.HEALTH_KIT),
                                technologyService.getTechnology(TechnologyType.SWIFT_CHARTS),
                                technologyService.getTechnology(TechnologyType.XCODE),
                                technologyService.getTechnology(TechnologyType.IOS_SDK),
                                technologyService.getTechnology(TechnologyType.SWIFT_TESTING),
                                technologyService.getTechnology(TechnologyType.XCTEST)
                        )
                ),
                new Project(
                        8L,
                        "FoamMetrics: Quantifying Disorder in Polygonal Networks",
                        "foammetrics",
                        "A computational geometry and scientific computing research project that measures disorder in two-dimensional foams and polygonal networks using turning-distance metrics. The work combines mathematical analysis with Python simulations of Voronoi structures, topological network transitions, and edge-rupture processes to study how geometric disorder evolves across cellular systems.",
                        "https://github.com/Scranton-foam-projects-24/foammetrics",
                        false,
                        8,
                        List.of(
                                technologyService.getTechnology(TechnologyType.PYTHON),
                                technologyService.getTechnology(TechnologyType.NUMPY),
                                technologyService.getTechnology(TechnologyType.SCIPY),
                                technologyService.getTechnology(TechnologyType.SYMPY),
                                technologyService.getTechnology(TechnologyType.MATPLOTLIB),
                                technologyService.getTechnology(TechnologyType.NETWORKX),
                                technologyService.getTechnology(TechnologyType.PYVORO)
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
