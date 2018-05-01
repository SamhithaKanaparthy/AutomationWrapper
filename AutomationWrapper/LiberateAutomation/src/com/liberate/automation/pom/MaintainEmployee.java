package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;

public class MaintainEmployee {
	TestActions action = null;
	RandomData random = new RandomData();

	public String VMSUserName = "";
	public String EmployeeID = "";
	
	By StaffNumber_Input = By.xpath("//*[text()='Staff No:']/following::input[1]");
	
	By VMSUserName_Input = By.xpath("//*[text()='VMS Username:']/following::input[1]");
	By Surname_Input = By.xpath("//*[text()[contains(.,'Surname:')]]/following::input[1]");
	By FirstName_Input = By.xpath("//*[text()[contains(.,'First Name')]]/following::input[1]");
	By Initials_Input = By.xpath("//*[text()[contains(.,'Initials')]]/following::input[1]");
	By EmployeeFunction_Select = By.xpath("//*[text()[contains(.,'Emp Function')]]/following::select[1]");
	By DefaultPrinter_Select = By.xpath("//*[text()[contains(.,'Default Printer')]]/following::select[1]");
	By BuildingCode_select = By.xpath("//*[text()[contains(.,'Building Code')]]/following::select[1]");
	By Language_Select = By.xpath("//*[text()[contains(.,'Language')]]/following::select[1]");
	
	By Success_Message = By.xpath("//*[text()[contains(.,'Operation Successfully Completed')]]");
	
	public MaintainEmployee(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Admin, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Admin);
		passed = action.waitFor(LeftLink.EmployeeAdministration.MaintainEmployee, 4, true);
		passed = action.clickOn(LeftLink.EmployeeAdministration.MaintainEmployee);

		return passed;
	}

	public boolean searchWithStaffNumber(String StaffNumber) {
		boolean passed = false;
		
		this.EmployeeID = StaffNumber;
		
		passed = action.waitFor(StaffNumber_Input, 4, true);
		passed = action.sendDataTo(StaffNumber_Input, StaffNumber);
		
		passed = action.clickOn(CommonPanel.Search_Button);
		
		return passed;
	}
	
	public boolean createNewEmployee()
	{
		boolean passed = false;
		
		this.VMSUserName = random.nextString().substring(0, 11);
		
		passed = action.waitFor(VMSUserName_Input, 4, true);
		passed = action.sendDataTo(VMSUserName_Input, this.VMSUserName);
		
		passed = action.sendDataTo(Surname_Input, random.nextString());
		passed = action.sendDataTo(FirstName_Input, random.nextString());
		passed = action.sendDataTo(Initials_Input, "Z");
		
		passed = action.selectByPartialText(Language_Select, "ENG");
		passed = action.selectBy(EmployeeFunction_Select, 1);
		passed = action.selectBy(DefaultPrinter_Select, 1);
		passed = action.selectBy(BuildingCode_select, 1);
		
		passed = action.clickOn(CommonPanel.Accept_Button);
		
		passed = action.waitFor(Success_Message, 4, true);
		
		return passed;
	}

}
