package harini.teaches;

import java.util.Scanner;

public class ATM {

    public static final double BANK_CHARGE_PER_TRANSACTION = 0.5;

    private static boolean isValid(int withdrawalAmount, double accountBalance) {
        return ( withdrawalAmount % 5 == 0
                && (withdrawalAmount+BANK_CHARGE_PER_TRANSACTION) <= accountBalance);
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int withdrawalAmount = inputScanner.nextInt();
        double accountBalance = inputScanner.nextDouble();

        if(isValid(withdrawalAmount,accountBalance)) {
            double output = accountBalance - (withdrawalAmount + BANK_CHARGE_PER_TRANSACTION);
            System.out.printf("%.2f",output);
        } else {
            System.out.printf("%.2f",accountBalance);
        }

    }

}
