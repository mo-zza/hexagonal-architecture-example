package com.example.hexagonalarchitectureexample.application.port.in;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;

import java.util.Set;
import java.util.UUID;

public interface GetRentCampSiteUseCase {
    Set<CampSite> getRentCampSitesByMemberId(GetRentCampSiteQuery query);

    record GetRentCampSiteQuery(UUID memberId) {
    }
}
