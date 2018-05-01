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
import com.liberate.automation.pom.CeaseMultipleServices;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class CeaseMultipleServicesTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;
	
	static String ceasemultipleserviceaccount;
	
	static String department;
	static String site;
	static String salesperson;
	static String applicationsource;
	
	static Map<String, String> data = new HashedMap<>();
	
	private CeaseMultipleServicesTC() {
	}

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		ceasemultipleserviceaccount = data.get("ceasemultipleserviceaccount");
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
	public static void testmultiplecease() {
		testCase = "Cease Multiple Services";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations CS = new ServiceOperations(action);
		ExistingCustomer ceasemultipleServices= new ExistingCustomer(action);
		CeaseMultipleServices CMS = new CeaseMultipleServices(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByAccountNumber(ceasemultipleserviceaccount);
		action.getScreenShot(testCase);

		CS.navigate();
		action.getScreenShot(testCase);
		CS.verifyServicesScreen();
		action.getScreenShot(testCase);
		CS.ceasemultipleservices();
		action.getScreenShot(testCase);

		ceasemultipleServices.selectDepartmentSite(department, site);
		ceasemultipleServices.selectsalesperson_multicease();
		action.getScreenShot(testCase);
		CMS.selectservicesandaccept();
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
