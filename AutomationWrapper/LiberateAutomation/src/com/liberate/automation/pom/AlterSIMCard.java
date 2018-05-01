package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class AlterSIMCard {
	TestActions action = null;

	// By Department Site Panel
	By department_Select = By.xpath("//*[text()='Department:']//following::select[1]");
	By siteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
	By site_Select = By.xpath("//*[text()='Site:']//following::select[1]");

	By retiredReason_Select = By.xpath("//*[text()='Retired Reason:']//following::select[1]");
	By LookUp_Button = By.xpath("//input[@value='Look Up']");
	By SIMSearch_Message = By.xpath("//*[text()[contains(.,'More Numbers exist matching the details entered')]]");
	By SIM_Select = By.xpath("(//*[text()='SIM:']//following::select)[2]");
	By SalesSignOff_CheckBox = By.xpath("//*[text()='Perform Sales Sign Off:']//following::input[@checked='checked']");

	public AlterSIMCard(TestActions action) {
		this.action = action;
	}

	public boolean selectDepartmentSite(String department, String site) {
		boolean passed = false;

		passed = action.waitFor(department_Select, 4, true);
		passed = action.selectByPartialText(department_Select, department);

		passed = action.waitFor(siteDisabled_Select, 4, false);
		passed = action.selectByPartialText(site_Select, site);

		return passed;
	}

	public boolean updateSIMCard() {
		boolean passed = false;

		passed = action.waitFor(retiredReason_Select, 4, true);
		passed = action.selectBy(retiredReason_Select, 1);

		action.waitFor(1);

		if (action.countOf(LookUp_Button) == 1) {
			action.clickOn(LookUp_Button);
			action.waitFor(SIMSearch_Message, 4, true);
			action.clickOn(CommonPanel.popUp.popUpOK_Button);
			action.waitFor(SIMSearch_Message, 4, false);
			action.waitFor(1);
			action.selectBy(SIM_Select, 8);
			action.waitFor(2);
		}
		if (action.countOf(CommonPanel.popUp.popUpYes_Button) > 0) {
			action.clickOn(CommonPanel.popUp.popUpYes_Button);
			passed = action.waitFor(CommonPanel.popUp.popUpYes_Button, 4, false);
		}
		if (action.countOf(SalesSignOff_CheckBox) == 1) {
			action.clickOn(SalesSignOff_CheckBox);
		}
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 2, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}
}
