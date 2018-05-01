package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;

public class LimeliteNewCustomer {

	TestActions action = null;
	RandomData random = new RandomData();

	// Application & service package panel

	By applicationForm_DropDown = By.xpath("//*[text()='Application Form:']/following::select[1]");
	By servicePackage_DropDown = By.xpath("//*[text()='Service Package:']/following::select[1]");
	By applicationDate_Input = By.xpath("//*[text()='Application Date:']/following::input[1]");
	By proceed_Button = By.xpath("//*[@value='Proceed >>']");
	By applicationDetails_ColumnHeader = By.xpath("//*[text()='Service Package']");
	By ShorCutPopupOK_Button = By.xpath("//input[@value='OK']");
	// Customer Information panel for both residential and business customers

	By customerInfo_panelHeader = By.xpath("//*[text()='Customer Info - Credit Validation']");

	By salutation_Dropdown = By.xpath("//*[text()='Salutation:']/following::select[1]");
	By surname_Input = By.xpath("//*[text()='Surname:']/following::input[1]");
	By firstName_Input = By.xpath("//*[text()='First Name:']/following::input[1]");
	By middleName_Input = By.xpath("//*[text()='Middle Name:']/following::input[1]");
	By DOB_Date = By.xpath("//*[text()='Date Of Birth:']/following::input[1]");
	By segment_DropDown = By.xpath("//*[text()[contains(.,'Segment')]]/following::select[1]");
	By emailNotification_RadioButton = By.xpath("//*[text()='E-mail Notification:']/following::input[1]");
	By primaryEmailAddress_Input = By.xpath("//*[text()='Primary E-mail Address:']/following::input[1]");
	By PrimaryEmailAddressDisabled_Input = By
			.xpath("(//*[text()='Primary E-mail Address:']/following::input[@disabled='true'])[1]");

	By gender_radioButton = By.xpath("//*[text()='Gender:']/following::input[1]");
	By tradingName_Input = By.xpath("//*[text()='Trading Name:']/following::input[1]");
	By SortCode_Dropdown = By.xpath("//*[text()[contains(.,'Sort')]]/following::select[1]");
	By nationality_DropDown = By.xpath("//*[text()='Nationality']/following::select[1]");

	
	By customerType_DropDown = By.xpath("//*[text()='Customer Type:']/following::select[1]");
	By billStatusArea_Input = By.xpath("//*[text()='Bill Status Area:']/following::input[1]");
	By billStatusArea_Icon = By.xpath("//*[text()='Bill Status Area:']/following::input[2]");
	By billStatusArea_DropDown = By.xpath("//*[text()='Bill Status Area:']/following::select[1]");
	By occupation_Input = By.xpath("//*[text()='Occupation:']/following::input[1]");
	By employmentStatus_DropDown = By.xpath("//*[text()='Employment Status:']/following::select[1]");
	
	// Billing details
	By billReport_DropDown = By.xpath("//*[text()='Bill Report:']/following::select[1]");
	By interimBillReport_DropDown = By.xpath("//*[text()='Interim Bill Report:']/following::select[1]");
	By primaryDayOfBiling_DropDown = By.xpath("//*[text()='Primary Day Of Billing:']/following::select[1]");
	
	
	// Billing and company address panel
	By addressType_DropDown = By.xpath("//*[text()='Address Type:']/following::select[1]");
	By addressLine1_Input = By.xpath("//*[text()='Street No and Name:']/following::input[1]");
	By addressLine2_Input = By.xpath("//*[text()='Street No and Name:']/following::input[2]");
	By addressLine3_Input = By.xpath("//*[text()='Street No and Name:']/following::input[3]");

	By companyBillingAddress_panelHeader = By.xpath("//*[text()='Company Billing Address']");
	By companyAddress_sameAsBillingSelect = By.xpath("//*[text()='Company Address:']/following::input[1]");

