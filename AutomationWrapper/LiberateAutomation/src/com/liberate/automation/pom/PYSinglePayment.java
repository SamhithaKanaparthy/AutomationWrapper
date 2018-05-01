package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYSinglePayment {
	TestActions action = null;

	By CashDrawerNotSelectedMessage_Value = By.xpath("//*[text()='Change the department to cashiers office']");
	By CashDrawerOpenedMessage_Value = By.xpath("//*[text()='Cashdrawer already open in another office.']");

	By DepartmentDisabled_Select = By.xpath("//*[text()='Department:']/following::select[@disabled='disabled']");
	By Department_Select = By.xpath("//*[text()='Department:']/following::select");
	By Change_Button = By.xpath("//input[@value='Change']");

	By AccountNumber_Input = By.xpath("//*[text()='Account Number:']/following::input[1]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service No:']/following::input[1]");

	By Search_Button = By.xpath("//input[@value='Search']");

	By PaymentType_Select = By.xpath("//*[text()='Payment Type:']/following::select[1]");
	By PaymentMethod_Select = By.xpath("//*[text()='Payment Method:']/following::select[1]");
	By Amount_Input = By.xpath("//*[text()='Amount:']/following::input[1]");

	By AmountAvailable_Lable = By.xpath("//*[text()='Amount Available:']");

	By Success_Message = By.xpath("//*[text()='Single payment updated successfully.']");

	By Deposits_PanelHeader = By.xpath("//*[text()='Deposits']");

	By DepositAmount_Input = By.xpath("//tbody[@id='singlePayment:deposits:tbody']//tr[1]//td[5]//input");
		
	public PYSinglePayment(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		action.waitFor(LiberateCommon.LevelOne.Payments, 4, true);
		action.clickOn(LiberateCommon.LevelOne.Payments);

		action.waitFor(LeftLink.Payments.SinglePayment, 4, true);

		return passed;
	}

	public boolean verifyCashDrawer() {
		boolean passed = false;

		action.waitFor(2);

		// If no pop available on navigation, will go to if branch.
		if (!(action.countOf(CommonPanel.popUp.popUpOK_Button) > 0)) {
			// If selected Department is not Cashier, select Cashier department
			if (action.countOf(CashDrawerNotSelectedMessage_Value) > 0) {
				if (action.countOf(DepartmentDisabled_Select) > 0) {
					action.clickOn(Change_Button);
					action.waitFor(DepartmentDisabled_Select, 4, false);
				}

				action.selectByPartialText(Department_Select, "CASH");
				action.waitFor(DepartmentDisabled_Select, 4, true);
			}
		}

		action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
		String PopUpMessage = action.getTextFromPage(CashDrawerOpenedMessage_Value);
		passed = PopUpMessage.equals("Cashdrawer already open in another office.");
		
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean searchWithAccountNumber(String AccountNumber) {
		boolean passed = false;

		passed = action.waitFor(AccountNumber_Input, 4, true);
		passed = action.sendDataTo(AccountNumber_Input, AccountNumber);

		action.waitFor(1);

		passed = action.clickOn(Search_Button);

		return passed;
	}

	public boolean searchWithServiceNumber(String ServiceNumber) {
		boolean passed = false;

		passed = action.waitFor(ServiceNumber_Input, 4, true);
		passed = action.sendDataTo(ServiceNumber_Input, ServiceNumber);

		action.waitFor(1);

		passed = action.clickOn(Search_Button);

		return passed;
	}

	public boolean doSinglePayment(String Amount) {
		boolean passed = false;

		// After searching, search button will be replaced with accept button.
		passed = action.waitFor(Search_Button, 4, false);

		passed = action.selectByPartialText(PaymentType_Select, "Standard");
		passed = action.selectBy(PaymentMethod_Select, 1);
		
		action.waitFor(1);
		
		passed = action.sendDataTo(Amount_Input, Amount);
		
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(AmountAvailable_Lable, 4, true);
		passed = action.clickOn(CommonPanel.Accept_Button);

		return passed;
	}

	public boolean doDepositPayment(String Amount) {
		boolean passed = false;

		// After searching, search button will be replaced with accept button.
		passed = action.waitFor(Search_Button, 4, false);

		passed = action.selectByPartialText(PaymentType_Select, "Deposit");
		passed = action.selectBy(PaymentMethod_Select, 1);

		action.waitFor(1);
		
		passed = action.sendDataTo(Amount_Input, Amount);
		
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(Deposits_PanelHeader, 4, true);

		passed = action.waitFor(DepositAmount_Input, 4, true);
		passed = action.sendDataTo(DepositAmount_Input, Amount);

		passed = action.clickOn(CommonPanel.Accept_Button);

		return passed;
	}

	public boolean verifySuccessMessage() {
		return (action.waitFor(Success_Message, 4, true));
	}
}
