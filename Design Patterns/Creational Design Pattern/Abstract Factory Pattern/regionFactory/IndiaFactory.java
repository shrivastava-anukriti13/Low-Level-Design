package regionFactory;

import paymentGateway.PaymentGateway;
import paymentGateway.indiaPayments.RazorpayGateway;
import paymentGateway.indiaPayments.PayUGateway;
import invoice.Invoice;
import invoice.indiaInvoice.GSTInvoice;

public class IndiaFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorpayGateway();
        } else if (gatewayType.equalsIgnoreCase("payu")) {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for India: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}