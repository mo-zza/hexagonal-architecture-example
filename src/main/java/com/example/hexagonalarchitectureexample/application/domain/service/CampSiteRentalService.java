package com.example.hexagonalarchitectureexample.application.domain.service;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.domain.model.Member;
import com.example.hexagonalarchitectureexample.application.port.in.GetCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.GetRentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.RentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.command.RentCampSiteCommand;
import com.example.hexagonalarchitectureexample.application.port.in.query.GetCampSiteByIdQuery;
import com.example.hexagonalarchitectureexample.application.port.in.query.GetRentCampSiteQuery;
import com.example.hexagonalarchitectureexample.application.port.out.InsertRentPort;
import com.example.hexagonalarchitectureexample.application.port.out.LoadCampSitePort;
import com.example.hexagonalarchitectureexample.application.port.out.LoadMemberPort;
import com.example.hexagonalarchitectureexample.application.port.out.LoadRentCampSitePort;
import com.example.hexagonalarchitectureexample.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@UseCase
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CampSiteRentalService implements GetCampSiteUseCase, GetRentCampSiteUseCase, RentCampSiteUseCase {
    private final LoadCampSitePort loadCampSitePort;
    private final LoadRentCampSitePort loadRentCampSitePort;
    private final InsertRentPort insertRentPort;
    private final LoadMemberPort loadMemberPort;

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

    @Override
    @Transactional
    public void rentCampSite(RentCampSiteCommand command) {
        Member member = getMemberById(command.memberId());
        GetCampSiteByIdQuery query = GetCampSiteByIdQuery.builder()
                .campSiteId(command.campSiteId())
                .build();
        CampSite campSite = getCampSiteById(query);
        insertRentPort.insertRent(member, campSite);
    }

    private Member getMemberById(UUID memberId) {
        return loadMemberPort.loadMemberById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }
}
