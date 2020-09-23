package com.mentormate.devcamp.application.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentormate.devcamp.application.persistence.dto.LoginRequestDTO;
import com.mentormate.devcamp.application.persistence.dto.RoleDTO;
import com.mentormate.devcamp.application.persistence.dto.SignupRequestDTO;
import com.mentormate.devcamp.application.persistence.entity.Role;
import com.mentormate.devcamp.application.persistence.entity.User;
import com.mentormate.devcamp.application.persistence.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AuthenticationControllerTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    void signupValidUser() throws Exception {
        //given
        Set<RoleDTO> rolesToAdd = new HashSet<>();
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        rolesToAdd.add(role);
        var userDTO = new SignupRequestDTO("borislav", "borislav@gmail.com", "password4e", rolesToAdd);

        //when
        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());

        User user = userRepository.findByUsername("borislav").orElse(null);
        assert user != null;
        Assertions.assertEquals(1, userRepository.findAll().size());
    }

    @Test
    void signupInvalidUser() throws Exception {
        //given
        var userDTO = new SignupRequestDTO("", "", "", null);

        //when
        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isBadRequest());

    }

    @Test
    void loginValidUser() throws Exception {
        //given
        Set<RoleDTO> rolesToAdd = new HashSet<>();
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        rolesToAdd.add(role);
        var registerDTO = new SignupRequestDTO("borislav", "borislav@gmail.com", "password4e", rolesToAdd);
        var loginDTO = new LoginRequestDTO("borislav", "password4e");
        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(registerDTO)))
                .andExpect(status().isCreated());

        //when
        mvc.perform(post("/api/v1/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isOk());

    }

    @Test
    void loginInvalidUser() throws Exception {
        //given
        var loginDTO = new LoginRequestDTO("invaliduser", "password4e");
        //when

        mvc.perform(post("/api/v1/auth/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isUnauthorized());

    }

}
