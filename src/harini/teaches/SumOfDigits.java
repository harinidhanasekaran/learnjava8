package harini.teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfDigits {

    private static boolean isInputNumberValid(int num, int minValue, int maxValue){
        return (num >= minValue && num <= maxValue);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        if(!isInputNumberValid(numOfTestCases, 1, 1000))
            System.exit(-1);
        else {
            int index = 0;
            int sumOfDigits = 0;
            List<Integer> sumOfDigitsList = new ArrayList<>();
            while(index < numOfTestCases) {
                int inputNumber = inputScanner.nextInt();
                if(!isInputNumberValid(inputNumber, 1, 1000000))
                    System.exit(-1);
                else {
                    int tempInputNumber = inputNumber;
                    while(tempInputNumber > 0) {
                        int lastDigit = tempInputNumber % 10;
                        sumOfDigits = sumOfDigits + lastDigit;
                        tempInputNumber = tempInputNumber / 10;
                    }
                    sumOfDigitsList.add(sumOfDigits);
                    sumOfDigits = 0;
                }
                index++;
            }
            sumOfDigitsList.forEach(element -> {
                System.out.println(element);
            });
        }
    }
}
