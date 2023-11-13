package com.example.hexagonalarchitectureexample.adapter.out.persistence.repository;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;

import java.util.Optional;
import java.util.UUID;

public interface CampSiteRepositoryCustom {
    Optional<CampSite> findOneById(UUID id);
}
