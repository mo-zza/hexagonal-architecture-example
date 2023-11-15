package com.example.hexagonalarchitectureexample.adapter.in.web;

import com.example.hexagonalarchitectureexample.adapter.in.web.response.CampSiteResponse;
import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ResponseMapper {

    static ResponseEntity<Set<CampSiteResponse>> mapToCampSiteResponse(Set<CampSite> campSite, HttpStatus status) {
        Set<CampSiteResponse> response = campSite.stream()
                .map(CampSiteResponse::fromEntity)
                .collect(Collectors.toSet());
        return new ResponseEntity<>(response, status);
    }

    static ResponseEntity<CampSiteResponse> mapToCampSiteResponse(CampSite campSite, HttpStatus status) {
        CampSiteResponse response = CampSiteResponse.fromEntity(campSite);
        return new ResponseEntity<>(response, status);
    }
}
