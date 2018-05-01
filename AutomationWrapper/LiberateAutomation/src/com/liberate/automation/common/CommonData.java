package com.liberate.automation.common;

/***
 * Common Data class to hold Common Data used in Liberate.
 * 
 * 
 *
 */
public class CommonData {
	/***
	 * Common Data class witch holds Data for Application Form Types Applicable for
	 * Application Form Drop Down in New Customer Screen.
	 * 
	 * 
	 *
	 */
	public static class ApplicationForm {
		public final static String MobileprepaidResidential = "Mobile prepaid(Residential)";
		public final static String MobileprepaidBusiness = "Mobile prepaid(Business)";
		public final static String MobilepostpaidResidential = "Mobile postpaid(Residential)";
		public final static String MobilepostpaidBusiness = "Mobile postpaid(Business)";
		public final static String FixedResidential = "Fixed(Residential)";
		public final static String FixedBusiness = "Fixed(Business)";
		public final static int IndexMobileprepaidResidential = 1;
		public final static int IndexMobileprepaidBusiness = 2;
		public final static int IndexMobilepostpaidResidential = 3;
		public final static int IndexMobilepostpaidBusiness = 4;
		public final static int IndexFixedResidential = 5;
		public final static int IndexFixedBusiness = 6;

	}

	/***
	 * Common Data class which hold data for Customer Type.
	 *
	 */
	public static class CustomerType {
		public final static String Business = "B - Business";
		public final static String Residential = "R - Residential";
	}

	/***
	 * Common Data class which hold data for Address Type.
	 * 
	 * 
	 *
	 */
	public static class AddressType {
		public final static String PostCode = "Post Code";
		public final static String StandardAddress = "A-Standard Address";
		public final static String ForeignAddress = "F-Foreign Address";
		public final static String POBox = "P-P.O. Box";
		public final static String PanamaReverseDropdown = "Q-Panama Reverse Dropdown";
		public final static String StreetAddress = "S-Street Address";
	}

	/***
	 * Common Data class which hold data for Plant Item Type.
	 * 
	 * 
	 *
	 */
	public static class PlantItemType {
		public final static String CopperDP = "DP-DISTRIBUTION";
		public final static String FiberDP = "FDP-";
	}

	/***
	 * Common Data class which hold Credit Control Service Status Types.
	 * 
	 * 
	 *
	 */
	public static class CreditControlServiceStatusValues {
		public final static String ROS = "ROS";
		public final static String BAR = "BAR";
		public final static String TOS = "TOS";
	}
}
