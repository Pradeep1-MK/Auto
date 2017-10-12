package com.jamcracker.commonFunctions.customer;

import org.testng.Reporter;

import com.jamcracker.objectRepository.customer.PaymentDetailsPage;
import com.jamcracker.objectRepository.customer.TMPaymentGatewayPage;
import com.jamcracker.utilities.TestBase;

public class PaymentOptions extends TestBase {

	PaymentDetailsPage objPDpage = new PaymentDetailsPage();
	TMPaymentGatewayPage objTMPGpage = new TMPaymentGatewayPage();
	
	public void paymentPaypal(String paymentMethod) throws Exception {

		try {
			objPDpage.paypalRadioButton.click();
		} catch (Exception e) {
			Reporter.log("Paypal Radio Button is not available", true);
		}
		objPDpage.proceedButton.click();
		explicitWait(objPDpage.authorizeButton);
		objPDpage.authorizeButton.click();
		PayPalAccount paypalLogin = new PayPalAccount();
		paypalLogin.enterPayPalDetails();

	}

	public void paymentCard(String paymentMethod) throws Exception {

		try {
			objPDpage.creditCardRadioButton.click();
		} catch (Exception e) {
			Reporter.log("Credit Card Radio Button is not available", true);
		}
		if (objPDpage.processingMode.getText().equalsIgnoreCase("Automatic")) {
			objPDpage.proceedButton.click();
			explicitWait(objPDpage.authorizeButton);
			objPDpage.authorizeButton.click();
			BrainTreeDetails btDetails = new BrainTreeDetails();
			btDetails.enterCCDetails();
		} else if (objPDpage.processingMode.getText()
				.equalsIgnoreCase("Customer Self Service")) {
			objPDpage.proceedButton.click();
			explicitWait(objPDpage.authorizeButton);
			objPDpage.authorizeButton.click();
			explicitWait(objTMPGpage.successRadioButton);
			objTMPGpage.successRadioButton.click();
			objTMPGpage.submitButton.click();
			explicitWait(objPDpage.closeButton);
			Thread.sleep(10000);
			objPDpage.closeButton.click();
		}

	}

	public void paymentPAC(String paymentMethod) {

		try {
			objPDpage.pacRadioButton.click();
		} catch (Exception e) {
			Reporter.log("PAC Radio Button is not available", true);
		}
		objPDpage.proceedButton.click();
	}

}
