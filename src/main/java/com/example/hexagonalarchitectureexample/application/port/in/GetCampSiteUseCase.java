package com.example.hexagonalarchitectureexample.application.port.in;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.port.in.query.GetCampSiteByIdQuery;

import java.util.Set;

public interface GetCampSiteUseCase {
    Set<CampSite> getAllCampSites();

    CampSite getCampSiteById(GetCampSiteByIdQuery query);
}
