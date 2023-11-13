package com.example.hexagonalarchitectureexample.adapter.out.persistence.repository;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CampSiteRepository extends JpaRepository<CampSite, UUID>, CampSiteRepositoryCustom {
}
