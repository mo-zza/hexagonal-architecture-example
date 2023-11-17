package com.example.hexagonalarchitectureexample.application.port.in;

import com.example.hexagonalarchitectureexample.application.port.in.command.RentCampSiteCommand;

public interface RentCampSiteUseCase {
    void rentCampSite(RentCampSiteCommand command);
}
