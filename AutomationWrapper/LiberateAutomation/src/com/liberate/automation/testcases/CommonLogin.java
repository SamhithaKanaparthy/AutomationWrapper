package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.Login;

/***
 * Class with Login funttionality
 * 
 * 
 *
 */
public class CommonLogin {
	public static TestActions action = new TestActions();

	public static String userName = "";
	public static String passWord = "";
	public static String autURL = "";

	public static void loadData() {
		userName = TestData.userName;
		passWord = TestData.passWord;
		autURL = TestData.autURL;
	}

	@BeforeSuite
	public static void login() {
		TestData.loadTestData();

		CommonLogin.loadData();

		action.gotoURL(autURL);

		Login login = new Login(action);

		assertEquals(login.login(userName, passWord), true);
	}

	public static void logout() {
		Login login = new Login(action);
		login.logout();
	}

	/**
	 * Private constructor to disable creation of object
	 */
	private CommonLogin() {
	}

	@AfterSuite
	public static void endTesting() {
		action.closeTab();
		action.quit();
		action = null;
	}
}
