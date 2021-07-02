package harini.teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindSquareRoot {

    private static boolean isNumberWithinRange(int number, int minValue, int maxValue){
        return (number >= minValue && number <= maxValue);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        if(!isNumberWithinRange(numOfTestCases, 1, 20))
            System.exit(-1);
        else {
            int index = 0;
            List<Integer> squareRootList = new ArrayList<>();
            while(index < numOfTestCases) {
                int input = inputScanner.nextInt();
                if(!isNumberWithinRange(input, 1, 10000))
                    System.exit(-1);
                else {
                    int squareRoot = (int) Math.sqrt(input);
                    squareRootList.add(squareRoot);
                }
                index++;
            }
            squareRootList.forEach(System.out::println);
        }
    }
}
