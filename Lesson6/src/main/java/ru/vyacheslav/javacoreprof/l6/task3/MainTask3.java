package ru.vyacheslav.javacoreprof.l6.task3;

import ru.vyacheslav.javacoreprof.l6.task3.DAO.DAO;
import ru.vyacheslav.javacoreprof.l6.task3.DAO.JdbcDaoImpl;
import ru.vyacheslav.javacoreprof.l6.task3.model.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MainTask3 {
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:students.sqlite");

        DAO dao = new JdbcDaoImpl(connection);

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS Students;");
            statement.execute("CREATE TABLE Students" +
                    " ( " +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "Surname TEXT NOT NULL, " +
                    "Score INTEGER NOT NULL " +
                    ");");

            // Удаляем все записи, добавляем студентов и выводим их в консоль
            statement.executeUpdate("INSERT INTO Students (Surname, Score) values ('Попов', 58);");
            statement.executeUpdate("INSERT INTO Students (Surname, Score) values ('Винокуров', 10);");
            statement.executeUpdate("INSERT INTO Students (Surname, Score) values ('Сергеев', 99);");
            statement.executeUpdate("INSERT INTO Students (Surname, Score) values ('Магомедов', 34);");
            List<Students> itemsAll = dao.getAllStudents();
            itemsAll.forEach(System.out::println);
        } finally {
            connection.close();
        }

        }
}
