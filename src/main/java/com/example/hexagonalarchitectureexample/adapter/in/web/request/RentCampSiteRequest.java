package com.example.hexagonalarchitectureexample.adapter.in.web.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

import static com.example.hexagonalarchitectureexample.common.validation.Validation.validate;

public record RentCampSiteRequest(
        @NotNull(message = "memberId is required")
        UUID memberId
) {

    public RentCampSiteRequest(UUID memberId) {
        this.memberId = memberId;
        validate(this);
    }
}
