package com.example.hexagonalarchitectureexample.adapter.out.persistence.repository;

import com.example.hexagonalarchitectureexample.application.domain.model.Rental;

import java.util.List;
import java.util.UUID;

public interface RentalRepositoryCustom {
    List<Rental> findByMemberId(UUID memberId);
}
