package org.example.app.controllers.employees;

import org.example.app.services.employees.EmployeeReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.employees.EmployeeReadView;

public class EmployeeReadController {

    EmployeeReadService service;
    EmployeeReadView view;

    public EmployeeReadController(EmployeeReadService service, EmployeeReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readEmployees() {
        String str = service.readEmployees();
        view.getOutput(str);
        AppStarter.startApp();
    }
}