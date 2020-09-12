package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.entity.Role;
import com.mentormate.devcamp.application.persistence.entity.User;
import com.mentormate.devcamp.application.persistence.dto.JwtResponseDTO;
import com.mentormate.devcamp.application.persistence.dto.LoginRequestDTO;
import com.mentormate.devcamp.application.persistence.dto.RoleDTO;
import com.mentormate.devcamp.application.persistence.dto.SignupRequestDTO;
import com.mentormate.devcamp.application.persistence.repository.RoleRepository;
import com.mentormate.devcamp.application.persistence.repository.UserRepository;
import com.mentormate.devcamp.application.security.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * The Authentication service.
 * <p>
 * This service takes care of the authentication of a certain user
 */
@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final ModelMapper modelMapper;

    private static final Map<Role.RoleType, Role> roles = new HashMap<>();

    /**
     * Post construct.
     * <p>
     * Finds all roles and puts them into the roles map
     */
    @PostConstruct
    protected void postConstruct() {
        roleRepository.findAll()
                .forEach(role -> roles.put(role.getName(), role));
    }

    /**
     * Sign-up.
     *
     * @param createUserDto the create user dto
     */
    public void signup(SignupRequestDTO createUserDto) {
        Set<RoleDTO> userRoles = createUserDto.getRoles();
        if (userRepository.findByUsername(createUserDto.getUsername()).isPresent()) {
            throw new RuntimeException(String.format("Username %s already exist", createUserDto.getUsername()));
        }
        Set<Role> mappedRoles = new HashSet<>();
        modelMapper.map(userRoles, mappedRoles);
        User user = new User(createUserDto.getUsername(), passwordEncoder.encode(createUserDto.getPassword()), createUserDto.getEmail(),
                mappedRoles);
        userRepository.save(user);
    }

    /**
     * Sign-in.
     *
     * @param loginRequestDTO the login request dto
     * @return the jwt response dto
     */
    public JwtResponseDTO signin(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return new JwtResponseDTO(jwt);
    }
}
