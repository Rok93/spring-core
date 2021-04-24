package com.example.springcore;

import com.example.springcore.domain.discount.DiscountPolicy;
import com.example.springcore.domain.discount.FixDiscountPolicy;
import com.example.springcore.domain.member.MemberRepository;
import com.example.springcore.domain.member.MemberService;
import com.example.springcore.domain.member.MemberServiceImpl;
import com.example.springcore.domain.member.MemoryMemberRepository;
import com.example.springcore.domain.order.OrderService;
import com.example.springcore.domain.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
