package org.example.app.services.employees;

import org.example.app.repositories.employees.EmployeeDeleteRepository;
import org.example.app.utils.Constants;

public class EmployeeDeleteService {

    private final EmployeeDeleteRepository repository;

    public EmployeeDeleteService(EmployeeDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteEmployee(int employeeId) {
        if (!repository.employeeExists(employeeId)) {
            return Constants.DELETE_WRONGID_MSG;
        }

        int affectedRows = repository.deleteEmployee(employeeId);

        if (affectedRows > 0) {
            return Constants.DELETE_SUCCESS_MSG;
        } else {
            return Constants.DELETE_FAILURE_MSG;
        }
    }
}