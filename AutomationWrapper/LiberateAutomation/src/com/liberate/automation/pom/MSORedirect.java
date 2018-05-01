package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSORedirect {
	
	TestActions action = null;
	
	public String ServiceOrderNumber = "";
	public String Department = "";
	
	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");
	By redirectDepartment_DropDown = By.xpath("(//*[text()='Department:'])[last()]/following::select[1]");
	
	By accept_Button = By.xpath("//input[@value='Accept']");
	
	public MSORedirect(TestActions action) {
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
		passed = action.waitFor(LeftLink.ManageServiceOrder.Redirect, 4, true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Redirect);

		return passed;
	}

	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {

		action.scrollUp();

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
	
	public boolean redirectServiceOrder()
	{
		boolean passed = false;
		
		passed = action.waitFor(redirectDepartment_DropDown, 4, true);
		passed = action.selectBy(redirectDepartment_DropDown, 1);
		
		passed = action.clickOn(accept_Button);
		
		return passed;
	}
	
	public boolean validateMessage()
	{
		boolean passed = false;
		
		passed = CommonPanel.popUp.validateMessage(action, "Redirected Successfully");
		
		return passed;
	}
}
