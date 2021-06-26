package com.example.springcore.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springcore.AppConfig;
import com.example.springcore.domain.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인 (다르다!)
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService1 = " + memberService2);

        // memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
