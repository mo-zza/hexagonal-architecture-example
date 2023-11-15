package com.example.hexagonalarchitectureexample.application.port.in;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;

import java.util.Set;
import java.util.UUID;

public interface GetCampSiteUseCase {
    Set<CampSite> getAllCampSites();

    CampSite getCampSiteById(GetCampSiteByIdQuery query);

    record GetCampSiteByIdQuery(UUID campSiteId) {
    }
}
