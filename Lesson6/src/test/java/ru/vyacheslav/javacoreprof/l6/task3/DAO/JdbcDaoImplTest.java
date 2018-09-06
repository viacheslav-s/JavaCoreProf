package ru.vyacheslav.javacoreprof.l6.task3.DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vyacheslav.javacoreprof.l6.task3.model.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class JdbcDaoImplTest {
    private static JdbcDaoImpl dao;
    static Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:students.sqlite");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    static void setUp() throws SQLException {
        new JdbcDaoImpl(connection);
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
    }

    @Test
    void getAllStudents() {
        
    }

    @Test
    void getSurnameById() {
    }

    @Test
    void addStudent() {

    }

    @Test
    void updateStudentScoreById () {
    }

    @Test
    void getSurnamesBetweenScore () {

    }
}