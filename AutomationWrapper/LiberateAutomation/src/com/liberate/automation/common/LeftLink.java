package com.liberate.automation.common;

import org.openqa.selenium.By;

/***
 * Class with list of Left Link elements.
 * 
 * 
 *
 */
public class LeftLink {
	private static By getLeftLink(String menuName) {
		return (By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='" + menuName + "']"));
	}

	/***
	 * Contains All left links of News
	 * 
	 * 
	 *
	 */
	public static class News {
		public static final By Home = getLeftLink("Home");
		public static final By ChangePassword = getLeftLink("Change Password");
		public static final By RequestProductionOfReport = getLeftLink("Request Production Of Report");
	}

	/***
	 * Contains All left links of Limelite
	 * 
	 * 
	 *
	 */
	public static class Limelite {
		public static final By NewCustomer = By.xpath("//*[text()='New Customer']");
		public static final By ExistingCustomer = By.xpath("//*[text()='Existing Customer']");
		public static final By AmendSOinSales = By.xpath("//*[text()='Amend Service Order In Sales']");
		public static final By EquipmentSale = By.xpath("//*[text()='Equipment Sale']");
		public static final By EquipmentReturn = By.xpath("//*[text()='Equipment Return']");
		public static final By DealerPointsRedemptionReport = By.xpath("//*[text()='Dealer Points Redemption Report']");
		public static final By PrepaidRegistration = By.xpath("//*[text()='Prepaid Registration']");
	}

	/***
	 * Contains All left links of Reports
	 * 
	 * 
	 *
	 */
	public static class Reports {
		public static final By BrowseReports = getLeftLink("Browse Reports");
		public static final By ShowReportStatus = getLeftLink("Show Report Status");
	}

	/***
	 * Contains All left links of Search
	 * 
	 * 
	 *
	 */
	public static class Search {
		public static final By CustomerSearch = getLeftLink("Customer Search");
		public static final By Dashboard = getLeftLink("Dashboard");
		public static final By CustomerDetails = getLeftLink("Customer Details");
		public static final By Services = getLeftLink("Services");
		public static final By AccountPaymentPlans = getLeftLink("Account Payment Plans");
		public static final By AccountPricingPlans = getLeftLink("Account Pricing Plans");
		public static final By Adjustments = getLeftLink("Adjustments");
		public static final By Audit = getLeftLink("Audit");
		public static final By Bills = getLeftLink("Bills");
		public static final By CallMonitoring = getLeftLink("Call Monitoring");
		public static final By DepositRequirements = getLeftLink("Deposit Requirements");
		public static final By MultiAccountPricingPlans = getLeftLink("Multi Account Pricing Plans");
		public static final By Payments = getLeftLink("Payments");
		public static final By Products = getLeftLink("Products");
		public static final By Queries = getLeftLink("Queries");
		public static final By ServiceCharges = getLeftLink("Service Charges");
		public static final By ServiceOrders = getLeftLink("Service Orders");
		public static final By SwitchRequests = getLeftLink("Switch Requests");
		public static final By UnbilledMessages = getLeftLink("Unbilled Messages");
		public static final By BilledMessages = getLeftLink("Billed Messages");
		public static final By RaiseQuery = getLeftLink("Raise Query");
		public static final By Documents = getLeftLink("Documents");
		public static final By OldQueries = getLeftLink("Old Queries");
		public static final By OldRaiseQuery = getLeftLink("Old Raise Query");
	}

	/***
	 * Contains All left links of Service Provisioning
	 * 
	 * 
	 *
	 */
	public static class ServiceProvisioning {
		public static final By NewCustomer = getLeftLink("New Customer");
		public static final By ExistingCustomer = getLeftLink("Existing Customer");
		public static final By AmendServiceOrderInSales = getLeftLink("Amend Service Order In Sales");
		public static final By MobileServicePaymentModeConversion = getLeftLink(
				"Mobile Service Payment Mode Conversion");
		public static final By ProvisionPrepaidCorporateCUG = getLeftLink("Provision Prepaid Corporate CUG");
	}

	/***
	 * Contains All left links of Maintain Query
	 * 
	 * 
	 *
	 */
	public static class MaintainQuery {

	}

	/***
	 * Contains All left links of Additional Customer Information
	 * 
	 * 
	 *
	 */
	public static class AdditionalCustomerInformation {
		public static final By AmendBillingAccount = getLeftLink("Amend Billing Account");
		public static final By CUGSearch = getLeftLink("CUG Search");
		public static final By CUGSwitchRequests = getLeftLink("CUG Switch Requests");
		public static final By InterimBill = getLeftLink("Interim Bill");
		public static final By MaintainEmail = getLeftLink("Maintain Email");
		public static final By MaintainOrganisation = getLeftLink("Maintain Organisation");
		public static final By MaintainPIAC = getLeftLink("Maintain PIAC");
		public static final By MaintainProperties = getLeftLink("Maintain Properties");
		public static final By MaintainSuspectHandset = getLeftLink("Maintain Suspect Handset");
		public static final By TransferProduct = getLeftLink("Transfer Product");
		public static final By BulkAdjustmentsUpload = getLeftLink("Bulk Adjustments Upload");
		public static final By BulkAdjustmentsEntry = getLeftLink("Bulk Adjustments Entry");
	}

	/***
	 * Contains All left links of Customer Care Admin
	 * 
	 * 
	 *
	 */
	public static class CustomerCareAdmin {
		public static final By MaintainAddressData = getLeftLink("Maintain Address Data");
		public static final By MaintainDealer = getLeftLink("Maintain Dealer");
		public static final By MaintainMaintenanceTask = getLeftLink("Maintain Maintenance Task");
		public static final By MaintainPOBoxRegion = getLeftLink("Maintain PO Box Region");
		public static final By MaintainAccountLinks = getLeftLink("Maintain Account Links");
		public static final By MaintainDealerLocations = getLeftLink("Maintain Dealer Locations");
		public static final By BulkUpdateDefaultExchangeIDforAddresses = getLeftLink(
				"Bulk Update Default Exchange ID for Addresses");
	}

	/***
	 * Contains All left links of Customer Care Reports
	 * 
	 * 
	 *
	 */
	public static class CustomerCareReports {
		public static final By AgedAnalysisofQueryCompletionReport = getLeftLink(
				"Aged Analysis of Query Completion Report");
		public static final By AgedQueryTransactionsReport = getLeftLink("Aged Query Transactions Report");
		public static final By BillNotifierReport = getLeftLink("Bill Notifier Report");
		public static final By BusinessMarketCategoryAnalysisReport = getLeftLink(
				"Business Market Category Analysis Report");
		public static final By ContractsReport = getLeftLink("Contracts Report");
		public static final By CustomerAuditReportRequest = getLeftLink("Customer Audit Report Request");
		public static final By OutstandingQueriesReports = getLeftLink("Outstanding Queries Reports");
		public static final By OutstandingResolvedQueryReport = getLeftLink("Outstanding/Resolved Query Report");
		public static final By PersonalInternationalAccessCodeActivityReport = getLeftLink(
				"Personal International Access Code Activity Report");
		public static final By QueryTransactionDetailsReport = getLeftLink("Query Transaction Details Report");
		public static final By ReportofPackageProductOwners = getLeftLink("Report of Package Product Owners");
		public static final By RequestISPCustomerInformationSheet = getLeftLink(
				"Request ISP Customer Information Sheet");
		public static final By StatementofProductsReport = getLeftLink("Statement of Products Report");
		public static final By StatementofServicebyPeriod = getLeftLink("Statement of Service by Period");
		public static final By StatementofService = getLeftLink("Statement of Service");
		public static final By QueryBilledCallsReport = getLeftLink("Query Billed Calls Report");
	}

	/***
	 * Contains All left links of Old Maintain Query
	 * 
	 * 
	 *
	 */
	public static class OldMaintainQuery {
		public static final By MaintainQuery = getLeftLink("Maintain Query");
		public static final By RaiseQuery = getLeftLink("Raise Query");
		public static final By RaiseQueryNonAccount = getLeftLink("Raise Query - Non Account");
	}

	/***
	 * Contains All left links of Browse SO
	 * 
	 * 
	 *
	 */
	public static class BrowseSO {
		public static final By Browse = getLeftLink("Browse");
		public static final By BrowsePortingOrders = getLeftLink("Browse Porting Orders");
		public static final By BrowsePortingMessages = getLeftLink("Browse Porting Messages");
	}

