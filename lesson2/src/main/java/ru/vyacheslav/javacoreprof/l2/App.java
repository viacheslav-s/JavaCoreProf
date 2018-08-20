package ru.vyacheslav.javacoreprof.l2;

import ru.vyacheslav.javacoreprof.l2.DAO.DAO;
import ru.vyacheslav.javacoreprof.l2.DAO.JdbcDaoImpl;
import ru.vyacheslav.javacoreprof.l2.model.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static Scanner sc = new Scanner(System.in);
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:items.sqlite");

        DAO dao = new JdbcDaoImpl(connection);

        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS ITEMS" +
                    " ( " +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "PRODID INTEGER NOT NULL, " +
                    "TITLE TEXT NOT NULL, " +
                    "COST INTEGER NOT NULL " +
                    ");");

            // Для теста удаляем все, добавляем одну запись и выводим ее
            statement.executeUpdate("DELETE FROM ITEMS;");
            statement.executeUpdate("INSERT INTO ITEMS (PRODID, TITLE, COST) values ('1', 'Товар1', '650');");
            List<Items> itemsAll = dao.getAllItems();
            itemsAll.forEach(System.out::println);

            // Удаляем все записи
            statement.executeUpdate("DELETE FROM ITEMS;");

            //  Добавляем 10 000 товаров
            for (int i = 1; i < 10001; i++) {
                int cost = i*10;
                statement.addBatch(String.format("INSERT INTO ITEMS (PRODID, TITLE, COST) values ('id_товара %d', 'товар%d', '%d')", i, i, cost));
            }
            statement.executeBatch();

            System.out.println("База подключена, интерфейсы настроены. Что дальше?");
            String userCmd = sc.nextLine();
            if (userCmd.startsWith("/")) {
                String[] parts = userCmd.split("\\s");
                String cmdStr1 = parts[0];
                String cmdStr2 = parts[1];

                if (cmdStr1.equals("/цена")) {
                    List<Items> itemsByTitle = dao.getItemByTitle(cmdStr2);
                    if (itemsByTitle.size() == 0) {
                        System.out.println("Такого товара нет");
                    } else {
                        itemsByTitle.forEach(System.out::println);
                    }

                }
                if (parts[0].equals("/сменитьцену")) {
                    int cmdInt3 = Integer.parseInt(parts[2]);
                    dao.changeCostByTitle(cmdStr2, cmdInt3);

                }
                if (parts[0].equals("/товарыпоцене")) {
                    int cmdInt2 = Integer.parseInt(parts[1]);
                    int cmdInt3 = Integer.parseInt(parts[2]);
                    List<Items> itemsByTitle = dao.displayItemsBetweenCosts(cmdInt2, cmdInt3);
                    itemsByTitle.forEach(System.out::println);

                }
            } else {
                System.out.println("Команда введена неверно");
            }

        } finally {
            connection.close();
        }
    }
}
