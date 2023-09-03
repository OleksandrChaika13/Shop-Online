package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.exceptions.EmployeeCreateException;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCreateService {

    private final EmployeeCreateRepository repository;

    public EmployeeCreateService(EmployeeCreateRepository repository) {
        this.repository = repository;
    }

    public String createEmployee(Employee employee) {

        Map<String, String> errors = new HashMap<>();

        if (employee.getLastName().isEmpty())
            errors.put("lastName", Constants.INPUT_REQ_MSG);

        if (employee.getFirstName().isEmpty())
            errors.put("firstName", Constants.INPUT_REQ_MSG);

        if (employee.getBirthDate().isEmpty())
            errors.put("birthDate", Constants.INPUT_REQ_MSG);

        if (employee.getPositionId() <= 0)
            errors.put("positionId", Constants.INPUT_REQ_MSG);

        if (employee.getPhone().isEmpty())
            errors.put("phone", Constants.INPUT_REQ_MSG);

        if (employee.getSalary() <= 0)
            errors.put("salary", Constants.INPUT_REQ_MSG);

        if (!errors.isEmpty()) {
            try {
                throw new EmployeeCreateException("Check inputs", errors);
            } catch (EmployeeCreateException e) {
                return e.getErrors(errors);
            }
        }

        return repository.createEmployee(employee);
    }
}
