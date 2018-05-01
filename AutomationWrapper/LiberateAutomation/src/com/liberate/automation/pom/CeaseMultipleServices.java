package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class CeaseMultipleServices {

	public TestActions action = null;
	
	By numberrangesearch_button= By.xpath("//*[@type='submit' and @value='Search']");
	By lineplant_select = By.xpath("//*[@type='radio' and @value='Release']");
	By accept_button = By.xpath("//*[@type='submit' and @value='Accept']");
	
	public CeaseMultipleServices(TestActions action) {
		this.action = action;
	}
	
	public boolean selectservicesandaccept() {
		boolean passed = false;
		passed = action.waitFor(numberrangesearch_button, 4, true);
		passed = action.clickOn(numberrangesearch_button);
		
		if(action.countOf(lineplant_select)>0) {
		passed = action.waitFor(lineplant_select, 4, true);
		passed = action.clickOn(lineplant_select);
		}
		
		passed = action.waitFor(accept_button,4,true);
		passed = action.clickOn(accept_button);
	
		return passed;
	}

	
}