	/***
	 * Contains All left links of Manage Service Order
	 * 
	 * 
	 *
	 */
	public static class ManageServiceOrder {
		public static final By AddSpecialInstructions = getLeftLink("Add Special Instructions");
		public static final By AddRemoveServiceCharge = getLeftLink("Add/Remove Service Charge");
		public static final By AllocateONTPort = getLeftLink("Allocate ONT Port");
		public static final By AlterExchNumArea = getLeftLink("Alter Exch/Num Area");
		public static final By AlterProduct = getLeftLink("Alter Product");
		public static final By AmendSOPriority = getLeftLink("Amend SO Priority");
		public static final By AmendWaitlistPriority = getLeftLink("Amend Waitlist Priority");
		public static final By Assign = getLeftLink("Assign");
		public static final By Cancel = getLeftLink("Cancel");
		public static final By Enquiry = getLeftLink("Enquiry");
		public static final By MaintainACUTAppointment = getLeftLink("Maintain ACUT Appointment");
		public static final By ManualWaitlistRelease = getLeftLink("Manual Waitlist Release");
		public static final By Redirect = getLeftLink("Redirect");
		public static final By Reject = getLeftLink("Reject");
		public static final By Release = getLeftLink("Release");
		public static final By ReleaseStructuredAddress = getLeftLink("Release Structured Address");
		public static final By RequestReferenceLetter = getLeftLink("Request Reference Letter");
		public static final By Signoff = getLeftLink("Sign off");
		public static final By Split = getLeftLink("Split");
		public static final By Suspend = getLeftLink("Suspend");
		public static final By Waitlist = getLeftLink("Waitlist");
	}

	/***
	 * Contains All left links of Waitlist Enquiry
	 * 
	 * 
	 *
	 */
	public static class WaitlistEnquiry {
		public static final By LineEquipmentWaitersEnquiry = getLeftLink("Line Equipment Waiters Enquiry");
		public static final By LinePlantWaitersEnquiry = getLeftLink("Line Plant Waiters Enquiry");
		public static final By NumberWaitersEnquiry = getLeftLink("Number Waiters Enquiry");
		public static final By ProductWaitersEnquiry = getLeftLink("Product Waiters Enquiry");
		public static final By WaitlistedServiceOrderEnquiry = getLeftLink("Waitlisted Service Order Enquiry");
	}

	/***
	 * Contains All left links of Work Assignment Management
	 * 
	 * 
	 *
	 */
	public static class WorkAssignmentManagement {
		public static final By MaintainAppointment = getLeftLink("Maintain Appointment");
		public static final By MaintainPlanWorkAssignment = getLeftLink("Maintain Plan Work Assignment");
		public static final By MaintainSOWorkAssignment = getLeftLink("Maintain SO Work Assignment");
		public static final By MaintenanceWorkAssignmentEnquiry = getLeftLink("Maintenance Work Assignment Enquiry");
		public static final By SignOffWorkAssignment = getLeftLink("Sign Off Work Assignment");
		public static final By SummaryWorkAssignmentEnquiry = getLeftLink("Summary Work Assignment Enquiry");
		public static final By WorkAssignmentEnquiryServiceOrder = getLeftLink(
				"Work Assignment Enquiry(Service Order)");
	}

	/***
	 * Contains All left links of Service Order Approval
	 * 
	 * 
	 *
	 */
	public static class ServiceOrderApproval {
		public static final By RequestSOApproval = getLeftLink("Request SO Approval");
		public static final By SignOffSOApproval = getLeftLink("Sign Off SO Approval");
	}

	/***
	 * Contains All left links of Switch Requests
	 * 
	 * 
	 *
	 */
	public static class SwitchRequests {
		public static final By ManageSwitchRequest = getLeftLink("Manage Switch Request");
		public static final By RequeueFailedSwitchRequest = getLeftLink("Requeue Failed Switch Request");
		public static final By ManageStalledSwitchRequest = getLeftLink("Manage Stalled Switch Request");
		public static final By BulkReSubmitFailedRequests = getLeftLink("Bulk Re-Submit Failed Requests");
		public static final By MaintainSwitchInterfaceParameters = getLeftLink("Maintain Switch Interface Parameters");
		public static final By ManageSTPUpdates = getLeftLink("Manage STP Updates");
	}

	/***
	 * Contains All left links of Route Maintenance
	 * 
	 * 
	 *
	 */
	public static class RouteMaintenance {
		public static final By AllocateReleaseRouteService = getLeftLink("Allocate / Release Route (Service)");
		public static final By AllocateRouteServiceOrder = getLeftLink("Allocate Route (Service Order)");
		public static final By CircuitDiversion = getLeftLink("Circuit Diversion");
		public static final By MaintainCableDiversion = getLeftLink("Maintain Cable Diversion");
		public static final By ManagePlantExpansion = getLeftLink("Manage Plant Expansion");
		public static final By MaintainCableFixes = getLeftLink("Maintain Cable Fixes");
		public static final By MaintainSurvey = getLeftLink("Maintain Survey");
		public static final By RaisePlantExpansion = getLeftLink("Raise Plant Expansion");
		public static final By RunCableDiversion = getLeftLink("Run Cable Diversion");
		public static final By SignOffCrossConnection = getLeftLink("Sign Off Cross Connection");
	}

	/***
	 * Contains All left links of Orders Reference Data
	 * 
	 * 
	 *
	 */
	public static class OrdersReferenceData {
		public static final By MaintainCommand = getLeftLink("Maintain Command");
		public static final By MaintainCommandProfile = getLeftLink("Maintain Command Profile");
		public static final By MaintainProvisionDefaults = getLeftLink("Maintain Provision Defaults");
		public static final By MaintainProvisioningRules = getLeftLink("Maintain Provisioning Rules");
		public static final By MaintainServiceOrderApprovalTypes = getLeftLink("Maintain Service Order Approval Types");
		public static final By MaintainServiceOrderStatusReason = getLeftLink("Maintain Service Order Status Reason");
		public static final By MaintainServicePackages = getLeftLink("Maintain Service Packages");
		public static final By MaintainSwitchCommand = getLeftLink("Maintain Switch Command");
		public static final By MaintainTeam = getLeftLink("Maintain Team");
	}

	/***
	 * Contains All left links of Orders Reports
	 * 
	 * 
	 *
	 */
	public static class OrdersReports {
		public static final By AgedAnalysisofServiceOrdersReport = getLeftLink(
				"Aged Analysis of Service Orders Report");
		public static final By AnalysisofTeamPerfandCancReasons = getLeftLink("Analysis of Team Perf and Canc Reasons");
		public static final By AverageServiceOrderProcessingTimeReport = getLeftLink(
				"Average Service Order Processing Time Report");
		public static final By CalculateAverageSOProcTime = getLeftLink("Calculate Average SO Proc Time");
		public static final By DailySOMaintenancePlanReport = getLeftLink("Daily SO Maintenance Plan Report");
		public static final By EmployeePerformanceReport = getLeftLink("Employee Performance Report");
		public static final By LineEquipmentWaitersReportRequest = getLeftLink("Line Equipment Waiters Report Request");
		public static final By NumberWaitersReport = getLeftLink("Number Waiters Report");
		public static final By OverdueServiceOrdersDetailReport = getLeftLink("Overdue Service Orders Detail Report");
		public static final By OverdueServiceOrdersSummaryReport = getLeftLink("Overdue Service Orders Summary Report");
		public static final By PrePaidCellularServicesLoad = getLeftLink("Pre-Paid Cellular Services Load");
		public static final By ProductWaitersReportRequest = getLeftLink("Product Waiters Report Request");
		public static final By ProvisionofServicePerformanceReport = getLeftLink(
				"Provision of Service Performance Report");
		public static final By ReportofOutstandingSOApprovals = getLeftLink("Report of Outstanding SO Approvals");
		public static final By ServiceOrderbyStreetReport = getLeftLink("Service Order by Street Report");
		public static final By ServiceOrdersCurrentlyinSystemSummaryReport = getLeftLink(
				"Service Orders Currently in System Summary Report");
		public static final By ServiceOrderMaintPlanScheduleReport = getLeftLink(
				"Service Order/Maint Plan Schedule Report");
		public static final By ServicePackageReport = getLeftLink("Service Package Report");
		public static final By ServiceOrderStatusAnalysisReport = getLeftLink("Service Order Status Analysis Report");
		public static final By SuspendedServiceOrderReport = getLeftLink("Suspended Service Order Report");
		public static final By DealerProvisioningReport = getLeftLink("Dealer Provisioning Report");
		public static final By OutstandingServiceOrdersDetailsReport = getLeftLink(
				"Outstanding Service Orders Details Report");
	}

