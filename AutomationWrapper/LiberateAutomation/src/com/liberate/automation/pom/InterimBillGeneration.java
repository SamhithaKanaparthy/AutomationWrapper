package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class InterimBillGeneration {
	TestActions action = null;
	
	By CustomerAccountNumber_Input = By.xpath("//*[text()[contains(.,'Customer Account')]]/following::input[1]");
	By CreateInterimBill_Button = By.xpath("//input[@value='Create Interim Bill']");
	
	By Close_Button = By.xpath("//input[@value='Close']");
	
	public InterimBillGeneration(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);
		passed = action.waitFor(LiberateCommon.CustomerCare.AdditionalCustomerInformation, 4, true);
		passed = action.clickOn(LiberateCommon.CustomerCare.AdditionalCustomerInformation);
		passed = action.waitFor(LeftLink.AdditionalCustomerInformation.InterimBill, 4, true);
		passed = action.clickOn(LeftLink.AdditionalCustomerInformation.InterimBill);

		return passed;
	}

	public boolean searchWithCustomerAccount(String AccountNumber) {
		boolean passed = false;
		
		passed = action.waitFor(CustomerAccountNumber_Input, 4, true);
		passed = action.sendDataTo(CustomerAccountNumber_Input, AccountNumber);
		
		passed = action.clickOn(CommonPanel.Search_Button);
		
		return passed;
	}
	
	public boolean createInterimBill() {
		boolean passed = false;
		
		passed = action.waitFor(CreateInterimBill_Button, 4, true);
		passed = action.clickOn(CreateInterimBill_Button);
		
		passed = action.waitFor(Close_Button, 180, true);
		passed = action.clickOn(Close_Button);
		
		return passed;
	}

}
