package harini.teaches;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindFactorials {

    private static boolean isInputNumberValid(int num, int minValue, int maxValue){
        return (num >= minValue && num <= maxValue);
    }

    private static BigInteger computeFactorial(int number, BigInteger factorial) {
        if(number == 1)
            return new BigInteger("1");
        else
            return new BigInteger(String.valueOf(number)).multiply(factorial);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        if(!isInputNumberValid(numOfTestCases, 1, 100))
            System.exit(-1);
        else {
            int index = 0;
            BigInteger factorial = new BigInteger("1");
            List<BigInteger> factorialList = new ArrayList<>();
            while(index < numOfTestCases) {
                int inputNumber = inputScanner.nextInt();
                if(!isInputNumberValid(inputNumber, 1, 100))
                    System.exit(-1);
                else {
                    while(inputNumber > 1) {
                        factorial = computeFactorial(inputNumber, factorial);
                        inputNumber--;
                    }
                    factorialList.add(factorial);
                    factorial = new BigInteger("1");
                }
                index++;
            }
            factorialList.forEach(System.out::println);
        }
    }
}
