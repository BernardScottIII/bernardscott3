package com.bernardscott.bernardscott3.model;

public enum TechnologyType {
    JAVA("Java", "java.png"),
    SPRING_BOOT("Spring Boot", "springboot.png"),
    PYTHON("Python", "python.png"),
    NODE_JS("Node.js", "nodejs.png"),
    JAVASCRIPT("JavaScript", "javascript.png"),
    SWIFT("Swift", "swift.png"),
    POSTGRESQL("PostgreSQL", "postgresql.png"),
    FIRESTORE("Firestore", "firestore.png"),
    PYTORCH("PyTorch", "pytorch.png");

    private final String displayName;
    private final String filename;

    TechnologyType(String displayName, String filename) {
        this.displayName = displayName;
        this.filename = filename;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getFilename() {
        return filename;
    }
}
