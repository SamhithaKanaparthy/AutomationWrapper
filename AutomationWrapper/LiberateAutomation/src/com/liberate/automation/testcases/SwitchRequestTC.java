package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.ManageSwitchRequest;

/***
 * Class with all Switch Request Test Cases
 * 
 * 
 *
 */
public class SwitchRequestTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String employeeID = "";
	static String switchRequestTime = "";
	static String switchRequestAccountNumber = "";

	/**
	 * Private constructor to disable creation of object
	 */
	private SwitchRequestTC() {
	}

	@BeforeClass
	public static void loadTestData() {
		SwitchRequestTC.employeeID = TestData.employeeID;
		SwitchRequestTC.switchRequestTime = TestData.switchRequestTime;
		SwitchRequestTC.switchRequestAccountNumber = TestData.switchRequestAccountNumber;
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void MonitorNewSwitchRequest() {
		testCase = "SwitchRequest_MonitorNewSwitchRequest";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectMonitorNewSwitchRequests(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.monitorNewSwitchRequests_Search(employeeID, switchRequestTime), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void SwitchRequestFailureQueries() {
		testCase = "SwitchRequest_SwitchRequestFailureQueries";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectFailureQueries(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.failureQueries("FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region", "FLOW-FLOW", "",
				"31/05/2015 03:15", "31/05/2017 03:15"), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void queryByAccountNumber() {
		testCase = "SwitchRequest_queryByAccountNumber";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectQuerybyAcctServiceOrderServiceCommand(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.queryByCustomerDetails(switchRequestAccountNumber, "", "", ""), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void generateSwitchRequest() {
		testCase = "SwitchRequest_generateSwitchRequest";

		ManageSwitchRequest msr = new ManageSwitchRequest(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectGeneralQueryOnNewRequests(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.generalQUery("C-Complete", "FLOW-FLOW TV Gateway Interface", "CAY-Cayman Islands Region",
				"FLOW-FLOW", "", "31/05/2015 03:15", "31/05/2017 03:15"), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyResults(), true);
		action.getScreenShot(testCase);
	}
}
