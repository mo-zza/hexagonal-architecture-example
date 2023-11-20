package com.example.hexagonalarchitectureexample.adapter.out.persistence;

import com.example.hexagonalarchitectureexample.adapter.out.persistence.repository.MemberRepository;
import com.example.hexagonalarchitectureexample.application.domain.model.Member;
import com.example.hexagonalarchitectureexample.application.port.out.LoadMemberPort;
import com.example.hexagonalarchitectureexample.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements LoadMemberPort {
    private final MemberRepository memberRepository;


    @Override
    public Optional<Member> loadMemberById(UUID memberId) {
        return memberRepository.findOneById(memberId);
    }
}
