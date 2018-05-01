package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOSignoff {
	private TestActions action = null;

	public String ServiceOrderNumber = "";

	By accpet_Button = By.xpath("//input[@value='Accept']");
	By OK_Button = By.xpath("//input[@value='OK']");

	By generalSignOff_Label = By.xpath("//*[text()[contains(.,'General Sign Off')]]");
	By accountSignOff_Label = By.xpath("//*[text()[contains(.,'Account Signoff')]]");

	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");

	public MSOSignoff(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		passed = action.waitFor(LeftLink.ManageServiceOrder.Signoff, 4, true);

		action.scrollDown();
		action.waitFor(1);

		passed = action.clickOn(LeftLink.ManageServiceOrder.Signoff);

		return passed;
	}

	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {
		boolean passed = false;
		if (!department.trim().equals("") && !ServiceOrderNumber.trim().equals("")) {
			this.ServiceOrderNumber = ServiceOrderNumber;
			passed = CommonPanel.ServiceOrder.Search(action, department, ServiceOrderNumber);
		}

		else {
			passed = action.clickOn(CommonPanel.ServiceOrder.serviceOrderList_Header);
			passed = action.waitFor(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]"), 4, true);
			this.ServiceOrderNumber = action
					.getTextFromPage(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]/descendant::td[1]"));
			passed = action.clickOn(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]"));
		}
		return passed;
	}

	public boolean verifyServiceOrdeDetails(String ServiceOrderNumber) {
		boolean passed = false;

		passed = action.waitFor(serviceOrder_Value, 3, true);
		passed = action.getTextFromPage(serviceOrder_Value).trim().equals(ServiceOrderNumber) ? true : false;

		return passed;
	}

	public boolean generalSignOff() {
		boolean passed = false;

		action.scrollDown();

		action.waitFor(generalSignOff_Label, 2, true);

		action.waitFor(accpet_Button, 2, true);
		action.clickOn(accpet_Button);

		action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		if (action.countOf(CommonPanel.popUp.popUpYes_Button) > 0) {
			action.clickOn(CommonPanel.popUp.popUpYes_Button);
			action.waitFor(CommonPanel.popUp.popUpYes_Button, 2, false);
		}

		action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean accountSignOff() {
		boolean passed = false;

		action.waitFor(accountSignOff_Label, 2, true);

		action.waitFor(OK_Button, 2, true);
		action.clickOn(OK_Button);
		
		action.waitFor(accpet_Button, 2, true);
		action.clickOn(accpet_Button);
		
		action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		if (action.countOf(CommonPanel.popUp.popUpYes_Button) > 0) {
			action.clickOn(CommonPanel.popUp.popUpYes_Button);
			action.waitFor(CommonPanel.popUp.popUpYes_Button, 2, false);
		}

		action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}
}
