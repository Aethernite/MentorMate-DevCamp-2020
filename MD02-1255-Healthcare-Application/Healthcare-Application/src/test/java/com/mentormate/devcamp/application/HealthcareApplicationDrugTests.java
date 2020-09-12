package com.mentormate.devcamp.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mentormate.devcamp.application.persistence.dto.DrugDTO;
import com.mentormate.devcamp.application.persistence.entity.Drug;
import com.mentormate.devcamp.application.persistence.repository.DrugRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@Transactional
@SpringBootTest
class HealthcareApplicationDrugTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DrugRepository drugRepository;

    @Test
    void createNewDrug() throws Exception {
        //given
        var drugDTO = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);

        //when
        mvc.perform(post("/api/v1/drugs")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(drugDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    void getAllDrugs() throws Exception {
        //given
        var expectedDrugs = Arrays.asList(
                new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50),
                new DrugDTO("Paracetamol", "paracetamol", "Bulgaria", 3.50));

        expectedDrugs.forEach(drugDTO -> drugRepository.save(modelMapper.map(drugDTO, Drug.class)));
        // when
        var response = mvc.perform(get("/api/v1/drugs"))
                .andExpect(status().isOk())
                .andReturn();

        //then
        var drugs = objectMapper.readValue(response.getResponse().getContentAsString(),
                new TypeReference<List<DrugDTO>>() {
                });

        assertThat(drugs, hasSize(2));
        assertEquals(drugs, expectedDrugs);
    }

    @Test
    void updateDrugById() throws Exception {
        //given
        var drugInDatabase = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);
        drugRepository.save(modelMapper.map(drugInDatabase, Drug.class));

        var newDrugInformation = new DrugDTO("Paracetamol", "paracetamol", "Bulgaria", 3.50);

        var drugInDatabaseWithId = drugRepository.findById(1L);
        //when
        var response = mvc.perform(put("/api/v1/drugs/{drugId}", drugInDatabaseWithId.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(newDrugInformation)))
                .andExpect(status().isOk())
                .andReturn();

        //then
        var drug = objectMapper.readValue(response.getResponse().getContentAsString(), DrugDTO.class);
        assertThat(drug, equalTo(newDrugInformation));
    }

    @Test
    void getDrugById() throws Exception {
        //given
        var drugInDatabase = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);
        var drug = modelMapper.map(drugInDatabase, Drug.class);
        drugRepository.save(drug);

        var drugInDatabaseWithId = drugRepository.findById(1L);

        //when
        var response = mvc.perform(get("/api/v1/drugs/{drugId}", drugInDatabaseWithId.getId()))
                .andExpect(status().isOk())
                .andReturn();

        //then
        var drugResponse = objectMapper.readValue(response.getResponse().getContentAsString(), DrugDTO.class);
        assertThat(drugResponse, equalTo(drugInDatabase));
    }

    @Test
    void getDrugByIdThatNotExist() throws Exception {
        //when
        long invalidId = 100L;
        var response = mvc.perform(delete("/api/v1/drugs/{drugId}", invalidId))
                .andExpect(status().isNotFound())
                .andReturn();
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getResponse().getStatus());
    }

    @Test
    void deleteDrugById() throws Exception {
        //given
        var drugInDatabase = new DrugDTO("Duxet", "duloxetine", "Bulgaria", 10.50);
        var drug = modelMapper.map(drugInDatabase, Drug.class);
        drugRepository.save(drug);

        var drugInDatabaseWithId = drugRepository.findById(1L);
        //when
        var response = mvc.perform(delete("/api/v1/drugs/{drugId}", drugInDatabaseWithId.getId()))
                .andExpect(status().isNoContent())
                .andReturn();

        //then
        assertNull(drugRepository.findById(1L));
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getResponse().getStatus());
    }

}
