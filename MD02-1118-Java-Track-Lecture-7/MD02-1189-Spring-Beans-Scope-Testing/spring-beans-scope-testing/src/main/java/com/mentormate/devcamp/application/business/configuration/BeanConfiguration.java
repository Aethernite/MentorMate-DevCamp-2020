package com.mentormate.devcamp.application.business.configuration;

import com.mentormate.devcamp.application.business.service.MemberService;
import com.mentormate.devcamp.application.business.service.UserService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * The Bean configuration class.
 */
@Configuration
public class BeanConfiguration {
    /**
     * Member service Bean.
     * <p>
     * The scope of this bean is singleton
     *
     * @return a member service
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MemberService memberService() {
        return new MemberService();
    }

    /**
     * User service Bean.
     * <p>
     * The scope of this bean is prototype
     *
     * @return a user service
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public UserService userService() {
        return new UserService();
    }

}
