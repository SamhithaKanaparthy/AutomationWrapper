package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class DepositRequirement {
	TestActions action = null;
	
	String DepositReason = "";

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");
	
	By DepositSummary_TabHeader = By.xpath("//*[text()='Deposit Summary']");
	By RefundDeposit_TabHeader = By.xpath("//*[text()='Refund Deposit']");

	By New_ActionButton = By.xpath("//span[text()='New']");

	By NewDepositRequirement_PanelHeader = By.xpath("//*[text()='New Deposit Requirements']");

	By ReasonForDeposit_Select = By.xpath("//*[text()='Reason For Deposit:']/following::select[1]");
	By AmountRequired_Input = By.xpath("//*[text()='Amount Required:']/following::input[1]");
	
	By RefundDeposit_Row = By.xpath("//tbody[contains(@id,'depositRefundTab')]/child::tr[1]");
	
	By ServiceCharge_RadioButton = By.xpath("(//*[text()='Refund Method :']/following::input)[3]");
	
	By RefundAmount_Input = By.xpath("//*[text()='Refund Amount:']/following::input[1]");
	
	By DepositRefunded_Message = By.xpath("//*[text()='Deposit refunded.']");

	By RefundOK_Button = By.xpath("//a[text()='OK']");

	public DepositRequirement(TestActions action) {
		this.action = action;
	}
	
	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		passed = action.clickOn(LeftLink.Search.DepositRequirements);

		return passed;
	}
	
	public boolean verifyDepositRequirement() {
		boolean passed = false;
		
		passed = action.waitFor(DepositSummary_TabHeader, 4, true);
		
		if(!this.DepositReason.trim().equals(""))
		{
			passed = action.isTextAvailable(this.DepositReason);
		}
		
		return passed;
	}	
	
	public boolean addNewDepositRequirement(String AmountRequired) {
		boolean passed = false;
		
		passed = action.waitFor(New_ActionButton, 4, true);
		passed = action.clickOn(New_ActionButton);
		
		passed = action.waitFor(ReasonForDeposit_Select, 4, true);
		passed = action.selectBy(ReasonForDeposit_Select, 1);
		
		this.DepositReason = action.getSelectedOption(ReasonForDeposit_Select).trim();
		
		passed = action.sendDataTo(AmountRequired_Input, AmountRequired);
		
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
		
		return passed;
	}
	
	public boolean refundDeposit(String Amount)
	{
		boolean passed = false;
		
		passed = action.waitFor(RefundDeposit_TabHeader, 4, true);
		passed = action.clickOn(RefundDeposit_TabHeader);
		
		passed = action.waitFor(RefundDeposit_Row, 4, true);
		passed = action.clickOn(RefundDeposit_Row);
		
		passed = action.waitFor(ServiceCharge_RadioButton, 4, true);
		passed = action.clickOn(ServiceCharge_RadioButton);
		
		passed = action.waitFor(RefundAmount_Input, 4, true);
		passed = action.sendDataTo(RefundAmount_Input, Amount);
		
		passed = action.clickOn(CommonPanel.Apply_Button);
		
		passed = action.waitFor(DepositRefunded_Message, 4, true);
		
		passed = action.clickOn(RefundOK_Button);
		
		return passed;
	}
}
