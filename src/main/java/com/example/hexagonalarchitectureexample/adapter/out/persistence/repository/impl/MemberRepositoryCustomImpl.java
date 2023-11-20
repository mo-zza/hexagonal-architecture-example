package com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.impl;

import com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.MemberRepositoryCustom;
import com.example.hexagonalarchitectureexample.application.domain.model.Member;
import com.example.hexagonalarchitectureexample.application.domain.model.QRental;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

import static com.example.hexagonalarchitectureexample.application.domain.model.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public Optional<Member> findOneById(UUID memberId) {
        return Optional.ofNullable(query.selectFrom(member).distinct()
                .leftJoin(member.rentals, QRental.rental).fetchJoin()
                .fetchOne());
    }
}
