package com.example.springcore.domain.discount;

import com.example.springcore.domain.member.Grade;
import com.example.springcore.domain.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private static final int discountFixAmount = 1_000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
