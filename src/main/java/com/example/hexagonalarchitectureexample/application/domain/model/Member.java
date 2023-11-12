package com.example.hexagonalarchitectureexample.application.domain.model;

import com.example.hexagonalarchitectureexample.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "member", indexes = {@Index(name = "idx_member_id", columnList = "id", unique = true)})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<Rental> rentals = new HashSet<>();

    @Builder
    Member(@NonNull String name, @NonNull String email) {
        this.name = name;
        this.email = email;
    }
}
