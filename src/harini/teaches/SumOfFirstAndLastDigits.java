package harini.teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfFirstAndLastDigits {

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
                    int lastDigit = inputNumber % 10;
                    int numberOfDigits = (int) Math.log10(inputNumber);
                    int firstDigit = inputNumber / ((int) Math.pow(10, numberOfDigits));
                    sumOfDigits = firstDigit + lastDigit;
                    sumOfDigitsList.add(sumOfDigits);
                }
                index++;
            }
            sumOfDigitsList.forEach(System.out::println);
        }
    }
}
