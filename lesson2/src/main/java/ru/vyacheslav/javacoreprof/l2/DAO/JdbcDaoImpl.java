package ru.vyacheslav.javacoreprof.l2.DAO;

import ru.vyacheslav.javacoreprof.l2.model.Items;

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

    @Override
    public List<Items> getAllItems() throws SQLException {
        String query = "SELECT * FROM ITEMS";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        List<Items> items = new ArrayList<>();
        while (resultSet.next()) {
            items.add(convertToItems(resultSet));
        }
        return items;
    }

    private Items convertToItems(ResultSet resultSet) throws SQLException {
        Items items = new Items();
        items.setId(resultSet.getInt(1));
        items.setProdId(resultSet.getString(2));
        items.setTitle(resultSet.getString(3));
        items.setCost(resultSet.getInt(4));
        return items;
    }

    @Override
    public Items getItemsById(int id) {
        return null;
    }

    @Override
    public List<Items> getItemByTitle(String title) throws SQLException {
        String sql = "SELECT * FROM ITEMS WHERE TITLE = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, title);
        ResultSet resultSet = statement.executeQuery();

        List<Items> items = new ArrayList<>();
        while (resultSet.next()) {
            items.add(convertToItems(resultSet));
        }

        return items;
    }

    @Override
    public void changeCostByTitle(String title, int cost) throws SQLException {
        String sql = "UPDATE ITEMS SET COST = ? WHERE TITLE = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cost);
        statement.setString(2, title);
        statement.executeUpdate();
        System.out.println("Запись " + title + " была обновлена.");
    }

    @Override
    public List<Items> displayItemsBetweenCosts(int cost1, int cost2) throws SQLException {
        String sql = "SELECT * FROM ITEMS WHERE COST BETWEEN ? AND ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cost1);
        statement.setInt(2, cost2);
        ResultSet resultSet = statement.executeQuery();

        List<Items> items = new ArrayList<>();
        while (resultSet.next()) {
            items.add(convertToItems(resultSet));
        }

        return items;
    }

}
