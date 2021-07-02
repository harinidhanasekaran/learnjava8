package harini.teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseNumber {

    private static boolean isInputNumberValid(int num, int minValue, int maxValue){
        return (num >= minValue && num <= maxValue);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        if(!isInputNumberValid(numOfTestCases, 0, 1000))
            System.exit(-1);
        else {
            int index = 0;
            int reversedNumber = 0;
            List<Integer> reversedNumbersList = new ArrayList<>();
            while(index < numOfTestCases) {
                int inputNumber = inputScanner.nextInt();
                if(!isInputNumberValid(inputNumber, 1, 1000000))
                    System.exit(-1);
                else {
                    int tempInputNumber = inputNumber;
                    while(tempInputNumber > 0) {
                        int lastDigit = tempInputNumber % 10;
                        reversedNumber = reversedNumber * 10 + lastDigit;
                        tempInputNumber = tempInputNumber / 10;
                    }
                    reversedNumbersList.add(reversedNumber);
                    reversedNumber = 0;
                }
                index++;
            }
            reversedNumbersList.forEach(System.out::println);
        }
    }
}
