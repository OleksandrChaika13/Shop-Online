package org.example.app.views.positions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PositionUpdateView {

    private final Scanner scanner;

    public PositionUpdateView() {
        scanner = new Scanner(System.in);
    }

    public int getPositionId() {
        System.out.print("Enter the ID of the position you want to update: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public String getUpdatedData() {
        scanner.nextLine();
        System.out.print("Enter updated position name: ");
        return scanner.nextLine().trim();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}