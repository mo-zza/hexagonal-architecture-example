package com.example.hexagonalarchitectureexample.adapter.in.web;

import com.example.hexagonalarchitectureexample.adapter.in.web.response.CampSiteResponse;
import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.port.in.GetCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.GetRentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.RentCampSiteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@Controller
@RestController
@RequestMapping("/camp-sites")
@RequiredArgsConstructor
public class CampSiteRentalController {
    private final GetCampSiteUseCase getCampSiteUseCase;
    private final GetRentCampSiteUseCase getRentCampSiteUseCase;
    private final RentCampSiteUseCase rentCampSiteUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<CampSiteResponse>> getAllCampSites() {
        Set<CampSite> campSites = getCampSiteUseCase.getAllCampSites();
        return ResponseMapper.mapToCampSiteResponse(campSites, HttpStatus.OK);
    }

    @GetMapping("/{memberId}/rentals")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Set<CampSiteResponse>> getRentCampSites(@PathVariable("memberId") UUID memberId) {
        GetRentCampSiteUseCase.GetRentCampSiteQuery query = new GetRentCampSiteUseCase.GetRentCampSiteQuery(memberId);
        Set<CampSite> campSites = getRentCampSiteUseCase.getRentCampSitesByMemberId(query);
        return ResponseMapper.mapToCampSiteResponse(campSites, HttpStatus.OK);
    }

    @GetMapping("/{campSiteId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CampSiteResponse> getCampSiteById(@PathVariable("campSiteId") UUID campSiteId) {
        GetCampSiteUseCase.GetCampSiteByIdQuery query = new GetCampSiteUseCase.GetCampSiteByIdQuery(campSiteId);
        CampSite campSite = getCampSiteUseCase.getCampSiteById(query);
        return ResponseMapper.mapToCampSiteResponse(campSite, HttpStatus.OK);
    }
}
