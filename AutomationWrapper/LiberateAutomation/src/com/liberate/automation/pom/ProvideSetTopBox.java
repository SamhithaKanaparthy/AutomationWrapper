package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class ProvideSetTopBox 
{
	TestActions action = null;
	
	By department_Select = By.xpath("//*[text()='Department:']//following::select[1]");
	By siteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
	By site_Select = By.xpath("//*[text()='Site:']//following::select[1]");
	By applicationSouce_Select = By.xpath("//*[text()='Application Source:']//following::select[1]");
	
	By Proceed_Button = By.xpath("//*[@value='Proceed']");
	By ProductPST_DropDown = By.xpath("//*[text()='Product:']/following::select[1]");
	By Allocate_Button = By.xpath("//*[@value='Allocate']");
	By SearchIcon_AllocateMAC = By.xpath("//*[@class='innertable']//tbody//tr[2]/td[2]//input[2]");
	By MACAddress_DropDown = By.xpath("//*[text()='MAC Address:']//following::select[1]");
	By Deallocate_Button = By.xpath("//*[@value='Deallocate']");
	
	By Accept_Button = By.xpath("//*[@value='Accept']");
	By Cancel_Button = By.xpath("//*[@value='Cancel']");
	
	
	public ProvideSetTopBox(TestActions action) {
		this.action = action;
	}
	
	
	public boolean selectDeptSite(String department, String site)
	{
		boolean passed = false;

		passed = action.waitFor(department_Select, 4, true);
		passed = action.selectByPartialText(department_Select, department);

		passed = action.waitFor(siteDisabled_Select, 4, false);
		passed = action.selectByPartialText(site_Select, site);
		passed = action.waitFor(applicationSouce_Select, 4, true);
		passed = action.selectBy(applicationSouce_Select, 1);
				
		return passed;
	}
	
	public boolean clickonProceed()
	{
		boolean passed = false;
		passed = action.waitFor(5);
//		passed = action.waitFor(Proceed_Button, 5, true);
		passed = action.clickOn(Proceed_Button);
		passed = action.waitFor(5);
		
		return passed;
	}
			
	public boolean allocateMACAddress(String productCode)
	{
		boolean passed = false;
		
		passed = action.waitFor(ProductPST_DropDown, 5, true);
		passed = action.selectByPartialText(ProductPST_DropDown, productCode);
		passed = action.waitFor(5);
		
		passed = action.waitFor(SearchIcon_AllocateMAC, 5, true);
		passed = action.clickOn(SearchIcon_AllocateMAC);
		passed = action.waitFor(MACAddress_DropDown, 5, true);
		passed = action.selectBy(MACAddress_DropDown, 1);
		passed = action.waitFor(Allocate_Button, 5, true);
		passed = action.clickOn(Allocate_Button);
		passed = action.waitFor(Deallocate_Button, 5, true);
		
		return passed;		
	}
	
	public boolean clickonAccept()
	{
		boolean passed = false;
		
		passed = action.waitFor(Accept_Button, 5, true);
		passed = action.clickOn(Accept_Button);
		passed = action.waitFor(5);
		
		return passed;
	}

}
