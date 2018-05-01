package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.DepositRequirement;
import com.liberate.automation.pom.PYBadCheckProcessing;
import com.liberate.automation.pom.PYBatchPayment;
import com.liberate.automation.pom.PYPOSPayment;
import com.liberate.automation.pom.PYSinglePayment;
import com.liberate.automation.pom.PYVoidPayment;

/***
 * Class with Payment Test Cases
 * 
 * 
 *
 */
public class PaymentsTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static Map<String, String> data = new HashedMap<>();
	static String badChequePaymentNumber = "";

	/**
	 * Private constructor to disable creation of object
	 */
	private PaymentsTC() {
	}

	@BeforeClass
	public static void loadData() {
		data = ExcelDataDriver.loadData();
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 3)
	public static void batchPayment() {
		testCase = "PaymentsTC_batchPayment";

		ArrayList<String> accountNumber = new ArrayList<String>();

		accountNumber.add("260002230000");
		accountNumber.add("260002260000");
		accountNumber.add("260002270000");

		PYBatchPayment bp = new PYBatchPayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		bp.navigate();
		action.getScreenShot(testCase);
		bp.providePaymentDetails(accountNumber);
		action.getScreenShot(testCase);
	}

	@Test(priority = 1)
	public static void verifyCashDrawer() {
		testCase = "PaymentsTC_verifyCashDrawer";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH6");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.verifyCashDrawer();
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void singlePaymentAccountNumber() {
		testCase = "PaymentsTC_singlePaymentAccountNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot(testCase);
		sp.doSinglePayment("10.00");
		action.getScreenShot(testCase);
		sp.verifySuccessMessage();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void depositPaymentAccountNumber() {
		testCase = "PaymentsTC_depositPaymentAccountNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.searchWithAccountNumber("260002230000");
		action.getScreenShot(testCase);
		sp.doDepositPayment("10.00");
		action.getScreenShot(testCase);
		sp.verifySuccessMessage();
		action.getScreenShot(testCase);
	}

	@Test(priority = 3)
	public static void singlePaymentServicetNumber() {
		testCase = "PaymentsTC_singlePaymentServicetNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.searchWithServiceNumber("4747623");
		action.getScreenShot(testCase);
		sp.doSinglePayment("10.00");
		action.getScreenShot(testCase);
		sp.verifySuccessMessage();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void depositPaymentServiceNumber() {
		testCase = "PaymentsTC_depositPaymentServiceNumber";

		PYSinglePayment sp = new PYSinglePayment(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.searchWithServiceNumber("556166");
		action.getScreenShot(testCase);
		sp.doDepositPayment("10.00");
		action.getScreenShot(testCase);
		sp.verifySuccessMessage();
		action.getScreenShot(testCase);
	}

	@Test(priority = 4)
	public static void payAndRefundDeposit() {
		testCase = "PaymentsTC_payAndRefundDeposit";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		DepositRequirement cd = new DepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYSinglePayment sp = new PYSinglePayment(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot(testCase);

		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(testCase);
		cd.addNewDepositRequirement("10.00");
		action.getScreenShot(testCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(testCase);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH4");
		action.getScreenShot(testCase);

		sp.navigate();
		action.getScreenShot(testCase);
		sp.searchWithAccountNumber("260002280000");
		action.getScreenShot(testCase);
		sp.doDepositPayment("10.00");
		action.getScreenShot(testCase);
		sp.verifySuccessMessage();
		action.getScreenShot(testCase);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot(testCase);

		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(testCase);
		cd.refundDeposit("10.00");
		action.getScreenShot(testCase);
	}

	@Test
	public static void voidPayment() {
		testCase = "VoidPayments_voidPayment";

		PYVoidPayment vp = new PYVoidPayment(action);

		assertEquals(vp.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(vp.PaymentNumber("9320148"), true);
		action.getScreenShot(testCase);
		assertEquals(vp.Search(), true);
		action.getScreenShot(testCase);
		assertEquals(vp.EnterVoidReason("3"), true);
		assertEquals(vp.Accept(), true);
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void depostitPaymentPOS() {
		testCase = "PaymentsTC_depostitPaymentPOS";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		DepositRequirement cd = new DepositRequirement(action);
		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYPOSPayment pos = new PYPOSPayment(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber("260002280000");
		action.getScreenShot(testCase);

		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(testCase);
		cd.addNewDepositRequirement("10.00");
		action.getScreenShot(testCase);
		cd.verifyDepositRequirement();
		action.getScreenShot(testCase);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH2");
		action.getScreenShot(testCase);

		pos.navigate();
		action.getScreenShot(testCase);
		pos.navigateToPOS();
		action.getScreenShot(testCase);

		pos.closePOSWindow();
		action.getScreenShot(testCase);
	}

	@Test(enabled = false)
	public static void paymentPOS() {
		testCase = "PaymentsTC_paymentPOS";

		BrowseServiceOrder bso = new BrowseServiceOrder(action);
		PYPOSPayment pos = new PYPOSPayment(action);

		bso.navigate();
		action.getScreenShot(testCase);
		bso.selectDepartment("CASH");
		action.getScreenShot(testCase);

		pos.navigate();
		action.getScreenShot(testCase);
		pos.navigateToPOS();
		action.getScreenShot(testCase);
		pos.searchWithAccountNumber("260002270000");
		action.getScreenShot(testCase);
		pos.POSPayment();
		action.getScreenShot(testCase);
	}

	@Test
	public static void badCheckProcessing() {
		testCase = "BadChequeProcessing_badCheckProcessing";

		PYBadCheckProcessing bcp = new PYBadCheckProcessing(action);

		assertEquals(bcp.navigate(), true);
		action.getScreenShot(testCase);
		assertEquals(bcp.SearchWithPaymentNumber(badChequePaymentNumber), true);
		action.getScreenShot(testCase);
		assertEquals(bcp.openChequeDetails(), true);
		action.getScreenShot(testCase);
		assertEquals(bcp.provideChequeCardDetails(), true);
		action.getScreenShot(testCase);
		assertEquals(bcp.acceptBadChequeProcessing(), true);
		action.getScreenShot(testCase);
	}
}
