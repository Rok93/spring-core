package com.example.springcore.domain.order;

import com.example.springcore.domain.member.Grade;
import com.example.springcore.domain.member.Member;
import com.example.springcore.domain.member.MemberService;
import com.example.springcore.domain.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    private MemberService memberService = new MemberServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 1_000);

        //then
        assertThat(order.getDiscountPrice()).isEqualTo(1_000);
    }

}
