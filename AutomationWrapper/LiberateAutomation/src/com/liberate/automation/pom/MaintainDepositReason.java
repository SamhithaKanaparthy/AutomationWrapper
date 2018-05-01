package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MaintainDepositReason

{
	TestActions action = null;

	// Maintain Deposit Reason Panel Header, first record selection in existing
	// records

	By MaintainDepositReason_PanelHeader = By.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/div[1]/div[1]/span");
	By FirstRecord_MaintainDepositReasons = By.xpath("//table[@class='iceDatTbl']/tbody[1]/tr[1]/td[1]/span");

	// New_Deposit Reason Creation

	// New button in Maintain Deposit Reason screen
	By NewButton = By.xpath("//div[@class='icePnlGrp iceNormalPnlGrd']/div[1]/input[1]");

	// After clicking on New button waiting for panel _ writing xpath for panel
	// header
	By DeposiReasonCodePanelHead = By.xpath("//*[text()='Deposit reason Code:']");

	// New record creation _ Maintain Deposit Reason - All input fields
	By DepositReasonCode_inputField = By.xpath("//*[text()='Deposit reason Code:']/following::input[1]");
	By Description_inputField = By.xpath("//*[text()='Description:']/following::input[1]");
	By InteresttobeCreditedtoCustomersBill = By
			.xpath("//*[text()[contains(.,'Interest to be credited to customer')]]/following::input[1]");
	By NoofMonthstoHoldDepositBeforeAutomaticRefund = By
			.xpath("//*[text()[contains(.,'deposit before automatic refund:')]]/following::input[1]");
	By NoofMonthsOverWhichDepositisRefunded = By
			.xpath("//*[text()[contains(.,'deposit is refunded:')]]/following::input[1]");
	By UsageAdvanceDefaultAmount = By.xpath("//*[text()[contains(.,'Default Amount:')]]/following::input[1]");
	By NoofMonthsthePayBill_onTimeBeforeDepositisAutomaticallyRefunded = By
			.xpath("//*[text()[contains(.,'before deposit is automatically refunded:')]]/following::input[1]");
	By NoofMonthsAfterProdorAcctCeasedBeforeRecommendforRefund = By
			.xpath("//*[text()[contains(.,'before recommend for refund:')]]/following::input[1]");

	// New record creation _ Maintain Deposit Reason - All radio buttons
	By RefundDeposit_radioButtonYes = By.xpath("(//*[text()='Refund deposit:']/following::input[@value='Y'])[1]");
	By RefundDeposit_radioButtonNo = By.xpath("(//*[text()='Refund deposit:']/following::input[@value='N'])[1]");
	By AccrueInterestOnDeposit_radioButtonYes = By
			.xpath("(//*[text()='Accrue interest on deposit :']/following::input[@value='Y'])[1]");
	By AccrueInterestOnDeposit_radioButtonNo = By
			.xpath("(//*[text()='Accrue interest on deposit :']/following::input[@value='N'])[1]");
	By AutomaticallyRefundtoWorkingAccounts_Yes = By
			.xpath("(//*[text()='Automatically Refund to Working Accounts:']/following::input[@value='Y'])[1]");
	By AutomaticallyRefundtoWorkingAccounts_No = By
			.xpath("(//*[text()='Automatically Refund to Working Accounts:']/following::input[@value='N'])[1]");
	By InterestisCompound_Yes = By.xpath("(//*[text()='Interest is compound:']/following::input[@value='Y'])[1]");
	By InterestisCompound_No = By.xpath("(//*[text()='Interest is compound:']/following::input[@value='N'])[1]");
	By PayInitialPartPeriodInterest_Yes = By
			.xpath("(//*[text()='Pay Initial Part Period Interest:']/following::input[@value='Y'])[1]");
	By PayInitialPartPeriodInterest_No = By
			.xpath("(//*[text()='Pay Initial Part Period Interest:']/following::input[@value='N'])[1]");
	By UsageAdvance_Yes = By.xpath("(//*[text()='Usage Advance:']/following::input[@value='Y'])[1]");
	By UsageAdvance_No = By.xpath("(//*[text()='Usage Advance:']/following::input[@value='N'])[1]");
	By AutomaticallyRefundtoCeasedAccounts_Yes = By
			.xpath("(//*[text()='Automatically Refund to Ceased Accounts:']/following::input[@value='Y'])[1]");
	By AutomaticallyRefundtoCeasedAccounts_No = By
			.xpath("(//*[text()='Automatically Refund to Ceased Accounts:']/following::input[@value='N'])[1]");
	By RefundMethod_Adjustment = By.xpath("//*[text()='Refund Method:']/following::input[@value='A']");
	By RefundMethod_ServiceCharge = By.xpath("//*[text()='Refund Method:']/following::input[@value='S']");

	// New record creation_Maintain Deposit Reason - Command button
	By Acceptbutton = By.xpath("//input[@value='Accept']");
	By CancelButton = By.xpath("//input[@value='Cancel']");

	// Amend Deposit Reason - Selecting Record
	By SelectionOfRecord = By.xpath("//*[@class='iceDatTbl']/thead/following::tr[1]/td[1]");

	// Amend Deposit Reason - Amend Command button
	By AmendButton = By.xpath("//*[@value='Amend']");

	/***
	 * Default constructor that takes TestAction object as argument.
	 * 
	 * @param action
	 *            The TestAction class object, which will be used to run test steps
	 */
	public MaintainDepositReason(TestActions action) {
		this.action = action;
	}

	/***
	 * The method to navigate to Maintain Deposit Reason screen
	 * 
	 * @return Returns true if able to navigate, else will return false.
	 */
	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;
		
		action.scrollUp();
		action.waitFor(1);
		
		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CreditControl);
		passed = action.waitFor(LiberateCommon.CreditControl.DepositMaintenance, 4, true);
		passed = action.clickOn(LiberateCommon.CreditControl.DepositMaintenance);
		passed = action.waitFor(LeftLink.DepositMaintenance.MaintainDepositReason, 4, true);
		passed = action.clickOn(LeftLink.DepositMaintenance.MaintainDepositReason);

		return passed;
	}

	/***
	 * Method to Click on'New' command button to navigate to Maintain Deposit Reason
	 * - New Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean clickNewButton() {
		boolean passed = false;

		passed = action.waitFor(NewButton, 4, true);
		passed = action.clickOn(NewButton);

		return passed;
	}

	/***
	 * Method to create New Maintain Deposit Reason Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 * @throws InterruptedException
	 */
	public boolean provideDepositReasonDetailsNewCreation(String DepositReasonCode, String Description,
			String InterestToBeCreditedToCustomersBill, String NoofMonthsOverWhichDepositIsRefunded) {
		boolean passed = false;

		passed = action.waitFor(DeposiReasonCodePanelHead, 4, true);
		action.scrollDown();
		
		passed = action.sendDataTo(DepositReasonCode_inputField, DepositReasonCode);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.sendDataTo(Description_inputField, Description);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(RefundDeposit_radioButtonYes);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(AccrueInterestOnDeposit_radioButtonYes);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(AutomaticallyRefundtoWorkingAccounts_Yes);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.sendDataTo(InteresttobeCreditedtoCustomersBill, InterestToBeCreditedToCustomersBill);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(InterestisCompound_Yes);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.sendDataTo(NoofMonthsOverWhichDepositisRefunded, NoofMonthsOverWhichDepositIsRefunded);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(PayInitialPartPeriodInterest_No);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(UsageAdvance_No);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(AutomaticallyRefundtoCeasedAccounts_No);
		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(RefundMethod_Adjustment);
		passed = action.waitFor(Acceptbutton, 4, true);
		
		action.scrollUp();
		action.waitFor(1);
		
		return passed;
	}

	/***
	 * Method to select a Record from available records
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean selectRecordToAmend() {
		boolean passed = false;

		passed = action.waitFor(NewButton, 4, true);
		passed = action.clickOn(SelectionOfRecord);

		return passed;
	}

	/***
	 * Method to Click on'Amend' command button to navigate to Maintain Deposit
	 * Reason - Amend Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean clickAmendButton() {
		boolean passed = false;

		passed = action.waitFor(AmendButton, 4, true);
		passed = action.clickOn(AmendButton);

		return passed;
	}

	/***
	 * Method to create Amend Maintain Deposit Reason Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean provideDetailsAmendDepositReason(String Description, String InterestToBeCreditedToCustomersBill,
			String NoofMonthsOverWhichDepositIsRefunded) {
		boolean passed = false;

		passed = action.waitFor(Description_inputField, 4, true);
		action.scrollDown();

		passed = action.sendDataTo(Description_inputField, Description);
		passed = action.clickOn(RefundDeposit_radioButtonYes);
		passed = action.clickOn(AccrueInterestOnDeposit_radioButtonYes);
		passed = action.clickOn(AutomaticallyRefundtoWorkingAccounts_Yes);
		passed = action.sendDataTo(InteresttobeCreditedtoCustomersBill, InterestToBeCreditedToCustomersBill);
		passed = action.clickOn(InterestisCompound_Yes);
		passed = action.sendDataTo(NoofMonthsOverWhichDepositisRefunded, NoofMonthsOverWhichDepositIsRefunded);
		passed = action.clickOn(PayInitialPartPeriodInterest_No);
		passed = action.clickOn(UsageAdvance_No);
		passed = action.clickOn(AutomaticallyRefundtoCeasedAccounts_No);
		passed = action.clickOn(RefundMethod_Adjustment);
		
		action.scrollUp();
		action.waitFor(1);
		
		return passed;
	}

	/***
	 * Method to Click on 'Accept' button in Maintain Deposit Reason - New
	 * Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean clickAcceptButton() {
		boolean passed = false;

		passed = action.waitFor(Acceptbutton, 4, true);
		passed = action.clickOn(Acceptbutton);

		return passed;
	}

	/***
	 * Method to Click on 'Cancel' button in Maintain Deposit Reason - New
	 * Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean clickCancelButton() {
		boolean passed = false;

		passed = action.waitFor(CancelButton, 4, true);
		passed = action.clickOn(CancelButton);

		return passed;
	}

}
