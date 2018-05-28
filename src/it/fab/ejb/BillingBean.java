package it.fab.ejb;

import it.fab.model.PaymentInfo;

public class BillingBean {

	public void bill(PaymentInfo paymentoInfo) {
		System.out.println("INVIATO SISTEMA DI PAGAMENTO. METODO SCELTO: " + paymentoInfo.getPaymentType().toString());
	}

}
