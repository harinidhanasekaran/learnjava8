package harini.teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindReminder {

    private static boolean isNumberWithinRange(int number, int minValue, int maxValue){
        return (number >= minValue && number <= maxValue);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = inputScanner.nextInt();
        if(!isNumberWithinRange(numOfTestCases, 1, 1000))
            System.exit(-1);
        else {
            int index = 0;
            List<Integer> remindersList = new ArrayList<>();
            while(index < numOfTestCases) {
                int dividend = inputScanner.nextInt();
                int divisor = inputScanner.nextInt();
                if(!isNumberWithinRange(dividend, 1, 10000) &&
                        !isNumberWithinRange(divisor, 1, 10000))
                    System.exit(-1);
                else {
                    int reminder = dividend % divisor;
                    remindersList.add(reminder);
                }
                index++;
            }
            remindersList.forEach(element -> {
                System.out.println(element);
            });
        }
    }

}


