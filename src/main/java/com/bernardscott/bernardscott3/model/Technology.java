package com.bernardscott.bernardscott3.model;

import jakarta.persistence.*;

@Entity
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String filename;

    protected Technology() {}

    public Technology(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }
}