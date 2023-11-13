package com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.impl;

import com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.RentalRepositoryCustom;
import com.example.hexagonalarchitectureexample.application.domain.model.QCampSite;
import com.example.hexagonalarchitectureexample.application.domain.model.QMember;
import com.example.hexagonalarchitectureexample.application.domain.model.Rental;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static com.example.hexagonalarchitectureexample.application.domain.model.QRental.rental;

@RequiredArgsConstructor
public class RentalRepositoryCustomImpl implements RentalRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public List<Rental> findByMemberId(UUID memberId) {
        return query.selectFrom(rental).distinct()
                .leftJoin(rental.campSite, QCampSite.campSite).fetchJoin()
                .leftJoin(rental.member, QMember.member).fetchJoin()
                .fetch();
    }
}
