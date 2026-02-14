interface PaymentGateway {
    void pay(String orderId, double amount);
}