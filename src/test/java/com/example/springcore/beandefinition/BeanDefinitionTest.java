package com.example.springcore.beandefinition;

import com.example.springcore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    private AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        AppConfig.class);

    @DisplayName("빈 설정 메타정보 확인")
    @Test
    void findApplicationBean() {
        //given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName
                    + "beanDefinition = " + beanDefinition);
            }
        }

        //when

        //then
    }
}
