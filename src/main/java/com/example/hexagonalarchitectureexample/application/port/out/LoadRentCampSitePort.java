package com.example.hexagonalarchitectureexample.application.port.out;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;

import java.util.Set;
import java.util.UUID;

public interface LoadRentCampSitePort {
    Set<CampSite> loadRentCampSitesByMemberId(UUID memberId);
}
