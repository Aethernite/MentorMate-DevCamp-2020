package com.mentormate.devcamp.application.database;

import com.mentormate.devcamp.application.entity.Account;

import java.sql.*;


/**
 * The class Database.
 * <p>
 * Operates all of the SQL queries and updates.
 */
public class Database {
    private static final String DB_URL = "jdbc:h2:mem:database";
    private static final String USER = "admin";
    private static final String PASS = "password";
    private static Connection db = null;

    private Database() {
    }

    /**
     * Initialize the database.
     */
    public static void initialize() {
        try {
            System.out.println("Connecting to database...");
            db = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Cannot create database!");
            System.exit(1);
        }
        System.out.println("Connected to database!");
        createTables();
    }

    private static void createTables() {
        Statement stmt;
        try {
            stmt = db.createStatement();
            stmt.executeUpdate(Queries.CREATE_TABLE_ACCOUNT);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error in creating table ACCOUNT");
        }
    }

    /**
     * Insert account into the database.
     *
     * @param account the account
     */
    public static void insertAccount(Account account) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.INSERT_ACCOUNT, account.getEmail(), account.getPassword(), account.getFirstName(), account.getLastName(), account.getDateOfBirth());
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error in inserting account in the database(method insertAccount)");
        }
    }

    /**
     * Check login.
     *
     * @param account the account
     * @return true if the account is in the database and false if it is not
     */
    public static boolean checkLogin(Account account) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.CHECK_ACCOUNT, account.getEmail(), account.getPassword());
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database in check login(method checkLogin)");
        }
        return false;
    }

    /**
     * Gets account.
     *
     * @param account the account
     * @return the account
     */
    public static Account getAccount(Account account) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.GET_ACCOUNT, account.getEmail(), account.getPassword());
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String dateOfBirth = rs.getString("dateOfBirth");
            String password = rs.getString("password");
            return new Account(id, email, firstName, lastName, dateOfBirth, password);
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database(method getAccount())");
        }
        return null;
    }

    /**
     * Checks if the given account exists in the database.
     *
     * @param account the account
     * @return true if it exists and false if it doesn't
     */
    public static boolean exists(Account account) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.EXISTS_ACCOUNT, account.getEmail());
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database (method exists())");
        }
        return false;
    }

    /**
     * Prints all accounts.
     */
    public static void printAllAccounts() {
        Statement stmt;
        try {
            stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery(Queries.SELECT_EVERYTHING_FROM_ACCOUNT);
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("First name: " + rs.getString("firstName"));
                System.out.println("Last name: " + rs.getString("lastName"));
                System.out.println("Date of birth: " + rs.getString("dateOfBirth"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database(method printAllAccounts()");
        }
    }

    /**
     * Delete an account by id.
     *
     * @param id the id
     */
    public static void delete(int id) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.DELETE_BY_ID, id);
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Deletion successful");

        } catch (SQLException e) {
            System.out.println("Error in executing deletion in the database(method delete)");
        }
    }

    /**
     * Gets account by id.
     *
     * @param id the id
     * @return the account by id
     */
    public static Account getAccountById(int id) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.GET_BY_ID, id);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int identification = rs.getInt("id");
            String email = rs.getString("email");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String dateOfBirth = rs.getString("dateOfBirth");
            String password = rs.getString("password");
            return new Account(identification, email, firstName, lastName, dateOfBirth, password);
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database(method getAccountById())");
        }
        return null;
    }

    /**
     * Checks if account exists by id.
     *
     * @param id the id
     * @return true if it exists and false if it doesn't
     */
    public static boolean existsById(int id) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.GET_EMAIL_BY_ID, id);
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database(method existsById())");
        }
        return false;
    }

    /**
     * Updates an account.
     *
     * @param account the account
     */
    public static void update(Account account) {
        Statement stmt;
        try {
            stmt = db.createStatement();
            String sql = String.format(Queries.UPDATE_ACCOUNT, account.getFirstName(), account.getLastName(), account.getPassword(), account.getDateOfBirth(), account.getEmail(), account.getId());
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database(method edit())");
        }
    }

}
