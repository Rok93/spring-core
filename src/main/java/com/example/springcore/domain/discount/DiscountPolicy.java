package com.example.springcore.domain.discount;

import com.example.springcore.domain.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
