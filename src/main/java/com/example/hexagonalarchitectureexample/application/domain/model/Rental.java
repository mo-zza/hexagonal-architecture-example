package com.example.hexagonalarchitectureexample.application.domain.model;

import com.example.hexagonalarchitectureexample.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "rental", indexes = {@Index(name = "idx_rental_id", columnList = "id", unique = true)})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rental extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "camp_site_id")
    private CampSite campSite;

    @Builder
    public Rental(
            @NonNull Member member,
            @NonNull CampSite campSite
    ) {
        this.member = member;
        this.campSite = campSite;
    }
}
