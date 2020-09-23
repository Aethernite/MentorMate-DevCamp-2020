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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class AppointmentControllerTests {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @BeforeEach
    public void init() throws Exception {
        Set<RoleDTO> rolesToAdd = new HashSet<>();
        RoleDTO role = new RoleDTO();
        role.setName(Role.RoleType.DOCTOR);
        rolesToAdd.add(role);
        var doctorDTO = new SignupRequestDTO("borislav", "borislav@gmail.com", "password4e", rolesToAdd);
        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(doctorDTO)))
                .andExpect(status().isCreated());

        rolesToAdd.remove(role);
        role.setName(Role.RoleType.CUSTOMER);
        rolesToAdd.add(role);
        var userDTO = new SignupRequestDTO("ivailo", "borislav@gmail.com", "password4e", rolesToAdd);

        mvc.perform(post("/api/v1/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void createNewAppointment() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("borislav", "", dateTime);
        var expected = appointmentDTO;
        expected.setCustomer("Customer not specified");
        //when
        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isCreated());

        Assertions.assertEquals(expected, modelMapper.map(appointmentRepository.findByDoctorAndStartTime("borislav", dateTime).orElse(null), AppointmentDTO.class));
    }

    @Test
    void createNewAppointmentInvalidDoctor() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("petrancho", "", dateTime);

        //when
        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isConflict());

    }

    @Test
    void createNewAppointmentNoDoctorRole() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("ivailo", "", dateTime);

        //when

        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isConflict());

    }

    @Test
    void createNewAppointmentAppointmentSlotBusy() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentDTO = new AppointmentDTO("borislav", "", dateTime);
        var appointment2DTO = new AppointmentDTO("borislav", "", dateTime);

        //when

        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointmentDTO)))
                .andExpect(status().isCreated());

        mvc.perform(post("/api/v1/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(appointment2DTO)))
                .andExpect(status().isConflict());

    }

    @Test
    void getAllAppointments() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointments = Arrays.asList(
                new AppointmentDTO("borislav", "Customer not specified", dateTime),
                new AppointmentDTO("borislav", "Customer not specified", dateTime.plusDays(1)));

        appointments.forEach(appointmentDTO -> appointmentRepository.save(modelMapper.map(appointmentDTO, Appointment.class)));

        // when
        var response = mvc.perform(get("/api/v1/appointments/?page=0"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateAppointmentById() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentInDatabase = new AppointmentDTO("borislav", "Customer not specified", dateTime);
        appointmentRepository.save(modelMapper.map(appointmentInDatabase, Appointment.class));

        var newAppointmentInformation = new AppointmentDTO("borislav", "Customer not specified", dateTime.plusDays(1));

        var appointmentInDatabaseWithId = appointmentRepository.findByDoctorAndStartTime("borislav", dateTime)
                .orElse(null);
        //when
        assert appointmentInDatabaseWithId != null;
        var response = mvc.perform(put("/api/v1/appointments/{appointmentId}", appointmentInDatabaseWithId.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(newAppointmentInformation)))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertNotNull(appointmentRepository.findByDoctorAndStartTime("borislav", dateTime.plusDays(1))
                .orElse(null));
    }

    @Test
    void getAppointmentById() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentInDatabase = new AppointmentDTO("borislav", "Customer not specified", dateTime);
        var appointment = modelMapper.map(appointmentInDatabase, Appointment.class);
        appointmentRepository.save(appointment);

        var appointmentInDatabaseWithId = appointmentRepository.findByDoctorAndStartTime("borislav", dateTime)
                .orElse(null);

        //when
        assert appointmentInDatabaseWithId != null;
        var response = mvc.perform(get("/api/v1/appointments/{appointmentId}", appointmentInDatabaseWithId.getId()))
                .andExpect(status().isOk())
                .andReturn();

        //then
        var appointmentResponse = objectMapper.readValue(response.getResponse().getContentAsString(), AppointmentDTO.class);
        assertThat(appointmentResponse, equalTo(appointmentInDatabase));
    }

    @Test
    void deleteAppointmentById() throws Exception {
        //given
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59));
        var appointmentInDatabase = new AppointmentDTO("borislav", "Customer not specified", dateTime);
        var appointment = modelMapper.map(appointmentInDatabase, Appointment.class);
        appointmentRepository.save(appointment);

        var appointmentInDatabaseWithId = appointmentRepository.findByDoctorAndStartTime("borislav", dateTime)
                .orElse(null);

        //when
        assert appointmentInDatabaseWithId != null;
        var response = mvc.perform(delete("/api/v1/appointments/{appointmentId}", appointmentInDatabaseWithId.getId()))
                .andExpect(status().isOk())
                .andReturn();

        //then
        assertTrue(appointmentRepository.findById(appointmentInDatabaseWithId.getId()).isEmpty());
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void getAllAppointmentsForCurrentDoctor() throws Exception {

        var response = mvc.perform(get("/api/v1/appointments/me?page=0"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @WithAnonymousUser
    void getAllAppointmentsForCurrentDoctorUnauthorized() throws Exception {

        var response = mvc.perform(get("/api/v1/appointments/me?page=0"))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    @WithMockUser(authorities = "CUSTOMER")
    void getAllAppointmentsForCurrentDoctorAuthorizedButNoRole() throws Exception {
        var response = mvc.perform(get("/api/v1/appointments/me?page=0"))
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
        assert appointment != null;
        int id = Math.toIntExact(appointment.getId());


        var response = mvc.perform(put("/api/v1/appointments/set/{appointmentId}?status=PENDING", id))
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
        assert appointment != null;
        int id = Math.toIntExact(appointment.getId());


        var response = mvc.perform(put("/api/v1/appointments/set/{appointmentId}?status=APPROVED", id))
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
        assert appointment != null;
        int id = Math.toIntExact(appointment.getId());


        var response = mvc.perform(put("/api/v1/appointments/set/{appointmentId}?status=DECLINED", id))
                .andExpect(status().isOk())
                .andReturn();

        Status expected = objectMapper.readValue(response.getResponse().getContentAsString(), FullAppointmentDTO.class).getStatus();

        Assertions.assertEquals(Status.DECLINED, expected);
    }
}

