package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AmendProductISPFields {

	public TestActions action = null;

	By product_Row = By.xpath(
			"//div[@id='customerServicesForm:serviceEnquiryTabs:0:productsTab:custServProductsResultTable']/div[2]/table/tbody/tr");
	By selectproduct_record = By.xpath(
			"//tr[@id='customerServicesForm:serviceEnquiryTabs:0:productsTab:custServProductsResultTable_row_0']");
	By AmendProductISPFields_ActionButton = By.xpath("//span[text()='Amend Product & ISP Fields']");
	By ISPUsername_Textfield = By.xpath("//input[@id='amendProductsForm:userNameId']");
	By ISPPassword_Textfield = By.id("amendProductsForm:pwdId");
	By GeneratePassword_Textfield = By.xpath("//*[@value='Generate Password']");
	By AmendISPFieldsAccept_Button = By.xpath("//*[@value='Generate Password']/following::input[@value='Accept']");
	By AmendISPFieldCancel_Button = By.xpath("//*[@value='Generate Password']/following::input[@value='Cancel']");
	By outputvalidation_Text = By.xpath(
			"//table[@id='customerServicesForm:serviceEnquiryTabs']/tbody/tr[2]/td/div/table/tbody/tr[7]/td[2]/div/table/tbody/tr/td/table/tbody/tr[1]/td[2]/span[@class='iceOutTxt']");

	public AmendProductISPFields(TestActions action) {
		this.action = action;
	}

	public boolean clickOnProductRecord() {
		boolean passed = false;
		passed = action.waitFor(product_Row, 6, true);

		for (int i = 0; i < action.countOf(product_Row); i++) {
			action.waitFor(1);
			passed = action.clickOn(By.xpath(action.getXpath(product_Row) + "[" + (i + 1) + "]"));
			action.waitFor(2);
			if (action.countOf(AmendProductISPFields_ActionButton) > 0) {
				action.waitFor(1);
				passed = action.clickOn(AmendProductISPFields_ActionButton);
				break;
			}
			passed = false;
		}

		return passed;
	}

	public boolean enterdatatoUsernamePwd(String ispUserName) {
		boolean passed = false;

		passed = action.waitFor(ISPUsername_Textfield, 4, true);
		passed = action.sendDataTo(ISPUsername_Textfield, ispUserName);
		passed = action.waitFor(GeneratePassword_Textfield, 4, true);
		passed = action.clickOn(GeneratePassword_Textfield);

		return passed;
	}

	public boolean clickOnAccept() {
		boolean passed = false;

		passed = action.waitFor(AmendISPFieldsAccept_Button, 4, true);
		passed = action.clickOn(AmendISPFieldsAccept_Button);

		return passed;
	}

	public boolean validate_output(String ispUserName) {
		boolean passed = false;

		passed = action.waitFor(outputvalidation_Text, 4, true);
		if (action.getXpath(outputvalidation_Text) == ispUserName)
			passed = true;
		else
			passed = false;

		return passed;

	}

}
