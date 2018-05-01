package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class BrowseServiceOrder {
	private TestActions action = null;

	public String ServiceOrderNumber = "";
	int BulkCount = 0;
	
	By ServiceOrder_Value = By.xpath("(//*[text()='Service Order:'])[2]/following::span[1]");
	By ServiceOrderStatus_Select = By.xpath("//*[text()='Status:']/following::select[1]");

	By Search_Button = By.xpath("//input[@value='Search']");

	By SearchCriteria_PanelHeader = By.xpath("//*[text()='Search Criteria']");
	By SarchCriteriaSearch_Button = By.xpath("(//input[@value='Search'])[last()]");

	By MultipleServiceOrderSelectYes_Radio = By
			.xpath("//*[text()='Multiple Service Order:']/following::input[@value='Y']");

	By MultipleServiceOrderSelectAll_CheckBox = By
			.xpath("//input[@id='browseServiceOrderForm:browseServiceOrderTable:browseServiceOrderCheckAll']");

	By Cancel_ActionButton = By.xpath("//span[text()='Cancel']");
	
	By BulkCancel_ActionButton = By.xpath("//span[text()='Bulk Cancel']");
	By BulkCancel_PanelHeader = By.xpath("//*[text()='Bulk Cancel Details']");
	By BulkCancelReason_Select = By.xpath("//*[text()='Reason']/following::select[1]");
	
	By BulkSuspend_ActionButton = By.xpath("//span[text()='Bulk Suspend']");
	By BulkSuspend_PanelHeader = By.xpath("//*[text()='Bulk Suspend Details']");
	By BulkSuspendReason_Select = By.xpath("//*[text()='Suspend Reason']/following::select[1]");
	
	By BulkSignOff_ActionButton = By.xpath("//span[text()='Bulk Signoff']");
	By BulkSignOff_PanelHeader = By.xpath("//*[text()='Bulk Account Sign off']");
	By BulkSignOffBillDate_Input = By.xpath("//*[text()='Billing Date/Time']/following::input[1]");
	By BillDateNow_Button = By.xpath("");
	
	By BulkOrderProcessSummary_Table = By.xpath("//div[@class='ui-datatable ui-widget']");
	
	/***
	 * Append with [< Count >] for particular row.
	 * After appending count, append <i>td[1]</i> for Service Order Number
	 * After appending count, append <i>td[2]</i> for Processing Summary
	 */
	By BulkOrderProcessSummary_Row = By.xpath("//div[@class='ui-datatable ui-widget']/descendant::tbody//tr");
	By Accept_Button = By.xpath("//input[@value='Accept']");
	
	/***
	 * Append with [< Count >] Start from [2]
	 */
	By ServiceOrder_CheckBox = By.xpath("//*[text()='Customer Name']//following::input[@class='iceSelBoolChkbx']");

	public BrowseServiceOrder(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);

		return passed;
	}

	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {

		action.scrollUp();

		boolean passed = false;

		this.ServiceOrderNumber = ServiceOrderNumber;

		passed = CommonPanel.ServiceOrder.Search(action, department, ServiceOrderNumber);

		return passed;
	}

	public boolean verifyServiceOrdeDetails(String ServiceOrderNumber) {
		boolean passed = false;

		passed = action.waitFor(ServiceOrder_Value, 3, true);
		passed = action.getTextFromPage(ServiceOrder_Value).trim().equals(ServiceOrderNumber) ? true : false;

		return passed;
	}
	
	public boolean selectDepartment(String Department)
	{
		return (CommonPanel.ServiceOrder.selectDepartment(action, Department));
	}
	
	public boolean selectMultipleServiceOrder(String Department, int count) {
		boolean passed = false;
		this.BulkCount = count;
		
		passed = this.selectDepartment(Department);
		
		passed = action.selectBy(ServiceOrderStatus_Select, 1);

		passed = action.clickOn(Search_Button);

		passed = action.waitFor(SearchCriteria_PanelHeader, 4, true);
		passed = action.clickOn(SarchCriteriaSearch_Button);

		passed = action.waitFor(MultipleServiceOrderSelectYes_Radio, 10, true);
		passed = action.clickOn(MultipleServiceOrderSelectYes_Radio);

		for (int i = 0; i < count; i++) {
			By ServiceOrderCheckBox = By.xpath(action.getXpath(ServiceOrder_CheckBox) + "[" + (2 + i) + "]");
			
			passed = action.waitFor(ServiceOrderCheckBox, 2, true);
			passed = action.clickOn(ServiceOrderCheckBox);
			if (i == 0)
				passed = action.waitFor(Cancel_ActionButton, 8, true);
			else if (i == 1)
				passed = action.waitFor(BulkCancel_ActionButton, 8, true);
			else
				action.waitFor(2);
		}

		return passed;
	}
	
	public boolean bulkCancel()
	{
		boolean passed = false;
		
		passed = action.clickOn(BulkCancel_ActionButton);
		
		passed = action.waitFor(BulkCancel_PanelHeader, 10, true);
		
		passed = action.selectBy(BulkCancelReason_Select, 1);
		
		action.waitFor(2);
		
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
	
	public boolean verifyBulkProcessing()
	{
		boolean passed = false;
		
		passed = action.waitFor(Accept_Button, 10, false);
		passed = action.waitFor(BulkOrderProcessSummary_Table, 10, true);
		
		for(int i = 0; i < BulkCount; i++)
		{
			By ServiceOrder = By.xpath(action.getXpath(BulkOrderProcessSummary_Row)+"["+(i+1)+"]//td[1]");
			By ProcessingStatus = By.xpath(action.getXpath(BulkOrderProcessSummary_Row)+"["+(i+1)+"]//td[2]");
			
			passed = action.countOf(ServiceOrder)>0;
			passed = action.countOf(ProcessingStatus)>0;

			TestActions.log("Service Order " + action.getTextFromPage(ServiceOrder) + " Processing Status : " + action.getTextFromPage(ProcessingStatus));
		}
		
		return passed;
	}
	
	public boolean bulkSuspend()
	{
		boolean passed = false;
		
		passed = action.clickOn(BulkSuspend_ActionButton);
		
		passed = action.waitFor(BulkSuspend_PanelHeader, 10, true);
		
		passed = action.selectBy(BulkSuspendReason_Select, 1);
		
		action.waitFor(2);
		
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
	
	public boolean bulkSignOff()
	{
		boolean passed = false;
		
		passed = action.clickOn(BulkSignOff_ActionButton);
		
		passed = action.waitFor(BulkSignOff_PanelHeader, 10, true);
		
		if(action.countOf(BulkSignOffBillDate_Input)>0)
		{
			action.typeDataTo(BulkSignOffBillDate_Input, "17/01/2018 00:00");
		}
			
		action.waitFor(2);
		
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
}
