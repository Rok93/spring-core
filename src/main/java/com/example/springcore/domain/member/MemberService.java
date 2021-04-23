package com.example.springcore.domain.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
