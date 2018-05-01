package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;

public class ManageUser {
	TestActions action = null;
	RandomData random = new RandomData();

	boolean CopyUser = false;

	String UserName = "";
	String userID = "";
	String FirstName = "";
	String CISUserName = "";

	// Search Panel
	By UserName_Input = By.xpath("//*[text()[contains(.,'Username')]]//following::input[1]");
	By FirstName_Input = By.xpath("//*[text()[contains(.,'First Name')]]//following::input[1]");
	By SurName_Input = By.xpath("//*[text()[contains(.,'Surname')]]//following::input[1]");
	By EmployeeID_Input = By.xpath("//*[text()[contains(.,'Employee ID')]]//following::input[1]");

	// User Details Panel
	By UserDetails_PanelHeader = By.xpath("//*[text()='User Details']");
	By UserName_Value = By.xpath("//*[text()[contains(.,'Username:')]]/following::td[1]//span");
	By Name_Value = By.xpath("//*[text()='Name:']//following::span[1]");

	// Amend User
	By AmendUser_ActionButton = By.xpath("//span[text()[contains(.,'Amend User')]]");

	// Delete User
	By DeleteUser_ActionButton = By.xpath("//span[text()[contains(.,'Delete User')]]");
	By DeleteComfirmation_PopUp = By
			.xpath("//*[text()='User will be removed from selected Business Units. Do you want to continue?']");
	By DeleteSuccess_Message = By.xpath("//*[text()='User deletetion successfully completed']");

	// User Details Input Panel
	By Password_Input = By.xpath("//*[text()[contains(.,'Password')]]//following::input[1]");
	By EMailAddress_Input = By.xpath("//*[text()[contains(.,'Email address')]]//following::input[1]");
	By CISUserName_Input = By.xpath("//*[text()[contains(.,'CIS User Name')]]//following::input[1]");

	By SelectAllBU_CheckBox = By.xpath("//*[text()='Select All']/following::input[1]");

	// Copy User
	By CopyUser_ActionButton = By.xpath("//span[text()[contains(.,'Copy User')]]");
	By CopyUserSuccess_Message = By.xpath("//*[text()='Copy User successfully completed']");

	By Position_Select = By.xpath("//*[text()='Position']/following::select[1]");

	By CreateUserSuccess_Message = By.xpath("//*[text()='User creation successfully completed']");
	By NewUser_ActionButton = By.xpath("//span[text()[contains(.,'New User')]]");

	public ManageUser(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Admin, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Admin);
		passed = action.waitFor(LeftLink.EmployeeAdministration.ManageUsers, 4, true);
		passed = action.clickOn(LeftLink.EmployeeAdministration.ManageUsers);

		return passed;
	}

	public boolean searchByUserName(String UserName) {
		boolean passed = false;

		this.UserName = UserName;

		passed = action.waitFor(UserName_Input, 4, true);
		passed = action.sendDataTo(UserName_Input, UserName);
		passed = action.clickOn(CommonPanel.Search_Button);

		return passed;
	}
	
	public boolean searchByUserIS(String userID) {
		boolean passed = false;

		this.userID = userID;

		passed = action.waitFor(EmployeeID_Input, 4, true);
		passed = action.sendDataTo(EmployeeID_Input, userID);
		passed = action.clickOn(CommonPanel.Search_Button);

		return passed;
	}

	public boolean verifyUserDetails() {
		boolean passed = false;

		if (action.countOf(CommonPanel.Accept_Button) > 0) {
			passed = action.waitFor(CommonPanel.Accept_Button, 4, false);
			action.waitFor(2);
			passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);
			passed = action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, false);
		}

		passed = action.waitFor(UserDetails_PanelHeader, 4, true);
		passed = this.UserName.equals(action.getTextFromPage(UserName_Value).trim());

		if (!this.FirstName.equals("")) {
			passed = action.getTextFromPage(Name_Value).contains(FirstName);
		}

		return passed;
	}

	public boolean amendUser() {
		boolean passed = false;

		passed = action.waitFor(AmendUser_ActionButton, 4, true);
		passed = action.clickOn(AmendUser_ActionButton);

		this.FirstName = random.nextString().trim();

		passed = action.waitFor(FirstName_Input, 4, true);
		passed = action.sendDataTo(FirstName_Input, FirstName);

		passed = action.clickOn(CommonPanel.Accept_Button);

		return passed;
	}

	public boolean deleteUser() {
		boolean passed = false;

		passed = action.waitFor(DeleteUser_ActionButton, 4, true);
		passed = action.clickOn(DeleteUser_ActionButton);

		passed = action.waitFor(CommonPanel.Accept_Button, 4, true);
		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(DeleteComfirmation_PopUp, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean verifyDelete() {
		boolean passed = false;

		passed = action.waitFor(DeleteSuccess_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean copyUser(String EmployeeID) {
		boolean passed = false;
		CopyUser = true;

		passed = action.waitFor(CopyUser_ActionButton, 4, true);
		passed = action.clickOn(CopyUser_ActionButton);

		passed = fillUserDetails("99999");

		return passed;
	}

	public boolean verifyCopyUser() {
		boolean passed = false;

		action.waitFor(2);

		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(CopyUserSuccess_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean createUser(String EmployeeID, String CISUserName) {
		boolean passed = false;
		CopyUser = false;

		passed = action.waitFor(NewUser_ActionButton, 4, true);
		passed = action.clickOn(NewUser_ActionButton);

		passed = action.waitFor(CISUserName_Input, 4, true);
		passed = action.sendDataTo(CISUserName_Input, CISUserName);

		fillUserDetails(EmployeeID);

		action.waitFor(3);

		passed = action.selectByPartialText(Position_Select, "Basic");

		passed = action.clickOn(CommonPanel.Accept_Button);

		return passed;
	}

	public boolean verifyCreateUser() {
		boolean passed = false;

		action.waitFor(2);

		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(CreateUserSuccess_Message, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	private boolean fillUserDetails(String EmployeeID) {
		boolean passed = false;

		passed = action.waitFor(EMailAddress_Input, 4, true);

		this.UserName = random.nextString();
		passed = action.sendDataTo(UserName_Input, this.UserName);
		passed = action.sendDataTo(Password_Input, "Test@123Test");

		this.FirstName = random.nextString();
		passed = action.sendDataTo(FirstName_Input, this.FirstName);
		passed = action.sendDataTo(SurName_Input, random.nextString());

		passed = action.sendDataTo(EMailAddress_Input, "testtesttest@cwc.com");

		this.CISUserName = CopyUser ? "RHQ_DEVELOP" : random.nextString();

		if (CopyUser) {
			passed = action.sendDataTo(CISUserName_Input, CISUserName);
		}
		passed = action.sendDataTo(EmployeeID_Input, EmployeeID);

		passed = action.clickOn(CommonPanel.Accept_Button);

		passed = action.waitFor(SelectAllBU_CheckBox, 4, true);
		passed = action.clickOn(SelectAllBU_CheckBox);

		return passed;
	}
}
