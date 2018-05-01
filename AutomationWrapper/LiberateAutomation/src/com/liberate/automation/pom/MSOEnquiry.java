package com.liberate.automation.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class MSOEnquiry 
{
	private TestActions action = null;
	
	public String ServiceOrderNumber = "";
	public String ServiceNumber = "";
	public String AccountNumber = "";
	
	public MSOEnquiry(TestActions action)
	{
		this.action = action;
	}
	
	//Search Panel
	By ServiceOrder_Input = By.xpath("//*[text()='Service Order:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");
	
	//Service Order Details
	By ServiceOrderDetails_PanelHeader = By.xpath("//*[text()='Service Order Details']");
	
	By ServiceOrderNumber_Value = By.xpath("(//*[text()='Service Order:'])[last()]/following::span[1]");
	By ServiceNumber_Value = By.xpath("(//*[text()='Service Number:'])[last()]/following::span[1]");
	
	//Summary Details
	By SummaryDetails_Tab = By.xpath("(//td[text()='Summary Details'])[1]");
	By AccountNumber_Value = By.xpath("(//*[text()='Account Number:'])[last()]/following::span[1]");
	
	
	//Department Circulation
	By DepartmentCirculation_Tab = By.xpath("(//td[text()='Department Circulation'])[1]");
	/***
	 * Can Be used to get the count of row of Department Circulation. Can Append '[<i>count</i>]' for a particular row.
	 * After '<i>count</i>' append 
	 * <br>'<i>/descendant::td[1]</i>' for Department
	 * <br>'<i>/descendant::td[2]</i>' for From Date
	 * <br>'<i>/descendant::td[3]</i>' for To Date
	 * <br>'<i>/descendant::td[4]</i>' for Status
	 * <br>'<i>/descendant::td[5]</i>' for Created By
	 * <br>'<i>/descendant::td[6]</i>' for Actioned By
	 * <br>'<i>/descendant::td[7]</i>' for Signed Off By
	 * <br>'<i>/descendant::td[8]</i>' for Status Reason
	 */
	By Circulation_Row = By.xpath("//tr[contains(@id,'serviceOrderEnquiryForm:serviceOrderEnquiryTabs:')]");	
	
	//Special Instructions
	By SpecialInstructions_Tab =  By.xpath("(//td[text()='Special Instructions'])[1]");
	By SpecialInstructions_PanelHeader = By.xpath("(//*[text()='Special Instructions'])[2]");
	
	/***
	 * Method called to navigate to manage Service Order Enquiry
	 * @return	True  : If able to Navigate.
	 * 			<br>False : If failed to Navigate.
	 */
	public boolean navigate()
	{
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;
		
		action.scrollUp();
		action.waitFor(1);
		
		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder,4,true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		passed = action.waitFor(LeftLink.ManageServiceOrder.Enquiry,4,true);
		passed = action.clickOn(LeftLink.ManageServiceOrder.Enquiry);
		
		return passed;
	}
	
	/***
	 * Method the search for a service order in Enquiry screen.
	 * @param serviceOrderNumber The Service Order Number to be searched for.
	 * @return True : If able to search. <br>False : If search for service order is failed.
	 */
	public boolean searchServiceOrder(String serviceOrderNumber)
	{
		this.ServiceOrderNumber = serviceOrderNumber;
		
		boolean passed = false;
		
		passed = action.waitFor(ServiceOrder_Input,4,true);
		passed = action.sendDataTo(ServiceOrder_Input, serviceOrderNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	/***
	 * Method to verify Service Order Details screen.
	 * @param serviceOrderNumber The service Order to be searched for.
	 * @return
	 */
	public boolean verifyServiceOrderDetails(String serviceOrderNumber)
	{
		this.ServiceOrderNumber = serviceOrderNumber;

		boolean passed = false;
		
		passed = action.waitFor(ServiceOrderDetails_PanelHeader,4,true);
		passed = action.getTextFromPage(ServiceOrderNumber_Value).trim().equals(serviceOrderNumber)?true:false;
		
		if(!passed)
		{
			return passed;
		}
		
		this.ServiceOrderNumber = action.getTextFromPage(ServiceOrderNumber_Value);
		this.ServiceNumber = action.getTextFromPage(ServiceNumber_Value);
		this.AccountNumber = action.getTextFromPage(AccountNumber_Value);
		
		System.out.println("Service Order Number : " + ServiceOrderNumber);
		System.out.println("Service Number : " + ServiceNumber);
		System.out.println("Account Number : " + AccountNumber);
		
		return passed;
	}
	
	/***
	 * The method used to navigate to department circulation.
	 * @return
	 */
	public boolean verifyDepartmentCirculation()
	{
		boolean passed = false;
		
		passed = action.waitFor(DepartmentCirculation_Tab, 4, true);
		passed = action.clickOn(DepartmentCirculation_Tab);

		passed = action.waitFor(Circulation_Row, 4, true);
		
		return passed;
	}
	
	/***
	 * Method used to get all the departments the Service Order Currently belongs to.
	 * @return The List of Departments the Service ORder currently belongs to.
	 */
	public List<String> getCurrentDepartments()
	{
		List<String> CurrentDepartments = new ArrayList<String>();
		
		int count = action.countOf(Circulation_Row);
		for(int i = 0; i < count; i++)
		{
			//Checking if action date is blank. If Date is blank, then Service order belongs to that department.
			String actionDate = action.getTextFromPage(By.xpath((action.getXpath(Circulation_Row)+"["+(i+1)+"]"+"/descendant::td[3]"))).trim();
			if(actionDate.equals(""))
			{
				//Getting the department name (cell value) where the action date is blank.
				CurrentDepartments.add(action.getTextFromPage(By.xpath((action.getXpath(Circulation_Row)+"["+(i+1)+"]"+"/descendant::td[1]"))).trim());
			}
		}
				
		return CurrentDepartments;
	}
	
	public String getCurrentServiceOrderStatus()
	{
		return (action.getTextFromPage(By.xpath((action.getXpath(Circulation_Row)+"[1]"+"/descendant::td[4]"))).trim());
	}
	
	public boolean verifySepcialInstructions(String SpecialInstruction)
	{
		boolean passed = false;
		
		passed = action.clickOn(SpecialInstructions_Tab);
		
		passed = action.waitFor(SpecialInstructions_PanelHeader, 4, true);
		
		passed = action.countOf(By.xpath("//*[text()='"+SpecialInstruction+"']"))>0;
		
		return passed;
	}
	
}
