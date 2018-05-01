package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRAccountPricingPlans {
	TestActions action = null;

	String PricingPlan = "";
	String PlanAddedDate = "";

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By PricingPlanSummary_Tab = By.xpath("//*[text()='Pricing Plan Sum']");

	By New_ActionButton = By.xpath("//span[text()='New']");

	By PricingPlanSearch_Input = By.xpath("//*[text()='Pricing Plan Like:']/following::input[1]");
	By PricingPlan_Select = By.xpath("//*[text()='Pricing Plan Like:']/following::select[1]");

	By Validate_Button = By.xpath("//input[@value='Validate']");

	By SalesPerson_Select = By.xpath("//*[text()='Sales Person:']//following::select[1]");
	By Proceed_Button = By.xpath("//*[@value='Proceed']");

	By NominatedNumber_CheckBox = By.xpath("(//input[@class='iceSelBoolChkbx'])[1]");

	By ToBeAuthorizedSearch_Input = By.xpath("//*[text()='To Be Authorised By:']/following::input[1]");
	By ToBeAuthorizedSearch_Button = By.xpath("(//*[text()='To Be Authorised By:']/following::input)[2]");
	By ToBeAuthorizedBy_Select = By.xpath("//*[text()='To Be Authorised By:']/following::select[1]");

	public CRAccountPricingPlans(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(PricingPlanSummary_Tab) > 0))
			passed = action.clickOn(LeftLink.Search.AccountPricingPlans);

		return passed;
	}

	public boolean searchPricingPlan(String PricingPlan) {
		boolean passed = false;

		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);

		passed = action.waitFor(PricingPlanSearch_Input, 4, true);
		passed = action.sendDataTo(PricingPlanSearch_Input, PricingPlan);

		passed = action.clickOn(CommonPanel.Search_Button);

		action.waitFor(4);

		passed = action.selectBy(PricingPlan_Select, 1);

		this.PricingPlan = action.getSelectedOption(PricingPlan_Select);

		passed = action.waitFor(CommonPanel.Accept_Button, 4, true);
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(Validate_Button, 4, true);
		passed = action.clickOn(Validate_Button);

		return passed;
	}

	public boolean addPricingPlan() {
		boolean passed = false;

		passed = action.waitFor(SalesPerson_Select, 4, true);
		passed = action.selectByPartialText(SalesPerson_Select, "99999-");
		action.waitFor(3);

		if (action.countOf(ToBeAuthorizedSearch_Input) > 0) {
			passed = action.sendDataTo(ToBeAuthorizedSearch_Input, "99999");
			action.waitFor(3);
			passed = action.selectBy(ToBeAuthorizedBy_Select, 1);
			action.waitFor(1);
		}

		if (action.countOf(Proceed_Button) > 0)
			passed = action.clickOn(Proceed_Button);

		action.waitFor(NominatedNumber_CheckBox, 4, true);

		if (action.countOf(NominatedNumber_CheckBox) > 0)
			passed = action.clickOn(NominatedNumber_CheckBox);

		action.waitFor(2);

		if (action.countOf(NominatedNumber_CheckBox) > 0)

			passed = action.clickOn(CommonPanel.Accept_Button);

		this.PlanAddedDate = action.getTextFromPage(CommonPanel.LiberateHeader.LiberateDate).replace(",", "");

		return passed;
	}

	public boolean validatePricingPlan() {
		boolean passed = false;

		passed = action.waitFor(CommonPanel.Accept_Button, 4, false);
		passed = action.isTextAvailable(PlanAddedDate);

		return passed;
	}
}
