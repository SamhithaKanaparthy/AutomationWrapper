package com.liberate.automation.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;

public class ServiceProductsTab {
	TestActions action;

	By ProvideCease_ActionButton = By.xpath("//span[text()='Provide/Cease Products']");

	By Command_Select = By.xpath("//*[text()='Command:']//following::select[1]");
	By ProductsDisabled_Select = By.xpath("//*[text()='Products:']//following::select[@disabled ='disabled']");
	By Products_Select = By.xpath("//*[text()='Products:']//following::select[1]");
	By Add_Button = By.xpath("//input[@value='Add']");
	By PerformSalesSignOff_CheckBox = By.xpath("//*[text()='Perform Sales Sign Off:']//following::input[1]");

	By FistProduct_CheckBox = By.xpath("//*[@id='provideCeaseForm:ceaseProductTable:0:select']");
	By CeaseReason_Select = By.xpath("(//*[text()='Cease Reason']//following::select)[1]");
	By CeaseComments_TestArea = By.xpath("(//*[text()='Comments:']//following::textarea)[1]");
	By product_code = By.xpath(
			"//div[@id='customerServicesForm:serviceEnquiryTabs:0:productsTab:custServProductsResultTable']/div[2]/table/tbody/tr/td[2]//span");

	By OK_Button = By.xpath("//input[contains(@value,'OK')]");

	public ServiceProductsTab(TestActions action) {
		this.action = action;
	}

	public boolean verifyProductsScreen() {
		/***
		 * Append [count]//descendant::td[1] for Service Number<br>
		 * Append [count]//descendant::td[2] for Product Code<br>
		 * Append [count]//descendant::td[3] for Status<br>
		 * Append [count]//descendant::td[4] for Description<br>
		 */
		By Products_Row = By.xpath(
				"//tr[contains(@id,'customerServicesForm:serviceEnquiryTabs:0:productsTab:custServProductsResultTable_row_')]");

		boolean passed = false;

		passed = action.waitFor(Products_Row, 24, true);
		for (int i = 0; i < action.countOf(Products_Row); i++) {
			for (int j = 0; j < 4; j++) {
				TestActions.log(action.getTextFromPage(
						By.xpath(action.getXpath(Products_Row) + "[" + (i + 1) + "]//descendant::td[" + (j + 1) + "]"))
						+ " ");
			}
		}

		return passed;
	}
	
	public boolean countofproducts() {
		boolean passed = false;
		passed = action.waitFor(product_code, 6, true);

		List<WebElement> products = action.getElements(product_code);

		for (int i = 0; i < action.countOf(product_code); i++) {
			TestActions.log("Product " + i + " : " + action.getTextFromPage(products.get(i)));
		}
		
		return passed;
	}

	public boolean provideProduct(String Department, String Site, String Command) {
		boolean passed = false;

		passed = action.waitFor(ProvideCease_ActionButton, 6, true);
		passed = action.clickOn(ProvideCease_ActionButton);

		passed = CommonPanel.ServiceOrder.selectDepartmentSite(action, Department, Site);

		passed = action.selectByPartialText(Command_Select, Command);
		passed = action.waitFor(ProductsDisabled_Select, 4, false);
		passed = action.selectBy(Products_Select, 1);

		passed = action.clickOn(Add_Button);

		proceedProviceCeaseProduct();

		return passed;
	}

	public boolean ceaseProduct(String Department, String Site) {
		boolean passed = false;

		passed = action.waitFor(ProvideCease_ActionButton, 6, true);
		passed = action.clickOn(ProvideCease_ActionButton);

		passed = CommonPanel.ServiceOrder.selectDepartmentSite(action, Department, Site);

		passed = action.clickOn(FistProduct_CheckBox);

		passed = action.waitFor(CeaseComments_TestArea, 4, true);

		passed = action.selectBy(CeaseReason_Select, 1);

		action.waitFor(2);

		proceedProviceCeaseProduct();

		return passed;
	}

	private boolean proceedProviceCeaseProduct() {
		boolean passed = false;

		passed = action.waitFor(PerformSalesSignOff_CheckBox, 4, true);
		passed = action.clickOn(PerformSalesSignOff_CheckBox);

		passed = action.waitFor(CommonPanel.Accept_Button, 4, true);
		passed = action.clickOn(CommonPanel.Accept_Button);

		action.waitFor(2);

		passed = action.waitFor(OK_Button, 4, true);
		passed = action.clickOn(OK_Button);

		return passed;
	}
}
