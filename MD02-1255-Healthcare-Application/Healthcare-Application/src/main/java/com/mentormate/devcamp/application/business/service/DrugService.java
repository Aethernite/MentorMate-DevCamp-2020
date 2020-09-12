package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.dto.DrugDTO;
import com.mentormate.devcamp.application.persistence.dto.FullDrugDTO;
import com.mentormate.devcamp.application.persistence.entity.Drug;
import com.mentormate.devcamp.application.persistence.repository.DrugRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * This service is responsible to handle all CRUD operation related to {@link Drug}
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DrugService {

    private final ModelMapper modelMapper;

    private final DrugRepository drugRepository;

    /**
     * Create new {@link Drug} in our application
     * @param drugDTO {@link DrugDTO} information needed for creation of new {@link Drug}
     * @return {@link Drug} that is saved in our database converted to {@link DrugDTO}
     */
    public FullDrugDTO createDrug(DrugDTO drugDTO) {
        Drug drug = modelMapper.map(drugDTO, Drug.class);
        drug = drugRepository.save(drug);
        log.info("Created drug with id {}", drug.getId());
        return modelMapper.map(drug, FullDrugDTO.class);
    }

    /**
     * Provide all {@link Drug}'s in all application
     * @return {@link List<FullDrugDTO>} of our {@link Drug}'s converted to {@link FullDrugDTO}'s
     */
    public List<FullDrugDTO> getAll() {
        log.info("Fetch all drugs");
        return StreamSupport.stream(drugRepository.findAll().spliterator() , false)
                .map(drug -> modelMapper.map(drug, FullDrugDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Get {@link Drug} by its ID
     * @param drugID id of the {@link Drug}
     * @return {@link FullDrugDTO} corresponding {@link Drug}
     */
    public FullDrugDTO getDrugById(Long drugID) {
        log.info("Get drug by id: {}", drugID);
        var drug = drugRepository.findById(drugID);
        if(drug == null){
            throw new EntityNotFoundException(String.format("Drug with id %s is not found", drugID));
        }
        return modelMapper.map(drug, FullDrugDTO.class);
    }

    /**
     * Update all information for {@link Drug} by its id
     * @param drugId Id of the {@link Drug}
     * @param updatedDrug {@link FullDrugDTO} new information that will be persisted into database
     * @return Updated {@link Drug}
     */
    public FullDrugDTO updateDrugByID(Long drugId, DrugDTO updatedDrug) {
        log.info("Start updating drug with id: {}", drugId);
        var drug = drugRepository.findById(drugId);
        if(drug == null){
           throw new EntityNotFoundException(String.format("Drug with id %s is not found", drugId));
        }
        drug.update(modelMapper.map(updatedDrug, Drug.class));
        log.info("Updated drug with id: {}", drugId);
        return modelMapper.map(drugRepository.save(drug), FullDrugDTO.class);
    }

    /**
     * Delete drug by ID
     * @param drugId Id of the drug that we want to delete
     */
    public void deleteDrugByID(Long drugId) {
        log.info("Start deleting drug with id {}", drugId);
        var drug = drugRepository.findById(drugId);
        if(drug == null){
            throw new EntityNotFoundException(String.format("Drug with id %s is not found", drugId));
        }
        drugRepository.delete(drug);
        log.info("Deleted drug with id {}", drugId);
    }
}
