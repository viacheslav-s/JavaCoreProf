package ru.vyacheslav.javacoreprof.l6.task3.DAO;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.vyacheslav.javacoreprof.l6.task3.model.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

class JdbcDaoImplTest {
    private static Connection connection;
    private static DAO dao;

    @BeforeAll
    static void setUp() throws SQLException{
        connection = DriverManager.getConnection("jdbc:sqlite:students.sqlite");
        dao = new JdbcDaoImpl(connection);
    }

    @AfterAll
    static void close() throws SQLException {
        connection.close();
    }

    @Test
    void getAllStudents() throws SQLException {
        List<Students> result = dao.getAllStudents();
        Assertions.assertEquals(4, result.size());
    }

    @Test
    void getStudentById() throws SQLException {
        List<Students> students = dao.getStudentById(1);
        String result = students.toString();
        String expected = "[Студенты {id=1, Фамилия='Попов', Баллы=58}]";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void addStudent() throws SQLException {
        dao.addStudent("Вакуленко", 69);
        List<Students> students = dao.getStudentById(5);
        String result = students.toString();
        String expected = "[Студенты {id=5, Фамилия='Вакуленко', Баллы=69}]";
        Assertions.assertEquals(expected, result);
        dao.deleteStudentById(5);
    }

    @Test
    void updateStudentScoreById () throws SQLException {
        dao.updateStudentScoreById(1, 11);
        List<Students> students = dao.getStudentById(1);
        String result = students.toString();
        String expected = "[Студенты {id=1, Фамилия='Попов', Баллы=11}]";
        Assertions.assertEquals(expected, result);
        dao.updateStudentScoreById(1, 58);
    }

    @Test
    void getStudentsBetweenScore () throws SQLException {
        List<Students> students = dao.getStudentsBetweenScore(50, 100);
        String result = students.toString();
        String expected = "[Студенты {id=1, Фамилия='Попов', Баллы=58}, Студенты {id=3, Фамилия='Сергеев', Баллы=99}]";
        Assertions.assertEquals(expected, result);

    }
}