	/***
	 * Contains All left links of Old Manage Service Order
	 * 
	 * 
	 *
	 */
	public static class OldManageServiceOrder {
		public static final By Browse = getLeftLink("Browse");
		public static final By Enquiry = getLeftLink("Enquiry");
		public static final By Signoff = getLeftLink("Sign off");
		public static final By Route = getLeftLink("Route");
		public static final By Cancel = getLeftLink("Cancel");
		public static final By Reject = getLeftLink("Reject");
		public static final By AddSpecialInstructions = getLeftLink("Add Special Instructions");
		public static final By AddRemoveServiceCharge = getLeftLink("Add/Remove Service Charge");
		public static final By AlterExchNumArea = getLeftLink("Alter Exch/Num Area");
		public static final By AlterProduct = getLeftLink("Alter Product");
		public static final By AmendSOPriority = getLeftLink("Amend SO Priority");
		public static final By Assign = getLeftLink("Assign");
		public static final By LEN = getLeftLink("LEN");
		public static final By Redirect = getLeftLink("Redirect");
		public static final By Release = getLeftLink("Release");
		public static final By Split = getLeftLink("Split");
		public static final By Suspend = getLeftLink("Suspend");
		public static final By Waitlist = getLeftLink("Waitlist");
		public static final By ManualWaitlistRelease = getLeftLink("Manual Waitlist Release");
		public static final By AmendWaitlistPriority = getLeftLink("Amend Waitlist Priority");
		public static final By RequestReferenceLetter = getLeftLink("Request Reference Letter");
		public static final By MaintainACUTAppointment = getLeftLink("Maintain ACUT Appointment");
		public static final By AllocateONTPort = getLeftLink("Allocate ONT Port");
		public static final By ReleaseStructuredAddress = getLeftLink("Release Structured Address");
	}

	/***
	 * Contains All left links of SIM Management
	 * 
	 * 
	 *
	 */
	public static class SIMManagement {
		public static final By ManageIMEI = getLeftLink("Manage IMEI");
		public static final By BulkProvisioningLabelFiles = getLeftLink("Bulk Provisioning Label Files");
		public static final By SIMEnquiry = getLeftLink("SIM Enquiry");
		public static final By SIMManagement = getLeftLink("SIM Management");
		public static final By SIMStatusManagement = getLeftLink("SIM Status Management");
		public static final By ViewSIMOrders = getLeftLink("View SIM Orders");
		public static final By SIMTracing = getLeftLink("SIM Tracing");
		public static final By CreateSIMOrder = getLeftLink("Create SIM Order");
		public static final By AcceptSIMOrder = getLeftLink("Accept SIM Order");
		public static final By GSMBulkProvisioning = getLeftLink("GSM Bulk Provisioning");
		public static final By GSMBulkCease = getLeftLink("GSM Bulk Cease");
		public static final By SIMInventory = getLeftLink("SIM Inventory");
		public static final By BulkProvisioningCeasingEnquiry = getLeftLink("Bulk Provisioning/Ceasing Enquiry");
	}

	/***
	 * Contains All left links of Manage MAC Inventory
	 * 
	 * 
	 *
	 */
	public static class ManageMACInventory {
		public static final By MaintainInventory = getLeftLink("Maintain Inventory");
		public static final By UploadInventoryFile = getLeftLink("Upload Inventory File");
		public static final By MaintainMACAddress = getLeftLink("Maintain MAC Address");
		public static final By AcceptUniqueAddressFile = getLeftLink("Accept Unique Address File");
	}

	/***
	 * Contains All left links of Manage Smart Card Inventory
	 * 
	 * 
	 *
	 */
	public static class ManageSmartCardInventory {
		public static final By MaintainSmartCardInventory = getLeftLink("Maintain Smart Card Inventory");
		public static final By AcceptSmartCardInventoryFile = getLeftLink("Accept Smart Card Inventory File");
	}

	/***
	 * Contains All left links of SIM Ref Data
	 * 
	 * 
	 *
	 */
	public static class SIMRefData {
		public static final By MaintainDeliveryAddress = getLeftLink("Maintain Delivery Address");
		public static final By MaintainGraphicsReference = getLeftLink("Maintain Graphics Reference");
		public static final By MaintainSIMCardProfile = getLeftLink("Maintain SIM Card Profile");
		public static final By MaintainSIMCardStatusReason = getLeftLink("Maintain SIM Card Status Reason");
	}

	/***
	 * Contains All left links of Inventory Reports
	 * 
	 * 
	 *
	 */
	public static class InventoryReports {
		public static final By SIMManagementMonitorReport = getLeftLink("SIM Management Monitor Report");
		public static final By SIMManagementReport = getLeftLink("SIM Management Report");
		public static final By SyniverseAuditFile = getLeftLink("Syniverse Audit File");
	}

	/***
	 * Contains All left links of Faults
	 * 
	 * 
	 *
	 */
	public static class Faults {
		public static final By AssignLeasedCircuit = getLeftLink("Assign Leased Circuit");
		public static final By ManageMassiveFault = getLeftLink("Manage Massive Fault");
		public static final By MaintainCircuitDesignation = getLeftLink("Maintain Circuit Designation");
		public static final By ManageFault = getLeftLink("Manage Fault");
		public static final By PrintFaultDocket = getLeftLink("Print Fault Docket");
		public static final By RaiseFault = getLeftLink("Raise Fault");
		public static final By RepeatFaultTest = getLeftLink("Repeat Fault Test");
		public static final By SituationEnquiry = getLeftLink("Situation Enquiry");
		public static final By SituationEnquiryByExchange = getLeftLink("Situation Enquiry By Exchange");
		public static final By UpdateFaultInvestigations = getLeftLink("Update Fault Investigations");
	}

	/***
	 * Contains All left links of Faults Reference Data
	 * 
	 * 
	 *
	 */
	public static class FaultsReferenceData {
		public static final By AddLevel1Code = getLeftLink("Add Level1 Code");
		public static final By AddLevel2Code = getLeftLink("Add Level2 Code");
		public static final By AddLevel3Code = getLeftLink("Add Level3 Code");
		public static final By FaultCoverageTimes = getLeftLink("Fault Coverage Times");
		public static final By MaintainFaultPriority = getLeftLink("Maintain Fault Priority");
		public static final By MaintainFaultStatusReason = getLeftLink("Maintain Fault Status Reason");
		public static final By MaintainFaultThresholds = getLeftLink("Maintain Fault Thresholds");
	}

	/***
	 * Contains All left links of Faults Reports
	 * 
	 * 
	 *
	 */
	public static class FaultsReports {
		public static final By CircuitDesignationReport = getLeftLink("Circuit Designation Report");
		public static final By FaultAnalysis = getLeftLink("Fault Analysis");
		public static final By FaultAnalysisbyRegionandCustomerType = getLeftLink(
				"Fault Analysis by Region and Customer Type");
		public static final By FaultAnalysisClearCodesbyRegion = getLeftLink("Fault Analysis Clear Codes by Region");
		public static final By FaultReports = getLeftLink("Fault Reports");
		public static final By ReportofFaultCodes = getLeftLink("Report of Fault Codes");
		public static final By ReportofFaultInvestigations = getLeftLink("Report of Fault Investigations");
		public static final By ReportofFaultPriorities = getLeftLink("Report of Fault Priorities");
		public static final By ReportofServiceFaultHistory = getLeftLink("Report of Service Fault History");
	}

