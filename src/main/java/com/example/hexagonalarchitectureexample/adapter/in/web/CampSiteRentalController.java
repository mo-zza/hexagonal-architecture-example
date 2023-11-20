package com.example.hexagonalarchitectureexample.adapter.in.web;

import com.example.hexagonalarchitectureexample.adapter.in.web.request.RentCampSiteRequest;
import com.example.hexagonalarchitectureexample.adapter.in.web.response.CampSiteResponse;
import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.port.in.GetCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.GetRentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.RentCampSiteUseCase;
import com.example.hexagonalarchitectureexample.application.port.in.command.RentCampSiteCommand;
import com.example.hexagonalarchitectureexample.application.port.in.query.GetCampSiteByIdQuery;
import com.example.hexagonalarchitectureexample.application.port.in.query.GetRentCampSiteQuery;
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
        GetRentCampSiteQuery query = GetRentCampSiteQuery.builder()
                .memberId(memberId)
                .build();
        Set<CampSite> campSites = getRentCampSiteUseCase.getRentCampSitesByMemberId(query);
        return ResponseMapper.mapToCampSiteResponse(campSites, HttpStatus.OK);
    }

    @GetMapping("/{campSiteId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CampSiteResponse> getCampSiteById(@PathVariable("campSiteId") UUID campSiteId) {
        GetCampSiteByIdQuery query = GetCampSiteByIdQuery
                .builder()
                .campSiteId(campSiteId)
                .build();
        CampSite campSite = getCampSiteUseCase.getCampSiteById(query);
        return ResponseMapper.mapToCampSiteResponse(campSite, HttpStatus.OK);
    }

    @PostMapping("/{campSiteId}/{siteNumber}/rentals")
    @ResponseStatus(HttpStatus.CREATED)
    public void rentCampSite(@PathVariable("campSiteId") UUID campSiteId,
                             @PathVariable("siteNumber") int siteNumber,
                             @RequestBody RentCampSiteRequest body) {
        RentCampSiteCommand command = RentCampSiteCommand.builder()
                .memberId(body.memberId())
                .siteNumber(siteNumber)
                .campSiteId(campSiteId)
                .build();
        rentCampSiteUseCase.rentCampSite(command);
    }
}
