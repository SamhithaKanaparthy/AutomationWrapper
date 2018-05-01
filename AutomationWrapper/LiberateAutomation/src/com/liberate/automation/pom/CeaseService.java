package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class CeaseService {
	TestActions action;
	
	By Proceed_Button = By.xpath("//input[contains(@value,'Proceed')]");
	By SelectAllProduct_CheckBox = By.xpath("(//*[text()='Cease All']//following::input)[1]");
	By CeaseWarning_Message = By.xpath("//*[text()='Entire Service will be ceased']");

	By CeaseReason_Select = By.xpath("//*[text()='Cease Reason:']//following::select[1]");
	By SIMRetireReason_Select = By.xpath("//*[text()='SIM Retired Reason:']//following::select[1]");
	
	public CeaseService(TestActions action) {
		this.action = action;
	}
	
	public boolean selectDepartmentSite(String Department, String Site) {
		boolean passed = false;
		
		passed = CommonPanel.selectDepartmentSite(action, Department, Site);
		
		return passed;
	}
	
	public boolean ceaseService() {
		boolean passed = false;

		action.waitFor(1);

		passed = action.clickOn(Proceed_Button);

		passed = action.waitFor(SelectAllProduct_CheckBox, 4, true);
		passed = action.clickOn(SelectAllProduct_CheckBox);

		action.waitFor(CeaseWarning_Message, 4, true);

		passed = action.selectBy(CeaseReason_Select, 1);
		passed = action.selectBy(SIMRetireReason_Select, 1);

		passed = action.clickOn(CommonPanel.Accept_Button);
		
		return passed;
	}
}
