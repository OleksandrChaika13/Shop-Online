package org.example.app.views.positions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PositionDeleteView {

    private final Scanner scanner;

    public PositionDeleteView() {
        scanner = new Scanner(System.in);
    }

    public int getPositionId() {
        System.out.print("Enter the ID of the position you want to delete: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
