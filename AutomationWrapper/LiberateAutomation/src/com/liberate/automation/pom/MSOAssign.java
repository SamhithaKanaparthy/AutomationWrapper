package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOAssign {

	TestActions action = null;
	
	public String ServiceOrderNumber = "";
	By serviceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");
	
	By selectDepartmentBySite = By.xpath("//*[text()='Select Department by :']/following::input[2]");
	By site_DropDown = By.xpath("//*[text()='Site :']/following::select");
	
	By department_Row = By.xpath("//*[text()='Select Department by :']/following::tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[last()]");
	
	By departmentSeq_Input = By.xpath("//*[text()='Assign Sequence']/following::input[1]");
	
	By submit_Button = By.xpath("//input[@value='Submit']");
	By accept_Button = By.xpath("//input[@value='Accept']");
	
	public MSOAssign(TestActions action) {
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
		passed = action.waitFor(LeftLink.ManageServiceOrder.Assign, 4, true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Assign);

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
	
	public boolean assignServiceOrder()
	{
		boolean passed = false;
		
		action.scrollDown();
		
		passed = action.waitFor(selectDepartmentBySite, 3, true);
		passed = action.clickOn(selectDepartmentBySite);
		
		passed = action.waitFor(site_DropDown, 5, true);
		passed = action.selectByPartialText(site_DropDown, "ANSQ-");
		
		passed = action.waitFor(department_Row, 5, true);
		action.scrollDown();
		passed = action.clickOn(department_Row);
		
		passed = action.waitFor(departmentSeq_Input, 3, true);
		action.scrollDown();
		passed = action.sendDataTo(departmentSeq_Input, "50");
		
		passed = action.clickOn(submit_Button);
		passed = action.waitFor(2);
		passed = action.clickOn(accept_Button);
		
		return passed;
	}
}
