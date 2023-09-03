package org.example.app.repositories.positions;

import org.example.app.database.DBConn;
import org.example.app.entities.Position;
import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionUpdateRepository {

    public int updatePosition(Position updatedPosition) {
        String sql = "UPDATE " + Constants.TABLE_POSITIONS + " SET name = ? WHERE id = ?";
        int affectedRows = 0;

        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, updatedPosition.getName());
            preparedStatement.setInt(2, updatedPosition.getId());

            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }

    public boolean positionExists(int positionId) {
        String sql = "SELECT COUNT(*) FROM " + Constants.TABLE_POSITIONS + " WHERE id = ?";
        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, positionId);
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
