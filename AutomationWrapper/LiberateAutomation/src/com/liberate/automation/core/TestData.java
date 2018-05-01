package com.liberate.automation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/***
 * Class that has all the test data.
 * 
 * 
 *
 */
public class TestData {

	public static String queryNumber = "";
	public static String faultNumber = "";
	public static String userName = "";
	public static String passWord = "";
	public static String autURL = "";
	public static String creditControlServiceNumber = "";
	public static String employeeID = "";
	public static String switchRequestTime = "";
	public static String switchRequestAccountNumber = "";
	public static String badChequePaymentNumber = "";
	public static String networkDepartment = "";
	public static String generalDepartment = "";
	public static String accountDepartment = "";
	public static String accountNumber = "";
	public static String salesDepartment = "";
	public static String site = "";
	public static String transferToAccount = "";
	public static String transferFromAccount = "";
	public static String suspendedService = "";
	public static String serviceASNCease = "";
	public static String serviceCease = "";
	public static String surName = "";
	public static String pricingPlanAccount = "";
	public static String employeeUserName = "";
	public static String newUserID = "";
	public static String arnServiceNumber = "";

	static String FileName = "TestData.properties";

	static Properties properties = new Properties();

	@SuppressWarnings("unused")
	private static void saveData(String dataName, String data) {
		properties.setProperty("queryNumber", queryNumber);
		properties.setProperty("faultNumber", faultNumber);
		properties.setProperty("userName", userName);
		properties.setProperty("passWord", passWord);
		properties.setProperty("autURL", autURL);
		properties.setProperty("creditControlServiceNumber", creditControlServiceNumber);
		properties.setProperty("employeeID", employeeID);
		properties.setProperty("switchRequestTime", switchRequestTime);
		properties.setProperty("switchRequestAccountNumber", switchRequestAccountNumber);
		properties.setProperty("badChequePaymentNumber", badChequePaymentNumber);
		properties.setProperty("networkDepartment", networkDepartment);
		properties.setProperty("generalDepartment", generalDepartment);
		properties.setProperty("accountDepartment", accountDepartment);
		properties.setProperty("accountNumber", accountDepartment);
		properties.setProperty("salesDepartment", accountDepartment);
		properties.setProperty("site", accountDepartment);
		properties.setProperty("transferToAccount", transferToAccount);
		properties.setProperty("transferFromAccount", transferFromAccount);
		properties.setProperty("suspendedService", suspendedService);
		properties.setProperty("serviceASNCease", serviceASNCease);
		properties.setProperty("serviceCease", serviceCease);
		properties.setProperty("surName", surName);
		properties.setProperty("pricingPlanAccount", pricingPlanAccount);
		properties.setProperty("employeeUserName", employeeUserName);
		properties.setProperty("newUserID", newUserID);
		properties.setProperty("arnServiceNumber", arnServiceNumber);

		try {
			properties.store(new FileOutputStream(FileName), null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * Method to retrieve Data
	 * 
	 * @param dataName
	 *            Name of the data to be retrieved
	 * @return Data as string
	 */
	private static String getData(String dataName) {
		try {
			properties.load(new FileInputStream(FileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data = properties.getProperty(dataName);

		System.out.println(dataName + " : " + data);

		return data;
	}

	/***
	 * Method to load TestData
	 */
	public static void loadTestData() {
		queryNumber = getData("queryNumber");
		faultNumber = getData("faultNumber");
		userName = getData("userName");
		passWord = getData("passWord");
		autURL = getData("autURL");
		creditControlServiceNumber = getData("creditControlServiceNumber");
		employeeID = getData("employeeID");
		switchRequestTime = getData("switchRequestTime");
		switchRequestAccountNumber = getData("switchRequestAccountNumber");
		badChequePaymentNumber = getData("badChequePaymentNumber");
		networkDepartment = getData("networkDepartment");
		generalDepartment = getData("generalDepartment");
		accountDepartment = getData("accountDepartment");
		accountNumber = getData("accountNumber");
		salesDepartment = getData("salesDepartment");
		site = getData("site");
		transferToAccount = getData("transferToAccount");
		transferFromAccount = getData("transferFromAccount");
		suspendedService = getData("suspendedService");
		serviceASNCease = getData("serviceASNCease");
		serviceCease = getData("serviceCease");
		surName = getData("surName");
		pricingPlanAccount = getData("pricingPlanAccount");
		employeeUserName = getData("employeeUserName");
		newUserID = getData("newUserID");
		arnServiceNumber = getData("arnServiceNumber");
	}
}
