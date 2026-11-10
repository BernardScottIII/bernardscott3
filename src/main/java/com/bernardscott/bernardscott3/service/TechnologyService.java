package com.bernardscott.bernardscott3.service;

import com.bernardscott.bernardscott3.model.Technology;
import com.bernardscott.bernardscott3.model.TechnologyType;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyService {

    private final Map<TechnologyType, Technology> technologiesByType = new EnumMap<>(TechnologyType.class);
    private final List<Technology> technologies;

    public TechnologyService() {
        for (TechnologyType type : TechnologyType.values()) {
            technologiesByType.put(type, new Technology(type.getDisplayName(), type.getFilename()));
        }
        technologies = List.copyOf(technologiesByType.values());
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public Technology getTechnology(TechnologyType type) {
        return technologiesByType.get(type);
    }
}
