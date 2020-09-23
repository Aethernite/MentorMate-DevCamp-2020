package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.dto.FullDoctorDTO;
import com.mentormate.devcamp.application.persistence.dto.RoleDTO;
import com.mentormate.devcamp.application.persistence.entity.Role;
import com.mentormate.devcamp.application.persistence.entity.Role.RoleType;
import com.mentormate.devcamp.application.persistence.repository.RoleRepository;
import com.mentormate.devcamp.application.persistence.repository.UserRepository;
import com.mentormate.devcamp.application.presentation.exception.NoDoctorRoleFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * The Customer service.
 * <p>
 * This service takes care of listing the doctor users
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DoctorService {
    private static final int PAGE_SIZE = 10;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    /**
     * Find paginated.
     *
     * @param page the page
     * @return page of full appointment DTOs
     */
    public Page<FullDoctorDTO> findPaginated(int page) {
        log.info("Fetch all doctors");
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        return userRepository.findByRolesIn(Collections.singletonList(getDoctorRole()), PageRequest.of(page, PAGE_SIZE))
                .map(user -> modelMapper.map(user, FullDoctorDTO.class));
    }

    private Role getDoctorRole() {
        return roleRepository.findByName(RoleType.DOCTOR).orElseThrow(() -> new NoDoctorRoleFoundException("No doctor role found in the database"));
    }
}
