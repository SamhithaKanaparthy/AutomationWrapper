package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.AlterLineProduct;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class AlterLineProductTC {

	static TestActions action = CommonLogin.action;

	static String TestCase;
	static String TestStatus;

	static Map<String, String> data = new HashedMap<>();
	static String alterlineproductServiceNumber;

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();

		alterlineproductServiceNumber = data.get("alterProductServiceNumber");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		ReportGenerator.generateReport(TestCase);
		TestStatus = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";

		TestActions.log("Test Status : " + TestStatus);
		TestActions.log("*****COMPLETED '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void alterProducts() {
		TestCase = "alterProduct";
		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterLineProduct alterlineproduct = new AlterLineProduct(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder order = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber(alterlineproductServiceNumber);
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);
		service.alterProduct();
		action.getScreenShot(TestCase);

		alterlineproduct.selectDepartmentSite("AQSAL", "ANSQ");

		sales.verifySalesSignOff();
		action.getScreenShot(TestCase);
		sales.signOff();
		action.getScreenShot(TestCase);

		order.getSONumber();
		action.getScreenShot(TestCase);
		order.getSOCommand();
		action.getScreenShot(TestCase);

	}
}