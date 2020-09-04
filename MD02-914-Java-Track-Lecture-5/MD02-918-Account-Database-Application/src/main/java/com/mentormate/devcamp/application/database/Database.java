package com.mentormate.devcamp.application.database;

import com.mentormate.devcamp.application.entity.Account;

import java.sql.*;

public class Database {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:mem:database";
    private static final String USER = "admin";
    private static final String PASS = "password";
    private static Connection db = null;

    public static void initialize() throws ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
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
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = "CREATE TABLE ACCOUNT " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " email NVARCHAR(255), " +
                    " password NVARCHAR(255), " +
                    " firstName NVARCHAR(255), " +
                    " lastName NVARCHAR(255), " +
                    " dateOfBirth NVARCHAR, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error in creating table ACCOUNT");
        }
    }

    public static void insertAccount(Account account) {
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = String.format("INSERT INTO ACCOUNT (email,password,firstName,lastName,dateOfBirth) VALUES ('%s', '%s', '%s', '%s', '%s')", account.getEmail(), account.getPassword(), account.getFirstName(), account.getLastName(), account.getDateOfBirth());
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error in inserting account in the database");
        }
    }

    public static boolean checkLogin(Account account) {
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = String.format("SELECT email, password FROM ACCOUNT WHERE email = '%s' AND password = '%s'", account.getEmail(), account.getPassword());
            ResultSet rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database in check login");
        }
        return false;
    }

    public static Account getAccount(Account account) {
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = String.format("SELECT * FROM Account WHERE email='%s' AND password='%s'", account.getEmail(), account.getPassword());
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
            System.out.println("Error in executing query in the database");
        }
        return null;
    }

    public static boolean exists(Account account) {
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = String.format("SELECT email FROM ACCOUNT WHERE email = '%s';", account.getEmail());
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database");
        }
        return false;
    }

    public static void printAllAccounts() {
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = "SELECT * FROM Account";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("First name: " + rs.getString("firstName"));
                System.out.println("Last name: " + rs.getString("lastName"));
                System.out.println("Date of birth: " + rs.getString("dateOfBirth"));
                System.out.println("Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Error in executing query in the database");
        }
    }

    public static void delete(int id) {
        Statement stmt = null;
        try {
            stmt = db.createStatement();
            String sql = String.format("DELETE FROM account WHERE id='%d'", id);
            stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Deletion successful");

        } catch (SQLException e) {
            System.out.println("Error in executing deletion in the database");
        }
    }

}
