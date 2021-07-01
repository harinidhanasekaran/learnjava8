package harini.teaches;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TurboSort {

    private static boolean isInputNumberValid(int num, int minValue, int maxValue){
        return (num >= minValue && num <= maxValue);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfNumberInList = inputScanner.nextInt();
        if(!isInputNumberValid(numOfNumberInList, 1, (int) Math.pow(10,6)))
            System.exit(-1);
        else {
            int index = 0;
            List<Integer> sortedNumbersList = new ArrayList<>();
            while(index < numOfNumberInList) {
                int inputNumber = inputScanner.nextInt();
                sortedNumbersList.add(inputNumber);
                index++;
            }
            Collections.sort(sortedNumbersList);
            sortedNumbersList.forEach(System.out::println);
        }
    }
}
