package com.example.springcore.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.springcore.AppConfig;
import com.example.springcore.domain.discount.DiscountPolicy;
import com.example.springcore.domain.member.MemberRepository;
import com.example.springcore.domain.member.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        SameBeanConfig.class);

    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    @Test
    void findBeanByTypeDuplicate() {
        //given

        //when //then
        assertThatThrownBy(() -> ac.getBean(MemberRepository.class))
            .isExactlyInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    @Test
    void findBeanByName() {
        //given

        //when
        MemberRepository memberRepository1 = ac
            .getBean("memberRepository1", MemberRepository.class);
        MemberRepository memberRepository2 = ac
            .getBean("memberRepository2", MemberRepository.class);

        //then
        assertThat(memberRepository1).isInstanceOf(MemoryMemberRepository.class);
        assertThat(memberRepository2).isInstanceOf(MemoryMemberRepository.class);
    }

    @DisplayName("특정 타입을 모두 조회하기")
    @Test
    void findAllBeanByType() {
        //given

        //when
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);

        //then
        assertThat(beansOfType).hasSize(2);
    }

    @Configuration
    static class SameBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
