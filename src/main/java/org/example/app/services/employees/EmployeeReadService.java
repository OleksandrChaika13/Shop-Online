package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeReadService {

    private final EmployeeReadRepository repository;

    public EmployeeReadService(EmployeeReadRepository repository) {
        this.repository = repository;
    }

    public String readEmployees() {
        List<Employee> list = repository.readEmployees();

        if (list != null) {
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((employee) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(employee.getId())
                                .append(", lastName: ")
                                .append(employee.getLastName())
                                .append(", firstName: ")
                                .append(employee.getFirstName())
                                .append(", birthDate: ")
                                .append(employee.getBirthDate())
                                .append(", positionId: ")
                                .append(employee.getPositionId())
                                .append(", phone: ")
                                .append(employee.getPhone())
                                .append(", salary: ")
                                .append(employee.getSalary())
                                .append("\n")
                );
                return "\n_ Employees ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}