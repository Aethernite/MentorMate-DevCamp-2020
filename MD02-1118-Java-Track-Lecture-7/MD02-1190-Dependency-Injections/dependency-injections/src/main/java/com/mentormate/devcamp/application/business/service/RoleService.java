package com.mentormate.devcamp.application.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple Role service.
 */
@Service
public class RoleService {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private UserService userService;
}
