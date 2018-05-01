
package com.liberate.automation.testcases;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.CRCustomerSearch;

import com.liberate.automation.pom.ServiceOperations;
import com.liberate.automation.pom.TransferProduct;

public class TransferProductTC {

	static TestActions action = CommonLogin.action;

	static String TestCase;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	static String TestStatus;

	static Map<String, String> data = new HashedMap<>();
	static String TransferProductServiceNumber;
	
	@Test
	public static void transferProduct() {
		
		TestCase = "TransferProductTC";
		CRCustomerSearch search = new CRCustomerSearch(action);
		ServiceOperations service = new ServiceOperations(action);
		TransferProduct TransferProduct = new TransferProduct(action); 
		
		
		search.navigate();
		action.getScreenShot(TestCase);
		search.searchByServiceNumber("");
		action.getScreenShot(TestCase);

		service.navigate();
		action.getScreenShot(TestCase);
		service.verifyServicesScreen();
		action.getScreenShot(TestCase);
		service.transferProduct();
		action.getScreenShot(TestCase);
		
		
		TransferProduct.sendDataToServiceNumber("");
		
		TransferProduct.clickonsearchbutton();
		
		TransferProduct.SelectTransferCheckbox();
		
		TransferProduct.clickonapplybutton();
		
		
		
		
		
		                                            
		
		
		
		
		
		
		
	}
	
	
}
