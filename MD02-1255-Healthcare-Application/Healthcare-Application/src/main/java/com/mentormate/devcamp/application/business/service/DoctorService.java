package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.dto.FullAppointmentDTO;
import com.mentormate.devcamp.application.persistence.entity.Appointment.Status;
import com.mentormate.devcamp.application.persistence.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


/**
 * The Doctor service.
 * <p>
 * This service takes care of listing appointments and setting certain status to them. Can be used only by doctors.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DoctorService {
    private static final int PAGE_SIZE = 10;
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    /**
     * Find paginated.
     *
     * @param page the page
     * @return page of full appointment DTOs
     */
    public Page<FullAppointmentDTO> findPaginated(int page) {
        log.info("Fetch all appointments for the current doctor");
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return appointmentRepository.findAllByDoctor(username, PageRequest.of(page, PAGE_SIZE)).map(appointment -> modelMapper.map(appointment, FullAppointmentDTO.class));
    }


    /**
     * Sets appointment to pending by id.
     *
     * @param appointmentId the appointment id
     * @return the appointment updated
     */
    public FullAppointmentDTO setAppointmentToPendingID(Long appointmentId) {
        log.info("Start updating the appointment to pending with id: {}", appointmentId);
        var appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Appointment with id %s is not found", appointmentId)));
        appointment.setStatus(Status.PENDING);
        appointmentRepository.save(appointment);
        log.info("Updated appointment status to pending with id: {}", appointmentId);
        return modelMapper.map(appointment, FullAppointmentDTO.class);
    }

    /**
     * Sets appointment to approved
     *
     * @param appointmentId the appointment id
     * @return the appointment updated
     */
    public FullAppointmentDTO setAppointmentToApprovedID(Long appointmentId) {
        log.info("Start updating the appointment to approved with id: {}", appointmentId);
        var appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Appointment with id %s is not found", appointmentId)));
        appointment.setStatus(Status.APPROVED);
        appointmentRepository.save(appointment);
        log.info("Updated appointment status to approved with id: {}", appointmentId);
        return modelMapper.map(appointment, FullAppointmentDTO.class);
    }

    /**
     * Sets appointment to declined
     *
     * @param appointmentId the appointment id
     * @return the appointment updated
     */
    public FullAppointmentDTO setAppointmentToDeclinedID(Long appointmentId) {
        log.info("Start updating the appointment to declined with id: {}", appointmentId);
        var appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Appointment with id %s is not found", appointmentId)));
        appointment.setStatus(Status.DECLINED);
        appointmentRepository.save(appointment);
        log.info("Updated appointment status to declined with id: {}", appointmentId);
        return modelMapper.map(appointment, FullAppointmentDTO.class);
    }
}
