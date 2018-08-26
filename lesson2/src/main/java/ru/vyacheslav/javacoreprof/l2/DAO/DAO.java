package ru.vyacheslav.javacoreprof.l2.DAO;

import ru.vyacheslav.javacoreprof.l2.model.Items;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
    List<Items> getAllItems() throws SQLException;

    Items getItemsById(int id);

    List<Items> getItemByTitle(String title) throws SQLException;

    void changeCostByTitle(String title, int cost) throws SQLException;

    List<Items> displayItemsBetweenCosts(int cost1, int cost2) throws SQLException;
}
