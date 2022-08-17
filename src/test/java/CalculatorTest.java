import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class CalculatorTest {
    Random random = new Random();

    final int PERIODLOW = 1;
    final int PERIODHIGH = 12;

    final int PERCENTLOW = 1;
    final int PERCENTHIGH = 10;

    final int creditSum = random.nextInt();
    final int creditPercent = random.nextInt(PERCENTHIGH-PERCENTLOW)+PERIODLOW;
    final int creditPeriod = random.nextInt(PERIODHIGH-PERIODLOW)+PERIODLOW;

    @Test
    public void testCalculateMonthlyPayment(){
        Calculator Calculator = new Calculator();

        int monthPaymentSum =
                Calculator.calculateMonthlyPayment(creditSum, creditPeriod, creditPercent);

        int expected = creditSum * (creditPercent+(creditPercent / (1 + creditPercent) * creditPeriod - 1));

        Assertions.assertEquals(expected,monthPaymentSum);

    }

    @Test
    public void testCalculateRefundAmount(){
        Calculator Calculator = new Calculator();

        int refundAmount =
                Calculator.calculateRefundAmount(creditSum, creditPeriod, creditPercent);

        int expected = creditSum + (creditPeriod * creditPercent * creditPeriod) / 100;

        Assertions.assertEquals(expected,refundAmount);
    }

    @Test
    public void testCalculateOverpayment(){
        Calculator Calculator = new Calculator();

        int overpayment = Calculator.calculatePayment(creditSum, creditPeriod, creditPercent);

        int expected = (creditSum * creditPercent * creditPeriod) / 100;

        Assertions.assertEquals(expected,overpayment);
    }
}