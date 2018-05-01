package com.liberate.automation.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.CRAccountPricingPlans;
import com.liberate.automation.pom.CRAdjustments;
import com.liberate.automation.pom.CRBills;
import com.liberate.automation.pom.CRCustomerDetails;
import com.liberate.automation.pom.CRCustomerSearch;
import com.liberate.automation.pom.DashBoard;
import com.liberate.automation.pom.ServiceCharges;

/***
 * Class with Customer Enquiry Test Case
 * 
 * 
 *
 */
public class CustomerEnquiryTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	public static String accountNumber;
	public static String surName;
	public static String pricingPlanAccount;

	/**
	 * Private constructor to disable creation of object
	 */
	private CustomerEnquiryTC() {
	}

	@BeforeClass
	public static void loadData() {
		accountNumber = TestData.accountNumber;
		surName = TestData.surName;
		pricingPlanAccount = TestData.pricingPlanAccount;
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 1)
	public static void verifyCustomerEnquiry() {
		testCase = "CustomerEnquiryTC_verifyCustomerEnquiry";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		DashBoard cd = new DashBoard(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);
		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDashBoard(accountNumber);
		action.getScreenShot(testCase);
	}

	@Test
	public static void customerEnquiryWithID() {
		testCase = "CustomerEnquiryTC_customerEnquiryWithID";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		DashBoard cd = new DashBoard(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByID("NI", "FN9ONJ2S3RPN ");
		action.getScreenShot(testCase);
		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDashBoard("");
		action.getScreenShot(testCase);
	}

	@Test
	public static void customerEnquiryWithSurname() {
		testCase = "CustomerEnquiryTC_customerEnquiryWithSurname";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		DashBoard cd = new DashBoard(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchBySurname(surName);
		action.getScreenShot(testCase);
		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDashBoard("");
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void amendAccountDetails() {
		testCase = "CustomerEnquiryTC_amendAccountDetails";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		DashBoard cd = new DashBoard(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);
		cd.navigate();
		action.getScreenShot(testCase);
		cd.verifyDashBoard(accountNumber);
		action.getScreenShot(testCase);

		cd.amendAccount();
		action.getScreenShot(testCase);
		cd.verifyDashBoard(accountNumber);
		action.getScreenShot(testCase);
	}

	@Test(priority = 3)
	public static void amendDayOfBilling() {
		testCase = "CustomerEnquiryTC_amendDayOfBilling";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRCustomerDetails cu = new CRCustomerDetails(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber("260002330000");
		action.getScreenShot(testCase);

		cu.navigate();
		action.getScreenShot(testCase);
		cu.validateGeneralDetails();
		action.getScreenShot(testCase);
		cu.amendDayOfBilling();
		action.getScreenShot(testCase);
		cu.validatedayOfBilling();
		action.getScreenShot(testCase);
	}

	@Test
	public static void raiseAdjustment() {
		testCase = "CustomerEnquiryTC_raiseAdjustment";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAdjustments ad = new CRAdjustments(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);

		ad.navigate();
		action.getScreenShot(testCase);
		ad.raiseAjustment();
		action.getScreenShot(testCase);
		ad.verifyRaiseAdjustment();
		action.getScreenShot(testCase);
	}

	@Test
	public static void verifyAdjustment() {
		testCase = "CustomerEnquiryTC_verifyAdjustment";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAdjustments ad = new CRAdjustments(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);

		ad.navigate();
		action.getScreenShot(testCase);
		ad.verifyAdjustmenst();
		action.getScreenShot(testCase);
	}

	@Test
	public static void addServiceCharge() {
		testCase = "CustomerEnquiryTC_addServiceCharge";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		ServiceCharges ad = new ServiceCharges(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);

		ad.navigate();
		action.getScreenShot(testCase);
		ad.addServiceCharge();
		action.getScreenShot(testCase);
		ad.verifyRaisedServiceCharge();
		action.getScreenShot(testCase);
	}

	@Test
	public static void verifySericeChargeServiceNumber() {
		testCase = "CustomerEnquiryTC_verifySericeChargeServiceNumber";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		ServiceCharges ad = new ServiceCharges(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);

		ad.navigate();
		action.getScreenShot(testCase);
		ad.searchWithServiceNumber();
		action.getScreenShot(testCase);
		ad.verifyServiceCharge();
		action.getScreenShot(testCase);
	}

	@Test
	public static void verifySericeChargeAccount() {
		testCase = "CustomerEnquiryTC_verifySericeChargeAccount";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		ServiceCharges ad = new ServiceCharges(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(accountNumber);
		action.getScreenShot(testCase);

		ad.navigate();
		action.getScreenShot(testCase);
		ad.verifyServiceCharge();
		action.getScreenShot(testCase);
	}

	@Test
	public static void verifyBills() {
		// Should be executed in S10
		testCase = "CustomerEnquiryTC_verifyBills";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRBills cb = new CRBills(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber("150303960000");
		action.getScreenShot(testCase);

		cb.navigate();
		action.getScreenShot(testCase);
		cb.verifyBill();
		action.getScreenShot(testCase);
	}

	@Test
	public static void addNominatedNumPricingPlan() {
		testCase = "CustomerEnquiryTC_addNominatedNumPricingPlan";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAccountPricingPlans cp = new CRAccountPricingPlans(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(pricingPlanAccount);
		action.getScreenShot(testCase);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.searchPricingPlan("AC+NN");
		action.getScreenShot(testCase);
		cp.addPricingPlan();
		action.getScreenShot(testCase);
		cp.validatePricingPlan();
		action.getScreenShot(testCase);
	}

	@Test
	public static void addCUGPricingPlan() {
		testCase = "CustomerEnquiryTC_addCUGPricingPlan";

		CRCustomerSearch cr = new CRCustomerSearch(action);
		CRAccountPricingPlans cp = new CRAccountPricingPlans(action);

		cr.navigate();
		action.getScreenShot(testCase);
		cr.searchByAccountNumber(pricingPlanAccount);
		action.getScreenShot(testCase);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.searchPricingPlan("CUG");
		action.getScreenShot(testCase);
		cp.addPricingPlan();
		action.getScreenShot(testCase);
		cp.validatePricingPlan();
		action.getScreenShot(testCase);
	}
}
