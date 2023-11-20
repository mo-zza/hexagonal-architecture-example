package com.example.hexagonalarchitectureexample.adapter.in.web.response;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonalarchitectureexample.common.validation.Validation.validate;

public record CampSiteResponse(
        @NotNull UUID id,
        @NotNull int[] siteNumber
) {

    @Builder
    public CampSiteResponse(
            UUID id,
            int[] siteNumber
    ) {
        this.id = id;
        this.siteNumber = siteNumber;
        validate(this);
    }

    public static CampSiteResponse fromEntity(CampSite entity) {
        return CampSiteResponse.builder()
                .id(entity.getId())
                .siteNumber(entity.getSiteNumber())
                .build();
    }
}
