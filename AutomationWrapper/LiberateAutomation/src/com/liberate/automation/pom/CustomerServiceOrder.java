package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.core.TestActions;

public class CustomerServiceOrder {
	TestActions action = null;

	By ExcludeCeaseClosed_CheckBox = By.xpath("//*[text()='Exclude Closed/Ceased Accounts:']");

	By ServiceOrderList_PanelHeader = By.xpath("//*[text()='Service Order List']");

	By ServiceOrderFilter_Input = By
			.xpath("(//th[contains(@class,'ui-widget-header')]//child::div//descendant::input)[2]");

	/***
	 * <br>
	 * Append [count]//td[1]//span for Cancelled Indicator <br>
	 * Append [count]//td[2]//span for Service Order Number <br>
	 * Append [count]//td[3]//span for Service Number <br>
	 * Append [count]//td[4]//span for Status <br>
	 * Append [count]//td[5]//span for Department <br>
	 * Append [count]//td[6]//span for Command <br>
	 * Append [count]//td[7]//span for Number Of Service <br>
	 * Append [count]//td[8]//span for Priority Append [count]//td[9]//span for
	 * Raised Date <br>
	 * Append [count]//td[10]//span for Completed Date <br>
	 * Append [count]//td[11]//span forAction Date <br>
	 * Append [count]//td[12]//span for Split <br>
	 * Append [count]//td[13]//span for Application Source <br>
	 * Append [count]//td[14]//span for Sales Person
	 */
	By ServiceOrder_Row = By.xpath("//tr[@id[contains(.,'serviceOrderForm:serviceOrdersTabSet:0:')]]");

	public CustomerServiceOrder(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);
		
		boolean passed = false;

		if (action.countOf(ExcludeCeaseClosed_CheckBox) > 0) {
			action.waitFor(ExcludeCeaseClosed_CheckBox, 4, false);
		}

		if (!(action.countOf(ServiceOrderList_PanelHeader) > 0))
			passed = action.waitFor(LeftLink.Search.ServiceOrders, 4, true);
		passed = action.clickOn(LeftLink.Search.ServiceOrders);

		return passed;
	}

	public boolean filterByServiceOrder(String ServiceOrder) {
		boolean passed = false;

		passed = action.waitFor(ServiceOrderFilter_Input, 4, true);
		passed = action.sendDataTo(ServiceOrderFilter_Input, ServiceOrder);

		action.waitFor(3);

		passed = action.clickOn(ServiceOrder_Row);

		return passed;
	}

	public String getSOCancelledIndicator() {
		action.waitFor(ServiceOrderFilter_Input, 4, true);
		return (action.getTextFromPage(By.xpath(action.getXpath(ServiceOrder_Row) + "[1]//td[1]//span")).trim());
	}

	public String getSOCommand() {
		action.waitFor(ServiceOrderFilter_Input, 4, true);
		return (action.getTextFromPage(By.xpath(action.getXpath(ServiceOrder_Row) + "[1]//td[6]//span")).trim());
	}

	public String getSONumber() {
		action.waitFor(ServiceOrderFilter_Input, 4, true);
		return (action.getTextFromPage(By.xpath(action.getXpath(ServiceOrder_Row) + "[1]//td[2]//span")).trim());
	}
	
	public String getServiceONumber() {
		action.waitFor(ServiceOrderFilter_Input, 4, true);
		return (action.getTextFromPage(By.xpath(action.getXpath(ServiceOrder_Row) + "[1]//td[3]//span")).trim());
	}

}
