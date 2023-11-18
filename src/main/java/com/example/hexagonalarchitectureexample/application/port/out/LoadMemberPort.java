package com.example.hexagonalarchitectureexample.application.port.out;

import com.example.hexagonalarchitectureexample.application.domain.model.Member;

import java.util.Optional;
import java.util.UUID;

public interface LoadMemberPort {
    Optional<Member> loadMemberById(UUID memberId);
}
