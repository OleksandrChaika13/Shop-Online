package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDeleteRepository {

    public int deleteEmployee(int employeeId) {
        String sql = "DELETE FROM " + Constants.TABLE_EMPLOYEES + " WHERE id = ?";
        int affectedRows = 0;

        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, employeeId);

            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public boolean employeeExists(int id) {
        String sql = "SELECT COUNT(*) FROM " + Constants.TABLE_EMPLOYEES + " WHERE id = ?";
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