import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Calculator Calculator = new Calculator();

    public static void main(String[] args) {
        System.out.println("Welcome to the application 'Calculator'\n");
        while (true) {
            System.out.println("To end the application, enter '0'\n\n" +
                    "For calculations, enter\n" +
                    "-- total loan amount in rubles");
            int creditSum = scanner.nextInt();
            if (creditSum == 0)break;
            System.out.println("-- term for which the loan was issued (years):");
            int creditPeriod = scanner.nextInt();
            System.out.println("-- loan percent rate:");
            int creditPercent = scanner.nextInt();

            System.out.println("The monthly payment will be: " +
                    Calculator.calculateMonthlyPayment(creditSum, creditPeriod, creditPercent));
            System.out.println("The total amount of the payment to the bank will be: " +
                    Calculator.calculateRefundAmount(creditSum, creditPeriod, creditPercent));
            System.out.println("The amount of payments will be: " +
                    Calculator.calculatePayment(creditSum, creditPeriod, creditPercent));
        }
        System.out.println("Terminate the application");
    }
}