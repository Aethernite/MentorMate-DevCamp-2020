package com.mentormate.devcamp.application;

import com.mentormate.devcamp.application.business.configuration.BeanConfiguration;
import com.mentormate.devcamp.application.business.service.MemberService;
import com.mentormate.devcamp.application.business.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

class SpringBeansApplicationTests {
    private static AbstractApplicationContext context;

    @BeforeAll
    static void contextLoads() {
        context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    }

    @AfterAll
    static void contextCloses() {
        context.close();
    }

    @Test
    void testSingleton() {
        MemberService service1 = context.getBean("memberService", MemberService.class);
        MemberService service2 = context.getBean("memberService", MemberService.class);

        Assertions.assertSame(service1, service2, "The two services are the same instance because of the singleton scope");
    }

    @Test
    void testPrototype() {
        UserService service1 = context.getBean("userService", UserService.class);
        UserService service2 = context.getBean("userService", UserService.class);

        Assertions.assertNotSame(service1, service2, "The two services are different instances because of the prototype scope");
    }

}
