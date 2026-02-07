package paymentGateway.indiaPayments;

import paymentGateway.PaymentGateway;

public class PayUGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}