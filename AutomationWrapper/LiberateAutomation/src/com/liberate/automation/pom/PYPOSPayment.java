package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYPOSPayment {
	TestActions action = null;
	
	By newTransaction_Tab = By.xpath("//*[text()='New Transaction']");
	By serviceNumber_Input = By.xpath("//*[text()='Service Number:']/following::input[1]");
	By accountNumber_Input = By.xpath("//*[text()='Account Number:']/following::input[1]");
	By billInvoiceNumber_Input = By.xpath("//*[text()='Bill Invoice No.:']/following::input[1]");
	
	By allocateAmountDisabled_Input = By.xpath("//*[text()='Allocate Amount:']//following::td[1]//child::input[@disabled='true']");
	By allocateAmount_Input = By.xpath("//*[text()='Allocate Amount:']//following::td[1]//child::input[1]");
	
	By manualAllocate_Button = By.xpath("//input[@value='Manual Allocate']");
	By autoAllocate_Button = By.xpath("//input[@value='Manual Allocate']");

	By payment_Row = By.xpath("//tr[@id='newTransactionForm:statictab:0:dynamictabs:1:billsTable:0']");
	
	By paymentMethod_Select = By.xpath("//*[text()='Select Payment Method:']//following::select[1]");
	
	By close_Button = By.xpath("//input[@value='Close']");
	By oK_Button = By.xpath("//input[@value='OK']");

	public PYPOSPayment(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Payments, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Payments);
		passed = action.waitFor(LiberateCommon.Payments.POS, 4, true);
		passed = action.clickOn(LiberateCommon.Payments.POS);
		passed = action.waitFor(LeftLink.POS.NewTransaction, 4, true);
		passed = action.clickOn(LeftLink.POS.NewTransaction);
		
		return passed;
	}

	public boolean navigateToPOS() {
		boolean passed = false;

		action.waitFor(4);
		action.switchToNewWindow();
		
		passed = action.waitFor(newTransaction_Tab, 4, true);
		
		if(action.countOf(close_Button)>0)
		{
			action.clickOn(close_Button);
			passed = action.waitFor(close_Button, 4, false);
		}

		return passed;
	}
	
	public boolean searchWithAccountNumber(String AccountNumber) {
		boolean passed = false;
		
		passed = action.waitFor(newTransaction_Tab, 4, true);
		passed = action.clickOn(newTransaction_Tab);
		
		passed = action.waitFor(accountNumber_Input, 4, true);
		passed = action.sendDataTo(accountNumber_Input, AccountNumber);
		
		passed = action.clickOn(CommonPanel.Search_Button);
		passed = action.waitFor(allocateAmountDisabled_Input, 4, false);
		
		return passed;
	}
	
	public boolean searchWithServiceNumber(String AccountNumber) {
		boolean passed = false;
		
		passed = action.waitFor(newTransaction_Tab, 4, true);
		passed = action.clickOn(newTransaction_Tab);
		
		passed = action.waitFor(serviceNumber_Input, 4, true);
		passed = action.sendDataTo(serviceNumber_Input, AccountNumber);
		
		passed = action.clickOn(CommonPanel.Search_Button);
		passed = action.waitFor(allocateAmountDisabled_Input, 4, false);
		
		return passed;
	}
	
	public boolean autoAllocate()
	{
		boolean passed = false;
		
		passed = action.clickOn(autoAllocate_Button);

		
		return passed;
	}
	
	public boolean POSPayment() {
		boolean passed = false;
		
		passed = action.waitFor(allocateAmountDisabled_Input, 4, false);
		action.waitFor(1);
		passed = action.sendDataTo(allocateAmount_Input, "10.00");
		
		passed = action.clickOn(manualAllocate_Button);
		
		passed = action.waitFor(payment_Row, 4, false);
		passed = action.clickOn(CommonPanel.Accept_Button);
		
		passed = action.waitFor(paymentMethod_Select, 4, true);
		
		if(action.countOf(oK_Button)>0)
		{
			action.clickOn(oK_Button);
			passed = action.waitFor(oK_Button, 4, false);
		}
		
		passed = action.selectByPartialText(paymentMethod_Select, "C ");
		
		
		return passed;
	}

	public boolean closePOSWindow() {
		boolean passed = false;

		action.waitFor(2);
		action.closeTab();

		action.switchToNewWindow();

		action.waitFor(2);
		passed = action.waitFor(LiberateCommon.LevelOne.Payments, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Payments);

		return passed;
	}
}
