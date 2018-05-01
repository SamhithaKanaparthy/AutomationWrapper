package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class AllocateRouteServiceOrder { // order
	// Route Allocation page
	By allocateAuto_ActionButton = By.xpath("//*[text ( ) = 'Allocate Auto']");
	By allocateManual_ActionButton = By.xpath("//*[text ( ) = 'Allocate Manual']");

	By releaseRoute_ActionButton = By.xpath("//span[text()='Release Route']");

	// Allocate Route - Auto
	By exchangeArea_Select = By.xpath("//*[text ( ) = 'Exchange Area :']/following::select[1]");
	By plantItemType_Select = By.xpath("//*[text ( ) = 'Exchange Area :']/following::select[2]");
	By plantItemNo_Input = By.xpath("//*[text ( ) = 'Plant Item No:']/following::input[1]");
	By accept_Button = By.xpath("//input[@value = 'Accept']");
	By allocate_Button = By.xpath("//input[@value = 'Allocate']");
	By release_Button = By.xpath("//input[@value='Release']");
	By addMore_Button = By.xpath("//input[@value='Add more...']");

	By serviceNumber_Value = By
			.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[1]/td[3]//span");
	By routeAllocatedState_Value = By
			.xpath("//tbody[@class='ui-datatable-data ui-widget-content']/descendant::tr[1]/td[5]//span");
	By selected_Row = By.xpath("//tr[contains(@class,'ui-selected')]");

	By routingTableTerminal_Header = By.xpath("//*[text()='Terminal']");

	TestActions action = null;
	public String serviceOrderNumber = "";
	public String serviceNumber = "";

	public AllocateRouteServiceOrder(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		action.scrollUp();
		action.waitFor(1);

		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);
		passed = action.waitFor(LiberateCommon.Orders.RouteMaintenance, 4, true);
		passed = action.clickOn(LiberateCommon.Orders.RouteMaintenance);
		passed = action.clickOn(LeftLink.RouteMaintenance.AllocateRouteServiceOrder);
		passed = action.waitFor(LeftLink.RouteMaintenance.AllocateRouteServiceOrder, 4, true);

		return passed;
	}

	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {
		boolean passed = false;
		if (!department.trim().equals("") && !ServiceOrderNumber.trim().equals("")) {
			this.serviceOrderNumber = ServiceOrderNumber;
			passed = CommonPanel.ServiceOrder.Search(action, department, ServiceOrderNumber);
		}

		else {
			passed = action.clickOn(CommonPanel.ServiceOrder.serviceOrderList_Header);
			passed = action.waitFor(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]"), 4, true);
			this.serviceOrderNumber = action
					.getTextFromPage(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]/descendant::td[1]"));
			passed = action.clickOn(CommonPanel.ServiceOrder.ServiceOrderList_Row("[1]"));
		}
		return passed;
	}

	public boolean releaseRoute() {
		boolean passed = false;

		passed = action.waitFor(releaseRoute_ActionButton, 4, true);
		passed = action.clickOn(releaseRoute_ActionButton);

		passed = action.waitFor(release_Button, 4, true);
		passed = action.clickOn(release_Button);

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = action.clickOn(CommonPanel.popUp.popUpYes_Button);

		return passed;
	}

	public boolean verifyRelease() {
		action.scrollUp();
		action.scrollUp();

		boolean passed = false;

		if (action.countOf(CommonPanel.popUp.popUpYes_Button) > 0)
			action.waitFor(2);

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim()
				.equals("Route released Successfully") ? true : false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean allocateAuto(String PlantItemType, String PlantItemNumber) {
		boolean passed = false;

		passed = action.waitFor(selected_Row, 4, true);
		if (!action.getTextFromPage(routeAllocatedState_Value).trim().equals("N")) {
			releaseRoute();
			verifyRelease();
		}

		action.scrollUp();
		action.waitFor(2);

		passed = action.clickOn(allocateAuto_ActionButton);
		passed = action.waitFor(exchangeArea_Select, 4, true);

		passed = action.selectByPartialText(exchangeArea_Select, "BOT");
		passed = action.waitFor(2);
		passed = action.selectByPartialText(plantItemType_Select, PlantItemType);

		passed = action.sendDataTo(plantItemNo_Input, PlantItemNumber);

		passed = action.clickOn(accept_Button);

		passed = action.waitFor(routingTableTerminal_Header, 4, true);
		passed = action.clickOn(accept_Button);

		return passed;
	}

	public boolean verifyAutoAllocateRoute() {
		boolean passed = false;

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim()
				.equals("Auto route created Successfully.") ? true : false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean verifyManualAllocateRoute() {
		boolean passed = false;

		passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
		passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim()
				.equals("Manual route created Successfully.") ? true : false);
		passed = action.clickOn(CommonPanel.popUp.popUpOK_Button);

		return passed;
	}

	public boolean allocateManual(String plantDP, String plantCAB, String plantMDF, String terminal) {
		boolean passed = false;

		String typeSideDropDown = "(//*[text()='Plant Item']/following::select)";
		String plantNoVertex = "(//*[text()='Plant Item']/following::input[@type='text'])";

		By ITEM_1 = By.xpath(typeSideDropDown + "[1]");
		By SIDE_1 = By.xpath(typeSideDropDown + "[2]");
		By ITEM_2 = By.xpath(typeSideDropDown + "[3]");
		By SIDE_2 = By.xpath(typeSideDropDown + "[4]");
		By ITEM_3 = By.xpath(typeSideDropDown + "[5]");
		By SIDE_3 = By.xpath(typeSideDropDown + "[6]");
		By ITEM_4 = By.xpath(typeSideDropDown + "[7]");
		By SIDE_4 = By.xpath(typeSideDropDown + "[8]");

		By PLANTNUM_1 = By.xpath(plantNoVertex + "[1]");
		By TERMINAL_1 = By.xpath(plantNoVertex + "[2]");
		By PLANTNUM_2 = By.xpath(plantNoVertex + "[3]");
		By TERMINAL_2 = By.xpath(plantNoVertex + "[4]");
		By PLANTNUM_3 = By.xpath(plantNoVertex + "[5]");
		By TERMINAL_3 = By.xpath(plantNoVertex + "[6]");
		By PLANTNUM_4 = By.xpath(plantNoVertex + "[7]");
		By TERMINAL_4 = By.xpath(plantNoVertex + "[8]");

		passed = action.waitFor(selected_Row, 4, true);
		if (!action.getTextFromPage(routeAllocatedState_Value).trim().equals("N")) {
			releaseRoute();
			verifyRelease();
		}

		action.scrollUp();
		action.waitFor(2);

		passed = action.clickOn(allocateManual_ActionButton);
		passed = action.waitFor(exchangeArea_Select, 4, true);

		passed = action.selectByPartialText(exchangeArea_Select, "BOT");
		passed = action.waitFor(2);

		action.waitFor(ITEM_1, 4, true);
		action.selectBy(ITEM_1, "DP-DISTRIBUTION POINT");
		action.waitFor(1);
		action.sendDataTo(PLANTNUM_1, plantDP);
		action.selectBy(SIDE_1, "E");
		action.waitFor(1);
		action.sendDataTo(TERMINAL_1, terminal);
		action.clickOn(addMore_Button);
		action.waitFor(ITEM_2, 4, true);

		action.waitFor(ITEM_2, 4, true);
		action.selectBy(ITEM_2, "CAB-CABINET");
		action.waitFor(1);
		action.sendDataTo(PLANTNUM_2, plantCAB);
		action.selectBy(SIDE_2, "D");
		action.waitFor(1);
		action.sendDataTo(TERMINAL_2, terminal);
		action.clickOn(addMore_Button);
		action.waitFor(ITEM_2, 4, true);
		action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
		CommonPanel.popUp.clickOK(action);

		action.waitFor(ITEM_3, 4, true);
		action.selectBy(ITEM_3, "CAB-CABINET");
		action.waitFor(1);
		action.sendDataTo(PLANTNUM_3, plantCAB);
		action.selectBy(SIDE_3, "E");
		action.waitFor(1);
		action.sendDataTo(TERMINAL_3, terminal);
		action.clickOn(addMore_Button);
		action.waitFor(ITEM_3, 4, true);
		action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
		CommonPanel.popUp.clickOK(action);

		action.waitFor(ITEM_4, 4, true);
		action.selectBy(ITEM_4, "MDF-MAIN DISTRIBUTION FRAME");
		action.waitFor(1);
		action.sendDataTo(PLANTNUM_4, plantMDF);
		action.selectBy(SIDE_4, "D");
		action.waitFor(1);
		action.sendDataTo(TERMINAL_4, terminal);
		action.clickOn(addMore_Button);
		action.waitFor(ITEM_4, 4, true);
		action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
		CommonPanel.popUp.clickOK(action);

		action.waitFor(1);
		passed = action.clickOn(allocate_Button);

		action.waitFor(CommonPanel.popUp.popUpYes_Button, 4, true);
		action.clickOn(CommonPanel.popUp.popUpYes_Button);
		action.waitFor(CommonPanel.popUp.popUpYes_Button, 4, false);
		action.waitFor(1);

		return passed;
	}
}
