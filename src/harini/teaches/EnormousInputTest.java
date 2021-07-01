package harini.teaches;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class EnormousInputTest {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numberOfInputLines = inputScanner.nextInt();
        int divisionFactor = inputScanner.nextInt();
        AtomicInteger divisibleCounter = new AtomicInteger();
        AtomicInteger index = new AtomicInteger(1);
        while(index.get() <= numberOfInputLines) {
            int input = inputScanner.nextInt();
            if(input % divisionFactor == 0) {
                divisibleCounter.getAndIncrement();
            }
            index.getAndIncrement();
        }
        System.out.println(divisibleCounter.get());
    }

}
