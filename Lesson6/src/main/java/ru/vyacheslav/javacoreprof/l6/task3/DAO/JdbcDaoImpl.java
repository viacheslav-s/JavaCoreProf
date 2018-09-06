package ru.vyacheslav.javacoreprof.l6.task3.DAO;

import ru.vyacheslav.javacoreprof.l6.task3.model.Students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDaoImpl implements DAO {
    private Connection connection;

    public JdbcDaoImpl(Connection connection) {
        this.connection = connection;
    }

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
        }
    }

    private Students convertStudents(ResultSet resultSet) throws SQLException {
        Students students = new Students();
        students.setId(resultSet.getInt(1));
        students.setSurname(resultSet.getString(2));
        students.setScore(resultSet.getInt(3));
        return students;
    }

    @Override
    public List<Students> getAllStudents() throws SQLException {
        String query = "SELECT * FROM Students";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Students> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(convertStudents(resultSet));
        }
        return students;
    }

    @Override
    public List<Students> getSurnameById(int id) throws SQLException {
        String sql = "SELECT * FROM Students WHERE ID = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        List<Students> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(convertStudents(resultSet));
        }
        return students;
    }

    @Override
    public void addStudent(String surname,int score) throws SQLException {
        String sql = "INSERT INTO Students (Surname, Score) VALUES ('?', '?');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, surname);
        statement.setInt(2, score);
        statement.executeUpdate();
        System.out.println("Запись студента " + surname + " " + score + " баллов была добавлена.");
    }

    @Override
    public void updateStudentScoreById(int id,int score) throws SQLException {
        String sql = "UPDATE Students SET Score = ? WHERE id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, score);
        statement.setInt(2, id);
        statement.executeUpdate();
        System.out.println("Баллы студента (Id " + id + ") изменены на " + score + " баллов.");

    }

    @Override
    public List<Students> getSurnamesBetweenScore(int scoreStart,int scoreEnd) throws SQLException {
        String sql = "SELECT * FROM Students WHERE Score BETWEEN ? AND ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, scoreStart);
        statement.setInt(2, scoreEnd);
        ResultSet resultSet = statement.executeQuery();

        List<Students> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(convertStudents(resultSet));
        }
        return students;
    }
}
