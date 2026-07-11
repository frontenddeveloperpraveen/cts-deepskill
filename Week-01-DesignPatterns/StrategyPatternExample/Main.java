interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private final String name;
    private final String cardNumber;

    public CreditCardPayment(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card (Cardholder: " + name + ", Card Number: " + cardNumber + ")");
    }
}

class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal (Account: " + email + ")");
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment strategy not set.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        System.out.println("Selecting Credit Card payment strategy...");
        context.setPaymentStrategy(new CreditCardPayment("John Doe", "1234-5678-9012-3456"));
        context.executePayment(250.00);

        System.out.println("\nSelecting PayPal payment strategy...");
        context.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        context.executePayment(89.99);
    }
}
