package com.example.hexagonalarchitectureexample.application.port.in.command;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonalarchitectureexample.common.validation.Validation.validate;

public record RentCampSiteCommand(
        @NotNull(message = "campSiteId is required")
        UUID campSiteId,
        @NotNull(message = "memberId is required")
        UUID memberId,
        @NotNull(message = "siteNumber is required")
        int siteNumber
) {

    @Builder
    public RentCampSiteCommand(
            UUID campSiteId,
            UUID memberId,
            int siteNumber
    ) {
        this.campSiteId = campSiteId;
        this.memberId = memberId;
        this.siteNumber = siteNumber;
        validate(this);
    }
}
