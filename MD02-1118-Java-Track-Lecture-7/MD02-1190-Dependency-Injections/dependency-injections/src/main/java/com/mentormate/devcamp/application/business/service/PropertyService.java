package com.mentormate.devcamp.application.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple Property service.
 */
@Service
public class PropertyService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
}
