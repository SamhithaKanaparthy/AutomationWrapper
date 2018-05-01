package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class CRCustomerSearch {
	TestActions action = null;

	public CRCustomerSearch(TestActions action) {
		this.action = action;
	}

	// Quick Search Panel
	By AccountNumber_Input = By.xpath("//*[text()='Account No.:']/following::input[1]");
	By LocalAccountNumber_Input = By.xpath("//*[text()='Local Account No.:']/following::input[1]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service No.:']/following::input[1]");
	By ServiceOrderNumber_Input = By.xpath("//*[text()='Service Order No.:']/following::input[1]");
	By CustomerID_Select = By.xpath("//*[text()='Customer ID:']/following::select[1]");
	By CustomerID_Input = By.xpath("//*[text()='Customer ID:']/following::input[1]");
	By BillInvoice_Input = By.xpath("//*[text()='Bill Invoice No.:']/following::input[1]");

	By ExcludeClosedAccount_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']/following::input[1]");
	By ShowFullStructure_Input = By.xpath("//*[text()='Show Full Structure:']/following::input[1]");
	By WorkingServiceOnly_input = By.xpath("//*[text()='Working Service Only:']/following::input[1]");

	By CustomerDetails_Tab = By.xpath("//*[text()='Customer Details Search']");
	By SurName_Input = By.xpath("//*[text()='Surname:']/following::input[1]");

	// Buttons
	By Search_Button = By.xpath("//input[@value='Search']");
	By Reset_Button = By.xpath("//input[@value='Reset']");

	By QuickSearch_PanelHeader = By.xpath("//*[text()='Quick Search']");

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		action.scrollUp();
		action.waitFor(1);

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);

		return passed;
	}

	public boolean searchByAccountNumber(String accountNumber) {
		boolean passed = false;

		passed = action.waitFor(AccountNumber_Input, 4, true);
		passed = action.sendDataTo(AccountNumber_Input, accountNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);

		return passed;
	}

	public boolean searchByServiceNumber(String serviceNumber) {
		boolean passed = false;

		passed = action.waitFor(ServiceNumber_Input, 4, true);
		passed = action.sendDataTo(ServiceNumber_Input, serviceNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);

		searchVerify();

		return passed;
	}

	public boolean searchByID(String IDType, String IDValue) {
		boolean passed = false;

		passed = action.waitFor(CustomerID_Select, 4, true);
		passed = action.selectByPartialText(CustomerID_Select, IDType);
		passed = action.waitFor(1);

		passed = action.sendDataTo(CustomerID_Input, IDValue);
		passed = action.waitFor(1);

		passed = action.clickOn(Search_Button);

		searchVerify();

		return passed;
	}

	public boolean searchBySurname(String Surname) {
		boolean passed = false;

		passed = action.waitFor(CustomerDetails_Tab, 4, true);
		passed = action.clickOn(CustomerDetails_Tab);

		passed = action.waitFor(SurName_Input, 4, true);
		passed = action.sendDataTo(SurName_Input, Surname);

		passed = action.clickOn(Search_Button);

		searchVerify();

		return passed;
	}

	private void searchVerify() {
		By FirstResult_Row = By
				.xpath("//tr[@id='customerSearchForm:customerSearchFBTabSet:0:customerSearchResults_row_0']");

		action.waitFor(3);

		if (action.countOf(QuickSearch_PanelHeader) > 0) {
			if (action.countOf(FirstResult_Row) == 1)
				action.clickOn(FirstResult_Row);
		}
	}
}
