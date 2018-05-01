package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOCancelServiceOrder {

	private TestActions action = null;

	public String ServiceOrderNumber = "";

	By cancelReason_Select = By.xpath("//*[text()='Status Reason:']/following::select[1]");
	By sendLetter_Select = By.xpath("//*[text()='Send Letter:']/following::select[1]");
	By accept_Button = By.xpath("//input[@value='Accept']");
	By cancel_Button = By.xpath("//input[@value='Cancel']");
	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");

	public MSOCancelServiceOrder(TestActions action) {
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
		passed = action.waitFor(LeftLink.ManageServiceOrder.Cancel, 4, true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Cancel);

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
			this.ServiceOrderNumber = action.getTextFromPage(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]/descendant::td[1]"));
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

	public boolean cancelServiceOrder() {
		boolean passed = false;

		passed = action.waitFor(cancelReason_Select, 3, true);
		passed = action.selectBy(cancelReason_Select, 1);
		passed = action.waitFor(1);
		passed = action.clickOn(accept_Button);

		return passed;
	}

	public boolean clickOnOKButton() {
		boolean passed = false;

		passed = CommonPanel.popUp.clickOK(action);

		return passed;
	}
}
