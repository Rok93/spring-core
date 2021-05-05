package com.example.springcore.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.springcore.AppConfig;
import com.example.springcore.domain.member.MemberService;
import com.example.springcore.domain.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("빈 이름으로 조회")
    @Test
    void findBeanByName() {
        //given

        //when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("이름 없이 타입으로 조회")
    @Test
    void findBeanByTYPE() {
        //given

        //when
        MemberService memberService = ac.getBean(MemberService.class);

        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("구체 타입으로 조회") // 구체 타입으로 조회하면 유연성이 떨어진다!
    @Test
    void findBeanByName2() {
        //given

        //when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        //then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("빈 이름으로 조회X")
    @Test
    void findBeanByNameX() {
        //given

        //when //then
        assertThatThrownBy(() -> ac.getBean("xxxxx", MemberService.class))
            .isExactlyInstanceOf(NoSuchBeanDefinitionException.class);
    }
}
