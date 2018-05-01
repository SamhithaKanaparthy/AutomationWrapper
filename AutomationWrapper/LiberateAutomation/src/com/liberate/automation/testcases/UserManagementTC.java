package com.liberate.automation.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.core.TestResult;
import com.liberate.automation.pom.MaintainEmployee;
import com.liberate.automation.pom.ManageUser;

/***
 * Class with all User Management Test Cases
 * 
 * 
 *
 */
public class UserManagementTC {
	static TestActions action = CommonLogin.action;
	static String testCase;
	static String testStatus;

	static String employeeUserName = "";
	static String newUserID = "";

	/**
	 * Private constructor to disable creation of object
	 */
	private UserManagementTC() {
	}

	@BeforeClass
	public static void loadData() {
		employeeUserName = TestData.employeeUserName;
		newUserID = TestData.newUserID;
	}

	@AfterMethod
	public static void logTestResult(ITestResult result) {
		TestResult.processTestResult(testCase, result);
	}

	@Test(priority = 1)
	public static void amendUser() {
		testCase = "UserManagementTC_amendUser";

		ManageUser adm = new ManageUser(action);

		adm.navigate();
		action.getScreenShot(testCase);
		adm.searchByUserName(employeeUserName);
		action.getScreenShot(testCase);
		adm.amendUser();
		action.getScreenShot(testCase);
		adm.verifyUserDetails();
		action.getScreenShot(testCase);
	}

	@Test(priority = 2)
	public static void copyUser() {
		testCase = "UserManagementTC_copyUser";

		ManageUser adm = new ManageUser(action);

		adm.navigate();
		action.getScreenShot(testCase);
		adm.searchByUserName(employeeUserName);
		action.getScreenShot(testCase);
		adm.copyUser("99999");
		action.getScreenShot(testCase);
		adm.verifyCopyUser();
		action.getScreenShot(testCase);
		adm.verifyUserDetails();
		action.getScreenShot(testCase);
	}

	@Test(priority = 3)
	public static void createUser() {
		testCase = "UserManagementTC_createUser";

		ManageUser adm = new ManageUser(action);
		MaintainEmployee ade = new MaintainEmployee(action);

		ade.navigate();
		ade.searchWithStaffNumber(newUserID);
		ade.createNewEmployee();

		adm.navigate();
		action.getScreenShot(testCase);
		adm.searchByUserName("");
		action.getScreenShot(testCase);
		adm.createUser(ade.EmployeeID, ade.VMSUserName);
		action.getScreenShot(testCase);
		adm.verifyUserDetails();
		action.getScreenShot(testCase);
	}

	@Test(priority = 4)
	public static void deleteUser() {
		testCase = "UserManagementTC_deleteUser";

		ManageUser adm = new ManageUser(action);

		adm.navigate();
		action.getScreenShot(testCase);
		adm.searchByUserIS(newUserID);
		action.getScreenShot(testCase);
		adm.deleteUser();
		action.getScreenShot(testCase);
		adm.verifyDelete();
		action.getScreenShot(testCase);
	}

}
