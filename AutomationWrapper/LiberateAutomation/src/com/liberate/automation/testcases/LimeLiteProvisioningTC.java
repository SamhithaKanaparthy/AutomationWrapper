package com.liberate.automation.testcases;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.core.ExcelDataDriver;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.CustomerServiceOrder;
import com.liberate.automation.pom.ExistingCustomer;
import com.liberate.automation.pom.LimeliteNewCustomer;
import com.liberate.automation.pom.NewCustomer;
import com.liberate.automation.pom.SalesSignOff;

public class LimeLiteProvisioningTC {
	
	
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static Map<String, String> dataMap = new HashedMap<>();

	static String SalesDepartment;
	static String GeneralDepartment;
	static String AccountsDepartment;
	static String PEL_PDL_LimeLitePackage;
	static String PDLServPackageLimelite;
	static String Site;
	static String PCLPostPaidServicePackage;
	
	/**
	 * Private constructor to disable creation of object
	 */
	private LimeLiteProvisioningTC() {
	}

	@BeforeClass
	public static void loadData() 
	{
		dataMap = ExcelDataDriver.loadData();

		SalesDepartment = dataMap.get("SalesDepartment");
		GeneralDepartment = dataMap.get("GeneralDepartment");
		AccountsDepartment = dataMap.get("AccountsDepartment");
		PEL_PDL_LimeLitePackage = dataMap.get("PEL_PDL_LimeLitePackage");
		PDLServPackageLimelite = dataMap.get("PDLServPackageLimelite");
		Site = dataMap.get("Site");
		PCLPostPaidServicePackage = dataMap.get("PCLPostPaidServicePackage");
		
	}

	
	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}
	
	
	@Test
	public static void limeLitePELandPDLNewResidential() 
	{
		LimeliteNewCustomer cust = new LimeliteNewCustomer(action);
		NewCustomer nc = new NewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		testCase = "limeLitePELandPDLNewResidential";

		cust.navigateLimeliteNewCustomer();
		action.getScreenShot(testCase);
		cust.serviceApplicationDetailspanel(CommonData.ApplicationForm.IndexFixedResidential, PEL_PDL_LimeLitePackage);
		action.getScreenShot(testCase);
		cust.click_ProceedButton();
		action.getScreenShot(testCase);
		cust.FillDetailsCustomerInfoPanel_PCLPostPELResidential();
		action.getScreenShot(testCase);
		cust.customerID();
		action.getScreenShot(testCase);
		cust.click_ProceedButton();
		action.getScreenShot(testCase);
		cust.customerInformation_FixedRes();
		action.getScreenShot(testCase);
		cust.addressDetails("test1", "test2", "test3");
		action.getScreenShot(testCase);
		cust.customerClassification_Details(CommonData.CustomerType.Residential);
		action.getScreenShot(testCase);
		cust.billingDetails();
		action.getScreenShot(testCase);
		cust.click_NextButton();
		action.getScreenShot(testCase);
		cust.fillContactDetails_Limelite();
		action.getScreenShot(testCase);
		cust.click_ConfirmButton();	
		action.getScreenShot(testCase);	
		assertTrue(nc.verifyCreatedAccount());
		action.getScreenShot(testCase);
		cust.applicationSourceSalesPerson_fill();
		action.getScreenShot(testCase);
		cust.clickOnProceedFromExistingCustScreen();
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.processServiceDetailsScreenLimelite("BOT", "BODD");
		action.getScreenShot(testCase);
		cust.clickOnProceedFromExistingCustScreen();
		action.getScreenShot(testCase);
		ce.provideADSL();
		action.getScreenShot(testCase);
		// PDL Part
		ce.selectPDLServicePackageLimelite(PDLServPackageLimelite);
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.processServiceDetailsScreenLimelite("BOT", "BODD");
		action.getScreenShot(testCase);
		ce.skipLinkedServices();
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.click_ChangeSite();
		action.getScreenShot(testCase);
		sso.changeSiteSelection(Site);
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);
		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
	
		}
	
	
	public static void limeLiteExistingCustomerPCLPostpaid() 
	{
		LimeliteNewCustomer cust = new LimeliteNewCustomer(action);
		ExistingCustomer ce = new ExistingCustomer(action);
		SalesSignOff sso = new SalesSignOff(action);
		CustomerServiceOrder cso = new CustomerServiceOrder(action);

		testCase = "limeLiteExistingCustomerPCLPostpaid";
		
		ce.navigateToLimeLiteExistingCustomerScreen();
		ce.searchWithAccount("220002260000");
		ce.selectServicePackageLimelite(PCLPostPaidServicePackage);
		cust.applicationSourceSalesPerson_fill();
//		ce.selectDepartmentSite("AQSAL", "ANSQ");
		action.getScreenShot(testCase);
		cust.clickOnProceedFromExistingCustScreen();
		action.getScreenShot(testCase);
//		ce.selectServicePackage("PCL", "SOW-");
		ce.limeLiteExistingCustomerInitialScreen();
		action.getScreenShot(testCase);
		ce.processPricingPlanScreen();
		action.getScreenShot(testCase);
		ce.processServiceProductsScreen();
		action.getScreenShot(testCase);
		ce.processProductFieldsScreen();
		action.getScreenShot(testCase);
		ce.processISPFieldsScreen();
		action.getScreenShot(testCase);
		ce.processServiceDetailsScreenLimelite("MSCA", "SMPO");
		action.getScreenShot(testCase);
		ce.skipLinkedServices();
		action.getScreenShot(testCase);
		ce.provideContractDetails();
		action.getScreenShot(testCase);
		assertTrue(sso.verifySalesSignOff());
		action.getScreenShot(testCase);
		sso.click_ChangeSite();
		action.getScreenShot(testCase);
		sso.changeSiteSelection(Site);
		action.getScreenShot(testCase);
		sso.signOff();
		action.getScreenShot(testCase);
		cso.getSONumber();
		action.getScreenShot(testCase);
		cso.getSOCommand();
		action.getScreenShot(testCase);
	
	}		
		
	}

	
	

