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
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.ServiceOperations;
import com.liberate.automation.pom.ServiceProductsTab;

public class CountofServiceProductsTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String CountofServiceProducts;
	static Map<String, String> data = new HashedMap<>();

	private CountofServiceProductsTC() {
	}

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		CountofServiceProducts = data.get("CountofServiceProducts");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void countofproducts() {
		testCase = "Count of Service products";

		ServiceProductsTab countproducts = new ServiceProductsTab(action);
		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations CS = new ServiceOperations(action);

		search.navigate();
		search.searchByServiceNumber(CountofServiceProducts);
		action.getScreenShot(testCase);

		CS.navigate();
		action.getScreenShot(testCase);
		CS.verifyServicesScreen();
		action.getScreenShot(testCase);
		CS.navigateToProductsScreen();
		CS.verifyServicesScreen();

		countproducts.countofproducts();
		action.getScreenShot(testCase);
	}

}
