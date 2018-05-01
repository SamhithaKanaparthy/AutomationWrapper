package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class ServiceCharges {
	TestActions action = null;

	String SelectedServiceCharge = "";
	String ServiceNumber = "";

	int countOfServiceNumber = 0;

	boolean searchedWithService = false;

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By New_ActionButton = By.xpath("//span[text()='New']");

	By ServiceChargeType_Select = By.xpath("//*[text()='Service Charge Type:']/following::select[1]");
	By ServiceChargeDescription_Input = By.xpath("//*[text()='Description:']/following::input[1]");
	By Amount_Input = By.xpath("//*[text()='Amount:']/following::input[1]");

	By ServiceNumber_Input = By.xpath("//*[text()='Service No:']/following::input[1]");

	By ServiceChargeFirst_Row = By.xpath("//tr[@id='serviceChargesForm:serviceChargesList:0']");

	/***
	 * Replace &ltServiceNumber&gt with actual service Number
	 */
	By ServiceNumber_Value = By.xpath("//span[text()='<ServiceNumber>']");

	/***
	 * Append [count]//td[1]//span for Raised Date<br>
	 * Append [count]//td[2]//span for Charge Type<br>
	 * Append [count]//td[3]//span for Description<br>
	 * Append [count]//td[4]//span for Service Number<br>
	 * Append [count]//td[5]//span for Amount<br>
	 * Append [count]//td[6]//span for Billed Indicator<br>
	 * Append [count]//td[7]//span for Number of Debits<br>
	 * Append [count]//td[8]//span for Pay Period<br>
	 * Append [count]//td[9]//span for Void Ind<br>
	 */
	By ServiceCharge_Row = By.xpath("//tr[contains(@id,'serviceChargesForm:serviceChargesList:')]");

	By RaisedDate_Value = By.xpath("//tr[@id='serviceChargesForm:serviceChargesList:0']//td[1]");
	By ServiceChargeType_Value = By.xpath("//tr[@id='serviceChargesForm:serviceChargesList:0']//td[2]");

	public ServiceCharges(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		passed = action.clickOn(LeftLink.Search.ServiceCharges);

		return passed;
	}

	public boolean addServiceCharge() {
		boolean passed = false;

		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);

		action.scrollDown();

		passed = action.waitFor(ServiceChargeType_Select, 4, true);
		passed = action.selectBy(ServiceChargeType_Select, 1);

		this.SelectedServiceCharge = action.getSelectedOption(ServiceChargeType_Select).split("-")[0].trim();

		action.waitFor(2);

		passed = action.clickOn(CommonPanel.Accept_Button);

		return passed;
	}

	public boolean verifyRaisedServiceCharge() {
		action.scrollUp();
		action.scrollUp();

		boolean passed = false;

		passed = action.waitFor(CommonPanel.Accept_Button, 4, false);
		String ServiceChargeRaisedDate = action.getTextFromPage(RaisedDate_Value);
		String ServiceChargeType = action.getTextFromPage(ServiceChargeType_Value);

		String ConvertedDate = action.getTextFromPage(CommonPanel.LiberateHeader.LiberateDate).replace("/", "-")
				.replace(",", "");

		TestActions.log("Selected Service Charge : " + this.SelectedServiceCharge);
		TestActions.log("Latest Service Charge : " + ServiceChargeType);

		TestActions.log("Liberate System Date : " + ConvertedDate);
		TestActions.log("Service Charge Raised on : " + ServiceChargeRaisedDate);

		passed = this.SelectedServiceCharge.equals(ServiceChargeType);
		passed = ServiceChargeRaisedDate.contains(ConvertedDate);

		return passed;
	}

	public boolean searchWithServiceNumber() {
		boolean passed = false;

		for (int i = 0; i < action.countOf(ServiceCharge_Row); i++) {
			this.ServiceNumber = action
					.getTextFromPage(By.xpath(action.getXpath(ServiceCharge_Row) + "["+(i+1)+"]//td[4]//span")).trim();
			if (!this.ServiceNumber.trim().equals("")) {
				break;
			}
		}
		this.countOfServiceNumber = action
				.countOf(By.xpath(action.getXpath(ServiceNumber_Value).replace("<ServiceNumber>", ServiceNumber)));

		passed = action.waitFor(ServiceNumber_Input, 4, true);
		passed = action.sendDataTo(ServiceNumber_Input, ServiceNumber);

		passed = action.clickOn(CommonPanel.Search_Button);

		this.searchedWithService = true;

		return passed;
	}

	public boolean verifyServiceCharge() {
		boolean passed = false;
		
		passed = action.waitFor(New_ActionButton, 4, true);
		
		if (this.searchedWithService) {
			for (int i = 0; i < this.countOfServiceNumber; i++) {
				By SNXpath = By.xpath(action.getXpath(ServiceCharge_Row) + "[" + (i + 1) + "]//td[4]//span");
				passed = action.getTextFromPage(SNXpath).trim().equals(this.ServiceNumber);
			}
		}

		passed = action.clickOn(ServiceChargeFirst_Row);

		String SNumber = action.getTextFromPage(By.xpath(action.getXpath(ServiceCharge_Row) + "[1]//td[4]//span"))
				.trim();
		String SCRaisedDate = action.getTextFromPage(By.xpath(action.getXpath(ServiceCharge_Row) + "[1]//td[1]//span"))
				.trim();
		String SCType = action.getTextFromPage(By.xpath(action.getXpath(ServiceCharge_Row) + "[1]//td[2]//span"))
				.trim();
		String SCDescription = action.getTextFromPage(By.xpath(action.getXpath(ServiceCharge_Row) + "[1]//td[3]//span"))
				.trim();
		String SCAmount = action.getTextFromPage(By.xpath(action.getXpath(ServiceCharge_Row) + "[1]//td[5]//span"))
				.trim();

		passed = !SCRaisedDate.trim().equals("");
		passed = !SCType.trim().equals("");
		passed = !SCDescription.trim().equals("");
		passed = !SCAmount.trim().equals("");

		TestActions.log("Service Number : " + SNumber);
		TestActions.log("Raised Date : " + SCRaisedDate);
		TestActions.log("Service Charge Type : " + SCType);
		TestActions.log("Description : " + SCDescription);
		TestActions.log("Amount : " + SCAmount);

		return passed;
	}
}
