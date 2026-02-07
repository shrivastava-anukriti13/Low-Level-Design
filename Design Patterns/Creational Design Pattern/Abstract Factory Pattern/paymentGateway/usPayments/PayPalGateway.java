package paymentGateway.usPayments;

import paymentGateway.PaymentGateway;

public class PayPalGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via PayPal: " + amount);
    }
}