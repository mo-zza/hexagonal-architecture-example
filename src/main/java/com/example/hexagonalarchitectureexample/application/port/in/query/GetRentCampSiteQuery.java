package com.example.hexagonalarchitectureexample.application.port.in.query;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

import static com.example.hexagonalarchitectureexample.common.validation.Validation.validate;

public record GetRentCampSiteQuery(
        @NotNull(message = "memberId is required")
        UUID memberId
) {

    @Builder
    public GetRentCampSiteQuery(
            UUID memberId
    ) {
        this.memberId = memberId;
        validate(this);
    }
}