	/***
	 * Contains All left links of Network Enquiries
	 * 
	 * 
	 *
	 */
	public static class NetworkEnquiries {
		public static final By DPAddressEnquiry = getLeftLink("DP Address Enquiry");
		public static final By EsideEnquiry = getLeftLink("E-side Enquiry");
		public static final By PlantItemEnquiry = getLeftLink("Plant Item Enquiry");
		public static final By ServiceRouteEnquiry = getLeftLink("Service Route Enquiry");
		public static final By StreetAddressEnquiry = getLeftLink("Street Address Enquiry");
		public static final By TerminalRouteEnquiry = getLeftLink("Terminal Route Enquiry");
		public static final By OpticalFibreEnquiry = getLeftLink("Optical Fibre Enquiry");
	}

	/***
	 * Contains All left links of Network Maintenance
	 * 
	 * 
	 *
	 */
	public static class NetworkMaintenance {
		public static final By MaintainLinePlant = getLeftLink("Maintain Line Plant");
		public static final By MaintainDistrict = getLeftLink("Maintain District");
		public static final By MaintainExchangeArea = getLeftLink("Maintain Exchange Area");
		public static final By RecordDPAddress = getLeftLink("Record DP Address");
		public static final By ConnectTerminals = getLeftLink("Connect Terminals");
		public static final By DisconnectTerminals = getLeftLink("Disconnect Terminals");
		public static final By JumperTerminals = getLeftLink("Jumper Terminals");
		public static final By StumpTerminals = getLeftLink("Stump Terminals");
		public static final By MaintainTerminals = getLeftLink("Maintain Terminals");
		public static final By RenumberPlantItem = getLeftLink("Renumber Plant Item");
		public static final By CreateInterExchangeLink = getLeftLink("Create Inter Exchange Link");
		public static final By MaintainInterExchangeLink = getLeftLink("Maintain Inter Exchange Link");
		public static final By MaintainMDFtoLENRelationship = getLeftLink("Maintain MDF to LEN Relationship");
		public static final By MaintainPlantItemCrossReference = getLeftLink("Maintain Plant Item Cross Reference");
		public static final By MaintainTestDate = getLeftLink("Maintain Test Date");
		public static final By MaintainSuspectAddressatDP = getLeftLink("Maintain Suspect Address at DP");
		public static final By ManageStoppedLine = getLeftLink("Manage Stopped Line");
		public static final By MaintainONT = getLeftLink("Maintain ONT");
		public static final By MaintainTerminalCapacity = getLeftLink("Maintain Terminal Capacity");
		public static final By FibreRouteDiversion = getLeftLink("Fibre Route Diversion");
	}

	/***
	 * Contains All left links of Exchange Maintenance
	 * 
	 * 
	 *
	 */
	public static class ExchangeMaintenance {
		public static final By MaintainServiceatExchange = getLeftLink("Maintain Service at Exchange");
		public static final By AllocateReleaseLineEquipment = getLeftLink("Allocate/Release Line Equipment");
		public static final By MaintainExchangeEquipment = getLeftLink("Maintain Exchange Equipment");
		public static final By AllocateDSLAMChannel = getLeftLink("Allocate DSLAM Channel");
		public static final By MaintainDSLAMEquipment = getLeftLink("Maintain DSLAM Equipment");
		public static final By MaintainExchangeType = getLeftLink("Maintain Exchange Type");
		public static final By MaintainStaticIPAddress = getLeftLink("Maintain Static IP Address");
		public static final By MaintainTrafficAnalysisControl = getLeftLink("Maintain Traffic Analysis Control");
		public static final By SharedServiceatExchange = getLeftLink("Shared Service at Exchange");
		public static final By MaintainExchange = getLeftLink("Maintain Exchange");
		public static final By AllocateMSANPort = getLeftLink("Allocate MSAN Port");
	}

	/***
	 * Contains All left links of Line Equipment Maintenance
	 * 
	 * 
	 *
	 */
	public static class LineEquipmentMaintenance {
		public static final By LineEquipmentEnquiry = getLeftLink("Line Equipment Enquiry");
		public static final By CreateLineEquipment = getLeftLink("Create Line Equipment");
		public static final By DeleteLineEquipmentRange = getLeftLink("Delete Line Equipment Range");
		public static final By SequenceLineEquipmentRequest = getLeftLink("Sequence Line Equipment Request");
		public static final By MaintainSEPRM = getLeftLink("Maintain SEPRM");
		public static final By RecordLineEquipmentPair = getLeftLink("Record Line Equipment Pair");
		public static final By MaintainLineEquipment = getLeftLink("Maintain Line Equipment");
		public static final By PBXEnquiry = getLeftLink("PBX Enquiry");
		public static final By AllocateLineCard = getLeftLink("Allocate Line Card");
	}

	/***
	 * Contains All left links of Number Management
	 * 
	 * 
	 *
	 */
	public static class NumberManagement {
		public static final By NumberEnquiry = getLeftLink("Number Enquiry");
		public static final By ReserveReleaseNumbers = getLeftLink("Reserve / Release Numbers");
		public static final By MaintainNiceNumbers = getLeftLink("Maintain Nice Numbers");
		public static final By MaintainNumbers = getLeftLink("Maintain Numbers");
		public static final By MaintainNumberArea = getLeftLink("Maintain Number Area");
	}

	/***
	 * Contains All left links of Network Reference Data
	 * 
	 * 
	 *
	 */
	public static class NetworkReferenceData {
		public static final By MaintainLineCardType = getLeftLink("Maintain Line Card Type");
		public static final By MaintainNumberStatusReason = getLeftLink("Maintain Number Status Reason");
		public static final By MaintainPlantItemSubType = getLeftLink("Maintain Plant Item SubType");
		public static final By MaintainPlantItemType = getLeftLink("Maintain Plant Item Type");
		public static final By MaintainTargetExchangeTypes = getLeftLink("Maintain Target Exchange Types");
		public static final By MaintainTerminalStatusReason = getLeftLink("Maintain Terminal Status Reason");
		public static final By MaintainPlantItemStatusCodes = getLeftLink("Maintain Plant Item Status Codes");
		public static final By MaintainONTModel = getLeftLink("Maintain ONT Model");
		public static final By MaintainInterconnectAgreement = getLeftLink("Maintain Interconnect Agreement");
	}

	/***
	 * Contains All left links of Network Reports
	 * 
	 * 
	 *
	 */
	public static class NetworkReports {
		public static final By AgeingReportofCrossConnectionForms = getLeftLink(
				"Ageing Report of Cross Connection Forms");
		public static final By AgeingReportofCableFixDockets = getLeftLink("Ageing Report of Cable Fix Dockets");
		public static final By AgeingReportofOutsideSurveyDockets = getLeftLink(
				"Ageing Report of Outside Survey Dockets");
		public static final By AllocatedRoutesReport = getLeftLink("Allocated Routes Report");
		public static final By DPAddressReport = getLeftLink("DP Address Report");
		public static final By FaultyPairsReport = getLeftLink("Faulty Pairs Report");
		public static final By InterExchangeLinkReport = getLeftLink("Inter Exchange Link Report");
		public static final By LinePlantWaitersReport = getLeftLink("Line Plant Waiters Report");
		public static final By PairProvingReport = getLeftLink("Pair Proving Report");
		public static final By PlantAnalysisReports = getLeftLink("Plant Analysis Reports");
		public static final By PlantItemCapacityReports = getLeftLink("Plant Item Capacity Reports");
		public static final By ReportsofAvailableorQuarantineNumbers = getLeftLink(
				"Reports of Available or Quarantine Numbers");
		public static final By ReportofLineEquipmentandNumberTotals = getLeftLink(
				"Report of Line Equipment and Number Totals");
		public static final By ReportofLineEquipmentbyStatus = getLeftLink("Report of Line Equipment by Status");
		public static final By ReportofNumberRanges = getLeftLink("Report of Number Ranges");
		public static final By ReportofOutstandingCableFixes = getLeftLink("Report of Outstanding Cable Fixes");
		public static final By ReportofOutstandingCrossConnectionForms = getLeftLink(
				"Report of Outstanding Cross Connection Forms");
		public static final By ReportofPBXbyExchange = getLeftLink("Report of PBX by Exchange");
		public static final By RouteReport = getLeftLink("Route Report");
		public static final By ServiceRouteReport = getLeftLink("Service Route Report");
		public static final By SparePlantReturnsReport = getLeftLink("Spare Plant Returns Report");
		public static final By StoppedLinesReport = getLeftLink("Stopped Lines Report");
		public static final By TerminalStatusReport = getLeftLink("Terminal Status Report");
		public static final By PrintOutsideSurveyDocket = getLeftLink("Print Outside Survey Docket");
	}

