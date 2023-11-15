package com.example.hexagonalarchitectureexample.adapter.out.persistence;

import com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.CampSiteRepository;
import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.port.out.LoadCampSitePort;
import com.example.hexagonalarchitectureexample.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class CampSitePersistenceAdapter implements LoadCampSitePort {
    private final CampSiteRepository campSiteRepository;

    @Override
    public Set<CampSite> loadAllCampSites() {
        List<CampSite> campSites = campSiteRepository.findAll();
        return Set.copyOf(campSites);
    }

    @Override
    public Optional<CampSite> loadCampSiteById(UUID id) {
        return campSiteRepository.findOneById(id);
    }
}
