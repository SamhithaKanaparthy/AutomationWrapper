package com.liberate.automation.common;

import org.openqa.selenium.By;

public class LiberateCommon {
	private static By getSecondLevelLocator(String menuName) {
		return By.xpath("(//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'" + menuName + "')]])[1]");
	}

	/***
	 * Contains All Level One Menu Items
	 * 
	 * 
	 *
	 */
	public static class LevelOne {
		public static final By Home = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Home']");
		public static final By CustomerCare = By
				.xpath("//div[@class='headermenu_row']/descendant::*[text()='Customer Care']");
		public static final By Orders = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Orders']");
		public static final By Inventory = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Inventory']");
		public static final By Faults = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Faults']");
		public static final By Networks = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Networks']");
		public static final By BillingEventProcessing = By
				.xpath("//div[@class='headermenu_row']/descendant::*[text()='Billing & Event Processing']");
		public static final By Payments = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Payments']");
		public static final By CreditControl = By
				.xpath("//div[@class='headermenu_row']/descendant::*[text()='Credit Control']");
		public static final By DirectoryEnquiries = By
				.xpath("//div[@class='headermenu_row']/descendant::*[text()='Directory Enquiries']");
		public static final By ProductsPricing = By
				.xpath("//div[@class='headermenu_row']/descendant::*[text()='Products & Pricing']");
		public static final By Admin = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Admin']");
	}

