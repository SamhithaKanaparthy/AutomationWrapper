package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;



public class AlterLineProduct {
	
	TestActions action = null;
	By department_Select = By.xpath("//*[text()='Department:']//following::select[1]");
    By siteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
    By site_Select = By.xpath("//*[text()='Site:']//following::select[1]");
    By  salesPerson_Select = By.xpath("//*[@id=\"alterForm:salesPerson\"]");
    By AplicationSource_Select = By.xpath("//*[text()='Application Source:']//following::select[1]");
    By SelectProduct_Panel = By.xpath("//td[text() = 'Product Description']//following::span[2]");
    By product_Select = By.xpath("//*[text()='Product:']//following::select[5]");
    By accept_button = By.xpath("//*[@value='Accept']");
    
    public AlterLineProduct(TestActions action) {
        this.action = action;
 }
    
    public boolean selectDepartmentSite(String department, String site ) {
        boolean passed = false;
        passed = action.waitFor(department_Select, 4, true);
        passed = action.selectByPartialText(department_Select, department);

        passed = action.waitFor(siteDisabled_Select, 4, false);
        passed = action.selectByPartialText(site_Select, site);
        
        passed = action.waitFor(salesPerson_Select, 4, false);
        passed = action.selectBy(salesPerson_Select, 1);

        passed = action.waitFor(AplicationSource_Select, 4, false);
        passed = action.selectBy(AplicationSource_Select, 1);
        
        
        passed = action.waitFor(product_Select, 4, false);
        passed = action.selectBy(product_Select, 1);
        
        action.clickOn(accept_button);
        
        return passed;
 }


    

	
	

}
