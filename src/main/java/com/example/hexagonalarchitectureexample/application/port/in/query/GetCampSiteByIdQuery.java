package com.example.hexagonalarchitectureexample.application.port.in.query;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonalarchitectureexample.common.validation.Validation.validate;

public record GetCampSiteByIdQuery(
        @NotNull(message = "campSiteId is required")
        UUID campSiteId
) {
    @Builder
    public GetCampSiteByIdQuery(
            UUID campSiteId
    ) {
        this.campSiteId = campSiteId;
        validate(this);
    }
}