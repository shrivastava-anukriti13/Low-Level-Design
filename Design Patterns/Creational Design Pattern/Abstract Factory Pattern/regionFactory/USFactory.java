package regionFactory;

import paymentGateway.PaymentGateway;
import paymentGateway.usPayments.PayPalGateway;
import paymentGateway.usPayments.StripeGateway;
import invoice.Invoice;
import invoice.usInvoice.USInvoice;

public class USFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        } else if (gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for US: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new USInvoice();
    }
}