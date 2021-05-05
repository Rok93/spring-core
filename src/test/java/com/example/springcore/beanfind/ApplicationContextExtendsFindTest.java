package com.example.springcore.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.example.springcore.domain.discount.DiscountPolicy;
import com.example.springcore.domain.discount.FixDiscountPolicy;
import com.example.springcore.domain.discount.RateDiscountPolicy;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        TestConfig.class);

    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
    @Test
    void findBeanByParentTypeDuplicate() {
        //given
        assertThatThrownBy(() -> ac.getBean(DiscountPolicy.class))
            .isExactlyInstanceOf(NoUniqueBeanDefinitionException.class);

        //when

        //then
    }

    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    @Test
    void findBeanByParentType() {
        //given

        //when
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

        //then
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("특정 하위 타입으로 조회")
    @Test
    void findBeanBySubType() {
        //given

        //when
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);

        //then
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("부모 타입으로 모두 조회하기")
    @Test
    void findAllBeanByParentType() {
        //given

        //when
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

        //then
        assertThat(beansOfType).hasSize(2);
    }

    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    @Test
    void findAllBeanByObjectType() {
        //given

        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

        //then
    }

    @Component
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
