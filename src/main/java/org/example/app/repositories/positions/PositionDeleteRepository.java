package org.example.app.repositories.positions;

import org.example.app.database.DBConn;
import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PositionDeleteRepository {

    public int deletePosition(int id) {
        String sql = "DELETE FROM " + Constants.TABLE_POSITIONS + " WHERE id = ?";
        int affectedRows = 0;

        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public boolean positionExists(int id) {
        String sql = "SELECT COUNT(*) FROM " + Constants.TABLE_POSITIONS + " WHERE id = ?";
        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
