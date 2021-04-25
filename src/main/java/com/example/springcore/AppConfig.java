package com.example.springcore;

import com.example.springcore.domain.discount.DiscountPolicy;
import com.example.springcore.domain.discount.FixDiscountPolicy;
import com.example.springcore.domain.member.MemberRepository;
import com.example.springcore.domain.member.MemberService;
import com.example.springcore.domain.member.MemberServiceImpl;
import com.example.springcore.domain.member.MemoryMemberRepository;
import com.example.springcore.domain.order.OrderService;
import com.example.springcore.domain.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
