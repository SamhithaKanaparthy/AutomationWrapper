package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.MaintainDepositReason;

/***
 * Class with Deposit Reason Test Cases
 * 
 * 
 *
 */
public class DepositReasonTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	/**
	 * Private constructor to disable creation of object
	 */
	private DepositReasonTC() {
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void createNewDepositReason() {
		testCase = "DepositReason_createNewDepositReason";

		RandomData random = new RandomData();
		MaintainDepositReason mdr = new MaintainDepositReason(action);

		action.getScreenShot(testCase);
		assertEquals(mdr.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.clickNewButton(), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.provideDepositReasonDetailsNewCreation(random.nextString().substring(4), "TestingAutomation",
				"Y", "4"), true);
		action.getScreenShot(testCase);
		assertEquals(mdr.clickAcceptButton(), true);
		action.getScreenShot(testCase);
		action.waitFor(By.xpath("//span[@class='iceMsgInfo']"), 2, true);
		String x = action.getTextFromPage(By.xpath("//span[@class='iceMsgInfo']"));
		action.getScreenShot(testCase);
		System.out.println(x);
	}
}
