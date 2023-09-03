package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeUpdateView;

public class EmployeeUpdateController {

    private final EmployeeUpdateService service;
    private final EmployeeUpdateView view;

    public EmployeeUpdateController(EmployeeUpdateService service, EmployeeUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateEmployee() {
        int employeeId = view.getEmployeeId();

        if (employeeId != -1) {
            if (!service.employeeExists(employeeId)) {
                view.getOutput("This ID does not exist. Update failed.");
            } else {
                String[] updatedData = view.getUpdatedData();
                String result = service.updateEmployee(employeeId, updatedData);
                view.getOutput(result);
            }
        }

        AppStarter.startApp();
    }
}





