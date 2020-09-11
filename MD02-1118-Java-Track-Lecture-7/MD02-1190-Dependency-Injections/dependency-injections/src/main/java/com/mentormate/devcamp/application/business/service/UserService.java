package com.mentormate.devcamp.application.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple User service.
 */
@Service
public class UserService {
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private RoleService roleService;
}
