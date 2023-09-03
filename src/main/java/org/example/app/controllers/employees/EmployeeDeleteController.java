package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeDeleteService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeDeleteView;

public class EmployeeDeleteController {

    private final EmployeeDeleteService service;
    private final EmployeeDeleteView view;

    public EmployeeDeleteController(EmployeeDeleteService service, EmployeeDeleteView view) {
        this.service = service;
        this.view = view;
    }

    public void deleteEmployee() {
        int employeeId = view.getEmployeeId();
        if (employeeId != -1) {
            String result = service.deleteEmployee(employeeId);
            view.getOutput(result);
            AppStarter.startApp();
        }
    }
}