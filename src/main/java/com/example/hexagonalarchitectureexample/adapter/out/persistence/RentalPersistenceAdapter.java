package com.example.hexagonalarchitectureexample.adapter.out.persistence;

import com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.RentalRepository;
import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.domain.model.Member;
import com.example.hexagonalarchitectureexample.application.domain.model.Rental;
import com.example.hexagonalarchitectureexample.application.port.out.InsertRentPort;
import com.example.hexagonalarchitectureexample.application.port.out.LoadRentCampSitePort;
import com.example.hexagonalarchitectureexample.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@PersistenceAdapter
@RequiredArgsConstructor
public class RentalPersistenceAdapter implements LoadRentCampSitePort, InsertRentPort {
    private final RentalRepository rentalRepository;

    @Override
    public Set<CampSite> loadRentCampSitesByMemberId(UUID memberId) {
        List<Rental> rentals = rentalRepository.findByMemberId(memberId);
        if (rentals.isEmpty()) {
            return Set.of();
        }

        List<CampSite> campSites = rentals.stream()
                .map(Rental::getCampSite)
                .collect(Collectors.toList());
        return Set.copyOf(campSites);
    }

    @Override
    public void insertRent(Member member, CampSite campSite) {
        Rental rental = Rental.builder()
                .member(member)
                .campSite(campSite)
                .build();
        rentalRepository.save(rental);
    }
}
