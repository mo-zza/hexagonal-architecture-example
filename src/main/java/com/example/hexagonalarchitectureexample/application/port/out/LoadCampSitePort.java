package com.example.hexagonalarchitectureexample.application.port.out;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface LoadCampSitePort {

    Set<CampSite> loadAllCampSites();

    Optional<CampSite> loadCampSiteById(UUID id);
}
