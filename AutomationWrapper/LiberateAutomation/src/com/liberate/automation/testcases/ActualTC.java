package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;

/***
 * This is a template for Test Case class
 * 
 *
 */
public class ActualTC {
	/***
	 * All Test Case class should have a TestActions object, and should hold the
	 * value from CommonLogin.action. This is to make sure that entire steps are
	 * executed using the same WebDriver/TestAction instance.
	 */
	static TestActions action = CommonLogin.action;

	/***
	 * The TestCase string variable should hold the name of the TestCase. The name
	 * should be assigned on every Test Case. Same variable should be used/passed as
	 * the filename while taking screenshot and generate Word Report.
	 */
	static String testCase;

	/***
	 * The TestStatus variable is used to hold the test status (PASSED/FAILED)
	 */
	static String testStatus;

	/***
	 * Map object is used to hold the test Data.
	 */
	static Map<String, String> data = new HashedMap<>();

	/***
	 * It is better declare all the data needed to perform the test case before hand
	 * and assign the values inside loadData method.
	 */
	static String testData;

	/***
	 * loadData method is used to load data from the ExcelData sheet. The same
	 * method can be used to retrieve data for all test cases. make sure the
	 * 'key'(first column of Excel Data sheet) is same as the variable name, to
	 * avoid confusion.
	 */
	@BeforeClass
	public void loadData() {
		data = ExcelDataDriver.loadData();

		// Just an example on how to get data
		testData = data.get("testData");
	}

	/***
	 * The logTestResult method will be executed after execution of each
	 * method/test. This method will log the test result in console and log file.
	 * This method will also generate the report with the name from variable
	 * TestCase. The same method can be used on all Test classes
	 * 
	 * @param result
	 *            Pass the same object as parameter.
	 */
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	/***
	 * The actual test method which hold the Test Steps. The return type of
	 * all @Test method should be void. Also the value for TestCase should be
	 * assigned inside the testCase method.
	 */
	@Test
	public static void testCase() {
		testCase = "Test Case";
	}
}
