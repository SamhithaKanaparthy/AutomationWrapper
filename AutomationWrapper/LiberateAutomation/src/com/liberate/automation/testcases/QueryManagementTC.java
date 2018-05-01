package com.liberate.automation.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.CRMaintainQuery;

/***
 * Class with all Query Management Test Cases
 * 
 * 
 *
 */
public class QueryManagementTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String nonAccountQuery = "";

	/**
	 * Private constructor to disable creation of object
	 */
	private QueryManagementTC() {
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 1)
	public static void raiseQueryAccount() {
		testCase = "QueryManagement_raiseQueryAccount";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void amendQuery() {
		testCase = "QueryManagement_amendQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(TestData.queryNumber);
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.amendQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 3)
	public static void addNoteQuery() {
		testCase = "QueryManagement_addNoteQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(TestData.queryNumber);
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.addNote("Additional Note");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 4)
	public static void progressQuery() {
		testCase = "QueryManagement_progressQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(TestData.queryNumber);
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test
	public static void signOffQuery() {
		testCase = "QueryManagement_signOffQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.signOffQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test
	public static void raiseAndAuthoriseAdjustment() {
		testCase = "QueryManagement_raiseAndAuthoriseAdjustment";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByAccount("260002260000");
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.raiseAdjustment();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.authoriseAdjustment();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void verifyBills() {
		testCase = "QueryManagement_verifyBills";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber("ZK00015");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.verifyBills();
		action.getScreenShot(testCase);
		mq.navigateBackFromBillView();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 5)
	public static void raiseQueryNonAccount() {
		testCase = "QueryManagement_raiseQueryNonAccount";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.raiseNonAccountQuery("Test Name", "mail", "test@cwc.com");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		nonAccountQuery = mq.QueryNumber;
		action.getScreenShot(testCase);
	}

	@Test(priority = 10)
	public static void amendQueryNonAccount() {
		testCase = "QueryManagement_amendQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(nonAccountQuery);
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
		mq.amendQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

	@Test(priority = 11)
	public static void signOffQueryNonAccount() {
		testCase = "QueryManagement_signOffQuery";

		CRMaintainQuery mq = new CRMaintainQuery(action);

		mq.navigate();
		action.getScreenShot(testCase);
		mq.searchByQueryNumber(nonAccountQuery);
		action.getScreenShot(testCase);
		mq.raiseAccountQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.progressQuery("RE");
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);

		mq.signOffQuery();
		action.getScreenShot(testCase);
		mq.verifyQuery();
		action.getScreenShot(testCase);
	}

}
