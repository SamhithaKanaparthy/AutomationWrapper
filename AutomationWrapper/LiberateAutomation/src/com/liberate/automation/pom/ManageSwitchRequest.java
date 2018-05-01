package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class ManageSwitchRequest {
	TestActions action = null;

	// Data
	public String monitorSwitchReq_Status = "";

	// Page Elements : Column Headers
	By ManageSwitchRequest_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Query Switch Request']");
	By MonitorNewSwitchRequests_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Monitor New Switch Requests']");
	By FailureQueries_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Failure Queries']");
	By SwitchRequestSummary_ColumnHeader = By
			.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Switch Request Summary']");
	By SwitchRequestSummaryDetails_ColumnHeader = By.xpath(
			"//div[@class='icePnlClpsbl icePnlClpsblDM']/descendant::*[text()='Switch Request Summary Details']");

	// Page Elements : Input Fields
	By QuerySwitchRequestDropdown = By.xpath("//*[text()='Query Switch Request:']/following::select");

	// Page Elements : Monitor New Switch Request
	By EmployeeNameID_Input = By.xpath("//*[text()='Employee Name / ID:']/following::input[1]");
	By EmployeeNameID_SearchButton = By.xpath("//*[text()='Employee Name / ID:']/following::input[@type='image']");
	By EmployeeNameID_DropDown = By.xpath("//*[text()='Employee Name / ID:']/following::select[1]");
	By UpdatedWithinLast_Input = By.xpath("//*[text()='Updated within last:']/following::input[1]");
	By Status_DropDown = By.xpath("(//*[text()[contains(.,'Status')]]/following::select)[1]");

	// Page Elements : Failure Queries

	// Page Elements : Query by Acct, Service Order, Service or Command
	By AccountNumber_Input = By.xpath("//*[text()='Account Number:']/following::input[1]");
	By ServiceOrderNumber_Input = By.xpath("//*[text()='Service Order Number:']/following::input[1]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service Number']/following::input[1]");
	By CommandNumber_Input = By.xpath("//*[text()='Command Number']/following::input[1]");

	// Page Elements : General Query on New Requests
	By Status = By.xpath("//*[text()[contains(.,'Status')]]/following::select[1]");

	// Page Elements : Command Buttons
	By SearchButton = By.xpath("//input[@value='Search']");
	By ResetButon = By.xpath("//input[@value='Reset']");

	// Page Elements : Common
	By SwitchReqSummaryColmn = By.xpath("//tr[contains(@id,'mangeSwitchRequestForm:switch_row')]");
	By SwitchID_DropDown = By.xpath("//*[text()[contains(.,'Switch ID')]]/following::select[1]");
	By Region_DropDown = By.xpath("(//*[text()[contains(.,'Region')]]/following::select)[1]");
	By DepartmentCode_DropDown = By.xpath("(//*[text()[contains(.,'Department Code')]]/following::select)[1]");
	By TargetExchangeID_DropDown = By.xpath("(//*[text()[contains(.,'Target Exch ID')]]/following::select)[1]");
	By StartDate_Input = By.xpath("//*[text()[contains(.,'Start Date')]]/following::input[1]");
	By EndDate_Input = By.xpath("//*[text()[contains(.,'End Date')]]/following::input[1]");

	/***
	 * Default constructor that takes TestAction object as argument.
	 * 
	 * @param action
	 *            The TestAction class object, which will be used to run test
	 *            steps
	 */
	public ManageSwitchRequest(TestActions action) {
		this.action = action;
	}

	/***
	 * The method to navigate to Manage Switch Request screen
	 * 
	 * @return Returns true if able to navigate, else will return false.
	 */
	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.SwitchRequests, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.SwitchRequests);

		return passed;
	}

	/***
	 * Method to select Monitor New Switch Requests Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean selectMonitorNewSwitchRequests() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.selectBy(QuerySwitchRequestDropdown, "Monitor New Switch Requests");

		return passed;
	}

	/***
	 * Method to select Failure Queries Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean selectFailureQueries() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.selectBy(QuerySwitchRequestDropdown, "Failure Queries");

		return passed;
	}

	/***
	 * Method to select Query by Acct, Service Order, Service or Command
	 * Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean selectQuerybyAcctServiceOrderServiceCommand() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.selectBy(QuerySwitchRequestDropdown, "Query by Acct, Service Order, Service or Command");

		return passed;
	}

	/***
	 * Method to select General Query on New Requests Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean selectGeneralQueryOnNewRequests() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.selectBy(QuerySwitchRequestDropdown, "General Query on New Requests");

		return passed;
	}

	/***
	 * Method to select Generate Switch Request Functionality
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean selectGenerateSwitchRequest() {
		boolean passed = false;

		passed = action.waitFor(QuerySwitchRequestDropdown, 4, true);
		passed = action.selectBy(QuerySwitchRequestDropdown, "Generate Switch Request");

		return passed;
	}

	/***
	 * Method to test Monitor New Switch Requests Functionality
	 * 
	 * @param employeeID
	 *            The employee ID that needs to be selected
	 * @param updatedWithinLast
	 *            Update Within Last filter in hours:minutes format. '00:00'
	 * @return True if the test step passed. Else will return false.
	 */
	public boolean monitorNewSwitchRequests_Search(String employeeID, String updatedWithinLast) {
		boolean passed = false;

		passed = action.waitFor(MonitorNewSwitchRequests_ColumnHeader, 4, true);

		passed = action.waitFor(EmployeeNameID_DropDown, 4, true);
		if (action.getSelectedOption(EmployeeNameID_DropDown).contains("Select")) {
			passed = action.sendDataTo(EmployeeNameID_Input, employeeID);
			passed = action.clickOn(EmployeeNameID_SearchButton);
			passed = action.waitFor(2);
			passed = action.selectBy(EmployeeNameID_DropDown, 1);
		}

		if (!monitorSwitchReq_Status.equals(""))
			passed = action.selectBy(Status_DropDown, monitorSwitchReq_Status);

		passed = action.sendDataTo(UpdatedWithinLast_Input, updatedWithinLast);
		passed = action.clickOn(SearchButton);

		passed = verifyResults();

		return passed;
	}

	/***
	 * Method to Test Failure Queries Functionality
	 * 
	 * @param switchID
	 *            The Switch ID that needs to be searched for
	 * @param Region
	 *            The Region that needs to be searched for
	 * @param TargetExchangeID
	 *            The Target Exchange ID that needs to be searched for
	 * @param DepartmentCode
	 *            The Department Code that needs to be searched for
	 * @param StartDate
	 *            The Date from which the results should be shown in "DD/MM/YYYY
	 *            hh:mm" format. For example:'31/05/2014 03:15'
	 * @param EndDate
	 *            The Date to which the results should be shown in "DD/MM/YYYY
	 *            hh:mm" format. For example:'31/05/2017 03:15'
	 * @return True if the test step passed. Else will return false.
	 */
	public boolean failureQueries(String switchID, String Region, String TargetExchangeID, String DepartmentCode,
			String StartDate, String EndDate) {
		boolean passed = false;

		passed = action.waitFor(FailureQueries_ColumnHeader, 4, true);
		passed = action.waitFor(SwitchID_DropDown, 3, true);
		passed = action.selectBy(SwitchID_DropDown, switchID);
		passed = action.selectBy(Region_DropDown, "");
		passed = action.selectBy(TargetExchangeID_DropDown, TargetExchangeID);
		passed = action.selectBy(DepartmentCode_DropDown, DepartmentCode);

		passed = action.typeDataTo(StartDate_Input, StartDate);
		passed = action.typeDataTo(EndDate_Input, EndDate);
		action.clickOn(StartDate_Input);

		passed = action.clickOn(SearchButton);

		passed = verifyResults();

		return passed;
	}

	/***
	 * Method to test Query by Query by Acct, Service Order, Service or Command.
	 * Pass only the parameter that need to be searched for. If multiple
	 * parameters are passed, only Account number will be considered.
	 * 
	 * @param AccountNumber
	 *            Account Number than needs to be searched with.
	 * @param ServiceNumber
	 *            Service Number that needs to be searched with.
	 * @param ServiceOrderNumber
	 *            Service Order Number that needs to be searched with.
	 * @param CommandNumber
	 *            Command Number than needs to be searched with.
	 * @return True if the test step passed. Else will return false.
	 */
	public boolean queryByCustomerDetails(String AccountNumber, String ServiceNumber, String ServiceOrderNumber,
			String CommandNumber) {
		boolean passed = false;

		passed = action.waitFor(AccountNumber_Input, 3, true);

		if (!AccountNumber.equals("")) {
			passed = action.clickOn(AccountNumber_Input);
			passed = action.waitFor(1);
			passed = action.sendDataTo(AccountNumber_Input, AccountNumber);
		}

		if (!ServiceNumber.equals("")) {
			passed = action.clickOn(ServiceNumber_Input);
			passed = action.waitFor(1);
			passed = action.sendDataTo(ServiceNumber_Input, ServiceNumber);
		}

		if (!ServiceOrderNumber.equals("")) {
			passed = action.clickOn(ServiceOrderNumber_Input);
			passed = action.waitFor(1);
			passed = action.sendDataTo(ServiceOrderNumber_Input, ServiceOrderNumber);
		}

		if (!CommandNumber.equals("")) {
			passed = action.clickOn(CommandNumber_Input);
			passed = action.waitFor(1);
			passed = action.sendDataTo(CommandNumber_Input, CommandNumber);
		}

		passed = action.clickOn(SearchButton);

		return passed;
	}

	/***
	 * Method to test General Query on new Switch Requests
	 * 
	 * @param Status
	 *            The status of Switch Request to be searched for.
	 * @param switchID
	 *            The Switch ID that needs to be searched for
	 * @param Region
	 *            The Region that needs to be searched for
	 * @param TargetExchangeID
	 *            The Target Exchange ID that needs to be searched for
	 * @param DepartmentCode
	 *            The Department Code that needs to be searched for
	 * @param StartDate
	 *            The Date from which the results should be shown in "DD/MM/YYYY
	 *            hh:mm" format. For example:'31/05/2014 03:15'
	 * @param EndDate
	 *            The Date to which the results should be shown in "DD/MM/YYYY
	 *            hh:mm" format. For example:'31/05/2017 03:15'
	 * @return True if the test step passed. Else will return false.
	 */
	public boolean generalQUery(String Status, String SwitchID, String Region, String TargetExchangeID,
			String DepartmentCode, String StartDate, String EndDate) {
		boolean passed = false;

		passed = action.waitFor(Status_DropDown, 3, true);
		passed = action.selectBy(Status_DropDown, Status);

		passed = failureQueries(SwitchID, Region, TargetExchangeID, DepartmentCode, StartDate, EndDate);

		return passed;
	}

	/***
	 * Method to verify the Switch Results
	 * 
	 * @return True, if results are available, else false.
	 */
	public boolean verifyResults() {
		boolean passed = false;

		// TODO Handle No Data Found
		passed = action.waitFor(SwitchRequestSummaryDetails_ColumnHeader, 3, true);
		passed = action.waitFor(SwitchReqSummaryColmn, 2, true);
		int countOfResults = action.countOf(SwitchReqSummaryColmn);

		System.out.println("Number of switch requests :" + countOfResults);

		System.out.println(action.getTestStatus(passed));

		return passed;
	}
}
