package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.dto.AppointmentDTO;
import com.mentormate.devcamp.application.persistence.dto.FullAppointmentDTO;
import com.mentormate.devcamp.application.persistence.entity.Appointment;
import com.mentormate.devcamp.application.persistence.entity.Role.RoleType;
import com.mentormate.devcamp.application.persistence.entity.User;
import com.mentormate.devcamp.application.persistence.repository.AppointmentRepository;
import com.mentormate.devcamp.application.persistence.repository.RoleRepository;
import com.mentormate.devcamp.application.persistence.repository.UserRepository;
import com.mentormate.devcamp.application.presentation.exception.AppointmentSlotBusyException;
import com.mentormate.devcamp.application.presentation.exception.NoDoctorRoleFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Service
public class AppointmentService {
    public static final int PAGE_SIZE = 10;
    private static final String NOT_SET = "Customer not specified";
    private final AppointmentRepository appointmentRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public FullAppointmentDTO createAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
        User user = userRepository.findByUsername(appointment.getDoctor()).orElseThrow(() -> new EntityNotFoundException("The provided doctor doesn't exist"));
        if (!user.getRoles().contains(roleRepository.findByName(RoleType.DOCTOR).orElse(null))) {
            throw new NoDoctorRoleFoundException("This user is not a doctor.");
        }
        boolean busy = appointmentRepository.findByDoctorAndStartTime(appointment.getDoctor(), appointment.getStartTime()).isPresent();
        if (busy) {
            throw new AppointmentSlotBusyException("Doctor is busy at this time");
        }

        if (appointment.getCustomer().isBlank()) {
            appointment.setCustomer(NOT_SET);
        }

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, FullAppointmentDTO.class);
    }

    public FullAppointmentDTO deleteAppointmentById(Long appointmentId) {
        var appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Appointment with id %s is not found", appointmentId)));
        appointmentRepository.delete(appointment);
        log.info("Deleted appointment with id {}", appointmentId);
        return modelMapper.map(appointment, FullAppointmentDTO.class);
    }

    public FullAppointmentDTO getAppointmentById(Long appointmentId) {
        log.info("Get appointment by id: {}", appointmentId);
        var drug = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Appointment with id %s is not found", appointmentId)));
        return modelMapper.map(drug, FullAppointmentDTO.class);
    }

    public FullAppointmentDTO updateAppointmentById(Long appointmentId, AppointmentDTO updatedAppointment) {
        log.info("Start updating appointment with id: {}", appointmentId);
        var appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Appointment with id %s is not found", appointmentId)));
        User user = userRepository.findByUsername(updatedAppointment.getDoctor()).orElseThrow(() -> new EntityNotFoundException("The provided doctor doesn't exist"));
        if (!user.getRoles().contains(roleRepository.findByName(RoleType.DOCTOR).orElse(null))) {
            throw new NoDoctorRoleFoundException("This user is not a doctor.");
        }
        appointment.update(modelMapper.map(updatedAppointment, Appointment.class));
        appointmentRepository.save(appointment);
        log.info("Updated appointment with id: {}", appointmentId);
        return modelMapper.map(appointment, FullAppointmentDTO.class);
    }

    public Page<FullAppointmentDTO> findPaginated(int page) {
        log.info("Fetch all appointments");
        return appointmentRepository.findAll(PageRequest.of(page, PAGE_SIZE)).map(appointment -> modelMapper.map(appointment, FullAppointmentDTO.class));
    }

}
