package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYBadCheckProcessing {
	TestActions action = null;

	// Search Panel
	By PaymentNumber_Input = By.xpath("//*[text()='Payment Number:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value = 'Search']");
	By Reset_button = By.xpath("//input[@value = 'Reset']");

	// Cheque details button
	By CheckDetails_Row = By.xpath("//*[@id = 'badChequeProcessing:badChequeProcessingResults:0']");
	By Cancel_Button = By.xpath("//input[@value = 'Cancel']");

	By ChequeCard_Input = By.xpath("//*[text()='Cheque/Card:']/following::input[1]");
	// If Desabled skip editing.
	By ChequeCardDisabled_Input = By.xpath("//*[text()='Cheque/Card:']/following::input[@disabled='true']");

	By Reason_DropDowmn = By.xpath("//*[text()='Reason:']/following::select[1]");
	By ReasonDisabled_DropDown = By.xpath("(//*[text()='Reason:']/following::select[@disabled='disabled'])[1]");
	By Accept_Button = By.xpath("//input[@value = 'Accept']");

	/***
	 * Default constructor that takes TestAction object as argument.
	 * 
	 * @param action
	 *            The TestAction class object, which will be used to run test steps
	 */
	public PYBadCheckProcessing(TestActions action) {
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
		passed = action.waitFor(LeftLink.PaymentsAdmin.BadChequeProcessing, 4, true);
		passed = action.clickOn(LeftLink.PaymentsAdmin.BadChequeProcessing);

		return passed;
	}

	/***
	 * The method to Enter the payment number in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */
	public boolean SearchWithPaymentNumber(String PaymentNumber) {
		boolean passed = false;

		passed = action.waitFor(PaymentNumber_Input, 4, true);
		passed = action.sendDataTo(PaymentNumber_Input, PaymentNumber);
		passed = action.clickOn(Search_Button);

		return passed;
	}

	/***
	 * The method to Click on Check Details Button in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Reset, else will return false.
	 */
	public boolean openChequeDetails() {
		boolean passed = false;

		passed = action.waitFor(CheckDetails_Row, 4, true);
		passed = action.clickOn(CheckDetails_Row);

		return passed;
	}

	public boolean provideChequeCardDetails() {
		String Amount = "";

		/***
		 * Append by [count]//td[4]//span for Apportion Amount Append by
		 * [count]//td[5]//input for Apportion Input
		 */
		By Apportion_Table = By.xpath("//tbody[@id='badChequeProcessing:paymentChequeDetails:tbody']//tr");

		boolean passed = false;

		passed = action.waitFor(Reason_DropDowmn, 2, true);

		if (action.countOf(ChequeCardDisabled_Input) == 0) {
			passed = action.sendDataTo(ChequeCard_Input, "3123342242124124");
		}

		passed = action.selectBy(Reason_DropDowmn, 1);
		action.waitFor(1);

		for (int i = 0; i < action.countOf(Apportion_Table); i++) {
			Amount = action
					.getTextFromPage(By.xpath(action.getXpath(Apportion_Table) + "[" + (i + 1) + "]//td[4]//span"));
			action.sendDataTo(By.xpath(action.getXpath(Apportion_Table) + "[" + (i + 1) + "]//td[5]//input"), Amount);
		}

		passed = action.clickOn(Accept_Button);

		return passed;
	}

	public boolean acceptBadChequeProcessing() {
		boolean passed = false;

		passed = action.waitFor(ReasonDisabled_DropDown, 3, true);
		action.waitFor(2);
		passed = action.clickOn(Accept_Button);

		return passed;
	}

}
