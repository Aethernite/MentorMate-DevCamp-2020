package com.mentormate.devcamp.application.entity;

/**
 * The class Account.
 * <p>
 * Holds user information such as first name, last name, password, email etc.
 */
public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String dateOfBirth;
    private String password;

    /**
     * Instantiates a new Account with email and password.
     *
     * @param email    the email
     * @param password the password
     */
    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Instantiates a new Account.
     *
     * @param id          the id
     * @param email       the email
     * @param firstName   the first name
     * @param lastName    the last name
     * @param dateOfBirth the date of birth
     * @param password    the password
     */
    public Account(int id, String email, String firstName, String lastName, String dateOfBirth, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    /**
     * Instantiates a new Account.
     *
     * @param email       the email
     * @param firstName   the first name
     * @param lastName    the last name
     * @param dateOfBirth the date of birth
     * @param password    the password
     */
    public Account(String email, String firstName, String lastName, String dateOfBirth, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===========================")
                .append("Id: ")
                .append(id)
                .append("First name: ").append(firstName)
                .append("Last name: ").append(lastName)
                .append("Email: ").append(email)
                .append("Date of Birth: ").append(dateOfBirth)
                .append("===========================");
        return sb.toString();
    }
}
