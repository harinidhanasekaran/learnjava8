package harini.teaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(inputScanner.nextLine());
        List<Integer> outputNumbers = new ArrayList<>();
        int index = 1;
        while(index <= numOfTestCases) {
            String [] twoNumbers = inputScanner.nextLine().split(" ");
            int sum = (Integer.parseInt(twoNumbers[0]) + Integer.parseInt(twoNumbers[1]));
            outputNumbers.add(sum);
            index++;
        }
        outputNumbers.forEach(element -> System.out.println(element));
    }
}
