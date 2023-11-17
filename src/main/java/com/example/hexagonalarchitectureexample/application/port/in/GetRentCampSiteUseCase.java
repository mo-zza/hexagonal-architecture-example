package com.example.hexagonalarchitectureexample.application.port.in;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.port.in.query.GetRentCampSiteQuery;

import java.util.Set;

public interface GetRentCampSiteUseCase {
    Set<CampSite> getRentCampSitesByMemberId(GetRentCampSiteQuery query);
}
