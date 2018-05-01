package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.RandomData;
import com.liberate.automation.core.TestActions;

public class MSOAddSpecialInstructions 
{
	private TestActions action = null;
	
	public String ServiceOrderNumber = "";
	public String ServiceNumber = "";
	public String SpecialInstruction = "";
	
	By ServiceOrder_Input = By.xpath("//*[text()='Service Order:']/following::input[1]");
	By Search_Button = By.xpath("//input[@value='Search']");
	By Reset_Button = By.xpath("//input[@value='Reset']");
	
	By ServiceOrderDetails_PanelHeader = By.xpath("//*[text()='Service Order Details']");
	By ServiceOrderNumber_Value = By.xpath("(//*[text()='Service Order:'])[last()]/following::span[1]");
	By ServiceNumber_Value = By.xpath("(//*[text()='Service Number:'])[last()]/following::span[1]");
	
	By AddSpecialInstruction_PanelHeader = By.xpath("(//*[text()='Add Special Instructions'])[2]");
	By SpecialInstruction_TextArea = By.xpath("//textarea");
	
	By Accept_Button = By.xpath("//input[@value='Accept']");
	By Cancel_Button = By.xpath("//input[@value='Cancel']");
	
	By OK_Button = By.xpath("//input[@value='OK']");
	
	public MSOAddSpecialInstructions(TestActions action)
	{
		this.action = action;
	}
	
	public boolean navigate()
	{
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;
		
		passed = action.waitFor(LiberateCommon.LevelOne.Orders,4,true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.ManageServiceOrder,4,true);
		passed = action.clickOn(LiberateCommon.Orders.ManageServiceOrder);
		
		return passed;
	}
	
	public boolean searchServiceOrder(String ServiceOrder)
	{
		boolean passed = false;
		this.ServiceOrderNumber = ServiceOrder;
		
		passed = action.waitFor(ServiceOrder_Input,	4, true);
		passed = action.sendDataTo(ServiceOrder_Input, this.ServiceOrderNumber);
		passed = action.waitFor(1);
		passed = action.clickOn(Search_Button);
		
		return passed;
	}
	
	public boolean verifyServiceOrderDetails()
	{
		boolean passed = false;
		
		passed = action.waitFor(ServiceOrderDetails_PanelHeader, 4, true);
		passed = action.getTextFromPage(ServiceOrderNumber_Value).trim().equals(this.ServiceOrderNumber);
		
		this.ServiceNumber=action.getTextFromPage(ServiceNumber_Value).trim();
		
		return passed;
	}
	
	public boolean addSpecialInstruction()
	{
		action.scrollDown();
		action.waitFor(1);
		
		boolean passed = false;
		RandomData random = new RandomData();
		
		this.SpecialInstruction = random.nextString();
		
		passed = action.waitFor(SpecialInstruction_TextArea,4,true);
		passed = action.sendDataTo(SpecialInstruction_TextArea, SpecialInstruction);
		passed = action.waitFor(1);
		passed = action.clickOn(Accept_Button);
		
		return passed;
	}
	
	public boolean clickOnOKpopup()
	{
		boolean passed = false;
		
		passed = CommonPanel.popUp.clickOK(action);

		return passed;
	}
	
}
