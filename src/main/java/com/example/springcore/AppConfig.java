package com.example.springcore;

import com.example.springcore.domain.discount.FixDiscountPolicy;
import com.example.springcore.domain.discount.RateDiscountPolicy;
import com.example.springcore.domain.member.MemberService;
import com.example.springcore.domain.member.MemberServiceImpl;
import com.example.springcore.domain.member.MemoryMemberRepository;
import com.example.springcore.domain.order.OrderService;
import com.example.springcore.domain.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
