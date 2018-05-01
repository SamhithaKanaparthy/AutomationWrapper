package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class ServiceOperations {
	TestActions action = null;

	public String ServiceNumber = "";
	public String RaisedServiceOrder = "";
	public String ServiceStatus = "";

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By FirstServiceNumber_Value = By
			.xpath("//tr[@id='customerServicesForm:serviceEnquiryTabs:0:summaryTab:resultTable_row_0']//td[1]//span");

	By ServiceNumberSearch_Input = By.xpath("//*[text()='Service No:']//following::input[1]");

	By ServiceStatusFilter_Input = By
			.xpath("(//th[contains(@class,'ui-widget-header')]//child::div//descendant::input)[2]");

	// Services Action Buttons
	By ServiceDetails_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Service Details')]]");
	By Provide_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Provide')]]");
	By Change_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Change')]]");
	By CopyMove_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Copy/Move')]]");
	By Products_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Products')]]");

	By Alter_Products_ActionButton = By.xpath("//*[text()='Alter products']");
	By Cease_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Cease')]]");
	By RaiseFault_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Raise fault')]]");
	By Suspend_ActionButton = By
			.xpath("//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Suspend')]]");

	By TransferService_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'Transfer Service')]]");
	By ASN_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'ASN')]]");
	By SuspendService_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Suspend')]]//following::span[text()='Suspend']");
	By ROS_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')][text()[contains(.,'Change')]]//following::span[text()='ROS']");
	By CeaseService_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'Cease Service')]]");

	By TranferProduct_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'Transfer Product')]]");
	By AlterSIMCard_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'Change SIM Card')]]");

	By ChangeLineproduct_ActionButton = By.xpath(
			"//span[contains(@class,'actionButtonHeadingSpaceLabel')]/preceding::span[contains(@class,'actionButton')][text()[contains(.,'Change Line Product')]]");

	By Summary_Tab = By.xpath("//*[text()='Summary']");

	By SelectedService_Value = By.xpath(
			"//tr[@id='customerServicesForm:serviceEnquiryTabs:0:summaryTab:resultTable_row_0']//td[1]//span[1]");

	// Transfer Service WebElements
	By TransferService_PanelHeader = By.xpath("//*[text()='Transfer Service']");
	By TargetAccountNumber_input = By.xpath("//*[text()[contains(.,'Target Account No')]]//following::input[1]");
	By Validate_Button = By.xpath("//input[@value='Validate']");
	By TransferServiceConfirmation_Message = By.xpath("//*[text()='Transferring service to']");
	By TrasnferCompletoin_Message = By.xpath("//*[text()='Account data has been transfered.']");

	// Suspend Service Elements
	By Department_Select = By.xpath("//*[text()='Department:']/following::select[1]");
	By Site_Select = By.xpath("//*[text()='Site:']/following::select[1]");
	By SiteDisabled_Select = By.xpath("(//*[text()='Site:']/following::select[@disabled='disabled'])[1]");
	By SalesSignOff_CheckBox = By.xpath("//*[text()='Perform Sales Sign Off:']/following::input[1]");
	By TOSConfirmation_PopUp = By.xpath("//*[text()='TOS Confirmation']");
	By RaisedServiceOrder_Value = By.xpath("//*[text()='Raised Service Order Number']//following::label[1]");

	// Clone service action button
	By Cloneservice_ActionButton = By.xpath("//*[text()='Clone Service']");

	// Cease multiple services action button
	By ceasemultipleservices_ActionButton = By.xpath("//*[text()='Cease Multiple Services']");

	public ServiceOperations(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(Summary_Tab) > 0))
			passed = action.clickOn(LeftLink.Search.Services);

		return passed;
	}

	public boolean searchByService(String SNumber) {
		boolean passed = false;

		passed = action.waitFor(ServiceNumberSearch_Input, 4, true);
		passed = action.sendDataTo(ServiceNumberSearch_Input, SNumber);

		passed = action.clickOn(CommonPanel.Search_Button);

		action.waitFor(3);

		return passed;
	}

	public boolean verifyServicesScreen() {
		boolean passed = true;

		return passed;
	}

	public void alterSIMCard() {
		action.moveMouseAwayFromScreen();
		action.waitFor(Change_ActionButton, 5, true);
		action.clickOn(Change_ActionButton);
		action.waitFor(1);

		action.waitFor(AlterSIMCard_ActionButton, 5, true);
		action.clickOn(AlterSIMCard_ActionButton);
		action.waitFor(5);
	}

	public boolean navigateToProductsScreen() {
		boolean passed = false;

		By Products_Tab = By.xpath("//a[@class='icePnlTbLblLnk']//descendant::td[text()[contains(.,'Products')]]");

		passed = action.waitFor(Products_Tab, 6, true);
		action.waitFor(1);
		passed = action.clickOn(Products_Tab);

		return passed;
	}

	public void alterProduct() {
		action.moveMouseAwayFromScreen();
		action.waitFor(Products_ActionButton, 5, true);
		action.clickOn(Products_ActionButton);
		action.waitFor(1);

		action.waitFor(Alter_Products_ActionButton, 5, true);
		action.clickOn(Alter_Products_ActionButton);
		action.waitFor(5);
	}

	public void transferProduct() {
		action.moveMouseAwayFromScreen();
		action.waitFor(CopyMove_ActionButton, 5, true);
		action.clickOn(CopyMove_ActionButton);
		action.waitFor(1);

		action.waitFor(TranferProduct_ActionButton, 5, true);
		action.clickOn(TranferProduct_ActionButton);
		action.waitFor(5);
	}

	public void alterlineProduct() {
		action.moveMouseAwayFromScreen();
		action.waitFor(Products_ActionButton, 5, true);
		action.clickOn(Products_ActionButton);
		action.waitFor(1);

		action.waitFor(ChangeLineproduct_ActionButton, 5, true);
		action.clickOn(ChangeLineproduct_ActionButton);
		action.waitFor(5);
	}

	public boolean transferService(String TargetAccount) {
		boolean passed = false;

		passed = action.waitFor(CopyMove_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();

		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);

		passed = action.clickOn(CopyMove_ActionButton);
		passed = action.waitForClickable(TransferService_ActionButton, 2);
		passed = action.clickOn(TransferService_ActionButton);

		passed = action.waitFor(TargetAccountNumber_input, 4, true);

		passed = action.sendDataTo(TargetAccountNumber_input, TargetAccount);
		action.waitFor(1);
		passed = action.clickOn(Validate_Button);

		passed = action.waitFor(CommonPanel.AcceptDisable_Button, 4, false);
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(TransferServiceConfirmation_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpYes_Button);

		passed = action.waitFor(TrasnferCompletoin_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean verifyTransferService(String TargetAccount) {
		boolean passed = false;

		passed = action.waitFor(ServiceDetails_ActionButton, 4, true);

		passed = action.isTextAvailable(TargetAccount);
		passed = action.isTextAvailable(this.ServiceNumber);

		this.ServiceNumber = "";

		return passed;
	}

	public boolean clickOnAlterServiceNumber() {
		boolean passed = false;

		passed = action.waitFor(Change_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();

		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);

		passed = action.clickOn(Change_ActionButton);
		passed = action.waitForClickable(ASN_ActionButton, 2);
		passed = action.clickOn(ASN_ActionButton);

		return passed;
	}

	public boolean clickOnCeaseService() {
		boolean passed = false;

		passed = action.waitFor(Cease_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();

		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);

		passed = action.clickOn(Cease_ActionButton);
		passed = action.waitForClickable(CeaseService_ActionButton, 2);
		passed = action.clickOn(CeaseService_ActionButton);

		return passed;
	}

	public boolean clickOnCeaseMultipleService() {
		boolean passed = false;

		passed = action.waitFor(Cease_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();

		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);

		passed = action.clickOn(Cease_ActionButton);
		passed = action.waitForClickable(CeaseService_ActionButton, 2);
		passed = action.clickOn(CeaseService_ActionButton);

		return passed;
	}

	public void clickOnProvideSetTopBox() {

		By ProvideSetTopBox_ActionButton = By.xpath("//*[text()='Provide Set Top Box ']");

		action.moveMouseAwayFromScreen();
		action.waitFor(Provide_ActionButton, 5, true);
		action.clickOn(Provide_ActionButton);
		action.waitFor(1);
		action.waitFor(ProvideSetTopBox_ActionButton, 5, true);
		action.clickOn(ProvideSetTopBox_ActionButton);
		action.waitFor(5);
	}

	public boolean raiseServiceCharge() {
		boolean passed = false;

		By RaiseSericeCharge_PanelHeader = By.xpath("//*[text()='Raise Service Charge']");
		By ServiceChargeType_Select = By.xpath("//*[text()='Service Charge Type:']//following::select[1]");

		passed = action.waitFor(RaiseSericeCharge_PanelHeader, 4, true);
		passed = action.selectBy(ServiceChargeType_Select, 2);

		action.waitFor(3);

		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 2, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean suspendService() {
		boolean passed = false;

		passed = action.waitFor(Suspend_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();

		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);

		passed = action.clickOn(Suspend_ActionButton);
		passed = action.waitForClickable(SuspendService_ActionButton, 2);
		passed = action.clickOn(SuspendService_ActionButton);

		passed = doTOSROS();

		return passed;
	}

	private boolean doTOSROS() {
		boolean passed = false;

		passed = action.waitFor(Department_Select, 4, true);

		passed = action.selectByPartialText(Department_Select, "AQSAL");
		passed = action.waitFor(SiteDisabled_Select, 2, false);
		passed = action.selectByPartialText(Site_Select, "ANSQ");

		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(RaisedServiceOrder_Value, 4, true);
		this.RaisedServiceOrder = action.getTextFromPage(RaisedServiceOrder_Value).trim();

		passed = action.clickOn(CommonPanel.popUp.popUpNo_Button);

		return passed;
	}

	public boolean restoreService() {
		boolean passed = false;

		passed = action.waitFor(Change_ActionButton, 4, true);
		if (!passed)
			return passed;

		action.moveMouseAwayFromScreen();

		this.ServiceNumber = action.getTextFromPage(FirstServiceNumber_Value);

		passed = action.clickOn(Change_ActionButton);
		passed = action.waitForClickable(ROS_ActionButton, 2);
		passed = action.clickOn(ROS_ActionButton);

		doTOSROS();

		return passed;
	}

	public boolean verifyAudit() {
		By Audit_Tab = By.xpath(
				"//td[contains(@id,'customerServicesForm:serviceEnquiryTabs:')]//descendant::td[text()='Audit']");

		boolean passed = false;

		passed = action.waitFor(Audit_Tab, 4, true);
		passed = action.clickOn(Audit_Tab);

		return passed;
	}

	public boolean verifyAuditTOSHistory() {
		By TOSHistory_Tab = By.xpath(
				"//td[contains(@id,'customerServicesForm:serviceEnquiryTabs:')]//descendant::td[text()='TOS History']");
		By TOSHistory_Table = By.xpath(
				"//table[@id='customerServicesForm:serviceEnquiryTabs:0:auditsTab:serviceAuditTabManagerSet:0:tosHistoryTab:auditTosHisResultTable']");
		By ServiceStatus_Value = By.xpath(
				"//tr[@id='customerServicesForm:serviceEnquiryTabs:0:auditsTab:serviceAuditTabManagerSet:0:tosHistoryTab:auditTosHisResultTable:0']//td[2]//span");

		boolean passed = false;

		passed = action.waitFor(TOSHistory_Tab, 140, true);
		passed = action.clickOn(TOSHistory_Tab);

		passed = action.waitFor(TOSHistory_Table, 30, true);

		this.ServiceStatus = action.getTextFromPage(ServiceStatus_Value).trim();

		return passed;
	}

	// method for clicking on clone service action button
	public boolean cloneservice() {
		boolean passed = false;

		action.waitFor(CopyMove_ActionButton, 5, true);
		action.clickOn(CopyMove_ActionButton);
		action.waitFor(1);
		action.moveMouseAwayFromScreen();
		action.waitFor(Cloneservice_ActionButton, 5, true);
		action.clickOn(Cloneservice_ActionButton);
		action.waitFor(1);

		return passed;
	}

	// method to click on Cease multiple services action button
	public boolean ceasemultipleservices() {
		boolean passed = false;

		action.waitFor(Cease_ActionButton, 5, true);
		action.clickOn(Cease_ActionButton);
		action.waitFor(1);
		action.moveMouseAwayFromScreen();
		action.waitFor(ceasemultipleservices_ActionButton, 5, true);
		action.clickOn(ceasemultipleservices_ActionButton);
		action.waitFor(1);

		return passed;
	}
}
