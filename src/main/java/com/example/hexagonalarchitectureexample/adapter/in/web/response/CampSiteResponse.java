package com.example.hexagonalarchitectureexample.adapter.in.web.response;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CampSiteResponse(
        UUID id,
        int[] siteNumber
) {

    public static CampSiteResponse fromEntity(CampSite entity) {
        return CampSiteResponse.builder()
                .id(entity.getId())
                .siteNumber(entity.getSiteNumber())
                .build();
    }
}