	/***
	 * Contains All left links of Event Processing D176
	 * 
	 * 
	 *
	 */
	public static class EventProcessingD176 {
		public static final By MaintainProhibitedNumbers = getLeftLink("Maintain Prohibited Numbers");
		public static final By ReTransmitBatches = getLeftLink("Re-Transmit Batches");
		public static final By RequestBatchesandCallsReports = getLeftLink("Request Batches and Calls Reports");
		public static final By TransmitUnsentBatches = getLeftLink("Transmit Unsent Batches");
		public static final By ValidateAnsSubmitIncomingBatches = getLeftLink("Validate & Submit Incoming Batches");
	}

	/***
	 * Contains All left links of Enter Bill Charges
	 * 
	 * 
	 *
	 */
	public static class EnterBillCharges {
		public static final By FixedChargesInterface = getLeftLink("Fixed Charges Interface");
		public static final By ManualMessageEntry = getLeftLink("Manual Message Entry");
		public static final By TapeQueueEnquiry = getLeftLink("Tape Queue Enquiry");
	}

	/***
	 * Contains All left links of Billing
	 * 
	 * 
	 *
	 */
	public static class Billing {
		public static final By AllocateDayofBilling = getLeftLink("Allocate Day of Billing");
		public static final By ReprintBills = getLeftLink("Reprint Bills");
	}

	/***
	 * Contains All left links of Suspense Management
	 * 
	 * 
	 *
	 */
	public static class SuspenseManagement {
		public static final By SuspenseDeletion = getLeftLink("Suspense Deletion");
		public static final By DeleteMTRRechargeSuspense = getLeftLink("Delete MTR/Recharge Suspense");
	}

	/***
	 * Contains All left links of Billing Reference Data
	 * 
	 * 
	 *
	 */
	public static class BillingReferenceData {
		public static final By MaintainAlternateExchange = getLeftLink("Maintain Alternate Exchange");
		public static final By MaintainBillText = getLeftLink("Maintain Bill Text");
		public static final By MaintainBillTextMatrix = getLeftLink("Maintain Bill Text Matrix");
		public static final By MaintainDayofBilling = getLeftLink("Maintain Day of Billing");
		public static final By MaintainCardRange = getLeftLink("Maintain Card Range");
		public static final By MaintainTaxAssignment = getLeftLink("Maintain Tax Assignment");
	}

	/***
	 * Contains All left links of Financial Reference Data
	 * 
	 * 
	 *
	 */
	public static class FinancialReferenceData {
		public static final By MaintainAdjustmentCodes = getLeftLink("Maintain Adjustment Codes");
		public static final By MaintainChargeItemCodes = getLeftLink("Maintain Charge Item Codes");
		public static final By MaintainDefaultFinancialTypes = getLeftLink("Maintain Default Financial Types");
		public static final By MaintainFinancialCodes = getLeftLink("Maintain Financial Codes");
		public static final By MaintainLedgerCode = getLeftLink("Maintain Ledger Code");
		public static final By MaintainQueryCode = getLeftLink("Maintain Query Code");
		public static final By MaintainServiceCostCentre = getLeftLink("Maintain Service Cost Centre");
		public static final By MaintainTaxPlan = getLeftLink("Maintain Tax Plan");
		public static final By MaintainBillInfo = getLeftLink("Maintain Bill Info");
	}

	/***
	 * Contains All left links of Billing Reports
	 * 
	 * 
	 *
	 */
	public static class BillingReports {
		public static final By AdjustmentsReport = getLeftLink("Adjustments Report");
		public static final By AuthorisedAdjustmentReport = getLeftLink("Authorised Adjustment Report");
		public static final By BillingCycleStatisticsReports = getLeftLink("Billing Cycle Statistics Reports");
		public static final By LedgersAllocatedReport = getLeftLink("Ledgers Allocated Report");
		public static final By LedgerPostingBreakdownReport = getLeftLink("Ledger Posting Breakdown Report");
		public static final By RevenueByServiceUsageReport = getLeftLink("Revenue By Service Usage Report");
		public static final By SubmitContentProviderRevenueSharingReport = getLeftLink(
				"Submit Content Provider Revenue Sharing Report");
	}

	/***
	 * Contains All left links of Payments
	 * 
	 * 
	 *
	 */
	public static class Payments {
		public static final By SinglePayment = getLeftLink("Single Payment");
		public static final By BatchPayment = getLeftLink("Batch Payment");
		public static final By CardPayment = getLeftLink("Card Payment");
		public static final By DirectDebit = getLeftLink("Direct Debit");
		public static final By Enquiries = getLeftLink("Enquiries");
		public static final By SecureBatchPayment = getLeftLink("Secure Batch Payment");
		public static final By ViewBadTransaction = getLeftLink("View Bad Transaction");
		public static final By ViewCardPaymentsforAccount = getLeftLink("View Card Payments for Account");
		public static final By CashtillPayments = getLeftLink("Cashtill Payments");
		public static final By TopUpEnquiry = getLeftLink("Top Up Enquiry");
		public static final By BulkPayment = getLeftLink("Bulk Payment");
	}

	/***
	 * Contains All left links of POS
	 * 
	 * 
	 *
	 */
	public static class POS {
		public static final By POSHomePage = getLeftLink("POS Home Page");
		public static final By NewTransaction = getLeftLink("New Transaction");
		public static final By PrintDuplicateReceipt = getLeftLink("Print Duplicate Receipt");
	}

	/***
	 * Contains All left links of Payments Admin
	 * 
	 * 
	 *
	 */
	public static class PaymentsAdmin {
		public static final By CreateDummyBankPaymentFile = getLeftLink("Create Dummy Bank Payment File");
		public static final By CreditCardorBonusPointsMaintenance = getLeftLink(
				"Credit Card or Bonus Points Maintenance");
		public static final By CreditCardPointsApproval = getLeftLink("Credit Card Points Approval");
		public static final By GenerateBACSDirectDebitClaim = getLeftLink("Generate BACS Direct Debit Claim");
		public static final By MaintainAccountBank = getLeftLink("Maintain Account Bank");
		public static final By MaintainCCAuthorisation = getLeftLink("Maintain CC Authorisation");
		public static final By MaintainUnacceptableCreditCard = getLeftLink("Maintain Unacceptable Credit Card");
		public static final By RequeueTasks = getLeftLink("Requeue Tasks");
		public static final By Vouchers = getLeftLink("Vouchers");
		public static final By CashDrawerSettle = getLeftLink("Cash Drawer-Settle");
		public static final By VoidPayment = getLeftLink("Void Payment");
		public static final By BadChequeProcessing = getLeftLink("Bad Cheque Processing");
	}

	/***
	 * Contains All left links of Payment Reference Data
	 * 
	 * 
	 *
	 */
	public static class PaymentReferenceData {
		public static final By MaintainBank = getLeftLink("Maintain Bank");
		public static final By MaintainBankAccountLedgers = getLeftLink("Maintain Bank Account Ledgers");
		public static final By MaintainBankBranches = getLeftLink("Maintain Bank Branches");
		public static final By MaintainBankCodes = getLeftLink("Maintain Bank Codes");
		public static final By MaintainBouncedChequeAction = getLeftLink("Maintain Bounced Cheque Action");
		public static final By MaintainCalendar = getLeftLink("Maintain Calendar");
		public static final By MaintainCashierOffice = getLeftLink("Maintain Cashier Office");
		public static final By MaintainDirectDebitBank = getLeftLink("Maintain Direct Debit Bank");
		public static final By MaintainExternalPaymentsDetails = getLeftLink("Maintain External Payments Details");
		public static final By MaintainFineThresholds = getLeftLink("Maintain Fine Thresholds");
		public static final By MaintainPaymentMethods = getLeftLink("Maintain Payment Methods");
		public static final By MaintainPaymentStampDuties = getLeftLink("Maintain Payment Stamp Duties");
		public static final By MaintainPhoneCardThresholds = getLeftLink("Maintain Phone Card Thresholds");
	}

