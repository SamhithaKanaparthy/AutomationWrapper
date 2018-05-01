package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRAdjustments {
	TestActions action = null;
	
	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");
	By CustomerAdjustments_PanelHeader = By.xpath("//*[text()[contains(.,'Customer Adjustments')]]");

	By New_ActionButton = By.xpath("//span[text()='New']");
	
	By AdjustmentType_Select = By.xpath("//*[text()='Description Contains:']/following::select[1]");
	By BillDescription_Input = By.xpath("//*[text()='Bill Description:']/following::input[1]");
	By Amount_Input = By.xpath("//*[text()='Amount:']/following::input[1]");
	
	By AdjustmentsFirst_Row = By.xpath("//tr[@id='adjustmentsForm:adstTable:0']");
	By Success_Message = By.xpath("//*[text()[contains(.,'Successfully Created')]]");
	
	public CRAdjustments(TestActions action)
	{
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(CustomerAdjustments_PanelHeader) > 0))
			passed = action.clickOn(LeftLink.Search.Adjustments);

		return passed;
	}
	
	public boolean raiseAjustment()
	{
		boolean passed = false;
		
		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);
				
		passed = action.waitFor(AdjustmentType_Select, 4, true);
		action.scrollDown();
		passed = action.selectBy(AdjustmentType_Select, 1);
		passed = action.waitFor(2);
		
		passed = action.sendDataTo(BillDescription_Input, "Test Description");
		passed = action.sendDataTo(Amount_Input, "10.00");
		
		passed = action.clickOn(CommonPanel.Accept_Button);
		
		return passed;
	}
	
	public boolean verifyRaiseAdjustment()
	{
		boolean passed = false;
		
		passed = action.waitFor(CommonPanel.Accept_Button, 4, false);
		passed = action.waitFor(Success_Message, 4, true);
		
		return passed;
	}
	
	public boolean verifyAdjustmenst()
	{
		boolean passed = false;
		
		passed = action.waitFor(CustomerAdjustments_PanelHeader, 4, true);
		passed = action.clickOn(AdjustmentsFirst_Row);
		
		return passed;
	}
}
