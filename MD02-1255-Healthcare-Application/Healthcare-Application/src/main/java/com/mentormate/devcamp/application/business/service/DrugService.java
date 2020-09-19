package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.dto.DrugDTO;
import com.mentormate.devcamp.application.persistence.dto.FullDrugDTO;
import com.mentormate.devcamp.application.persistence.entity.Drug;
import com.mentormate.devcamp.application.persistence.repository.DrugRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * This service is responsible to handle all CRUD operation related to {@link Drug}
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DrugService {
    private static final int PAGE_SIZE = 10;

    private final ModelMapper modelMapper;

    private final DrugRepository drugRepository;

    /**
     * Create new {@link Drug} in our application
     *
     * @param drugDTO {@link DrugDTO} information needed for creation of new {@link Drug}
     * @return {@link Drug} that is saved in our database converted to {@link DrugDTO}
     */
    public FullDrugDTO createDrug(DrugDTO drugDTO) {
        Drug drug = modelMapper.map(drugDTO, Drug.class);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        drug.setCreatedBy(username);
        drug = drugRepository.save(drug);
        log.info("Created drug with id {}", drug.getId());
        return modelMapper.map(drug, FullDrugDTO.class);
    }

    /**
     * Gets a page of {@link Drug}'s
     *
     * @return {@link List<FullDrugDTO>} of our {@link Drug}'s converted to {@link FullDrugDTO}'s
     */
    public Page<FullDrugDTO> findPaginated(int page) {
        log.info("Fetch all drugs");
        return drugRepository.findAll(PageRequest.of(page, PAGE_SIZE)).map(drug -> modelMapper.map(drug, FullDrugDTO.class));
    }

    /**
     * Get {@link Drug} by its ID
     *
     * @param drugID id of the {@link Drug}
     * @return {@link FullDrugDTO} corresponding {@link Drug}
     */
    public FullDrugDTO getDrugById(Long drugID) {
        log.info("Get drug by id: {}", drugID);
        var drug = drugRepository.findById(drugID)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Drug with id %s is not found", drugID)));
        return modelMapper.map(drug, FullDrugDTO.class);
    }

    /**
     * Update all information for {@link Drug} by its id
     *
     * @param drugId      Id of the {@link Drug}
     * @param updatedDrug {@link FullDrugDTO} new information that will be persisted into database
     * @return Updated {@link Drug}
     */
    public FullDrugDTO updateDrugByID(Long drugId, DrugDTO updatedDrug) {
        log.info("Start updating drug with id: {}", drugId);
        var drug = drugRepository.findById(drugId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Drug with id %s is not found", drugId)));
        drug.update(modelMapper.map(updatedDrug, Drug.class));
        drugRepository.save(drug);
        log.info("Updated drug with id: {}", drugId);
        return modelMapper.map(drug, FullDrugDTO.class);
    }

    /**
     * Delete drug by ID
     *
     * @param drugId Id of the drug that we want to delete
     */
    public FullDrugDTO deleteDrugByID(Long drugId) {
        log.info("Start deleting drug with id {}", drugId);
        var drug = drugRepository.findById(drugId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Drug with id %s is not found", drugId)));
        drugRepository.delete(drug);
        log.info("Deleted drug with id {}", drugId);
        return modelMapper.map(drug, FullDrugDTO.class);
    }
}
