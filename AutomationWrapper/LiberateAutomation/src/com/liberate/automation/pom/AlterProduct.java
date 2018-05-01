package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AlterProduct {

	TestActions action = null;

	By department_Select = By.xpath("//*[text()='Department:']//following::select[1]");
	By siteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
	By site_Select = By.xpath("//*[text()='Site:']//following::select[1]");
	By AplicationSource_Select = By.xpath("//*[text()='Application Source:']//following::select[1]");
	By Proceed_button = By.xpath("//*[@value=\"Proceed >>\"]");
	By SelectProduct_Panel = By.xpath("//*[@id=\"alterProductsDetailsForm:plantItemList:0:productDescription\"]");
	By Product_dropdown = By.xpath("//select[@id = \"alterProductsDetailsForm:changedProduct\"]");
	By Accept_button = By.xpath("//*[@value=\"Accept\"]");

	public AlterProduct(TestActions action) {
		this.action = action;
	}

	public boolean selectDepartmentSite(String department, String site ) {
		boolean passed = false;

		passed = action.waitFor(department_Select, 4, true);
		passed = action.selectByPartialText(department_Select, department);

		passed = action.waitFor(siteDisabled_Select, 4, false);
		passed = action.selectByPartialText(site_Select, site);

		passed = action.waitFor(AplicationSource_Select, 4, false);
		passed = action.selectBy(AplicationSource_Select, 1);
		
		action.clickOn(Proceed_button);
		
		return passed;
	}
	
	
	public boolean alterProductScreen() {
		return action.clickOn(SelectProduct_Panel);
				
	}
	
	
	public boolean altertTOProduct()
	{
		boolean passed = false;
		passed = action.waitFor(Product_dropdown, 4, true);
		passed = action.selectBy(Product_dropdown, 1); //need to pass value by index
		 action.clickOn(Accept_button);
		 return passed;
	}
	
}