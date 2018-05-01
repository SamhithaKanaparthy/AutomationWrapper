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
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ProvideSetTopBox;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

public class ProvideSetTopBoxTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String setTopBoxService;
	static String setTopBoxProduct;
	static String SalesDepartment;
	static String Site;

	static Map<String, String> data = new HashedMap<>();

	/**
	 * Private constructor to disable creation of object
	 */
	private ProvideSetTopBoxTC() {
	}

	@BeforeClass
	public void loadData() {
		data = ExcelDataDriver.loadData();

		setTopBoxService = data.get("setTopBoxService");
		setTopBoxProduct = data.get("setTopBoxProduct");
		SalesDepartment = data.get("SalesDepartment");
		Site = data.get("Site");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void provideSetTopBox() {
		testCase = "provideSetTopBox";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		ProvideSetTopBox setTopBox = new ProvideSetTopBox(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder order = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(setTopBoxService);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);
		service.clickOnProvideSetTopBox();
		action.getScreenShot(testCase);

		setTopBox.selectDeptSite(SalesDepartment, Site);
		action.getScreenShot(testCase);
		setTopBox.clickonProceed();
		action.getScreenShot(testCase);
		setTopBox.allocateMACAddress(setTopBoxProduct);
		action.getScreenShot(testCase);
		setTopBox.clickonAccept();
		action.getScreenShot(testCase);

		sales.verifySalesSignOff();
		action.getScreenShot(testCase);
		sales.signOff();
		action.getScreenShot(testCase);

		order.getSONumber();
		action.getScreenShot(testCase);
		order.getSOCommand();
		action.getScreenShot(testCase);
	}
}
