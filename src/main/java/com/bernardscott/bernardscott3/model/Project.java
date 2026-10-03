package com.bernardscott.bernardscott3.model;

import jakarta.persistence.*;

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

    private String githubUrl;

    @Column(nullable = false)
    private boolean featured;

    @Column(nullable = false)
    private int displayOrder;

    protected  Project() {}

    public Project(Long id, String title, String slug, String description, String githubUrl, boolean isFeatured, int displayOrder) {

        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.githubUrl = githubUrl;
        this.featured = isFeatured;
        this.displayOrder = displayOrder;
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
}
