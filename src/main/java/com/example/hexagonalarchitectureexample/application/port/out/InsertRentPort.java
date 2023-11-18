package com.example.hexagonalarchitectureexample.application.port.out;

import com.example.hexagonalarchitectureexample.application.domain.model.CampSite;
import com.example.hexagonalarchitectureexample.application.domain.model.Member;

public interface InsertRentPort {

    void insertRent(Member member, CampSite campSite);
}
