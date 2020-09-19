package com.mentormate.devcamp.application.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentormate.devcamp.application.persistence.dto.AppointmentDTO;
import com.mentormate.devcamp.application.persistence.dto.FullAppointmentDTO;
import com.mentormate.devcamp.application.persistence.dto.RoleDTO;
import com.mentormate.devcamp.application.persistence.dto.SignupRequestDTO;
import com.mentormate.devcamp.application.persistence.entity.Appointment;
import com.mentormate.devcamp.application.persistence.entity.Appointment.Status;
import com.mentormate.devcamp.application.persistence.entity.Role;
import com.mentormate.devcamp.application.persistence.repository.AppointmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DoctorControllerTests {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void init() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void getAllAppointmentsForCurrentDoctor() throws Exception {

        var response = mvc.perform(get("/api/v1/doctors/appointments/?page=0"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithAnonymousUser
    void getAllAppointmentsForCurrentDoctorUnauthorized() throws Exception {

        var response = mvc.perform(get("/api/v1/doctors/appointments/?page=0"))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    @WithMockUser(authorities = "CUSTOMER")
    void getAllAppointmentsForCurrentDoctorAuthorizedButNoRole() throws Exception {
        var response = mvc.perform(get("/api/v1/doctors/appointments/?page=0"))
                .andExpect(status().isForbidden())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void setAppointmentToPending() throws Exception {
        //given
        Set<RoleDTO> rolesToAdd = new HashSet<>();
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        rolesToAdd.add(role);
        var userDTO = new SignupRequestDTO("doctor", "borislav@gmail.com", "password4e", rolesToAdd);

        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("doctor", "", dateTime);
        //when
        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isCreated());

        Appointment appointment = appointmentRepository.findOneByDoctor("doctor").orElse(null);
        assert appointment!=null;
        int id = Math.toIntExact(appointment.getId());


        var response = mvc.perform(put("/api/v1/doctors/appointments/pending/{appointmentId}", id))
                .andExpect(status().isOk())
                .andReturn();

        Status expected = objectMapper.readValue(response.getResponse().getContentAsString(), FullAppointmentDTO.class).getStatus();

        Assertions.assertEquals(Status.PENDING, expected);
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void setAppointmentToApproved() throws Exception {
        //given
        Set<RoleDTO> rolesToAdd = new HashSet<>();
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        rolesToAdd.add(role);
        var userDTO = new SignupRequestDTO("doctor", "borislav@gmail.com", "password4e", rolesToAdd);

        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("doctor", "", dateTime);
        //when
        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isCreated());

        Appointment appointment = appointmentRepository.findOneByDoctor("doctor").orElse(null);
        assert appointment!=null;
        int id = Math.toIntExact(appointment.getId());


        var response = mvc.perform(put("/api/v1/doctors/appointments/approved/{appointmentId}", id))
                .andExpect(status().isOk())
                .andReturn();

        Status expected = objectMapper.readValue(response.getResponse().getContentAsString(), FullAppointmentDTO.class).getStatus();

        Assertions.assertEquals(Status.APPROVED, expected);
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void setAppointmentToDeclined() throws Exception {
        //given
        Set<RoleDTO> rolesToAdd = new HashSet<>();
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        rolesToAdd.add(role);
        var userDTO = new SignupRequestDTO("doctor", "borislav@gmail.com", "password4e", rolesToAdd);

        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());

        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("doctor", "", dateTime);
        //when
        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isCreated());

        Appointment appointment = appointmentRepository.findOneByDoctor("doctor").orElse(null);
        assert appointment!=null;
        int id = Math.toIntExact(appointment.getId());


        var response = mvc.perform(put("/api/v1/doctors/appointments/declined/{appointmentId}", id))
                .andExpect(status().isOk())
                .andReturn();

        Status expected = objectMapper.readValue(response.getResponse().getContentAsString(), FullAppointmentDTO.class).getStatus();

        Assertions.assertEquals(Status.DECLINED, expected);
    }
}