	// Customer ID panel
	By customerID_PanelHeader = By.xpath("//*[text()='Customer ID']");
	
	By customerID_InputDisabled = By.xpath("//*[text()='ID:']/following::input[@disabled=\"\"]");
	By customerID_DropDown = By.xpath("//*[text()[contains(.,'ID')]]/following::select[1]");
	By customerID_Input = By.xpath("(//*[text()='ID:'])[1]/following::input[1]");

	// Contact information
	By ContactInformation_PanelHeader = By.xpath("//*[text() = 'Contact Information']");
	
	By addNewContact_Button = By.xpath("//*[@value='Add New Contact']");

	By contactName_Input = By.xpath("//*[text()='Contact Name:']/following::input[1]");
	By sameAsBillingAddress_CheckBox = By.xpath("//*[text()='Same as Billing:']/following::input[1]");
	By emailIDForElectricalBill_Input = By.xpath("//*[text()[contains(.,'electronic Bill')]]/following::input[1]");
	By emailIDForElectricalBill_CheckBox = By.xpath("//*[text()[contains(.,'electronic Bill')]]/following::input[2]");
	By contactEmailAddress_Input = By.xpath("//*[text() = 'E-mail Address']/following::input[1]");
	By contactHomeNumber_Input = By.xpath("//*[text() = 'Home Number']/following::input[1]");
	By contactMobileNumber_Input = By.xpath("//*[text() = 'Mobile Number 1']/following::input[1]");
	
	//Application source and sales person selection
	By servicePackage_PanelHeader = By.xpath("//*[text()='Service Package']");
	By applicationSource_DropDown = By.xpath("//*[text()='Application Source:']/following::select[1]");
	By salesPerson_Input = By.xpath("//*[text()='Sales Person:']/following::input[1]");
	By salesPerson_DropDown = By.xpath("//*[text()='Sales Person:']/following::select[1]");
	

	// Proceed button from existingCustomer screen
	By proceedFromExistingCust_Button = By.xpath("//*[@value='Proceed']");
	// next button
	By next_Button = By.xpath("//*[@value='Next>>']");
	
	// confirm button
	By confirm_Button = By.xpath("(//input[@value='Confirm'])[last()]");

	public LimeliteNewCustomer(TestActions action) {
		/***
		 * The passed TestAction class object should be assigned to the local variable
		 */
		this.action = action;
	}

