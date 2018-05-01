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
import com.liberate.automation.pom.AlterProduct;
import com.liberate.automation.pom.AlterSIMCard;
import com.liberate.automation.pom.AmendProductISPFields;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.SalesSignOff;
import com.liberate.automation.pom.ServiceOperations;

/***
 * Class contains all Alter Service Test Cases
 * 
 * 
 *
 */
public class AlterServiceTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String alterSIMService;
	static String department;
	static String site;
	static String ispSerciceNumber;
	static String ispUsername;

	static Map<String, String> data = new HashedMap<>();

	/**
	 * Private constructor to disable creation of object
	 */
	private AlterServiceTC() {
	}

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
		alterSIMService = data.get("alterSIMService");
		department = data.get("SalesDepartment");
		site = data.get("Site");
		ispSerciceNumber = data.get("ispSerciceNumber");
		ispUsername = data.get("ispUsername");
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void alterSIMCard() {
		testCase = "Alter SIM Card";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterSIMCard alterSim = new AlterSIMCard(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder order = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(alterSIMService);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);
		service.alterSIMCard();
		action.getScreenShot(testCase);

		alterSim.selectDepartmentSite(department, site);
		action.getScreenShot(testCase);
		alterSim.updateSIMCard();
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

	@Test
	public static void amendProductISPField() {
		testCase = "Amend Product ISP fields";

		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AmendProductISPFields amendISP = new AmendProductISPFields(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber(ispSerciceNumber);
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);
		service.navigateToProductsScreen();
		action.getScreenShot(testCase);

		amendISP.clickOnProductRecord();
		amendISP.enterdatatoUsernamePwd(ispUsername);
		action.getScreenShot(testCase);
		amendISP.clickOnAccept();
		action.getScreenShot(testCase);
		action.scrollDown();
		amendISP.validate_output(ispUsername);
		action.getScreenShot(testCase);
	}

	@Test
	public static void alterProducts() {
		testCase = "alterProduct";
		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		AlterProduct alterProduct = new AlterProduct(action);
		SalesSignOff sales = new SalesSignOff(action);
		CustomerServiceOrder order = new CustomerServiceOrder(action);

		search.navigate();
		action.getScreenShot(testCase);
		search.searchByServiceNumber("");
		action.getScreenShot(testCase);

		service.navigate();
		action.getScreenShot(testCase);
		service.verifyServicesScreen();
		action.getScreenShot(testCase);
		service.alterProduct();
		action.getScreenShot(testCase);

		alterProduct.selectDepartmentSite("AQSAL", "ANSQ");
		alterProduct.alterProductScreen();
		alterProduct.alterProductScreen();

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
