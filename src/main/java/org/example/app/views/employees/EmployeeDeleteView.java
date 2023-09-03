package org.example.app.views.employees;

import org.example.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeDeleteView {

    private final Scanner scanner;

    public EmployeeDeleteView() {
        scanner = new Scanner(System.in);
    }

    public int getEmployeeId() {
        System.out.print("Enter the ID of the employee you want to delete: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            return -1;
        }
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}