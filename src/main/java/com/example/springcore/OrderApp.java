package com.example.springcore;

import com.example.springcore.domain.member.Grade;
import com.example.springcore.domain.member.Member;
import com.example.springcore.domain.member.MemberService;
import com.example.springcore.domain.order.Order;
import com.example.springcore.domain.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10_000);

        System.out.println("order = " + order);
    }
}
