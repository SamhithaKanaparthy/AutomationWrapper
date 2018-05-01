package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CreditControlService;
import com.liberate.automation.pom.DashBoard;
import com.liberate.automation.pom.ServiceOperations;

/***
 * Class with Credit Control Test Case
 * 
 * 
 *
 */
public class CreditControlTC {
	static TestActions action = CommonLogin.action;

	static String testCase;
	static String testStatus;

	static String creditControlServiceNumber = "";

	/**
	 * Private constructor to disable creation of object
	 */
	private CreditControlTC() {
	}

	@BeforeClass
	public static void loadData() {
		creditControlServiceNumber = TestData.creditControlServiceNumber;
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 0)
	public static void serviceBAR() {
		testCase = "CreditControlTC_serviceBAR";

		CreditControlService creditControl = new CreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(testCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		creditControl.serviceBAR();
		action.getScreenShot(testCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void serviceTOS() {
		testCase = "CreditControlTC_serviceTOS";

		CreditControlService creditControl = new CreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(testCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		creditControl.serviceTOS();
		action.getScreenShot(testCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void serviceROS() {
		testCase = "CreditControlTC_serviceROS";

		CreditControlService creditControl = new CreditControlService(action);

		creditControl.navigate();
		action.getScreenShot(testCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		creditControl.serviceROS();
		action.getScreenShot(testCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(testCase);
	}

	@Test(priority = 11)
	public static void serviceTOSVerifyAudit() {
		testCase = "CreditControlTC_serviceTOSVerifyAudit";

		CreditControlService creditControl = new CreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations services = new ServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(testCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		creditControl.serviceTOS();
		action.getScreenShot(testCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(testCase);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);

		services.navigate();
		action.getScreenShot(testCase);
		services.verifyServicesScreen();
		action.getScreenShot(testCase);
		services.verifyAudit();
		action.getScreenShot(testCase);
		services.verifyAuditTOSHistory();
		action.getScreenShot(testCase);
		assertEquals(services.ServiceStatus, "T");
	}

	@Test(priority = 12)
	public static void serviceROSVerifyAudit() {
		testCase = "CreditControlTC_serviceROSVerifyAudit";

		CreditControlService creditControl = new CreditControlService(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		DashBoard dashboard = new DashBoard(action);
		ServiceOperations services = new ServiceOperations(action);

		creditControl.navigate();
		action.getScreenShot(testCase);
		creditControl.searchWithServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		creditControl.serviceROS();
		action.getScreenShot(testCase);
		creditControl.verifyServiceStatus();
		action.getScreenShot(testCase);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(creditControlServiceNumber);
		action.getScreenShot(testCase);
		dashboard.verifyDashBoard("");
		action.getScreenShot(testCase);

		services.navigate();
		action.getScreenShot(testCase);
		services.verifyServicesScreen();
		action.getScreenShot(testCase);
		services.verifyAudit();
		action.getScreenShot(testCase);
		services.verifyAuditTOSHistory();
		action.getScreenShot(testCase);
		assertEquals(services.ServiceStatus, "W");
	}
}
