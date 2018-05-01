package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class AlterServiceNumber {
	TestActions action;
	
	By ServiceNumberAllocation_Select = By.xpath("//*[text()='Service Number Allocation:']//following::select[1]");
	By Deallocate_Button = By.xpath("//input[@value='Deallocate']");
	By SalesSignOff_CheckBox = By
			.xpath("//*[text()='Perform Sales Sign Off:']//following::input[@checked='checked']");
	By RaiseServiceCharge_CheckBox = By.xpath("//*[text()='Raise Service Charge:']//following::input[1]");
	
	public AlterServiceNumber(TestActions action) {
		this.action = action;
	}
	
	public boolean selectDepartmentSite(String Department, String Site) {
		boolean passed = false;
		
		passed = CommonPanel.selectDepartmentSite(action, Department, Site);
		
		return passed;
	}
	
	public boolean alterServiceNumber(boolean raiseServiceCharge) {
		boolean passed = false;

		action.waitFor(1);

		passed = action.selectByPartialText(ServiceNumberAllocation_Select, "Auto");
		passed = action.waitFor(Deallocate_Button, 2, true);

		if (!raiseServiceCharge) {
			if (action.countOf(SalesSignOff_CheckBox) == 1)
				action.clickOn(SalesSignOff_CheckBox);
		} else {
			if (action.countOf(RaiseServiceCharge_CheckBox) == 1)
				action.clickOn(RaiseServiceCharge_CheckBox);
		}

		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 2, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}
}
