package com.liberate.automation.pom;

import org.openqa.selenium.By;

public class AllocateReleaseRouteServiceNumber {
	//main heading
	By OrdersHeading = By.xpath("//*[text ( ) = 'Orders']");
	//sub heading
	By  Route_Maintaince_sublink = By.xpath("//*[text ( ) = 'Route Maintenance']");
	//left navigation menu
	By Allocate_Release_Route_Service_Number = By.xpath("//*[@class = 'leftmenu']/div[1]/div[1]/a");
//Allocate and Release Route panel
	By Service_Number = By.xpath("//*[text() = 'Service Number']/following::input[1]");
	By SearchButton = By.xpath("//*[@value = 'Search']");
	//Service Route Details
	By ManualButton = By.xpath("//*[@value = \"Manual\"]");//Manual is pending
	By  AutoButton = By.xpath("//*[@value = 'Auto']");
	//Allocate Route Auto-Panel
	By ExchangeArea = By.xpath("//*[text ( ) = 'Exchange Area:']/following::select[1]");
	By Plant_Item_Type = By.xpath("//*[text ( ) = 'Exchange Area:']/following::select[2]");
	By Plant_Item_No = By.xpath("//*[text ( ) = 'Plant Item No:']/following::input[1]");
	By Accept_Button = By.xpath("//*[@value = 'Accept']");
	
}
