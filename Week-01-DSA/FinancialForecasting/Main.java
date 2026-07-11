public class Main {
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.00;
        double growthRate = 0.05;
        int years = 10;

        double forecastedValue = calculateFutureValue(initialInvestment, growthRate, years);
        System.out.println("Initial Investment: $" + initialInvestment);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecasted Value after " + years + " years: $" + String.format("%.2f", forecastedValue));
    }
}
