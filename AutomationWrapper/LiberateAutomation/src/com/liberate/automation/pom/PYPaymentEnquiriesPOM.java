package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYPaymentEnquiriesPOM 
{
	TestActions action = null;
			
			
	//Payment Enquiries Panel Header
	By PaymentEnquiry_PanelHeader = By.xpath("//*[text()='Payment Enquiry']");
			
	// Payemnt enquiries search options - Input fileds
	By SearchAccountNumber_InputField = By.xpath("//*[text()='Account No :']/following::input[1]");
	By SearchServiceOrderNumber_InputField = By.xpath("//*[text()='Service Order Number:']/following::input[1]");
	By SearchPaymentNo_InputField = By.xpath("//*[text()='Payment No  :']/following::input[1]");
	// But as of now we are not considering cheque number field 
	By SearchChequeOrCardNo_InputField = By.xpath("//*[text()='Cheque/Card No:']/following::input[1]");
					
	// Payemnt enquiries search options - Dropdown 
	By SearchStatus_Dropdown = By.xpath("//*[text()='Status:']/following::select[1]");
			
	// Payemnt enquiries - Command buttons
	By SearchButton = By.xpath("//*[@value='Search']");
	By ResetButton = By.xpath("//*[@value='Reset']");
			
	// Selecting payment details column to get 'Account Details' command button
	By PaymetDetails_Column_getAccountDetailsCommandButton = By.xpath("//*[@class='iceDatTbl datatablestyle']//td[3]");
			
	// Command buttons after getting payment details
	By VoidPayment_CommandButton = By.xpath("//*[@value='Void Payment']");
	By AccountDetails_CommandButton = By.xpath("//*[@value='Account Details']");
	By BackButton = By.xpath("//*[@value='<< Back']");
	By CancelButton = By.xpath("//*[@value='Cancel']");
			
	/***
	* Default constructor that takes TestAction object as argument.
	* 
	* @param action
	*            The TestAction class object, which will be used to run test
	*            steps
	*/

	public PYPaymentEnquiriesPOM(TestActions action) 
	{
		this.action = action;
	}
			
			
	/***
	* The method to navigate to Payment Enquiries screen
	* 
	* @return Returns true if able to navigate, else will return false.
	*/
	public boolean navigate() 
	{
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

			passed = action.waitFor(LiberateCommon.LevelOne.Admin, 4, true);
			passed = action.clickOn(LiberateCommon.LevelOne.Payments);
			passed = action.waitFor(LiberateCommon.Payments.Payments, 4, true);
			passed = action.clickOn(LiberateCommon.Payments.Payments);
			passed = action.waitFor(LeftLink.Payments.Enquiries, 4, true);
			passed = action.clickOn(LeftLink.Payments.Enquiries);

		return passed;
	}		 

			
	/***
	* The method to search with an account number in payment enquiries
	* 
	* @return Returns true if able to navigate, else will return false.
	*/
	public boolean paymentEnquiryWithAccountNumber(String AccountNumber) 
	{
		boolean passed = false;

			passed = action.waitFor(SearchButton, 4, true);
			passed = action.sendDataTo(SearchAccountNumber_InputField, AccountNumber);
			passed = action.waitFor(SearchButton, 4, true);
			passed = action.clickOn(SearchButton);

		return passed;
	}		 

	
	/***
	* The method to search with an account number in payment enquiries
	* 
	* @return Returns true if able to navigate, else will return false.
	*/
	public boolean paymentEnquiryWithPaymentNo(String PaymentNumber) 
	{
		boolean passed = false;

			passed = action.waitFor(SearchButton, 4, true);
			passed = action.sendDataTo(SearchPaymentNo_InputField, PaymentNumber);
			passed = action.waitFor(SearchButton, 4, true);
			passed = action.clickOn(SearchButton);

		return passed;
	}

	
	/***
	* The method to search with an account number in payment enquiries
	* 
	* @return Returns true if able to navigate, else will return false.
	*/
	public boolean paymentEnquiryWithServiceOrderNo(String ServiceOrderNumber) 
	{
		boolean passed = false;

			passed = action.waitFor(SearchButton, 4, true);
			passed = action.sendDataTo(SearchServiceOrderNumber_InputField, ServiceOrderNumber);
			passed = action.waitFor(SearchButton, 4, true);
			passed = action.clickOn(SearchButton);

		return passed;
	}
	
	

	/***
	 * Method to get Account details for the searched payment
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean clickOnAccountDetails_CommandButton()
	{
		boolean passed = false;
		
			passed = action.waitFor(BackButton, 4, true);
			passed = action.clickOn(PaymetDetails_Column_getAccountDetailsCommandButton);
			passed = action.waitFor(AccountDetails_CommandButton, 4, true);
			passed = action.waitForClickable(AccountDetails_CommandButton, 4);			passed = action.clickOn(AccountDetails_CommandButton);
			passed = action.waitFor(BackButton, 4, true);
			
		return passed;	
	}
	
	
	
	/***
	 * Method to click on void payment button for the searched payment
	 * 
	 * @return True, if able to select; false if not able to select.
	 */
	public boolean clickOnVoidPayment_CommandButton()
	{
		boolean passed = false;
		
			passed = action.waitFor(VoidPayment_CommandButton, 4, true);
			passed = action.clickOn(VoidPayment_CommandButton);
			
		return passed;	
	}
}