	/***
	 * Contains All left links of Payments Reports
	 * 
	 * 
	 *
	 */
	public static class PaymentsReports {
		public static final By AuditReport = getLeftLink("Audit Report");
		public static final By CashdrawerPaymentItemsReport = getLeftLink("Cashdrawer Payment Items Report");
		public static final By CashdrawerPaymentMethodsReport = getLeftLink("Cashdrawer Payment Methods Report");
		public static final By CashdrawerSummaryReport = getLeftLink("Cashdrawer Summary Report");
		public static final By CashOfficeSiteReport = getLeftLink("Cash Office Site Report");
		public static final By PhonecardInventoryReport = getLeftLink("Phonecard Inventory Report");
		public static final By ReportofBadChequePayers = getLeftLink("Report of Bad Cheque Payers");
	}

	/***
	 * Contains All left links of Credit Control
	 * 
	 * 
	 *
	 */
	public static class CreditControl {
		public static final By ProcessCreditControl = getLeftLink("Process Credit Control");
		public static final By CommitTOSRecommendations = getLeftLink("Commit TOS Recommendations");
		public static final By CommitWriteOffRecommendations = getLeftLink("Commit Write Off Recommendations");
		public static final By ReverseWriteOffDebt = getLeftLink("Reverse Write Off Debt");
		public static final By CallMonitorLimitUpdateRecommendation = getLeftLink(
				"Call Monitor Limit Update / Recommendation");
		public static final By CommitBARRecommendations = getLeftLink("Commit BAR Recommendations");
		public static final By CommitCeaseRecommendations = getLeftLink("Commit Cease Recommendations");
		public static final By CommitTOSBARServiceRecommendations = getLeftLink(
				"Commit TOS/BAR Service Recommendations");
		public static final By MaintainBankGuarantee = getLeftLink("Maintain Bank Guarantee");
		public static final By MaintainCreditControlServiceStatus = getLeftLink(
				"Maintain Credit Control Service Status");
		public static final By CreatePaymentPlan = getLeftLink("Create Payment Plan");
		public static final By EnquireCancelPaymentPlan = getLeftLink("Enquire/Cancel Payment Plan");
	}

	/***
	 * Contains All left links of Debt Collection
	 * 
	 * 
	 *
	 */
	public static class DebtCollection {
		public static final By AssignAccounttoDebtCollectionAgency = getLeftLink(
				"Assign Account to Debt Collection Agency");
		public static final By MaintainDebtCollectionAgency = getLeftLink("Maintain Debt Collection Agency");
	}

	/***
	 * Contains All left links of Credit Control Reference Data
	 * 
	 * 
	 *
	 */
	public static class CreditControlReferenceData {
		public static final By MaintainCustomerCreditGroup = getLeftLink("Maintain Customer Credit Group");
		public static final By MaintainCreditRating = getLeftLink("Maintain Credit Rating");
		public static final By MaintainCreditControlInformation = getLeftLink("Maintain Credit Control Information");
		public static final By MaintainCreditLimitActions = getLeftLink("Maintain Credit Limit Actions");
		public static final By MaintainMessagesforCreditControlActions = getLeftLink(
				"Maintain Messages for Credit Control Actions");
		public static final By MaintainSMSandTOSBlockingPeriods = getLeftLink("Maintain SMS and TOS Blocking Periods");
		public static final By MaintainTOSParameters = getLeftLink("Maintain TOS Parameters");
		public static final By MaintainTOSExtension = getLeftLink("Maintain TOS Extension");
		public static final By MaintainBadDebtProvisionRules = getLeftLink("Maintain Bad Debt Provision Rules");
	}

	/***
	 * Contains All left links of Deposit Maintenance
	 * 
	 * 
	 *
	 */
	public static class DepositMaintenance {
		public static final By MaintainDepositInformation = getLeftLink("Maintain Deposit Information");
		public static final By MaintainDepositInterestRates = getLeftLink("Maintain Deposit Interest Rates");
		public static final By MaintainDepositReason = getLeftLink("Maintain Deposit Reason");
	}

	/***
	 * Contains All left links of Credit Control Reports
	 * 
	 * 
	 *
	 */
	public static class CreditControlReports {
		public static final By BankGuaranteesReport = getLeftLink("Bank Guarantees Report");
		public static final By BARTOSInstructionSummaryReport = getLeftLink("BAR/TOS Instruction Summary Report");
		public static final By ClosedAccountsReport = getLeftLink("Closed Accounts Report");
		public static final By PaymentPlanReport = getLeftLink("Payment Plan Report");
		public static final By ReportofCreditControlforMigratedAccount = getLeftLink(
				"Report of Credit Control for Migrated Account");
		public static final By RequestCallBARExclusionList = getLeftLink("Request Call BAR Exclusion List");
		public static final By RequestTOSExclusionList = getLeftLink("Request TOS Exclusion List");
		public static final By ServiceTOSWarningRecommendationList = getLeftLink(
				"Service TOS/Warning Recommendation List");
		public static final By TOSROSServiceInstructionList = getLeftLink("TOS/ROS Service Instruction List");
		public static final By WOSROSInstructionListReport = getLeftLink("WOS/ROS Instruction List Report");
		public static final By WriteoffRecommendationsReport = getLeftLink("Write off Recommendations Report");
		public static final By WriteoffWarningsReport = getLeftLink("Write off Warnings Report");
		public static final By RequestTOSBARLetter = getLeftLink("Request TOS/BAR Letter");
	}

	/***
	 * Contains All left links of Directory Search
	 * 
	 * 
	 *
	 */
	public static class DirectorySearch {
		public static final By Enquiries = getLeftLink("Enquiries");
		public static final By Areas = getLeftLink("Areas");
		public static final By Entries = getLeftLink("Entries");
		public static final By Synonyms = getLeftLink("Synonyms");
	}

	/***
	 * Contains All left links of Directory Maintenance
	 * 
	 * 
	 *
	 */
	public static class DirectoryMaintenance {
		public static final By AssignDirectorySequence = getLeftLink("Assign Directory Sequence");
	}

	/***
	 * Contains All left links of Directory Reports
	 * 
	 * 
	 *
	 */
	public static class DirectoryReports {
		public static final By PrintDirectorybyNumber = getLeftLink("Print Directory by Number");
		public static final By DirectoryDistributionReport = getLeftLink("Directory Distribution Report");
		public static final By DirectoryReconciliationReport = getLeftLink("Directory Reconciliation Report");
		public static final By ReportDirectory = getLeftLink("Report Directory");
		public static final By RequestCPCDirectoryListingReport = getLeftLink("Request CPC Directory Listing Report");
	}

	/***
	 * Contains All left links of Products
	 * 
	 * 
	 *
	 */
	public static class Products {
		public static final By AddProductstoCommand = getLeftLink("Add Products to Command");
		public static final By BUProductInformation = getLeftLink("BU Product Information");
		public static final By MaintainCashtillPaymentItems = getLeftLink("Maintain Cashtill Payment Items");
		public static final By MaintainProducts = getLeftLink("Maintain Products");
		public static final By MaintainProductPackage = getLeftLink("Maintain Product Package");
		public static final By MaintainSystemProducts = getLeftLink("Maintain System Products");
		public static final By MaintainProductFieldCharacteristics = getLeftLink(
				"Maintain Product Field Characteristics");
	}

	/***
	 * Contains All left links of Pricing Plans
	 * 
	 * 
	 *
	 */
	public static class PricingPlans {
		public static final By PlanPlanRules = getLeftLink("Plan/Plan Rules");
		public static final By PlanCharges = getLeftLink("Plan Charges");
		public static final By SubPlanAndElement = getLeftLink("Sub Plan & Element");
		public static final By SubPlanCharacteristic = getLeftLink("Sub Plan Characteristic");
		public static final By PlanIncompatibility = getLeftLink("Plan Incompatibility");
		public static final By AllocateSubServiceTypestoPricingPlan = getLeftLink(
				"Allocate Sub Service Types to Pricing Plan");
		public static final By AllocateProductstoaPricingPlan = getLeftLink("Allocate Products to a Pricing Plan");
		public static final By AllocateMeteredUsagetoPricingPlan = getLeftLink(
				"Allocate Metered Usage to Pricing Plan");
		public static final By PremiumCategory = getLeftLink("Premium Category");
		public static final By SignoffPricingPlanApproval = getLeftLink("Signoff Pricing Plan Approval");
	}

