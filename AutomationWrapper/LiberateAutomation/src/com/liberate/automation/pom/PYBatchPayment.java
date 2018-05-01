package com.liberate.automation.pom;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon.LevelOne;
import com.liberate.automation.core.TestActions;

public class PYBatchPayment {
	TestActions action = null;
	
	By BatchNumber_Input = By.xpath("//*[text()='Batch No:']/following::input[1]");
	By NumberOfEntries_Input = By.xpath("//*[text()='No of Entries:']/following::input[1]");
	By TotalAmount_Input = By.xpath("//*[text()='Total Amount:']/following::input[1]");
	By PaymentMethod_Select = By.xpath("//*[text()='Payment Method:']/following::select[1]");
	
	/***
	 * Append with [<i>count</i>]//td[1]//input for account Number inpur field
	 */
	By AccountNumber_Input = By.xpath("//tbody[@id='batchPaymentForm:batchPaymentTable:tbody']/child::tr");
	
	/***
	 * Append with [<i>count</i>]//td[2]//input[@value='Account Name'] for Account Name button
	 */
	By ShowAccountNames_Button = By.xpath("//tbody[@id='batchPaymentForm:batchPaymentTable:tbody']/child::tr");
	
	/***
	 * Append with [<i>count</i>]//td[4]//input for Amount Input
	 */
	By Amount_Input = By.xpath("//tbody[@id='batchPaymentForm:batchPaymentTable:tbody']/child::tr");
	
	By Accept_Button = By.xpath("//input[@value='Accept']");
	By Proceed_Button = By.xpath("//input[@value='Proceed']");

	
	public PYBatchPayment(TestActions action) {
		this.action = action;
	}
	
	public boolean navigate()
	{
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;
		
		passed = action.waitFor(LevelOne.Payments, 4, true);
		passed = action.clickOn(LevelOne.Payments);
		passed = action.waitFor(LeftLink.Payments.BatchPayment, 4, true);
		passed = action.clickOn(LeftLink.Payments.BatchPayment);

		return passed;
	}
	
	public boolean providePaymentDetails(ArrayList<String> accountNumber)
	{
		boolean passed = false;
		
		passed = action.waitFor(2);
		
		if(action.countOf(Proceed_Button)>0)
		{
			action.clickOn(Proceed_Button);
			passed = action.waitFor(Proceed_Button, 4, false);
		}
		
		for (int i = 1; i <= accountNumber.size(); i++)
		{
			By AccountNumberField = By.xpath(action.getXpath(AccountNumber_Input)+"["+i+"]//td[1]//input");
			By AccountNameButton = By.xpath(action.getXpath(ShowAccountNames_Button)+"["+i+"]//td[2]//input[@value='Account Name']");
			By AmountField = By.xpath(action.getXpath(Amount_Input)+"["+i+"]//td[4]//input");
			
			passed = action.waitFor(AccountNumberField, 4, true);
			passed = action.sendDataTo(AccountNumberField, accountNumber.get(i-1));
			passed = action.clickOn(AmountField);

			passed = action.waitFor(AccountNameButton, 4, true);
			passed = action.clickOn(AccountNameButton);
			action.waitFor(2);
			
			passed = action.waitFor(AmountField, 4, true);
			passed = action.sendDataTo(AmountField, "10.00");

		}
		
		passed = action.waitFor(BatchNumber_Input, 4, true);
		passed = action.sendDataTo(BatchNumber_Input, "222");
		
		passed = action.sendDataTo(NumberOfEntries_Input, String.valueOf(accountNumber.size()));
		
		passed = action.sendDataTo(TotalAmount_Input, String.valueOf(10*accountNumber.size())+".00");
		
		String paymentMethod = action.getSelectedOption(PaymentMethod_Select);
		
		if(paymentMethod.contains("elect"))
		{
			passed = action.selectBy(PaymentMethod_Select, 1);
		}
		
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		passed = action.waitFor(By.xpath("//*[text()='Batch payment submitted successfully.']"), 4, true);	
		action.getTextFromPage(By.xpath("//*[text()='Batch payment submitted successfully.']"));
		
		passed = action.clickOn(By.xpath("//*[text()='Batch payment submitted successfully.']/following::input[@value='OK'][last()]"));
		
		return passed;
	}
}
