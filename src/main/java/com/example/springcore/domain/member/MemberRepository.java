package com.example.springcore.domain.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