	/***
	 * Contains All left links of Prices
	 * 
	 * 
	 *
	 */
	public static class Prices {
		public static final By MaintainConcession = getLeftLink("Maintain Concession");
		public static final By MaintainInternationalChargeAreaCode = getLeftLink(
				"Maintain International Charge Area Code");
		public static final By MaintainNationalChargeAreaCode = getLeftLink("Maintain National Charge Area Code");
		public static final By MaintainNationalTelexChargeAreaCodes = getLeftLink(
				"Maintain National Telex Charge Area Codes");
		public static final By MaintainPriceVariation = getLeftLink("Maintain Price Variation");
		public static final By MaintainProductTariffs = getLeftLink("Maintain Product Tariffs");
		public static final By MaintainTariffChargeArea = getLeftLink("Maintain Tariff Charge Area");
		public static final By MaintainTariffPlanCode = getLeftLink("Maintain Tariff Plan Code");
		public static final By MaintainMatrixPrices = getLeftLink("Maintain Matrix Prices");
		public static final By UploadMatrixFile = getLeftLink("Upload Matrix File");
		public static final By UploadPromotionFile = getLeftLink("Upload Promotion File");
		public static final By MaintainPromotions = getLeftLink("Maintain Promotions");
	}

	/***
	 * Contains All left links of Pricing Reference Data
	 * 
	 * 
	 *
	 */
	public static class PricingReferenceData {
		public static final By MaintainApplicationCategory = getLeftLink("Maintain Application Category");
		public static final By MaintainCategoryGroups = getLeftLink("Maintain Category Groups");
		public static final By MaintainCharacteristicGroups = getLeftLink("Maintain Characteristic Groups");
		public static final By MaintainCharacteristicSet = getLeftLink("Maintain Characteristic Set");
		public static final By MaintainPricingParameters = getLeftLink("Maintain Pricing Parameters");
		public static final By MaintainSalesTransactions = getLeftLink("Maintain Sales Transactions");
		public static final By MaintainSpendLevels = getLeftLink("Maintain Spend Levels");
		public static final By MaintainCustomerGroups = getLeftLink("Maintain Customer Groups");
	}

	/***
	 * Contains All left links of Event Rating
	 * 
	 * 
	 *
	 */
	public static class EventRating {
		public static final By AutomaticRateUpdate = getLeftLink("Automatic Rate Update");
		public static final By MaintainCalendarDay = getLeftLink("Maintain Calendar Day");
		public static final By MaintainCallCategory = getLeftLink("Maintain Call Category");
		public static final By MaintainChargeAreaCodes = getLeftLink("Maintain Charge Area Codes");
		public static final By MaintainChargeGroup = getLeftLink("Maintain Charge Group");
		public static final By MaintainCurrencyExchangeRates = getLeftLink("Maintain Currency Exchange Rates");
		public static final By MaintainDaytype = getLeftLink("Maintain Day type");
		public static final By MaintainMessageType = getLeftLink("Maintain Message Type");
		public static final By MaintainMessageUnit = getLeftLink("Maintain Message Unit");
		public static final By MaintainMobileGSMCarrier = getLeftLink("Maintain Mobile GSM Carrier");
		public static final By MaintainPortOperatorDestinationCountry = getLeftLink(
				"Maintain Port Operator Destination Country");
		public static final By MaintainRatingCategory = getLeftLink("Maintain Rating Category");
		public static final By MaintainRouteType = getLeftLink("Maintain Route Type");
		public static final By MaintainServiceType = getLeftLink("Maintain Service Type");
		public static final By MaintainSIDCIBERChargeTypes = getLeftLink("Maintain SID CIBER Charge Types");
		public static final By MaintainForeignSIDSurchargeRates = getLeftLink("Maintain Foreign SID Surcharge Rates");
		public static final By MaintainSurchargeType = getLeftLink("Maintain Surcharge Type");
		public static final By MaintainTariffPlans = getLeftLink("Maintain Tariff Plans");
		public static final By MaintainTimeBandType = getLeftLink("Maintain Time Band Type");
	}

	/***
	 * Contains All left links of Automatic Rate Update
	 * 
	 * 
	 *
	 */
	public static class AutomaticRateUpdate {
		public static final By AutomaticRateUpdate = getLeftLink("Automatic Rate Update");
		public static final By MaintainCalendarDay = getLeftLink("Maintain Calendar Day");
		public static final By MaintainCallCategory = getLeftLink("Maintain Call Category");
		public static final By MaintainChargeAreaCodes = getLeftLink("Maintain Charge Area Codes");
		public static final By MaintainChargeGroup = getLeftLink("Maintain Charge Group");
		public static final By MaintainCurrencyExchangeRates = getLeftLink("Maintain Currency Exchange Rates");
		public static final By MaintainDaytype = getLeftLink("Maintain Day type");
		public static final By MaintainMessageType = getLeftLink("Maintain Message Type");
		public static final By MaintainMessageUnit = getLeftLink("Maintain Message Unit");
		public static final By MaintainMobileGSMCarrier = getLeftLink("Maintain Mobile GSM Carrier");
		public static final By MaintainPortOperatorDestinationCountry = getLeftLink(
				"Maintain Port Operator Destination Country");
		public static final By MaintainRatingCategory = getLeftLink("Maintain Rating Category");
		public static final By MaintainRouteType = getLeftLink("Maintain Route Type");
		public static final By MaintainServiceType = getLeftLink("Maintain Service Type");
		public static final By MaintainSIDCIBERChargeTypes = getLeftLink("Maintain SID CIBER Charge Types");
		public static final By MaintainForeignSIDSurchargeRates = getLeftLink("Maintain Foreign SID Surcharge Rates");
		public static final By MaintainSurchargeType = getLeftLink("Maintain Surcharge Type");
		public static final By MaintainTariffPlans = getLeftLink("Maintain Tariff Plans");
		public static final By MaintainTimeBandType = getLeftLink("Maintain Time Band Type");
	}

	/***
	 * Contains All left links of Comverse
	 * 
	 * 
	 *
	 */
	public static class Comverse {
		public static final By MaintainComverseChargeCode = getLeftLink("Maintain Comverse Charge Code");
		public static final By MaintainComverseClassofService = getLeftLink("Maintain Comverse Class of Service");
		public static final By MaintainComverseLocation = getLeftLink("Maintain Comverse Location");
		public static final By MaintainComverseSubtype = getLeftLink("Maintain Comverse Sub-type");
		public static final By MaintainComverseONEBundles = getLeftLink("Maintain Comverse ONE Bundles");
		public static final By MaintainComverseONEOffers = getLeftLink("Maintain Comverse ONE Offers");
		public static final By MaintainComverseONEBalances = getLeftLink("Maintain ComverseONE Balances");
	}

	/***
	 * Contains All left links of Meters
	 * 
	 * 
	 *
	 */
	public static class Meters {
		public static final By AmendMeterReadings = getLeftLink("Amend Meter Readings");
		public static final By ManualMeterReading = getLeftLink("Manual Meter Reading");
		public static final By MaintainMeterRates = getLeftLink("Maintain Meter Rates");
		public static final By MaintainMeterTypes = getLeftLink("Maintain Meter Types");
		public static final By MaintainServiceRateType = getLeftLink("Maintain Service Rate Type");
		public static final By MaintainFreeUnits = getLeftLink("Maintain Free Units");
	}

	/***
	 * Contains All left links of IAA
	 * 
	 * 
	 *
	 */
	public static class IAA {
		public static final By MaintainAdministrationType = getLeftLink("Maintain Administration Type");
		public static final By MaintainCountryReferenceCode = getLeftLink("Maintain Country Reference Code");
		public static final By MaintainDisputeCodes = getLeftLink("Maintain Dispute Codes");
		public static final By MaintainIAALedgerCodeBase = getLeftLink("Maintain IAA Ledger Code Base");
		public static final By MaintainInwardDiallingRange = getLeftLink("Maintain Inward Dialling Range");
		public static final By MaintainMasterServiceTypeRefCode = getLeftLink("Maintain Master Service Type Ref Code");
		public static final By MaintainOperatingAdminRefCode = getLeftLink("Maintain Operating Admin Ref Code");
		public static final By MaintainServiceTypeReferenceCode = getLeftLink("Maintain Service Type Reference Code");
		public static final By MaintainTrafficCategory = getLeftLink("Maintain Traffic Category");
		public static final By MaintainRoutes = getLeftLink("Maintain Routes");
		public static final By MaintainOperatingAdministration = getLeftLink("Maintain Operating Administration");
		public static final By MaintainCountry = getLeftLink("Maintain Country");
		public static final By MaintainTestUnits = getLeftLink("Maintain Test Units");
	}

