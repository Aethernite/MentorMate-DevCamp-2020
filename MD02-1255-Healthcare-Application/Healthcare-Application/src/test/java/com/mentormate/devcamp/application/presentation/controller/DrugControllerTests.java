package com.mentormate.devcamp.application.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentormate.devcamp.application.persistence.dto.DrugDTO;
import com.mentormate.devcamp.application.persistence.repository.DrugRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class DrugControllerTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void init() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void createNewDrug() throws Exception {
        //given
        var drugDTO = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        //when
        mvc.perform(post("/api/v1/doctors/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "customer", authorities = "CUSTOMER")
    void createNewDrugAuthenticatedButNoRole() throws Exception {
        //given
        var drugDTO = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        //when
        mvc.perform(post("/api/v1/doctors/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugDTO)))
                .andExpect(status().isForbidden());
    }

    @Test
    void createNewDrugAuthenticatedButUnauthorized() throws Exception {
        //given
        var drugDTO = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        //when
        mvc.perform(post("/api/v1/doctors/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugDTO)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void getAllDrugs() throws Exception {
        //given
        var drugs = Arrays.asList(
                new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50),
                new DrugDTO("Paracetamol", "paracetamol", "Bulgaria", 3.50));

        drugs.forEach(drugDTO -> {
            try {
                mvc.perform(post("/api/v1/doctors/drugs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(drugDTO)))
                        .andExpect(status().isCreated());
            } catch (Exception e) {
                fail();
            }
        });

        // when
        var response = mvc.perform(get("/api/v1/doctors/drugs/?page=0"))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void updateDrugById() throws Exception {
        //given
        var drugInDatabase = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        mvc.perform(post("/api/v1/doctors/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugInDatabase)))
                .andExpect(status().isCreated());

        var newDrugInformation = new DrugDTO("Paracetamol", "paracetamol", "Bulgaria", 3.50);

        var drugInDatabaseWithId = drugRepository.findByName("Duxet")
                .orElse(null);
        //when
        assert drugInDatabaseWithId!=null;
        var response = mvc.perform(put("/api/v1/doctors/drugs/{drugId}", drugInDatabaseWithId.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(newDrugInformation)))
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void getDrugById() throws Exception {
        //given
        var drugInDatabase = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        mvc.perform(post("/api/v1/doctors/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugInDatabase)))
                .andExpect(status().isCreated());

        var drugInDatabaseWithId = drugRepository.findByName("Duxet")
                .orElse(null);

        //when
        assert drugInDatabaseWithId!=null;
        var response = mvc.perform(get("/api/v1/doctors/drugs/{drugId}", drugInDatabaseWithId.getId()))
                .andExpect(status().isOk())
                .andReturn();

        //then
        var drugResponse = objectMapper.readValue(response.getResponse().getContentAsString(), DrugDTO.class);
        assertThat(drugResponse, equalTo(drugInDatabase));
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void getDrugByIdThatNotExist() throws Exception {
        //when
        long invalidId = 100L;
        var response = mvc.perform(delete("/api/v1/doctors/drugs/{drugId}", invalidId))
                .andExpect(status().isNotFound())
                .andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getResponse().getStatus());
    }

    @Test
    @WithMockUser(username = "doctor", authorities = "DOCTOR")
    void deleteDrugById() throws Exception {
        //given
        var drugInDatabase = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        mvc.perform(post("/api/v1/doctors/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugInDatabase)))
                .andExpect(status().isCreated());

        var drugInDatabaseWithId = drugRepository.findByName("Duxet")
                .orElse(null);
        //when
        assert drugInDatabaseWithId!=null;
        var response = mvc.perform(delete("/api/v1/doctors/drugs/{drugId}", drugInDatabaseWithId.getId()))
                .andExpect(status().isOk())
                .andReturn();

        //then
        assertTrue(drugRepository.findById(drugInDatabaseWithId.getId()).isEmpty());
    }

}
