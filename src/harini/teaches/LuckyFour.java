package harini.teaches;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyFour {

    private static boolean isInputNumberValid(int num, int minValue, int maxValue){
        return (num >= minValue && num <= maxValue);
    }

    private static boolean isInputNumberValid(BigInteger num, BigInteger minValue, BigInteger maxValue){
        int greaterOrEqualTo = num.compareTo(minValue);
        int lesserOrEqualTo = num.compareTo(maxValue);
        return (greaterOrEqualTo >= 0 && lesserOrEqualTo <= 0);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        if(!isInputNumberValid(numOfTestCases, 0, (int) Math.pow(10,5)))
            System.exit(-1);
        else {
            int index = 0;
            int countOccurrences = 0;
            List<Integer> countOfFourList = new ArrayList<>();
            while(index < numOfTestCases) {
                BigInteger inputNumber = inputScanner.nextBigInteger();
                if(!isInputNumberValid(inputNumber, new BigInteger("0"),
                        new BigInteger("1000000000")))
                    System.exit(-1);
                else {
                    while(inputNumber.compareTo(new BigInteger("0")) == 1) {
                        BigInteger lastDigit = inputNumber.mod(new BigInteger("10"));
                        countOccurrences = lastDigit.compareTo(new BigInteger("4")) == 0 ? countOccurrences+1 : countOccurrences;
                        inputNumber = inputNumber.divide(new BigInteger("10"));
                    }
                    countOfFourList.add(countOccurrences);
                    countOccurrences = 0;
                }
                index++;
            }
            countOfFourList.forEach(System.out::println);
        }
    }
}
