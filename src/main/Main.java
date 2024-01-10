package main;

import controller.SortController;
import model.SortModel;
import view.SortView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;

        ArrayList<Integer> numbers = new ArrayList<>(); 

        do {
            try {
                System.out.print("Enter the number of elements: ");
                int n = scanner.nextInt();

                System.out.println("Enter the elements:");

                for (int i = 0; i < n; i++) {
                    try {
                        int element = scanner.nextInt();
                        numbers.add(element);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Skipping the current element.");
                        scanner.next(); 
                        i--; 
                    }
                }

                System.out.println("___________ Menu Sort ___________");
                System.out.println("1. Bubble sort.");
                System.out.println("2. Quick sort.");
                System.out.print("Enter your choice: ");

                int sortType = scanner.nextInt();

                SortModel model = new SortModel();
                model.setNumbers(numbers);

                SortView view = new SortView();

                SortController controller = new SortController(model, view);
                controller.performSort(sortType);

                System.out.print("Sorted array: ");
                view.printNumbers(model.getNumbers());

                validInput = true; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid numeric values.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } while (!validInput);
        scanner.close();
    }
}