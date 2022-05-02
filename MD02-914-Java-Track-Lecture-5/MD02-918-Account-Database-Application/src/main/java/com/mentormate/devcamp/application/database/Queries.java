package com.mentormate.devcamp.application.database;

/**
 * The type Queries.
 */
public class Queries {
    /**
     * The constant GET_ACCOUNT.
     * <p>
     * Selects everything from ACCOUNT where email and password is equal to the given
     */
    public static final String GET_ACCOUNT = "SELECT * FROM Account WHERE email='%s' AND password='%s'";
    /**
     * The constant CHECK_ACCOUNT.
     * <p>
     * Selects email and password from ACCOUNT where email and password is equal to the given
     */
    public static final String CHECK_ACCOUNT = "SELECT email, password FROM ACCOUNT WHERE email = '%s' AND password = '%s'";
    /**
     * The constant INSERT_ACCOUNT.
     * <p>
     * Inserts account into the database with the given values
     */
    public static final String INSERT_ACCOUNT = "INSERT INTO ACCOUNT (email,password,firstName,lastName,dateOfBirth) VALUES ('%s', '%s', '%s', '%s', '%s')";
    /**
     * The constant EXISTS_ACCOUNT.
     * <p>
     * Selects email only from ACCOUNT where the email is equal to the given
     */
    public static final String EXISTS_ACCOUNT = "SELECT email FROM ACCOUNT WHERE email='%s'";
    /**
     * The constant CREATE_TABLE_ACCOUNT.
     * <p>
     * Creates table ACCOUNT with id, email, password, first and last name, date of birth
     */
    public static final String CREATE_TABLE_ACCOUNT = "CREATE TABLE ACCOUNT (id INTEGER not NULL AUTO_INCREMENT, email NVARCHAR(255), password NVARCHAR(255), firstName NVARCHAR(255), lastName NVARCHAR(255), dateOfBirth NVARCHAR, PRIMARY KEY ( id ))";
    /**
     * The constant SELECT_EVERYTHING_FROM_ACCOUNT.
     * <p>
     * Selects everything from ACCOUNT
     */
    public static final String SELECT_EVERYTHING_FROM_ACCOUNT = "SELECT * FROM Account";
    /**
     * The constant DELETE_BY_ID.
     * <p>
     * Deletes an account by id
     */
    public static final String DELETE_BY_ID = "DELETE FROM account WHERE id='%d'";
    /**
     * The constant GET_BY_ID.
     * <p>
     * Gets an account by id
     */
    public static final String GET_BY_ID = "SELECT * FROM ACCOUNT WHERE id='%d'";
    /**
     * The constant GET_EMAIL_BY_ID.
     * <p>
     * Gets only the email of an account by id
     */
    public static final String GET_EMAIL_BY_ID = "SELECT email FROM ACCOUNT WHERE id = '%d';";
    /**
     * The constant UPDATE_ACCOUNT.
     * <p>
     * Updates an existing account with given values
     */
    public static final String UPDATE_ACCOUNT = "UPDATE ACCOUNT SET firstName = '%s', lastName = '%s', password='%s', dateOfBirth='%s', email='%s' WHERE id='%d'";

    private Queries() {
    }
}
