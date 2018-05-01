package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYVoidPayment {

	TestActions action = null;

	// Enter payment number, search and reset button

	// Payment button
	By Payment_number_input = By.xpath("//*[@id='voidPayment:paymentNumber'] ");

	// search button

	By Search_button = By.xpath("//*[@value = 'Search'] ");

	// reset button

	By Reset_button = By.xpath("//*[@value = 'Reset'] ");

	// Enter Void Reason , Accept and Cancel

	// Enter Void Reason

	By Enter_void_reason = By.xpath("//*[@id='voidPayment:voidReason']");

	// Accept button

	By accept_button = By.xpath("//*[@value = 'Accept']");

	// Cancel Button

	By Cancel_button = By.xpath("//*[@value = 'Cancel']");

	/***
	 * Default constructor that takes TestAction object as argument.
	 * 
	 * @param action
	 *            The TestAction class object, which will be used to run test steps
	 */
	public PYVoidPayment(TestActions action) {
		this.action = action;
	}

	/***
	 * The method to navigate to Void Payment screen
	 * 
	 * @return Returns true if able to navigate, else will return false.
	 */
	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Payments);
		passed = action.waitFor(LiberateCommon.Payments.PaymentsAdmin, 4, true);
		passed = action.clickOn(LiberateCommon.Payments.PaymentsAdmin);
		passed = action.waitFor(LeftLink.PaymentsAdmin.VoidPayment, 4, true);
		passed = action.clickOn(LeftLink.PaymentsAdmin.VoidPayment);

		return passed;
	}

	/***
	 * The method to Enter the payment number in Void Payment screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

	public boolean PaymentNumber(String PaymentNumber) {
		boolean passed = false;

		passed = action.waitFor(Payment_number_input, 4, true);
		passed = action.sendDataTo(Payment_number_input, PaymentNumber);

		return passed;

	}

	/***
	 * The method to search the Entered the payment number in Void Payment screen
	 * 
	 * @return Returns true if able to Search, else will return false.
	 */
	public boolean Search() {
		boolean passed = false;

		passed = action.waitFor(Search_button, 4, true);
		passed = action.clickOn(Search_button);

		return passed;
	}

	/***
	 * The method to Reset the Entered the payment number in Void Payment screen
	 * 
	 * @return Returns true if able to Reset, else will return false.
	 */
	public boolean Reset() {
		boolean passed = false;

		passed = action.waitFor(Reset_button, 4, true);
		passed = action.clickOn(Reset_button);

		return passed;
	}

	/***
	 * The method to Select the void reason in void payment screen
	 * 
	 * @return Returns true if able to Select, else will return false.
	 */

	public boolean EnterVoidReason(String EnterVoidReason) {
		boolean passed = false;

		passed = action.waitFor(Enter_void_reason, 4, true);
		passed = action.selectBy(Enter_void_reason, Integer.parseInt(EnterVoidReason));

		return passed;
	}

	/***
	 * The method to Accept the void reason in void payment screen
	 * 
	 * @return Returns true if able to Accept, else will return false.
	 */

	public boolean Accept() {
		boolean passed = false;

		passed = action.waitFor(accept_button, 4, true);
		passed = action.clickOn(accept_button);

		return passed;
	}

	/***
	 * The method to Cancel the void reason in void payment screen
	 * 
	 * @return Returns true if able to Cancel, else will return false.
	 */

	public boolean Cancel() {
		boolean passed = false;

		passed = action.waitFor(Cancel_button, 4, true);
		passed = action.clickOn(Cancel_button);

		return passed;
	}

}
