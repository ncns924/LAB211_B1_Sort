package view;

import java.util.ArrayList;

public class SortView {

    public void printNumbers(ArrayList<Integer> numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
