package com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.impl;

import com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.CampSiteRepositoryCustom;
import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

import static com.example.hexagonalarchitectureexample.application.domain.model.QCampSite.campSite;
import static com.example.hexagonalarchitectureexample.application.domain.model.QRental.rental;

@RequiredArgsConstructor
public class CampSiteRepositoryCustomImpl implements CampSiteRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public Optional<CampSite> findOneById(UUID id) {
        return Optional.ofNullable(query.selectFrom(campSite)
                .leftJoin(campSite.rentals, rental)
                .where(campSite.id.eq(id))
                .fetchOne());
    }
}
