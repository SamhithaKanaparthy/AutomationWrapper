package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.BrowseServiceOrder;

/***
 * Class with Bulk Service Order processing Test Cases
 * 
 * 
 *
 */
public class BulkSOProcessingTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static Map<String, String> data = new HashedMap<>();
	static String networkDepartment = "";
	static String generalDepartment = "";
	static String accountDepartment = "";

	/**
	 * Private constructor to disable creation of object
	 */
	private BulkSOProcessingTC() {
	}

	@BeforeClass
	public static void loadData() {
		networkDepartment = TestData.networkDepartment;
		generalDepartment = TestData.generalDepartment;
		accountDepartment = TestData.accountDepartment;
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void bulkCancel() {
		testCase = "BulkSOProcessing_bulkCancel";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectMultipleServiceOrder(generalDepartment, 2), true);
		action.getScreenShot(testCase);
		assertEquals(msr.bulkCancel(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void bulkSuspend() {
		testCase = "BulkSOProcessing_bulkSuspend";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectMultipleServiceOrder(generalDepartment, 2), true);
		action.getScreenShot(testCase);
		assertEquals(msr.bulkSuspend(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void bulkAccountSignOff() {
		testCase = "BulkSOProcessing_bulkAccountSignOff";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectMultipleServiceOrder(accountDepartment, 2), true);
		action.getScreenShot(testCase);
		assertEquals(msr.bulkSignOff(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(testCase);
	}

	@Test
	public static void bulkGeneralSignOff() {
		testCase = "BulkSOProcessing_bulkGeneralSignOff";

		BrowseServiceOrder msr = new BrowseServiceOrder(action);

		assertEquals(msr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.selectMultipleServiceOrder(generalDepartment, 2), true);
		action.getScreenShot(testCase);
		assertEquals(msr.bulkSignOff(), true);
		action.getScreenShot(testCase);
		assertEquals(msr.verifyBulkProcessing(), true);
		action.getScreenShot(testCase);
	}
}
