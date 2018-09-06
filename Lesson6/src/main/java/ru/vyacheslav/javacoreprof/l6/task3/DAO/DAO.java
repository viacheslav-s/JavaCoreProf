package ru.vyacheslav.javacoreprof.l6.task3.DAO;

import ru.vyacheslav.javacoreprof.l6.task3.model.Students;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
    void addStudent(String surname, int score) throws SQLException;

    void updateStudentScoreById(int id, int score) throws SQLException;

    List<Students> getSurnameById(int id) throws SQLException;

    List<Students> getSurnamesBetweenScore(int scoreStart, int scoreEnd) throws SQLException;

    List<Students> getAllStudents() throws SQLException;
}
