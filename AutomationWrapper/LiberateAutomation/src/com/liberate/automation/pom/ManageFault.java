package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class ManageFault {
	TestActions action = null;

	// ManageFault search Elements
	By ManageFault_PanelHeader = By.xpath("//*[text()='Search']");
	By NationalFault_RadioButton = By.xpath("(//*[text()='National']/preceding::input)[last()]");
	By International_RadioButton = By.xpath("(//*[text()='International']/preceding::input)[last()]");
	By FaultNumber_Input = By.xpath("(//*[text()='Fault Number:']/following::input)[1]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service Number:']/following::input[1]");
	By WorkingService_RadioButton = By.xpath("(//*[text()='Working Service']/preceding::input)[last()]");
	By LastCeasedService_RadioButton = By.xpath("(//*[text()='Last Ceased Service']/preceding::input)[last()]");
	By Region_DropDown = By.xpath("(//*[text()[contains(.,'Region: ')]]/following::select)[1]");
	By Customertype_Dropdown = By.xpath("(//*[text()[contains(.,'Customer Type:')]]/following::select)[1]");
	By Department_DropDown = By.xpath("(//*[text()[contains(.,'Department:')]]/following::select)[1]");
	By FaultStatus_DropDown = By.xpath("(//*[text()[contains(.,'Fault Status:')]]/following::select)[1]");
	By Priority_DropDown = By.xpath("(//*[text()[contains(.,'Priority:')]]/following::select)[1]");
	By DateRaisedFrom_datepicker = By.xpath("(//*[text()[contains(.,'Date Raised From:')]]/following::select)[1]");
	By DateRaisedTo_datepicker = By.xpath("(//*[text()[contains(.,'Date Raised To:')]]/following::select)[1]");
	By ManageFaultSearch_Button = By.xpath("//input[@value='Search']");
	By ManageFaultClear_Button = By.xpath("//input[@value='Clear']");

	// Action buttons upon searching with Fault Number
	By MaintainFaultNotes_ActionButton = By.xpath("(//*[text()[contains(.,'Maintain Fault Notes')]])");
	By AssignFault_ActionButton = By.xpath("(//*[text()[contains(.,'Assign Fault')]])");
	By SignOff_ActionButton = By.xpath("(//*[text()[contains(.,'Sign Off ')]])");
	By SuspendRelease_ActionButton = By.xpath("(//*[text()[contains(.,'Suspend/Release')]])");
	By UpgreadeFaultPriority_ActionButton = By.xpath("(//*[text()[contains(.,'Upgrade Fault Priority')]])");
	By RecordFaultTest_actionButton = By.xpath("(//*[text()[contains(.,'Record Fault Test')]])[1]");
	By PrintFaultDocket_ActionButton = By.xpath("(//*[text()[contains(.,'Print Fault Docket')]])[2]");
	By RecordFaultActivity_ActionButton = By.xpath("(//*[text()[contains(.,'Record Fault Activity')]])");

	// Maintain Fault Notes - Buttons
	By FaultNotes_PanelHeader = By.xpath("//*[text()='Fault Notes']");
	By AddNotes_Button = By.xpath("//input[@value='Add Notes']");
	By CancelNotes_Button = By.xpath("//input[@value='Cancel']");
	// xpath for validation if notes has been added or not
	By NotesDetails_PanelHeader = By.xpath("//*[text()='Notes Details']");
	By IdentifyAddNotes_LineCount = By.xpath("//*[@id='manageFault:notesDetailsTable']");

	// Add notes to fault through Maintain Fault Notes
	By Addnotes_Input = By.xpath("(//*[text()='Add Notes']/following::textarea)[1]");
	By AddNotesApply_Button = By.xpath("//input[@value='Apply']");
	By AddNotesClear_Button = By.xpath("//input[@value='Clear']");
	By AddNotesCancel_Button = By.xpath("//input[@value='Cancel']");

	// Assigning a Fault to a department
	By AssignFaultDepartment_DropDown = By.xpath("(//*[text()[contains(.,'Assign Fault')]]//following::select)[1]");
	By AssignFaultAssign_Button = By.xpath("//input[@value='Assign']");
	By AssignFaultCancel_Button = By.xpath("//input[@value='Cancel']");
	// xpath for validation if department is assigned or not
	By AssignmentDetails_PanelHeader = By.xpath("//*[text()='Assignments Details']");
	By IdentifyAssignmentDetails_LineCount = By.xpath("//*[@id='manageFault:assignmentsTable']");

	// Signoff a fault
	By Signoff_PanelHeader = By.xpath("//*[text()='Sign Off']");
	By SignoffClearedBy_DropDown = By.xpath("(//*[text()[contains(.,'Cleared By')]]/following::select)[1]");
	By SignoffClearedCode_DropDown = By.xpath("(//*[text()[contains(.,'Clear Code')]]/following::select)[1]");
	By SignoffLevel2_Dropdown = By.xpath("(//*[text()[contains(.,'Level 2')]]/following::select)[1]");
	By SignoffLevel3_Dropdown = By.xpath("(//*[text()[contains(.,'Level 3')]]/following::select)[1]");
	By SignoffClearAction_Dropdown = By.xpath("(//*[text()[contains(.,'Clear Action')]]/following::select)[1]");
	By SignoffApply_Button = By.xpath("//input[@value='Apply']");
	By SignoffClear_Button = By.xpath("//input[@value='Clear']");
	By SignoffCancel_Button = By.xpath("//input[@value='Cancel']");
	// xpath for validation if fault is signed off or not
	By FaultInfo_PanelHeader = By.xpath("//*[text()='Fault Info']");
	By FaultStatus_Value = By.xpath("//*[text()='Status']/following::td[1]//span");

	// Suspend/release a fault
	By SuspendRelease_PanelHeader = By.xpath("//*[text()='Suspend/Release']");
	By SuspendReleaseSuspensionReason_DropDown = By
			.xpath("(//*[text()[contains(.,'Suspension Reason')]]/following::select)[1]");
	By SuspendReleaseSuspend_Button = By.xpath("//input[@value='Suspend']");
	By SuspendReleaseClear_Button = By.xpath("//input[@value='Clear']");
	By SuspendReleaseCancel_Button = By.xpath("//input[@value='Cancel']");
	By SuspendReleaseRelease_Button = By.xpath("//input[@value='Release']");

	// Upgrade fault priority
	By UpgradeFaultPriority_PanelHeader = By.xpath("//*[text()='Upgrade Fault Priority ']");
	By UgradeFaultPriorityNewPriority_DropDown = By
			.xpath("(//*[text()[contains(.,'New Priority:')]]/following::select)[1]");
	By UgradeFaultPriorityAccept_Button = By.xpath("//input[@value='Accept']");
	By UpgradeFaultPriorityCancel_Button = By.xpath("//input[@value='Cancel']");

	// Record Test Result
	By RecordTestResult_PanelHeader = By.xpath("//*[text()='Record Test Result']");
	By RecordTestResultDiagnosis_DropDown = By.xpath("(//*[text()='Diagnosis:']/following::select)[1]");
	By RecordTestResultApply_Button = By.xpath("//input[@value='Apply']");
	By RecordTestResultCancel_Button = By.xpath("//input[@value='Cancel']");

	// Print Fault Docket
	By PrintFaultDocket_PanelHeader = By.xpath("//*[text()='Print Fault Docket']");
	By PrintFaultDocketAccept_Button = By.xpath("//input[@value='Accept']");
	By PrintFaultDocketBack_Button = By.xpath("//input[@value='Back']");

	// Record Fault Activities
	By RecordFaultActivities_PanelHeader = By.xpath("//*[text()='Record Fault Activities']");
	By RecordFaultActivitiesRecordActivity_Button = By.xpath("//input[@value='Record Activity']");
	By RecordFaultActivitiesCancel_Button = By.xpath("//input[@value='Cancel']");
	By RecordFaultActivitiesActivityID_Dropdown = By
			.xpath("(//*[text()[contains(.,'Activity Id:')]]/following::select)[1]");
	By RecordFaultActivitiesActivityNotes_Input = By.xpath("(//*[text()='Activity Notes:']/following::textarea)[1]");
	By RecordFaultActivitiesActivityAccept_Button = By.xpath("//input[@value='Accept']");
	By RecordFaultActivitiesActivityCancel_Button = By
			.xpath("//input[@value='Accept']/following::input[@value='Cancel']");

	public ManageFault(TestActions action) {
		this.action = action;
	}

	/* Navigating to Manage fault Lefts screen */

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Faults, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Faults);
		passed = action.waitFor(LiberateCommon.Faults.Faults, 4, true);
		passed = action.clickOn(LiberateCommon.Faults.Faults);
		passed = action.waitFor(LeftLink.Faults.ManageFault, 4, true);
		passed = action.clickOn(LeftLink.Faults.ManageFault);

		return passed;
	}

	/* Enter service number to manage a fault on Manage fault screen */
	public boolean enterFaultNumber(String FaultNumberValue) {
		boolean passed = false;

		passed = action.waitFor(FaultNumber_Input, 4, true);
		passed = action.sendDataTo(FaultNumber_Input, FaultNumberValue);

		return passed;
	}

	// Click on Search button to manage a fault
	public boolean clickonSearchbutton() {
		boolean passed = false;

		passed = action.waitFor(ManageFaultSearch_Button, 4, true);
		passed = action.clickOn(ManageFaultSearch_Button);

		return passed;
	}

	// Click on Clear button after providing ServiceNumber to manage a fault
	public boolean clickonclearbutton() {
		boolean passed = false;

		passed = action.waitFor(ManageFaultClear_Button, 4, true);
		passed = action.clickOn(ManageFaultClear_Button);

		return passed;
	}

	// Action Buttons
	// ----------------------------------------
	// Click on Maintain Fault notes action button
	public boolean clickonMaintainFaultnotesactionbutton() {
		boolean passed = false;

		passed = action.waitFor(MaintainFaultNotes_ActionButton, 4, true);
		passed = action.clickOn(MaintainFaultNotes_ActionButton);

		return passed;
	}

	// Click on Add notes action button of Fault notes panel
	public boolean clickonAddNotesbutton() {
		boolean passed = false;

		passed = action.waitFor(AddNotes_Button, 4, true);
		passed = action.clickOn(AddNotes_Button);

		return passed;
	}

	// Click on Add notes action button of Fault notes panel
	public boolean clickonAddNotesCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(CancelNotes_Button, 4, true);
		passed = action.clickOn(CancelNotes_Button);

		return passed;
	}

	// Enter notes in Fault notes panel
	public boolean enterDataInAddNotestextfield(String AddNotesData) {
		boolean passed = false;

		passed = action.waitFor(Addnotes_Input, 4, true);
		passed = action.sendDataTo(Addnotes_Input, AddNotesData);

		return passed;
	}

	// Click on Add notes -apply button of Fault notes panel
	public boolean clickonAddNotesApplybutton() {
		boolean passed = false;

		passed = action.waitFor(AddNotesApply_Button, 4, true);
		passed = action.clickOn(AddNotesApply_Button);

		return passed;
	}

	// Click on Add notes -Clear button of Fault notes panel
	public boolean clickonAddNotesClearbutton() {
		boolean passed = false;

		passed = action.waitFor(AddNotesClear_Button, 4, true);
		passed = action.clickOn(AddNotesClear_Button);

		return passed;
	}

	// Click on Add notes -Cancel button of Fault notes panel
	public boolean clickonAddNotesFaultNotesCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(AddNotesCancel_Button, 4, true);
		passed = action.clickOn(AddNotesCancel_Button);

		return passed;
	}

	// Validate if notes has been added or not
	public int rowCountofAddNotes() {
		int count = 0;

		count = action.countOf(IdentifyAddNotes_LineCount);

		return count;
	}
	// ---------------------------------------------------

	// ----------------------------------------------
	// Clicking on Assign Fault action button
	public boolean clickonAssignFaultactionbutton() {
		boolean passed = false;

		passed = action.waitFor(AssignFault_ActionButton, 4, true);
		passed = action.clickOn(AssignFault_ActionButton);

		return passed;
	}

	/* Assign Fault select the department drop down for assign fault */
	public boolean selectDepartmentDropdown() {
		boolean passed = false;

		passed = action.waitFor(AssignFaultDepartment_DropDown, 4, true);
		passed = action.selectBy(AssignFaultDepartment_DropDown, "FLT-C-Cable Faults");

		return passed;
	}

	// Assign Fault Click on assign button
	public boolean clickonAssignFaultAssignbutton() {
		boolean passed = false;

		passed = action.waitFor(AssignFaultAssign_Button, 4, true);
		passed = action.clickOn(AssignFaultAssign_Button);

		return passed;
	}

	// Assign Fault Click on Cancel button
	public boolean clickonAssignFaultCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(AssignFaultCancel_Button, 4, true);
		passed = action.clickOn(AssignFaultCancel_Button);

		return passed;
	}

	// Validate if department has been assigned or not
	public int rowcountofAssignFault() {
		int passed = 0;

		passed = action.countOf(IdentifyAssignmentDetails_LineCount);

		return passed;
	}
	// ---------------------------------------------------

	// ---------------------------------------------------
	// Click on Sign Off action button
	public boolean clickonSignOffactionbutton() {
		boolean passed = false;

		passed = action.waitFor(SignOff_ActionButton, 4, true);
		passed = action.clickOn(SignOff_ActionButton);

		return passed;
	}

	/* Signoff Fault select dropdowns */
	public boolean selectSignoffDropDowns() {
		boolean passed = false;

		passed = action.waitFor(SignoffClearedBy_DropDown, 4, true);
		passed = action.selectByPartialText(SignoffClearedBy_DropDown, "99999-");
		action.waitFor(1);
		passed = action.waitFor(SignoffClearedCode_DropDown, 4, true);
		action.waitFor(1);
		passed = action.selectBy(SignoffClearedCode_DropDown, 1);
		action.waitFor(1);
		passed = action.waitFor(SignoffLevel2_Dropdown, 4, true);
		action.waitFor(1);
		passed = action.selectBy(SignoffLevel2_Dropdown, 1);
		action.waitFor(1);
		passed = action.waitFor(SignoffLevel3_Dropdown, 4, true);
		action.waitFor(1);
		passed = action.selectBy(SignoffLevel3_Dropdown, 1);
		action.waitFor(1);
		passed = action.waitFor(SignoffClearAction_Dropdown, 4, true);
		action.waitFor(1);
		passed = action.selectBy(SignoffClearAction_Dropdown, 1);
		action.waitFor(1);

		return passed;
	}

	/***
	 * 
	 * @return
	 */
	public boolean clickonSignOffApplybutton() {
		boolean passed = false;

		passed = action.waitFor(SignoffApply_Button, 4, true);
		passed = action.clickOn(SignoffApply_Button);

		return passed;
	}

	// Sign off fault Clear button
	public boolean clickonSignOffClearbutton() {
		boolean passed = false;

		passed = action.waitFor(SignoffClear_Button, 4, true);
		passed = action.clickOn(SignoffClear_Button);

		return passed;
	}

	// Sign off fault Cancel button
	public boolean clickonSignOffCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(SignoffCancel_Button, 4, true);
		passed = action.clickOn(SignoffCancel_Button);

		return passed;
	}

	// Validate status of fault number
	public String statusOfFaultNumber() {
		String status = null;
		
		action.waitFor(SignoffApply_Button, 4, false);
		status = action.getTextFromPage(FaultStatus_Value);
		return status;
	}
	// ------------------------------------------

	// ----------------------------------------------------
	// Click on Suspend/Release action button
	public boolean clickonSuspendReleaseactionbutton() {
		boolean passed = false;

		passed = action.waitFor(SuspendRelease_ActionButton, 10, true);
		passed = action.clickOn(SuspendRelease_ActionButton);

		return passed;
	}

	/* Suspend/Release select suspension reason */
	public boolean selectSuspensionReason() {
		boolean passed = false;

		passed = action.waitFor(SuspendReleaseSuspensionReason_DropDown, 4, true);
		passed = action.selectBy(SuspendReleaseSuspensionReason_DropDown, 02);

		return passed;
	}

	// * Suspend/Release Click on suspend button
	public boolean clickonSuspendbutton() {
		boolean passed = false;

		passed = action.waitFor(SuspendReleaseSuspend_Button, 4, true);
		passed = action.clickOn(SuspendReleaseSuspend_Button);

		return passed;
	}

	// Suspend/Release Click on Clear button
	public boolean clickonSuspendClearbutton() {
		boolean passed = false;

		passed = action.waitFor(SuspendReleaseClear_Button, 4, true);
		passed = action.clickOn(SuspendReleaseClear_Button);

		return passed;
	}

	// Suspend/Release Click on Cancel button
	public boolean clickonSuspendCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(SuspendReleaseCancel_Button, 4, true);
		passed = action.clickOn(SuspendReleaseCancel_Button);

		return passed;
	}

	// Suspend/Release Click on Release button
	public boolean clickonReleasebutton() {
		boolean passed = false;

		passed = action.waitFor(SuspendReleaseRelease_Button, 4, true);
		passed = action.clickOn(SuspendReleaseRelease_Button);

		return passed;
	}
	// -----------------------------------------------------

	// ----------------------------------------------------------
	// Click on UpgreadeFaultPriority action button
	public boolean clickonUpgradeFaultPriorityactionbutton() {
		boolean passed = false;

		passed = action.waitFor(UpgreadeFaultPriority_ActionButton, 4, true);
		passed = action.clickOn(UpgreadeFaultPriority_ActionButton);

		return passed;
	}

	/* Upgrade Fault priority select new priority */
	public boolean selectNewPriorityDropdown() {
		boolean passed = false;

		passed = action.waitFor(UgradeFaultPriorityNewPriority_DropDown, 4, true);
		passed = action.selectBy(UgradeFaultPriorityNewPriority_DropDown, 2);

		return passed;
	}

	// * Upgrade Fault priority select accept button
	public boolean clickonFaultPriorityAcceptbutton() {
		boolean passed = false;

		passed = action.waitFor(UgradeFaultPriorityAccept_Button, 4, true);
		passed = action.clickOn(UgradeFaultPriorityAccept_Button);

		return passed;
	}

	// Upgrade Fault priority select cancel priority
	public boolean clickonFaultPriorityCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(UpgradeFaultPriorityCancel_Button, 4, true);
		passed = action.clickOn(UpgradeFaultPriorityCancel_Button);

		return passed;
	}
	// ------------------------------------------------

	// -------------------------------------------
	// Click on Record Fault Test action button
	public boolean clickonRecordFaultTestactionbutton() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultTest_actionButton, 4, true);
		passed = action.clickOn(RecordFaultTest_actionButton);

		return passed;
	}

	/* Record Fault Test Diagnosis drop down */
	public boolean selectRecordFaultTestDiagnosisDropDown() {
		boolean passed = false;

		passed = action.waitFor(RecordTestResultDiagnosis_DropDown, 4, true);
		passed = action.selectBy(RecordTestResultDiagnosis_DropDown, "1-TP Needs dropwire replaced");

		return passed;
	}

	// * Record Fault Test Apply button
	public boolean clickonRecordFaultTestApplybutton() {
		boolean passed = false;

		passed = action.waitFor(RecordTestResultApply_Button, 4, true);
		passed = action.clickOn(RecordTestResultApply_Button);

		return passed;
	}

	// Record Fault Test Cancel button
	public boolean clickonRecordFaultTestClearbutton() {
		boolean passed = false;

		passed = action.waitFor(RecordTestResultCancel_Button, 4, true);
		passed = action.clickOn(RecordTestResultCancel_Button);

		return passed;
	}
	// ---------------------------------------------

	// -------------------------------------------------
	// Click on Record Fault Test action button
	public boolean clickonPrintFaultDocketactionbutton() {
		boolean passed = false;

		passed = action.waitFor(PrintFaultDocket_ActionButton, 4, true);
		passed = action.clickOn(PrintFaultDocket_ActionButton);

		return passed;
	}

	// * Print Fault Docket Accept button
	public boolean clickonPrintFaultDocketAcceptbutton() {
		boolean passed = false;

		passed = action.waitFor(PrintFaultDocketAccept_Button, 4, true);
		passed = action.clickOn(PrintFaultDocketAccept_Button);

		return passed;
	}

	// Print Fault Docket Cancel button
	public boolean clickonPrintFaultDocketCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(PrintFaultDocketBack_Button, 4, true);
		passed = action.clickOn(PrintFaultDocketBack_Button);

		return passed;
	}
	// ----------------------------------------------------

	// -------------------------------------------------------
	// Click on Record Fault Test action button
	public boolean clickonRecordFaultActivityActionbutton() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultActivity_ActionButton, 4, true);
		passed = action.clickOn(RecordFaultActivity_ActionButton);

		return passed;
	}

	// * Record Fault Activity record activity button
	public boolean clickonRecordActivitybutton() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultActivitiesRecordActivity_Button, 4, true);
		passed = action.clickOn(RecordFaultActivitiesRecordActivity_Button);

		return passed;
	}

	// Record Fault Activity Cancel button
	public boolean clickonRecordActivityCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultActivitiesCancel_Button, 4, true);
		passed = action.clickOn(RecordFaultActivitiesCancel_Button);

		return passed;
	}

	/* Record Fault Activity selection of Activity ID and Activity Notes */
	public boolean recordFaultActivitySelectActivityIDActivityNotes() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultActivitiesActivityID_Dropdown, 4, true);
		passed = action.selectBy(RecordFaultActivitiesActivityID_Dropdown, "Call Customer Care");

		passed = action.waitFor(RecordFaultActivitiesActivityNotes_Input, 4, true);
		passed = action.sendDataTo(RecordFaultActivitiesActivityNotes_Input, "Test");
		return passed;
	}

	/* Record Fault Activity Accept of Raising activity */
	public boolean recordFaultActivityRaiseActivityAceeptbutton() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultActivitiesActivityAccept_Button, 4, true);
		passed = action.clickOn(RecordFaultActivitiesActivityAccept_Button);

		return passed;
	}

	/* Record Fault Activity Cancel of Raising activity */
	public boolean recordFaultActivityRaiseActivityCancelbutton() {
		boolean passed = false;

		passed = action.waitFor(RecordFaultActivitiesActivityCancel_Button, 4, true);
		passed = action.clickOn(RecordFaultActivitiesActivityCancel_Button);

		return passed;
	}
	// ---------------------------------------------------------------
}
