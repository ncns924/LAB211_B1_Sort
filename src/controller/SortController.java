package controller;

import java.util.ArrayList;

import model.SortModel;
import view.SortView;

public class SortController {

    private SortModel model;
    private SortView view;

    public SortController(SortModel model, SortView view) {
        this.model = model;
        this.view = view;
    }

    public void performSort(int sortType) {
        ArrayList<Integer> numbers = model.getNumbers();

        switch (sortType) {
            case 1:
                performBubbleSort(numbers);
                break;
            case 2:
                performQuickSort(numbers, 0, numbers.size() - 1);
                break;
            default:
                System.out.println("Invalid sort type!");
        }
    }

    private void performBubbleSort(ArrayList<Integer> numbers) {
        int n = numbers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    private void performQuickSort(ArrayList<Integer> numbers, int low, int high) {
        if (low < high) {
            int pi = model.partition(low, high);

            performQuickSort(numbers, low, pi - 1);
            performQuickSort(numbers, pi + 1, high);
        }
    }
}
