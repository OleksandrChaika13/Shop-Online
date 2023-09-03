package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeUpdateRepository {

    public int updateEmployee(Employee employee) {
        String sql = "UPDATE " + Constants.TABLE_EMPLOYEES + " SET lastName = ?, firstName = ?, " +
                "birthDate = ?, positionId = ?, phone = ?, salary = ? WHERE id = ?";
        int affectedRows = 0;

        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getBirthDate());
            preparedStatement.setInt(4, employee.getPositionId());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setInt(7, employee.getId());

            affectedRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRows;
    }

    public boolean employeeExists(int employeeId) {
        String sql = "SELECT COUNT(*) FROM " + Constants.TABLE_EMPLOYEES + " WHERE id = ?";
        try (Connection connection = DBConn.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, employeeId);
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
