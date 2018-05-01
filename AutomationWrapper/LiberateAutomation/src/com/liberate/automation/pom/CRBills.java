package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CRBills {
	TestActions action = null;

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By BillTotals_Tab = By.xpath("//*[text()='Bill Totals']");

	/***
	 * Append '//td[1]//span' for Bill Ref Number
	 * Append '//td[1]//span' for Bill Invoice Number
	 * Append '//td[1]//span' for Bill Bill Date
	 * Append '//td[1]//span' for Bill Bill Due Date
	 * Append '//td[1]//span' for Date Cleared
	 * Append '//td[1]//span' for DOB
	 * Append '//td[1]//span' for Brought Forward Balance
	 * Append '//td[1]//span' for New Charges
	 * Append '//td[1]//span' for Bill Query
	 * Append '//td[1]//span' for Payments 
	 * Append '//td[1]//span' for Prev Period Ad
	 * Append '//td[1]//span' for Outstanding Balance
	 */
	By BillFirst_Row = By.xpath("//tr[@id='customerbillTabs:customerBillTabSet:0:billTotalsView:details_row_0']");

	public CRBills(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		passed = action.clickOn(LeftLink.Search.Bills);

		return passed;
	}

	public boolean verifyBill() {
		boolean passed = false;

		passed = action.waitFor(BillTotals_Tab, 4, true);

		passed = action.waitFor(BillFirst_Row, 4, true);
		
		String BillRefNumber = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[1]//span" ));
		String BillInvoiceNumber = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[2]//span" ));
		String BillDate = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[3]//span" ));
		String BillDueDate = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[4]//span" ));
		String DateCleared = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[5]//span" ));
		String DOB = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[6]//span" ));
		String BroughtForwardBalance = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[7]//span" ));
		String NewCharges = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[8]//span" ));
		String BillQuery = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[9]//span" ));
		String Payments  = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[10]//span"));
		String PrevPeriodAd = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[11]//span"));
		String OutstandingBalance = action.getTextFromPage(By.xpath(action.getXpath(BillFirst_Row)+"//td[12]//span"));	
			
		TestActions.log("BillRefNumber : " + BillRefNumber);
		TestActions.log("BillInvoiceNumber : " + BillInvoiceNumber);
		TestActions.log("BillDate : " + BillDate);
		TestActions.log("BillDueDate : " + BillDueDate);
		TestActions.log("DateCleared : " + DateCleared);
		TestActions.log("DOB : " + DOB);
		TestActions.log("BroughtForwardBalance : " + BroughtForwardBalance);
		TestActions.log("NewCharges : " + NewCharges);
		TestActions.log("BillQuery : " + BillQuery);
		TestActions.log("Payments : " + Payments);
		TestActions.log("PrevPeriodAd : " + PrevPeriodAd);
		TestActions.log("OutstandingBalance : " + OutstandingBalance);
		
		return passed;
	}
}
