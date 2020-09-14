package com.mentormate.devcamp.application.persistence;

import com.mentormate.devcamp.application.persistence.entity.Role;
import com.mentormate.devcamp.application.persistence.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * The Database initializer.
 * <p>
 * Used to initialize the database with the user roles if they don't exist already
 */
@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements ApplicationRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) {
        initialize();
    }

    private void initialize() {
        if (roleRepository.findAll().isEmpty()) {
            roleRepository.save(new Role(Role.RoleType.CUSTOMER));
            roleRepository.save(new Role(Role.RoleType.DOCTOR));
        }
    }

}
