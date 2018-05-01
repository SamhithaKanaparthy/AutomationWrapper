package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRCustomerDetails {
	TestActions action = null;

	String DayOfBilling = "";

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By GeneralDetails_PanelHeader = By.xpath("//*[text()='General Details']");
	By CustomerID_Input = By.xpath("(//*[text()='ID:'])[1]/following::input[1]");

	By DayOfBilling_Tab = By.xpath("//*[text()='Day of Billing']");

	By DayOfBillingHistory_PanelHeader = By.xpath("//*[text()='Day of Billing History']");
	By DayOfBilling_Value = By.xpath(
			"//tr[@id='customerDetails:customerDetailsTabManagerSet:0:customerDayOfBillingTb:resultTable2:0']//td[1]//span");

	By Amend_ActionButton = By.xpath("//span[text()='Amend']");

	By DayOfBilling_Select = By.xpath("//*[text()='Days of Billing:']/following::select[1]");

	By DayOfBillingAmendSuccess_Message = By.xpath("//*[text()='DOB code details Amended successfully']");
	
	public CRCustomerDetails(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(GeneralDetails_PanelHeader) > 0))
			passed = action.clickOn(LeftLink.Search.CustomerDetails);

		return passed;
	}

	public boolean validateGeneralDetails() {
		boolean passed = false;

		passed = action.waitFor(CustomerID_Input, 4, true);

		return passed;
	}

	public boolean validatedayOfBilling() {
		boolean passed = false;

		passed = action.waitFor(DayOfBilling_Value, 4, true);
		
		passed = action.waitFor(DayOfBillingAmendSuccess_Message, 4, true);
		
		if (this.DayOfBilling.trim().equals("")) {
			this.DayOfBilling = action.getTextFromPage(DayOfBilling_Value).trim();
		} else {
			passed = this.DayOfBilling.equals(action.getTextFromPage(DayOfBilling_Value).trim().substring(0, 1));
		}
		return passed;
	}

	public boolean amendDayOfBilling() {
		boolean passed = false;

		passed = action.waitFor(DayOfBilling_Tab, 4, true);
		passed = action.clickOn(DayOfBilling_Tab);

		passed = action.waitFor(DayOfBillingHistory_PanelHeader, 4, true);

		passed = action.waitFor(Amend_ActionButton, 4, true);
		passed = action.clickOn(Amend_ActionButton);

		passed = action.waitFor(DayOfBilling_Select, 4, true);
		passed = action.selectBy(DayOfBilling_Select, 1);

		this.DayOfBilling = action.getSelectedOption(DayOfBilling_Select).substring(0, 1);

		passed = action.clickOn(CommonPanel.Accept_Button);

		return passed;
	}
}
