package com.example.lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter car make (e.g., Toyota, Ford):");
        String make = scanner.nextLine();

        System.out.println("Enter car model (e.g., Camry, Mustang):");
        String model = scanner.nextLine();

        int year = 0;
        boolean validInput = false;

        // Loop until a valid year is entered
        while (!validInput) {
            System.out.println("Enter car year:");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year > 1885 && year <= java.time.Year.now().getValue()) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a valid year (after 1885).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for the year.");
            }
        }

        try {
            Car car = new Car(make, model, year);
            System.out.println("Car details:");
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYear());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        if (make == null || make.isEmpty()) {
            throw new IllegalArgumentException("Make cannot be empty");
        }
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }
        if (year <= 1885) {
            throw new IllegalArgumentException("Year must be after 1885");
        }
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
