package com.liberate.automation.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.AddMore;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.NewCustomer;
import com.liberate.automation.pom.SalesSignOff;

/***
 * Class with Service Provisioning Test Cases
 * 
 * 
 *
 */
public class ServiceProvisioningTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String arnServiceNumber = "";

	/**
	 * Private constructor to disable creation of object
	 */
	ServiceProvisioningTC() {
	}

	@BeforeClass
	public static void loadData() {
		arnServiceNumber = TestData.arnServiceNumber;
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test
	public static void newCustomerPEL() {
		testCase = "ServiceProvisioningTC_newCustomerPEL";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
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

	@Test
	public static void existingCustomerPEL() {
		testCase = "ServiceProvisioningTC_existingCustomerPEL";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
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

	@Test
	public static void existingCustomerPCLPostpaid() {
		testCase = "ServiceProvisioningTC_existingCustomerPCLPostpaid";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		// ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void newCustomerPCLPostpaid() {
		testCase = "ServiceProvisioningTC_newCustomerPCLPostpaid";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PCL", "LIME_POST");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void newCustomerPCLCreditLimit() {
		testCase = "ServiceProvisioningTC_newCustomerPCLCreditLimit";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PCL", "LIME_POST");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());

		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void existingCustomerPDL() {
		testCase = "ServiceProvisioningTC_existingCustomerPDL";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void existingCustomerPTV() {
		testCase = "ServiceProvisioningTC_existingCustomerPTV";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PTV - ", "CableTV");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void existingCustomerIPTV() {
		testCase = "ServiceProvisioningTC_existingCustomerIPTV";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PTI - ", "IPTVBasic");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test(enabled = false)
	public static void existingCustomerARN() {
		testCase = "ServiceProvisioningTC_existingCustomerARN";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("260002270000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectNonPackage("ARN");
		action.getScreenShot(testCase);

		ce.processServiceNoScreen(arnServiceNumber);
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void newCustomerPELandPDL() {
		testCase = "ServiceProvisioningTC_newCustomerPELandPDL";

		NewCustomer cp = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		cp.navigate();
		action.getScreenShot(testCase);
		cp.fillApplicationDetails(CommonData.ApplicationForm.FixedResidential, CommonData.CustomerType.Residential,
				"PEL", "ETFT");
		action.getScreenShot(testCase);

		cp.fillResidentialCustomerDetails();
		action.getScreenShot(testCase);
		cp.fillStandardAddress();
		action.getScreenShot(testCase);
		cp.fillCustomerClassification();
		action.getScreenShot(testCase);
		cp.fillBillingDetails();
		action.getScreenShot(testCase);
		cp.fillCustomerID();
		action.getScreenShot(testCase);
		cp.fillContactDetails();
		action.getScreenShot(testCase);
		assertTrue(cp.verifyCreatedAccount());
		action.getScreenShot(testCase);

		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.provideADSL();
		action.getScreenShot(testCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void addMorePELandPDL() {
		testCase = "ServiceProvisioningTC_addMorePELandPDL";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("BGSAL", "BUSG");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.addMore();
		action.getScreenShot(testCase);

		addmore.addADSL();
		action.getScreenShot(testCase);

		// PDL Part
		ce.selectServicePackage("PDL", "ADSL_PACK");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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

	@Test
	public static void addMorePELandPCL() {
		testCase = "ServiceProvisioningTC_addMorePELandPCL";

		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);
		AddMore addmore = new AddMore(action);

		ce.navigate();
		action.getScreenShot(testCase);
		ce.searchWithAccount("280000710000");
		action.getScreenShot(testCase);
		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		ce.selectServicePackage("PEL", "ETFT");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		ce.skipADSL();
		action.getScreenShot(testCase);

		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.addMore();
		action.getScreenShot(testCase);

		addmore.addServicePackage();
		action.getScreenShot(testCase);

		action.getScreenShot(testCase);
		ce.selectServicePackage("PCL", "LIME_POST");
		// ce.selectServicePackage("PCL", "SOW-");
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.provideServiceDetailsScreen("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.provideContractDetails();
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
