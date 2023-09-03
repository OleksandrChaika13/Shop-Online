package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeeUpdateRepository;
import org.example.app.utils.Constants;

public class EmployeeUpdateService {

    private final EmployeeUpdateRepository repository;

    public EmployeeUpdateService(EmployeeUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateEmployee(int employeeId, String[] updatedData) {
        if (!repository.employeeExists(employeeId)) {
            return Constants.UPDATE_WRONGID_MSG;
        }

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(employeeId);
        updatedEmployee.setLastName(updatedData[0]);
        updatedEmployee.setFirstName(updatedData[1]);
        updatedEmployee.setBirthDate(updatedData[2]);
        updatedEmployee.setPositionId(Integer.parseInt(updatedData[3]));
        updatedEmployee.setPhone(updatedData[4]);
        updatedEmployee.setSalary(Double.parseDouble(updatedData[5]));

        int affectedRows = repository.updateEmployee(updatedEmployee);

        if (affectedRows > 0) {
            return Constants.UPDATE_SUCCESS_MSG;
        } else {
            return Constants.UPDATE_FAILURE_MSG;
        }
    }

    public boolean employeeExists(int employeeId) {
        return repository.employeeExists(employeeId);
    }
}
