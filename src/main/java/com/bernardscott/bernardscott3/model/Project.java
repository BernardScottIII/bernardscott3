package com.bernardscott.bernardscott3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column
    private String githubUrl;

    @Column(nullable = false)
    private boolean featured;

    @Column(nullable = false)
    private int displayOrder;

    @ManyToMany
    @JoinTable(
            name = "project_technology",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies;

    protected  Project() {}

    public Project(Long id, String title, String slug, String description, String githubUrl, boolean isFeatured, int displayOrder, List<Technology> technologies) {

        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.githubUrl = githubUrl;
        this.featured = isFeatured;
        this.displayOrder = displayOrder;
        this.technologies = technologies;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public boolean isFeatured() {
        return featured;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