	/***
	 * Contains All Level Two link for Home
	 * 
	 * 
	 *
	 */
	public static class Home {
		public static final By News = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='News']");
		public static final By Reports = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Reports']");
	}

	/***
	 * Contains All Level Two link for Customer Care
	 * 
	 * 
	 *
	 */
	public static class CustomerCare {
		public static final By Search = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Search')]]");
		public static final By ServiceProvisioning = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Service Provisioning')]]");
		public static final By MaintainQuery = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Maintain Query']");
		public static final By AdditionalCustomerInformation = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Additional Customer Information']");
		public static final By CustomerCareAdmin = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Customer Care Admin']");
		public static final By CustomerCareReports = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Customer Care Reports']");
		public static final By LIMELITE = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='LIME LITE']");
	}

	/***
	 * Contains All Level Two link for Orders
	 * 
	 * 
	 *
	 */
	public static class Orders {
		public static final By BrowseSO = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Browse SO']");
		public static final By ManageServiceOrder = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Manage Service Order']");
		public static final By WaitlistEnquiry = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Waitlist Enquiry')]]");
		public static final By WorkAssignmentManagement = By.xpath(
				"//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Work Assignment Management')]]");
		public static final By ServiceOrderApproval = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Service Order Approval')]]");
		public static final By SwitchRequests = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Switch Requests']");
		public static final By RouteMaintenance = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Route Maintenance')]]");
		public static final By OrderReferenceData = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Orders Reference Data')]]");
		public static final By OrderReports = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Orders Reports')]]");
	}

	/***
	 * Contains All Level Two link for Inventory
	 * 
	 * 
	 *
	 */
	public static class Inventory {
		public static final By SimManagement = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='SIM Management']");
		public static final By ManageMACInventory = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Manage MAC Inventory']");
		public static final By ManageSmartCardInventory = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Manage Smart Card Inventory']");
		public static final By SIMReferenceData = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='SIM Ref Data']");
		public static final By InventoryReports = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Inventory Reports']");
	}

	/***
	 * Contains All Level Two link for Faults
	 * 
	 * 
	 *
	 */
	public static class Faults {
		public static final By Faults = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Faults']");
		public static final By FaultsReferenceData = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Faults Reference Data']");
		public static final By FaultsReports = By
				.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Faults Reports']");
	}

	/***
	 * Contains All Level Two link for Networks
	 * 
	 * 
	 *
	 */
	public static class Networks {
		public static final By NetworkEnquiries = getSecondLevelLocator("Network Enquiries");
		public static final By NetworkMaintenance = getSecondLevelLocator("Network Maintenance");
		public static final By ExchangeMaintenance = getSecondLevelLocator("Exchange Maintenance");
		public static final By LineEquipmentMaintenance = getSecondLevelLocator("Line Equipment Maintenance");
		public static final By NumberManagement = getSecondLevelLocator("Number Management");
		public static final By NetworkReferenceData = getSecondLevelLocator("Network Reference Data");
		public static final By NetworkReports = getSecondLevelLocator("Network Reports");
	}

	/***
	 * Contains All Level Two link for Billing Event Processing
	 * 
	 * 
	 *
	 */
	public static class BillingEventProcessing {
		public static final By EventProcessing = getSecondLevelLocator("Event Processing(D176)");
		public static final By EnterBillCharges = getSecondLevelLocator("Enter Bill Charges");
		public static final By Billing = getSecondLevelLocator("Billing");
		public static final By SuspenseManagement = getSecondLevelLocator("Suspense Management");
		public static final By BillingReferenceData = getSecondLevelLocator("Billing Reference Data");
		public static final By FinancialReferenceData = getSecondLevelLocator("Financial Reference Data");
		public static final By BillingReports = getSecondLevelLocator("Billing Reports");
	}

	/***
	 * Contains All Level Two link for Payments
	 * 
	 * 
	 *
	 */
	public static class Payments {
		public static final By Payments = getSecondLevelLocator("Payments");
		public static final By POS = getSecondLevelLocator("POS");
		public static final By PaymentsAdmin = getSecondLevelLocator("Payments Admin");
		public static final By PaymentReferenceData = getSecondLevelLocator("Payment Reference Data");
		public static final By PaymentsReports = getSecondLevelLocator("Payments Reports");
	}

	/***
	 * Contains All Level Two link for Credit Control
	 * 
	 * 
	 *
	 */
	public static class CreditControl {
		public static final By CreditControl = getSecondLevelLocator("Credit Control");
		public static final By DebtCollection = getSecondLevelLocator("Debt Collection");
		public static final By CreditControlReferenceData = getSecondLevelLocator("Credit Control Reference Data");
		public static final By DepositMaintenance = getSecondLevelLocator("Deposit Maintenance");
		public static final By CreditControlReports = getSecondLevelLocator("Credit Control Reports");
	}

	/***
	 * Contains All Level Two link for Directory Enquiries
	 * 
	 * 
	 *
	 */
	public static class DirectoryEnquiries {
		public static final By DirectorySearch = getSecondLevelLocator("Directory Search");
		public static final By DirectoryMaintenance = getSecondLevelLocator("Directory Maintenance");
		public static final By DirectoryReports = getSecondLevelLocator("Directory Reports");
	}

	/***
	 * Contains All Level Two link for Products Pricing
	 * 
	 * 
	 *
	 */
	public static class ProductsPricing {
		public static final By Products = getSecondLevelLocator("Productsv");
		public static final By PricingPlans = getSecondLevelLocator("Pricing Plans");
		public static final By Prices = getSecondLevelLocator("Prices");
		public static final By PricingReferenceData = getSecondLevelLocator("Pricing Reference Data");
		public static final By EventRating = getSecondLevelLocator("Event Rating");
		public static final By SpecialNumberSetup = getSecondLevelLocator("Special Number Set-up");
		public static final By Comverse = getSecondLevelLocator("Comverse");
		public static final By Meters = getSecondLevelLocator("Meters");
		public static final By IAA = getSecondLevelLocator("IAA");
		public static final By ProductandPricingReports = getSecondLevelLocator("Product and Pricing Reports");
		public static final By IAAReports = getSecondLevelLocator("IAA Reports");
		public static final By Ericsson = getSecondLevelLocator("Ericsson");
	}

	/***
	 * Contains All Level Two link for Admin
	 * 
	 * 
	 *
	 */
	public static class Admin {
		public static By EmployeeAdministration = getSecondLevelLocator("Employee Administration");
		public static By BUSetUp = getSecondLevelLocator("BU Set-Up");
		public static By Otherdatasetup = getSecondLevelLocator("Other data set-up");
		public static By WithdrawnItems = getSecondLevelLocator("Withdrawn Items");

	}
}
