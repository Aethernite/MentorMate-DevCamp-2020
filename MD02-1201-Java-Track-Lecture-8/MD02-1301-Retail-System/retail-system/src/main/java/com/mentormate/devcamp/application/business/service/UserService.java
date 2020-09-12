package com.mentormate.devcamp.application.business.service;

import com.mentormate.devcamp.application.persistence.entity.User;
import com.mentormate.devcamp.application.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * The User service.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Gets all users.
     *
     * @return the all users
     */
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    /**
     * Creates user.
     *
     * @param user the user
     * @return the user
     */
    public User createUser(User user) {
        user.setDateCreated(Instant.now());
        user.setDiscount();

        return this.userRepository.save(user);
    }

    /**
     * Edit user.
     *
     * @param userId the user id
     * @param user   the user
     * @return the user
     */
    public User editUser(long userId, User user) {
        User editUser = this.userRepository.getOne(userId);

        editUser.setUsername(user.getUsername());
        editUser.setUserRole(user.getUserRole());
        editUser.setFirstName(user.getFirstName());
        editUser.setLastName(user.getLastName());
        editUser.setEmail(user.getEmail());
        editUser.setDiscount(user.getDiscount());
        editUser.setDiscount();
        editUser.setDateEdited(Instant.now());

        return editUser;
    }

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    public User getUserById(long userId) {
        return this.userRepository.getOne(userId);
    }

    /**
     * Delete user by id.
     *
     * @param userId the user id
     * @return the user
     */
    public User deleteUserById(long userId) {
        User deleteUser = this.userRepository.getOne(userId);

        this.userRepository.delete(deleteUser);

        return deleteUser;
    }
}
