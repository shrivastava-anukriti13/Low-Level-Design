package regionFactory;

import paymentGateway.PaymentGateway;
import invoice.Invoice;

public interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}