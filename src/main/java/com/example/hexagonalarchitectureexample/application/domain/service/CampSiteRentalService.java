package com.example.hexagonalarchitectureexample.application.domain.service;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.port.in.GetCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.GetRentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.RentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.out.LoadCampSitePort;
import com.example.hexagonalarchitectureexample.application.port.out.LoadRentCampSitePort;
import com.example.hexagonalarchitectureexample.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@UseCase
@Service
@RequiredArgsConstructor
public class CampSiteRentalService implements GetCampSiteUseCase, GetRentCampSiteUseCase, RentCampSiteUseCase {
    private final LoadCampSitePort loadCampSitePort;
    private final LoadRentCampSitePort loadRentCampSitePort;


    @Override
    public Set<CampSite> getAllCampSites() {
        return loadCampSitePort.loadAllCampSites();
    }

    @Override
    public CampSite getCampSiteById(GetCampSiteByIdQuery query) {
        return loadCampSitePort.loadCampSiteById(query.campSiteId())
                .orElseThrow(() -> new IllegalArgumentException("CampSite not found"));
    }

    @Override
    public Set<CampSite> getRentCampSitesByMemberId(GetRentCampSiteQuery query) {
        return loadRentCampSitePort.loadRentCampSitesByMemberId(query.memberId());
    }
}