	/***
	 * Contains All left links of Product And Pricing Reports
	 * 
	 * 
	 *
	 */
	public static class ProductandPricingReports {
		public static final By ReportofOutstandingPricingPlanApprovals = getLeftLink(
				"Report of Outstanding Pricing Plan Approvals");
		public static final By RequestAdhocPricingPlanReports = getLeftLink("Request Ad-hoc Pricing Plan Reports");
		public static final By RequestRateUpdateAuditReport = getLeftLink("Request Rate Update Audit Report");
		public static final By ProductsProvidedByBUReport = getLeftLink("Products Provided By BU Report");
		public static final By BulkMessageTariffChanges = getLeftLink("Bulk Message Tariff Changes");
	}

	/***
	 * Contains All left links of IAA Reports
	 * 
	 * 
	 *
	 */
	public static class IAAReports {
		public static final By AccountsAwaitingSettlementReport = getLeftLink("Accounts Awaiting Settlement Report");
		public static final By IAAChargeRateReport = getLeftLink("IAA Charge Rate Report");
		public static final By OutstandingBalancesReport = getLeftLink("Outstanding Balances Report");
		public static final By ProcessingofAccountswithAdministration = getLeftLink(
				"Processing of Accounts with Administration");
		public static final By RevaluationSummaryReport = getLeftLink("Revaluation Summary Report");
		public static final By SettlementAdjustmentandChargeItem = getLeftLink("Settlement Adjustment and Charge Item");
		public static final By InpaymentSummaryReport = getLeftLink("Inpayment Summary Report");
		public static final By EnterRateExceptionReport = getLeftLink("Enter Rate Exception Report");
		public static final By PrimaryRouteUpdateReport = getLeftLink("Primary Route Update Report");
		public static final By TapesOutpaymentSourceDataProcessed = getLeftLink(
				"Tapes/Outpayment Source Data Processed");
		public static final By EnterNonAccountableTrafficReportDetails = getLeftLink(
				"Enter Non-Accountable Traffic Report Details");
		public static final By IAAPaymentSummaryReport = getLeftLink("IAA Payment Summary Report");
		public static final By PrimaryRouteReport = getLeftLink("Primary Route Report");
		public static final By RequestAggregateInterconnectReport = getLeftLink(
				"Request Aggregate Interconnect Report");
		public static final By RevenueAndOutpaymentSummaryReport = getLeftLink("Revenue & Outpayment Summary Report");
		public static final By TransitRateChangeImpactAnalysis = getLeftLink("Transit Rate Change Impact Analysis");
		public static final By ForeignCurrencyAccountReport = getLeftLink("Foreign Currency Account Report");
		public static final By EnterAccountableTrafficReportDetails = getLeftLink(
				"Enter Accountable Traffic Report Details");
		public static final By AgedDebtorCreditorAnalysisReport = getLeftLink("Aged Debtor/Creditor Analysis Report");
	}

	/***
	 * Contains All left links of Ericsson
	 * 
	 * 
	 *
	 */
	public static class Ericsson {
		public static final By MaintainEricssonPackages = getLeftLink("Maintain Ericsson Packages");
	}

	/***
	 * Contains All left links of Employee Administration
	 * 
	 * 
	 *
	 */
	public static class EmployeeAdministration {
		public static final By MaintainEmployeeParams = getLeftLink("Maintain Employee Params");
		public static final By MaintainDepartmentEmployee = getLeftLink("Maintain Department Employee");
		public static final By MaintainEmployeeDepartment = getLeftLink("Maintain Employee Department");
		public static final By MaintainEmployee = getLeftLink("Maintain Employee");
		public static final By MaintainEmployeeCompany = getLeftLink("Maintain Employee Company");
		public static final By MaintainEmployeeFunction = getLeftLink("Maintain Employee Function");
		public static final By ManageUsers = getLeftLink("Manage Users");
		public static final By ManagePositions = getLeftLink("Manage Positions");
		public static final By ManageRoles = getLeftLink("Manage Roles");
		public static final By MaintainPrivileges = getLeftLink("Maintain Privileges");
		public static final By MaintainScreenPreferences = getLeftLink("Maintain Screen Preferences");
		public static final By RequestEmail = getLeftLink("Request Email");
		public static final By MaintainLocation = getLeftLink("Maintain Location");
	}

	/***
	 * Contains All left links of BU SetUp
	 * 
	 * 
	 *
	 */
	public static class BUSetUp {
		public static final By MaintainAlternateCodes = getLeftLink("Maintain Alternate Codes");
		public static final By MaintainBusinessUnitDetails = getLeftLink("Maintain Business Unit Details");
		public static final By MaintainCodes = getLeftLink("Maintain Codes");
		public static final By MaintainCompany = getLeftLink("Maintain Company");
		public static final By MaintainCustomerService = getLeftLink("Maintain Customer Service");
		public static final By MaintainCustomerType = getLeftLink("Maintain Customer Type");
		public static final By MaintainDepartment = getLeftLink("Maintain Department");
		public static final By MaintainDepartmentFunction = getLeftLink("Maintain Department Function");
		public static final By MaintainOrderTypeComponent = getLeftLink("Maintain Order Type Component");
		public static final By MaintainMessageInformation = getLeftLink("Maintain Message Information");
		public static final By MaintainSite = getLeftLink("Maintain Site");
		public static final By MaintainSiteDerivation = getLeftLink("Maintain Site Derivation");
		public static final By MaintainSiteProfile = getLeftLink("Maintain Site Profile");
	}

	/***
	 * Contains All left links of Other data setup
	 * 
	 * 
	 *
	 */
	public static class Otherdatasetup {
		public static final By MaintainEmployeeReportCategory = getLeftLink("Maintain Employee Report Category");
		public static final By EndUserReportList = getLeftLink("End User Report List");
		public static final By MasterEndUserReport = getLeftLink("Master End User Report");
		public static final By MaintainContractType = getLeftLink("Maintain Contract Type");
		public static final By MaintainCurrencyCode = getLeftLink("Maintain Currency Code");
		public static final By MaintainETFType = getLeftLink("Maintain ETF Type");
		public static final By MaintainLetter = getLeftLink("Maintain Letter");
		public static final By MessageEditor = getLeftLink("Message Editor");
		public static final By MaintainMaintenancePlan = getLeftLink("Maintain Maintenance Plan");
		public static final By MaintainPrinter = getLeftLink("Maintain Printer");
		public static final By MaintainPropertiesandPropertyValueRange = getLeftLink(
				"Maintain Properties and Property Value Range");
		public static final By IdentifyEndUserReport = getLeftLink("Identify End User Report");
		public static final By CustomerCharterReport = getLeftLink("Customer Charter Report");
		public static final By MaintainReportGroupandCategoryData = getLeftLink(
				"Maintain Report Group and Category Data");
	}

	/***
	 * Contains All left links of Support Functions
	 * 
	 * 
	 *
	 */
	public static class SupportFunctions {
		public static final By MaintainReportInformation = getLeftLink("Maintain Report Information");
		public static final By SpeedTest = getLeftLink("Speed Test");
		public static final By Telnet = getLeftLink("Telnet");
	}

	/***
	 * Contains All left links of Withdrawn Items
	 * 
	 * 
	 *
	 */
	public static class WithdrawnItems {
		public static final By CallingCards = getLeftLink("Calling Cards");
		public static final By CustomerNameSearch = getLeftLink("Customer Name Search");
		public static final By MaintainAvailabilityStatusReason = getLeftLink("Maintain Availability Status Reason");
		public static final By MaintainElectronicStandards = getLeftLink("Maintain Electronic Standards");
		public static final By RequestSuspensebyExchangeIdReport = getLeftLink(
				"Request Suspense by Exchange Id Report");
		public static final By RequestAdhocReports = getLeftLink("Request Ad-hoc Reports");
	}
}
