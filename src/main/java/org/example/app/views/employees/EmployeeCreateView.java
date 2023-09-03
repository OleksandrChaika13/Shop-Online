package org.example.app.views.employees;

import java.util.Scanner;

public class EmployeeCreateView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter birth date (yyyy-MM-dd): ");
        String birthDate = scanner.nextLine().trim();
        System.out.print("Enter position ID: ");
        String positionId = scanner.nextLine().trim();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter salary: ");
        String salary = scanner.nextLine().trim();
        return new String[]{lastName, firstName, birthDate, positionId, phone, salary};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}