	public boolean navigateLimeliteNewCustomer() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);
		passed = action.waitFor(LiberateCommon.CustomerCare.LIMELITE, 4, true);
		passed = action.clickOn(LiberateCommon.CustomerCare.LIMELITE);

		return passed;
	}

	public boolean serviceApplicationDetailspanel(int ApplicationForm, String ServicePackage) {
		boolean passed = false;

		passed = action.waitFor(applicationDetails_ColumnHeader, 4, true);

		if (action.countOf(ShorCutPopupOK_Button) > 0) {
			action.clickOn(ShorCutPopupOK_Button);
			action.waitFor(ShorCutPopupOK_Button, 2, false);
		}

		passed = action.waitFor(applicationForm_DropDown, 4, true);
		passed = action.selectBy(applicationForm_DropDown, ApplicationForm);
		passed = action.waitFor(servicePackage_DropDown, 4, true);
		passed = action.waitFor(5);
		passed = action.selectBy(servicePackage_DropDown, ServicePackage);
		passed = action.waitFor(5);

		return passed;
	}

	public boolean click_ProceedButton() {

		boolean passed = false;

		passed = action.waitFor(proceed_Button, 4, true);
		passed = action.clickOn(proceed_Button);

		return passed;
	}

	public boolean FillDetailsCustomerInfoPanel_PCLPostPELResidential() {
		boolean passed = false;

		action.waitFor(surname_Input, 2, true);

		if (action.countOf(salutation_Dropdown) > 0)
			passed = action.selectBy(salutation_Dropdown, 2);

		if (action.countOf(surname_Input) > 0)
			passed = action.sendDataTo(surname_Input, random.nextString());
		if (action.countOf(firstName_Input) > 0)
			passed = action.sendDataTo(firstName_Input, random.nextString());
		if (action.countOf(middleName_Input) > 0)
			passed = action.sendDataTo(middleName_Input, random.nextString());
		passed = action.waitFor(2);

		if (action.countOf(DOB_Date) > 0)
			passed = action.typeDataTo(DOB_Date, "0001/01/1991");
		action.moveMouseAwayFromScreen();
		passed = action.waitFor(2);

		return passed;
	}

	public boolean customerID() {
		boolean passed = false;
		if (action.countOf(customerID_DropDown) > 0) {
			action.waitFor(customerID_DropDown, 4, true);
			action.selectBy(customerID_DropDown, 1);
		}
		passed = action.sendDataTo(customerID_Input, random.nextString().substring(0, 15));

		return passed;
	}

	public boolean customerInformation_FixedRes() {
		boolean passed = false;

		action.waitFor(primaryEmailAddress_Input, 5, true);

		if (action.countOf(segment_DropDown) > 0) {
			action.selectBy(segment_DropDown, 2);
		}
		if (action.countOf(gender_radioButton) > 0) {
			passed = action.clickOn(gender_radioButton);
		}
		if (action.countOf(nationality_DropDown) > 0) {
			passed = action.selectBy(nationality_DropDown, 2);
		}
		if (action.countOf(emailNotification_RadioButton) > 0) {
			passed = action.clickOn(emailNotification_RadioButton);
		}
		if (action.countOf(primaryEmailAddress_Input) == 1) {
			action.sendDataTo(primaryEmailAddress_Input, random.nextString().substring(10) + "@cwc.com");
		}
		if (action.countOf(SortCode_Dropdown) > 0) {
			action.selectBy(SortCode_Dropdown, 1);
		}

		return passed;
	}

	public boolean addressDetails(String AddressLine1, String AddressLine2, String AddressLine3) {
		boolean passed = false;
		passed = action.waitFor(addressType_DropDown, 4, true);
		passed = action.selectBy(addressType_DropDown, "A-Standard Address");
		passed = action.waitFor(addressLine1_Input, 4, true);
		passed = action.sendDataTo(addressLine1_Input, AddressLine1);
		passed = action.waitFor(addressLine2_Input, 4, true);
		passed = action.sendDataTo(addressLine2_Input, AddressLine2);
		passed = action.waitFor(addressLine3_Input, 4, true);
		passed = action.sendDataTo(addressLine3_Input, AddressLine3);
		passed = action.waitFor(4);
		if (action.countOf(companyBillingAddress_panelHeader) > 0) {
			action.waitFor(companyAddress_sameAsBillingSelect, 4, true);
			action.clickOn(companyAddress_sameAsBillingSelect);
		}
		return passed;
	}
	
	public boolean customerClassification_Details(String CustomerType) {
		boolean passed = false;
		
		passed = action.waitFor(customerID_PanelHeader, 4, true);
		
		if (action.countOf(customerType_DropDown) > 0) {
			passed = action.selectBy(customerType_DropDown, CustomerType);
			}
		if (action.countOf(billStatusArea_Input) > 0)
		{
			passed = action.sendDataTo(billStatusArea_Input, "B");
			passed = action.waitFor(billStatusArea_Icon, 4, true);
			passed = action.clickOn(billStatusArea_Icon);
			passed = action.waitFor(billStatusArea_DropDown, 4, true);
			passed = action.selectBy(billStatusArea_DropDown, 2);
			
		}
		if (action.countOf(occupation_Input) > 0) {
			passed = action.sendDataTo(occupation_Input, "test");
			}
		if (action.countOf(employmentStatus_DropDown) > 0) {
			passed = action.selectBy(employmentStatus_DropDown, 2);
			}
		
		return passed;
	}
	public boolean billingDetails() 
	{
		boolean passed = false;
		
		passed = action.waitFor(customerID_PanelHeader, 4, true);
		
		if (action.countOf(billReport_DropDown) > 0)
		{
			passed = action.selectBy(billReport_DropDown, 1);
		}
		
		if (action.countOf(interimBillReport_DropDown) > 0)
		{
			passed = action.selectBy(interimBillReport_DropDown, 1);
		}
		
		if (action.countOf(primaryDayOfBiling_DropDown) > 0)
		{
			passed = action.selectBy(primaryDayOfBiling_DropDown, 1);
		}

		
		return passed;
	}
	
	
	public boolean fillContactDetails_Limelite() {
		boolean passed = false;

		passed = action.waitFor(ContactInformation_PanelHeader, 4, true);

		if (action.countOf(addNewContact_Button) == 0) {
			if (action.countOf(contactName_Input) > 0)
			{
				action.sendDataTo(contactName_Input, random.nextString().substring(0, 14));
			}
			if (action.countOf(sameAsBillingAddress_CheckBox) > 0)
			{
				action.clickOn(sameAsBillingAddress_CheckBox);
			}
			if (action.countOf(emailIDForElectricalBill_Input) > 0)
			{
				action.sendDataTo(emailIDForElectricalBill_Input, "billemail@cwc.com");
				action.clickOn(emailIDForElectricalBill_CheckBox);
			}
			
			if (action.countOf(contactEmailAddress_Input) > 0)
			{
				action.sendDataTo(contactEmailAddress_Input, "contactemail@cwc.com");
			}
			
			if (action.countOf(contactHomeNumber_Input) > 0)
			{
				action.sendDataTo(contactHomeNumber_Input, "12345");
			}
			
			if (action.countOf(contactMobileNumber_Input) > 0)
			{
				action.sendDataTo(contactMobileNumber_Input, "876543210");
			}
			action.waitFor(2);

			passed = action.clickOn(CommonPanel.Accept_Button);

			action.waitFor(2);
			action.waitFor(addNewContact_Button, 2, true);
		}

		return passed;
	}

	public boolean click_ConfirmButton()
	{
		boolean passed = false;
		action.waitFor(confirm_Button, 4, true);
		action.clickOn(confirm_Button);
		
		return passed;
	}
	
	public boolean applicationSourceSalesPerson_fill()
	{
		boolean passed = false;
		action.waitFor(servicePackage_PanelHeader, 4, true);
		action.waitFor(applicationSource_DropDown, 4, true);
		action.selectBy(applicationSource_DropDown, 2);
		action.sendDataTo(salesPerson_Input, "9999");
		action.selectBy(salesPerson_DropDown, 1);
		
		return passed;
	}
	
	public boolean clickOnProceedFromExistingCustScreen()
	{
		boolean passed = false;
		
		action.waitFor(proceedFromExistingCust_Button, 4, true);
		action.clickOn(proceedFromExistingCust_Button);
		return passed;
	}
	
	/*
	 * public boolean customerDetailsPCLPostResidential(String Surname, String
	 * FirstName, String DateOfBirth, String AddressLine1, String AddressLine2,
	 * String AddressLine3, String CustomerID) {
	 * 
	 * boolean passed = false;
	 * 
	 * try { if(action.countOf(customerInfo_panelHeader) > 0) { passed =
	 * action.waitFor(surname_Input, 4, true); passed =
	 * action.sendDataTo(surname_Input, Surname); passed = action.waitFor(DOB_Date,
	 * 4, true); passed = action.sendDataTo(DOB_Date, DateOfBirth); if
	 * (action.countOf(customerID_DropDown) > 0) {
	 * action.waitFor(customerID_DropDown, 2, true);
	 * action.selectBy(customerID_DropDown, 1); action.waitFor(customerID_Input, 4,
	 * true); action.sendDataTo(customerID_Input, CustomerID); }
	 * 
	 * // need to add screenshot code passed = action.waitFor(proceed_Button, 4,
	 * true); passed = action.clickOn(proceed_Button); if
	 * (action.countOf(gender_radioButton) > 0) { action.waitFor(gender_radioButton,
	 * 2, true); action.getSelectedOption(gender_radioButton); } if
	 * (action.countOf(primaryEmailAddress_Input) > 0) {
	 * action.waitFor(primaryEmailAddress_Input, 2, true);
	 * action.sendDataTo(primaryEmailAddress_Input, "test@automatic.com"); } if
	 * (action.countOf(SortCode_Dropdown) > 0) { action.waitFor(SortCode_Dropdown,
	 * 2, true); action.selectBy(SortCode_Dropdown, 1); } if
	 * (action.countOf(segment_DropDown) > 0) { action.waitFor(segment_DropDown, 2,
	 * true); action.selectBy(segment_DropDown, 1); } passed =
	 * action.waitFor(addressType_DropDown, 4, true); passed =
	 * action.sendDataTo(addressLine1_Input, AddressLine1); passed =
	 * action.sendDataTo(addressLine2_Input, AddressLine2); passed =
	 * action.sendDataTo(addressLine3_Input, AddressLine3); if
	 * (action.countOf(CompanyBillingAddress_panelHeader) > 0) {
	 * action.waitFor(companyAddress_sameAsBillingSelect, 4, true);
	 * action.clickOn(companyAddress_sameAsBillingSelect); } } else {
	 * 
	 * passed = action.waitFor(surname_Input, 4, true); passed =
	 * action.sendDataTo(surname_Input, Surname); passed = action.waitFor(DOB_Date,
	 * 4, true); passed = action.sendDataTo(DOB_Date, DateOfBirth);
	 * 
	 * if (action.countOf(segment_DropDown) > 0) { action.waitFor(segment_DropDown,
	 * 2, true); action.selectBy(segment_DropDown, 1); }
	 * 
	 * if (action.countOf(primaryEmailAddress_Input) > 0) {
	 * action.waitFor(primaryEmailAddress_Input, 2, true);
	 * action.sendDataTo(primaryEmailAddress_Input, "test@automatic.com"); }
	 * 
	 * if (action.countOf(gender_radioButton) > 0) {
	 * action.waitFor(gender_radioButton, 2, true);
	 * action.getSelectedOption(gender_radioButton); }
	 * 
	 * passed = action.waitFor(addressType_DropDown, 4, true); passed =
	 * action.sendDataTo(addressLine1_Input, AddressLine1); passed =
	 * action.sendDataTo(addressLine2_Input, AddressLine2); passed =
	 * action.sendDataTo(addressLine3_Input, AddressLine3);
	 * 
	 * if (action.countOf(SortCode_Dropdown) > 0) {
	 * action.waitFor(SortCode_Dropdown, 2, true);
	 * action.getSelectedOption(SortCode_Dropdown); } if
	 * (action.countOf(CompanyBillingAddress_panelHeader) > 0) {
	 * action.waitFor(companyAddress_sameAsBillingSelect, 4, true);
	 * action.clickOn(companyAddress_sameAsBillingSelect); } if
	 * (action.countOf(customerID_DropDown) > 0) {
	 * action.waitFor(customerID_DropDown, 2, true);
	 * action.selectBy(customerID_DropDown, 1); action.waitFor(customerID_Input, 4,
	 * true); action.sendDataTo(customerID_Input, CustomerID); } } } catch(Exception
	 * ex) {
	 * 
	 * } return passed;
	 * 
	 * }
	 * 
	 */
	public boolean click_NextButton() {

		boolean passed = false;

		passed = action.waitFor(next_Button, 4, true);
		passed = action.clickOn(next_Button);

		return passed;
	}

}
