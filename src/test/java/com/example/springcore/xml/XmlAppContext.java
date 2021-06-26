package com.example.springcore.xml;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springcore.domain.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        //given
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");

        //when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        //then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
