package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class RaiseFault {
	TestActions action = null;
	// RaiseFault National Fault Telephone Elements
	By RaiseFault_PanelHeader = By.xpath("//td[@class='blackBold']//*[text()='Raise Fault']");
	By NationalFault_RadioButton = By.xpath("(//*[text()='National']/preceding::input)[last()]");
	By Telephone_RadioButton = By.xpath("(//*[text()='Telephone']/preceding::input)[last()]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service Number:']/following::input[1]");
	By Extension_Input = By.xpath("//*[text()='Extension:']/following::input[1]");
	By LineNo_Input = By.xpath("//*[text()='Line No:']/following::input[1]");

	// RaiseFault National Fault Leased Circuit selected
	By LeasedCircuit_RadioButton = By.xpath("(//*[text()='Leased Circuit']/preceding::input)[last()]");
	By LeasedCircuitStartsWith_Input = By.xpath("//*[text()='Starts With']/following::input[1]");
	By LeasedCircuitStartsWithFind_Button = By
			.xpath("(//*[text()[contains(.,'Starts With')]]/following::input[@value='Find'])[1]");
	By LeasedCircuitStartsWith_DropDown = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::select)[1]");

	// RaiseFault InterNational Fault Elements
	By International_RadioButton = By.xpath("(//*[text()='International']/preceding::input)[last()]");
	By StartsWith_Input = By.xpath("//*[text()='Starts With']/following::input[1]");
	By StartsWithFind_Button = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::input[@value='Find'])[1]");
	By StartsWith_DropDown = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::select)[1]");
	By StartsWithFrom_Input = By.xpath("//*[text()='From']/following::input[1]");
	By StartsWithTo_Input = By.xpath("//*[text()='To']/following::input[1]");
	By StartsWithFromToFind_Button = By.xpath("(//*[text()[contains(.,'From')]]/following::input[@value='Find'])[1]");
	By CircuiDesignation_DropDown = By.xpath("(//*[text()='Circuit Designation']/following::select)[1]");

	// RaiseFault Common button
	By RaiseFault_Button = By.xpath("//input[@value='Raise Fault']");
	By RaiseFaultReset_Button = By.xpath("//input[@value='Reset']");

	// RaiseFault Service Info panel
	By ServiceInfo_PanelHeader = By.xpath("//td[@class='blackBold']//*[text()='Service Info']");

	// RaiseFault Service Info panel
	By FaultList_PanelHeader = By.xpath("//table[@class='panelHdr']//*[text()='Fault List']");

	// RaiseFault Customer Info panel
	By CustomerInfo_PanelHeader = By.xpath("//table[@class='panelHdr']//*[text()='Customer Info']");

	// NewFault panel elements
	By Contact_Input = By.xpath("//*[text()='Contact:']/following::input[1]");
	By Number_Input = By.xpath("//*[text()='Number:']/following::input[1]");
	By ExtensionNewFault_Input = By.xpath("//*[text()='Extension:']/following::input[1]");
	By Comments1_Input = By.xpath("//*[text()='Comments:']/following::input[1]");
	By Comments2_Input = By.xpath("(//*[text()[contains(.,'Time:')]]/following::input)[2]");
	By Priority_Dropdown = By.xpath("(//*[text()='Priority:']/following::select)[1]");
	By Time_Input = By.xpath("//*[text()='Time:']/following::input[1]");
	By Symptom_DropDown = By.xpath("(//*[text()='Symptom:']/following::select)[1]");
	By Diagnosis_DropDown = By.xpath("(//*[text()='Diagnosis:']/following::select)[1]");
	By DatePicker_Input = By.xpath("(//*[text()='Date:'])[2]/following::input[1]");
	By Site_Dropdown = By.xpath("(//*[text()='Site:']/following::select)[1]");
	By Department_Dropdown = By.xpath("(//*[text()='Department:']/following::select)[1]");
	By Reference_Input = By.xpath("(//*[text()='Reference:']/following::input)[1]");
	By ReportingAdmin_Input = By.xpath("(//*[text()='Reporting Admin:']/following::input)[1]");
	By ReportingAdminSearch_Button = By.xpath("//*[text()='Reporting Admin:']/following::input[@type='image']");
	By ReportingAdmin_Dropdown = By.xpath("(//*[text()='Reporting Admin:']/following::select)[1]");
	By Addnotes_Input = By.xpath("(//*[text()='Add Notes:']/following::textarea)[1]");
	By Accept_Button = By.xpath("//input[@value='Accept']");
	By Cancel_Button = By.xpath("//input[@value='Cancel']");

	// Identifying the Fault number
	By RaisedFault_Number = By.xpath("//*[text()='Fault Number:']/following::span[1]");

	public RaiseFault(TestActions action) {
		this.action = action;
	}

	/* Navigating to Raise fault Lefts screen */

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Faults, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Faults);
		passed = action.waitFor(LiberateCommon.Faults.Faults, 4, true);
		passed = action.clickOn(LiberateCommon.Faults.Faults);
		passed = action.waitFor(LeftLink.Faults.RaiseFault, 4, true);
		passed = action.clickOn(LeftLink.Faults.RaiseFault);

		return passed;
	}

	/* Enter service number to raise fault on Raise fault screen */

	public boolean enterServiceNumber(String servicenumber) {
		boolean passed;

		passed = action.waitFor(ServiceNumber_Input, 5, true);
		passed = action.sendDataTo(ServiceNumber_Input, servicenumber);

		return passed;
	}

	// Click on Raise Fault button to raise a fault
	public boolean clickonRaiseFaultbutton() {
		boolean passed = false;

		passed = action.waitFor(RaiseFault_Button, 4, true);
		passed = action.clickOn(RaiseFault_Button);

		return passed;
	}

	// Click on Reset button after providing ServiceNumber to raise a fault
	public boolean clickonResetbutton() {
		boolean passed = false;

		passed = action.waitFor(RaiseFaultReset_Button, 4, true);
		passed = action.clickOn(RaiseFaultReset_Button);

		return passed;
	}

	// Enter data in fields for raising a new fault on new fault panel
	public boolean enterDataInFieldsToRaiseFault() {
		boolean passed = false;

		passed = action.waitFor(Symptom_DropDown, 4, true);
		// passed = action.selectBy(Symptom_DropDown, "01-TP No Dial Tone");
		action.waitFor(1);
		passed = action.selectBy(Symptom_DropDown, 2);

		passed = action.waitFor(Diagnosis_DropDown, 4, true);
		// passed = action.selectBy(Diagnosis_DropDown, "1-TP Needs dropwire
		// replaced");
		passed = action.selectBy(Diagnosis_DropDown, 2);
		action.waitFor(1);

		passed = action.waitFor(Site_Dropdown, 4, true);
		// passed = action.selectBy(Site_Dropdown, "Faults");
		passed = action.selectBy(Site_Dropdown, 1);
		action.waitFor(1);

		passed = action.waitFor(Department_Dropdown, 4, true);
		// passed = action.selectBy(Department_Dropdown, "FLT-B-Business
		// Faults");
		passed = action.selectBy(Department_Dropdown, 2);
		action.waitFor(1);

		return passed;
	}

	// Click on Raise Fault button to raise a fault
	public boolean clickonAccepttbutton() {
		boolean passed = false;

		action.scroll(0, 2000);
		action.waitFor(1);
		passed = action.waitFor(Accept_Button, 4, true);
		passed = action.clickOn(Accept_Button);

		action.waitFor(1);
		action.scroll(0, -2000);

		return passed;
	}

	// Click on Cancel button after providing details to raise a fault
	public boolean clickonCanceltbutton() {
		boolean passed = false;

		passed = action.waitFor(Cancel_Button, 4, true);
		passed = action.clickOn(Cancel_Button);

		return passed;
	}

	// Print the raised fault number
	public boolean raisedFaultNumber() {
		boolean passed = false;

		passed = action.waitFor(RaisedFault_Number, 4, true);
		System.out.println(action.getTextFromPage(RaisedFault_Number));

		return passed;
	}
}
