interface PaymentProcessor {
    void processPayment(double amount);
}

class PaypalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal Gateway.");
    }
}

class StripeGateway {
    public void chargeAmount(double amount) {
        System.out.println("Charging $" + amount + " using Stripe Payment Gateway.");
    }
}

class PaypalAdapter implements PaymentProcessor {
    private final PaypalGateway paypalGateway;

    public PaypalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.chargeAmount(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaypalGateway paypal = new PaypalGateway();
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypal);
        paypalProcessor.processPayment(100.50);

        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(250.75);
    }
}
