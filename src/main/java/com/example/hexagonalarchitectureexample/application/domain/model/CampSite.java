package com.example.hexagonalarchitectureexample.application.domain.model;

import com.example.hexagonalarchitectureexample.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "camp_site", indexes = {@Index(name = "idx_camp_site_id", columnList = "id", unique = true)})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CampSite extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "camp_site_site_number", joinColumns = @JoinColumn(name = "camp_site_id"))
    @Column(name = "site_number", nullable = false)
    private int[] siteNumber;

    @OneToMany(mappedBy = "campSite", fetch = FetchType.LAZY)
    private Set<Rental> rentals = new HashSet<>();

    @Builder
    CampSite(@NonNull String name, @NonNull int[] siteNumber) {
        this.name = name;
        this.siteNumber = siteNumber;
    }
}
