package com.liberate.automation.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActions {

	public String classVersion = "0.9.0";

	Boolean retry = false;
	int retryCount = 3;
	int executionCount = 0;

	int screenshotCount = 0;

	WebDriver driver = null;

	Select select = null;

	/**
	 * Default constructor, which will also create and instance of WebDriver inside
	 * class
	 */
	public TestActions() {
		screenshotCount = 0;

		System.setProperty("webdriver.chrome.driver", "Resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	/**
	 * Method that can be called to navigate to a particular URL.
	 * 
	 * @param URL
	 *            URL to which the driver needs to navigate to.
	 * @return Return true, if the able to navigate to the given URL, else will
	 *         return false.
	 */
	public Boolean gotoURL(String URL) {
		try {
			log("Navigating to '" + URL + "'");
			driver.navigate().to(URL);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				gotoURL(URL);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to click on an element in the currently opened
	 * WebPage.
	 * 
	 * @param locator
	 *            Identifies the element which needs to be clicked.
	 * @return Return true, if able to click on the element, else will return false.
	 */
	public Boolean clickOn(By locator) {
		try {
			log("Clicking on element '" + locator.toString() + "'");
			driver.findElement(locator).click();
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				clickOn(locator);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to send data to any Field which is currently
	 * available in the WebPage.
	 * 
	 * @param locator
	 *            Identifies the element which the data needs to be sent.
	 * @param data
	 *            Data than needs to be sent
	 * @return Return true, if able to sent data to the provided field, else will
	 *         return false.
	 */
	public Boolean sendDataTo(By locator, String data) {
		if (data.equals(""))
			return true;

		try {
			log("Sending data '" + data + "' to field '" + locator.toString() + "'");
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(data);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				sendDataTo(locator, data);
			else
				return false;
		}

		return true;
	}

	/***
	 * Method that can be called to send Data to a field. Used to send Data to a
	 * field which is validated on key-press and slow to accept input.
	 * 
	 * @param locator
	 *            Identifies the element which the data needs to be sent.
	 * @param data
	 *            If Date then should be in format 'DD/MM/YYYY hh:mm'
	 * @return
	 */
	public Boolean typeDataTo(By locator, String data) {
		if (data.equals(""))
			return true;

		clearField(locator);

		try {
			char[] dateChars = data.toCharArray();
			log("Typing in data '" + data + "' to '" + locator.toString() + "'");

			for (int i = 0; i < data.length(); i++) {
				driver.findElement(locator).sendKeys(Character.toString(dateChars[i]));
				Thread.sleep(200);
			}
		} catch (Exception e) {
			handleException(e);
		}

		return true;
	}

	/***
	 * Method that can be called to clear any Input field which is currently
	 * available in the WebPade.
	 * 
	 * @param locator
	 *            Identifies the element that needs to be cleared
	 * @return Returns true, if able to clear the Field, or else will return false.
	 */
	public Boolean clearField(By locator) {
		try {
			log("Clearing field '" + locator.toString() + "'");
			driver.findElement(locator).clear();
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				clearField(locator);
			else
				return false;
		}

		return true;
	}

	/**
	 * Method that can be called to select a value from a DropDown based on index
	 * value provided.
	 * 
	 * @param locator
	 *            Identifies the drop down element.
	 * @param index
	 *            The index of the value that needs to be selected.
	 * @return Returns true, if able to select the provided index from the provided
	 *         element in WebPage
	 */
	public Boolean selectBy(By locator, int index) {
		if (countOf(locator) == 0) {
			log("ERROR : Element located by '" + locator.toString() + "' is not available.");
			return false;
		}
		try {
			log("Selecting index '" + index + "' from '" + locator.toString() + "'");
			select = new Select(driver.findElement(locator));
			select.selectByIndex(index);
			waitFor(1);
			log("Selected value : " + this.getSelectedOption(locator));
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				selectBy(locator, index);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to select a value from a DropDown based on the text
	 * available in the drop down.
	 * 
	 * @param locator
	 *            Identifies the drop down element.
	 * @param index
	 *            The Text of the value that needs to be selected.
	 * @return Returns true, if able to select the provided Text from the provided
	 *         element in WebPage
	 */
	public Boolean selectBy(By locator, String visibleText) {
		if (visibleText.equals(""))
			return true;

		try {
			log("Selecting value '" + visibleText + "' from '" + locator.toString() + "'");
			select = new Select(driver.findElement(locator));
			select.selectByVisibleText(visibleText);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				selectBy(locator, visibleText);
			else
				return false;
		}

		return true;
	}

	/**
	 * Method that can be called to select a value from a DropDown based on the
	 * Value of the Select.
	 * 
	 * @param locator
	 *            Identifies the drop down element.
	 * @param index
	 *            The Text of the value that needs to be selected.
	 * @return Returns true, if able to select the provided Text from the provided
	 *         element in WebPage
	 */
	public Boolean selectByValue(By locator, String value) {
		if (value.equals(""))
			return true;

		try {
			log("Selecting value '" + value + "' from '" + locator.toString() + "'");
			select = new Select(driver.findElement(locator));
			select.selectByValue(value);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				selectByValue(locator, value);
			else
				return false;
		}

		return true;
	}

	/***
	 * Method that can be called to select a value from a DropDown based on the
	 * partial text passed
	 * 
	 * @param locator
	 *            Identifies the drop down element.
	 * @param partialText
	 *            The partial Text of the value that needs to be selected
	 * @return Returns true, if able to select the provided Text from the provided
	 *         element in WebPage
	 */
	public boolean selectByPartialText(By locator, String partialText) {
		String xpath = getXpath(locator);
		String fullText = "";
		xpath = xpath + "/descendant::option";

		try {
			List<WebElement> options = driver.findElements(By.xpath(xpath));

			for (WebElement option : options) {
				if (option.getText().contains(partialText)) {
					fullText = option.getText();
					log("Full Text : " + fullText);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			handleException(e);
		}

		return selectBy(locator, fullText);
	}

	/***
	 * Method to get the index of an Option from Select
	 * 
	 * @param locator
	 *            The Locator of Select
	 * @param SelectText
	 *            The Text to get the index of.
	 * @return 0 if not found. Else the index.
	 */
	public int getIndexOfSelect(By locator, String SelectText) {
		String xpath = getXpath(locator);
		xpath = xpath + "/descendant::option";

		int index = 0;

		List<WebElement> options = driver.findElements(By.xpath(xpath));

		for (WebElement option : options) {
			if (option.getText().contains(SelectText)) {
				index = options.indexOf(option);
				break;
			}
		}

		return (index + 1);
	}

	/***
	 * Method to get the selected value from The Drop-down.
	 * 
	 * @param locator
	 *            The locator of drop down from which the selected value should be
	 *            returned.
	 * @return The selected value as String.
	 */
	public String getSelectedValue(By dropdown) {
		String xpath = getXpath(dropdown);
		xpath = xpath + "/descendant::option[@selected='selected']";

		return getTextFromPage(By.xpath(xpath));
	}

	/**
	 * Method that can be called to wait until an element is available on not
	 * available based of parameter 'visibility'.
	 * 
	 * @param locator
	 *            The visibility of element that needs to be considered for waiting.
	 * @param seconds
	 *            Maximum time in seconds, waited for before throwing timeout
	 *            exception.
	 * @param visibility
	 *            True : Wait till element is available, False : Wait till element
	 *            is not available.
	 * @return Returns true, when able to wait for element visibility successfully,
	 *         false if exception is thrown.
	 */
	public Boolean waitFor(By locator, int seconds, Boolean visibility) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		try {
			if (visibility) {
				log("Waiting '" + seconds + "' seconds for '" + locator.toString() + "' to appear");
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			} else {
				log("Waiting '" + seconds + "' seconds for '" + locator.toString() + "' to disappear");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			}
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				waitFor(locator, seconds, visibility);
			else
				return false;
		}

		return true;
	}

	/***
	 * Method called to wait till an element is clickable.
	 * 
	 * @param locator
	 *            The locator which needs to be considered for waiting.
	 * @param seconds
	 *            Max time to wait in seconds.
	 * @return Return true, if element is clickable in the given time. Else will
	 *         return false.
	 */
	public Boolean waitForClickable(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		try {
			log("Waiting '" + seconds + "' seconds for '" + locator.toString() + "' to be clickable");
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				waitForClickable(locator, seconds);
			else
				return false;
		}

		return true;
	}

	/**
	 * Method that can be used to wait for passed value of seconds
	 * 
	 * @param seconds
	 *            Seconds that need to be waited for
	 * @return Always return true.
	 */
	public Boolean waitFor(int seconds) {
		try {
			log("Waiting for '" + seconds + "' seconds");
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				waitFor(seconds);
			else
				return false;
		}
		return true;
	}

	/**
	 * Method that can be called to get the count of passed Element in the WebPage.
	 * 
	 * @param locator
	 *            The element that needs to be counted.
	 * @return Returns 0, if the element is not available, else will return the
	 *         count.
	 */
	public int countOf(By locator) {
		int count = 0;

		try {
			log("Counting the occurence of element '" + locator.toString() + "'");
			count = driver.findElements(locator).size();
			log("Count is : " + count);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				countOf(locator);
			else
				return 0;
		}

		return count;
	}

	/***
	 * Method to check is passed Text is available in page.
	 * 
	 * @param Text
	 *            The Text that needs to be checked for availability.
	 * @return True: If available, False : If not available.
	 */
	public boolean isTextAvailable(String Text) {
		int count = 0;

		By locator = By.xpath("//*[text()[contains(.,'" + Text.trim() + "')]]");

		try {
			log("Checking Availability of text : '" + Text + "'");
			count = driver.findElements(locator).size();
			log("Count is : " + count);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				countOf(locator);
			else
				return false;
		}

		return (count > 0);
	}

	/***
	 * Method that can be called to get the selected value from a Drop-down.
	 * 
	 * @param locator
	 *            The locator from which the selected value should be retrieved.
	 * @return Returns the selected option as String. Returns '' if the nothing is
	 *         selected or failed to get the value from the locator.
	 */
	public String getSelectedOption(By locator) {
		String option = "";

		try {
			log("Getting selected value from '" + locator.toString() + "'");
			Select select = new Select(driver.findElement(locator));
			option = select.getFirstSelectedOption().getText();
			log("Selected value is : " + option);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				getSelectedOption(locator);
			else
				return "";
		}

		return option;
	}

	/***
	 * Method called to get text from page based on locator
	 * 
	 * @param locator
	 *            The locator from which the text should be taken.
	 * @return Returns the text
	 */
	public String getTextFromPage(By locator) {
		String text = "";

		try {
			log("Getting text from '" + locator.toString() + "'");
			text = driver.findElement(locator).getText();
			log("Text is : " + text);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				getTextFromPage(locator);
			else
				return "";
		}

		return text;
	}

	/***
	 * Method that can be called to switch to another frame in a web page.
	 * 
	 * @param locator
	 *            The unique locator of the frame where the driver should switch to.
	 * @return returns True, if able to switch else false.
	 */
	public Boolean switchToFrame(By locator) {
		try {
			log("Switching to frame '" + locator.toString() + "'");
			driver.switchTo().frame(driver.findElement(locator));
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				switchToFrame(locator);
			else
				return false;
		}
		return true;
	}

	/***
	 * Method that can be called to switch to newly opened Window/Tab.
	 * 
	 * @return returns True, if able to switch else false.
	 */
	public Boolean switchToNewWindow() {
		try {
			log("Switching to New Window");
			Set<String> WindowHandles = driver.getWindowHandles();
			String[] Window = WindowHandles.toArray(new String[WindowHandles.size()]);
			driver.switchTo().window(Window[Window.length - 1]);
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				switchToNewWindow();
			else
				return false;
		}
		return true;
	}

	/***
	 * Method that is called to switch to default frame in the page.
	 * 
	 * @return returns True, if able to switch else false.
	 */
	public Boolean switchBacktoMain() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				switchBacktoMain();
			else
				return false;
		}
		return true;
	}

	/***
	 * Method that can be called to take Screenshot of the current page, where the
	 * driver is in.
	 * 
	 * @return Returns the screenshot as a file, and 'null' if not able to take
	 *         screenshot.
	 */
	public File getScreenShot(String filename) {
		screenshotCount = screenshotCount + 1;

		File screenshot = null;
		try {
			screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("Screenshots//" + filename + "_" + screenshotCount + ".png"));
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				getScreenShot(filename);
			else
				return null;
		}
		return screenshot;
	}

	public String getTestStatus(Boolean passed) {
		return ((passed) ? "PASSED" : "FAILED");
	}

	/***
	 * Method called to get the xpath from By class object
	 * 
	 * @param locator
	 *            The locator from which xpath needs to be retrieved.
	 * @return The xpath locator as string. Returns "" if nothing found.
	 */
	public String getXpath(By locator) {
		return locator.toString().replace("By.xpath:", "").trim();
	}

	/***
	 * Method called to close current tab.
	 */
	public void closeTab() {
		driver.close();
	}

	/***
	 * Method called to quit current session.
	 */
	public void quit() {
		driver.quit();
	}

	/***
	 * This Method scrolls the Web document by the specified number of pixels.
	 * 
	 * @param horizontalScrollAmount
	 * 
	 *            How many pixels to scroll by, along the x-axis (horizontal).
	 *            Positive values will scroll to the right, while negative values
	 *            will scroll to the left
	 * 
	 * @param verticalScrollAmount
	 * 
	 *            How many pixels to scroll by, along the y-axis (vertical).
	 *            Positive values will scroll down, while negative values scroll up
	 */
	public void scroll(int horizontalScrollAmount, int verticalScrollAmount) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(" + horizontalScrollAmount + ", " + verticalScrollAmount + ");");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * Simple method that can be called to scroll Up
	 */
	public void scrollUp() {
		log("Scrolling up");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-2000)", "");
	}

	/***
	 * Simple method that can be called to scroll Down
	 */
	public void scrollDown() {
		log("Scrolling down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2000)", "");
	}

	/***
	 * Method to move mouse away from web application.
	 */
	public void moveMouseAwayFromScreen() {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseMove(0, 2000);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * Method to retrieve all elements located by the passed Locator as a list.
	 * 
	 * @param locator
	 *            The locator of the elements that need to be returned.
	 * @return All webElements as a list.
	 */
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	/***
	 * Method that is called to process and exception and take appropriate action.
	 * 
	 * @param e
	 *            The exception object that is passed, for processing.
	 * @return Returns true, if the step can be retried. Else will return false, can
	 *         can stop execution.
	 */
	private boolean handleException(Exception e) {
		// e.printStackTrace();

		// This code block checks how many times the step is executed. If >
		// retryCount, it will exit stopping execution of step.
		executionCount = executionCount + 1;
		if (executionCount >= retryCount) {
			executionCount = 0;
			log("ERROR : UAVOIDABLE ERROR OCCURED.");
			e.printStackTrace();
			return false;
		}

		// This code block with get the type of exception occurred and Handle
		// it.
		if (e instanceof StaleElementReferenceException) {
			log("WARNING : StaleElementReferenceException occured");
			waitFor(1);
			return true;
		} else if (e instanceof TimeoutException) {
			log("WARNING : TimeoutException occured");
			return false;
		} else if (e instanceof InvalidElementStateException) {
			log("WARNING : InvalidElementStateException occured");
			waitFor(1);
			return true;
		} else if (e instanceof WebDriverException) {
			log("WARNING : WebDriverException occured");
			waitFor(1);
			if (countOf(By.xpath("//input[@value='OK']")) > 0) {
				clickOn(By.xpath("(//input[@value='OK'])[last()]"));
				waitFor(By.xpath("//input[@value='OK']"), 2, false);
			}
			return true;
		} else {
			log("ERROR");
			System.out.println(e.getMessage());
			e.printStackTrace();

			return false;
		}
	}

	/***
	 * Class to log String Message
	 * 
	 * @param message
	 *            String Message that needs to be logged.
	 */
	public static void log(String message) {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");

		String d = sdf.format(date);

		String Log = d + " : " + message;

		System.out.println(Log);
		logToFile(d.split(" ")[0].replace("/", "_").trim(), Log);
	}

	/***
	 * Method to add the log to a file
	 * 
	 * @param FileName
	 *            Name of the file
	 * @param Log
	 *            Message to be logged
	 */
	private static void logToFile(String FileName, String Log) {

		BufferedWriter bw = null;

		try {
			// APPEND MODE SET HERE
			bw = new BufferedWriter(new FileWriter(FileName + "_log.txt", true));
			bw.write(Log);
			bw.newLine();
			bw.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException ioe2) {
				}
		}

	}

	public String getTextFromPage(WebElement webElement) {
		try {
			return webElement.getText();
		} catch (Exception e) {
			retry = handleException(e);
			if (retry)
				return webElement.getText();
			else
				return "";
		}
	}
}
