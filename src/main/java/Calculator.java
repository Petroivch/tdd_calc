public class Calculator {

    public int calculateMonthlyPayment(int creditSum, int creditPeriod, int creditPercent) {
        return creditSum * (creditPercent+(creditPercent / (1 + creditPercent) * creditPeriod - 1));
    }


    public int calculateRefundAmount(int creditSum, int creditPeriod, int creditPercent) {
        return creditSum + (creditPeriod * creditPercent * creditPeriod) / 100;
    }


    public int calculatePayment(int creditSum, int creditPeriod, int creditPercent) {
        return (creditSum * creditPercent * creditPeriod) / 100;
    }
}
