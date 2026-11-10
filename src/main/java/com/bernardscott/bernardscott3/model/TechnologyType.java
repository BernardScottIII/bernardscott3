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
    PYTORCH("PyTorch", "pytorch.png"),
    JUPYTER_NOTEBOOK("Jupyter Notebook", "jupyterNotebook.png"),
    SCIKIT_LEARN("Scikit-learn", ""),
    NUMPY("NumPy", ""),
    PANDAS("Pandas", ""),
    MATPLOTLIB("Matplotlib", ""),
    SEABORN("Seaborn", ""),
    SWIFT_UI("SwiftUI", ""),
    SWIFT_DATA("SwiftData", ""),
    CORE_DATA("Core Data", ""),
    FIREBASE_AUTHENTICATION("Firebase Authentication", ""),
    HEALTH_KIT("HealthKit", ""),
    SWIFT_CHARTS("Swift Charts", ""),
    XCODE("Xcode", ""),
    IOS_SDK("iOS SDK", ""),
    SWIFT_TESTING("Swift Testing", ""),
    XCTEST("XCTest", ""),
    SCIPY("SciPy", ""),
    SYMPY("SymPy", ""),
    NETWORKX("NetworkX", ""),
    PYVORO("Pyvoro", "");

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
