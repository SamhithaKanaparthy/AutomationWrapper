package com.liberate.automation.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class CloneServiceTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String cloneServiceNumber;
	static String department;
	static String site;
	static String salesperson;
	static String applicationsource;

	static Map<String, String> data = new HashedMap<>();

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();

		cloneServiceNumber = data.get("cloneServiceNumber");
		department = data.get("SalesDepartment");
		salesperson = data.get("salesperson");
		applicationsource = data.get("applicationsource");
		site = data.get("Site");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void cloneService() {
		testCase = "Clone Service";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations CS = new ServiceOperations(action);
		ExistingCustomer csprovisioning = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(cloneServiceNumber);
		action.getScreenShot(testCase);

		CS.navigate();
		action.getScreenShot(testCase);
		CS.verifyServicesScreen();
		action.getScreenShot(testCase);
		CS.cloneservice();
		action.getScreenShot(testCase);

		csprovisioning.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		csprovisioning.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(testCase);
		csprovisioning.processPricingPlanScreen();
		action.getScreenShot(testCase);
		csprovisioning.processServiceProductsScreen();
		action.getScreenShot(testCase);
		csprovisioning.processProductFieldsScreen();
		action.getScreenShot(testCase);
		csprovisioning.processISPFieldsScreen();
		action.getScreenShot(testCase);
		csprovisioning.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		csprovisioning.provideContractDetails();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);

		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
	}
}
