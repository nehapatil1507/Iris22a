package com.iris22a.keyword;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.inject.spi.Element;
import com.iris22a.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Neha Patil
 * 
 * 
 */


public class UIKeyword {
	private static final Logger log = Logger.getLogger(UIKeyword.class);

	public static RemoteWebDriver driver;

	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("FireFox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--disable-notifications","start-maximized","--incognito");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications","start-maximized","--incognito");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		log.info(browserName + "browser is launched successfully");
	}

	public static void launchUrl(String url) {
		driver.get(url);
		log.info("url is launched " + url);

	}

	public static void closeBrowser() {
		driver.close();
		log.info("browser is closed successfully");
	}

	public static void switchToWindow(String byTitle) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		String title = driver.getTitle();
		for (String window : windows) {
			if (driver.switchTo().window(window).getTitle().equalsIgnoreCase(byTitle)) {
				System.out.println("Switched towindow" + byTitle);
				break;

			}

		}

	}

	public static void enterText(By element, String text) {
		driver.findElement(element).sendKeys(text);

	}

	public static void hitButton(int KeyCode) {

		Robot robo = null;

		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			log.error("unable to instatiate rorbot class instance");
		}
		robo.keyPress(KeyCode);
		robo.keyRelease(KeyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement ele : elements) {
			texts.add(ele.getText());

		}
		return texts;

	}

	public static void mouseMove(By xpath) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(xpath)).build().perform();
	}

	public static void click(By xpath) {
		driver.findElement(xpath).click();
	}

	public static void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();

	}

	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));

		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));

		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));

		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locatorValue));

		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locatorValue));

		} else if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));

		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));

		} else if (locatorType.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorValue));

		} else {
			System.err.println("Invalid Locator Type: " + locatorType);
		}
		return element;

	}

	public static List<WebElement> getWebElements(String locatorType, String locatorValue) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatorValue));

		} else if (locatorType.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locatorValue));

		} else if (locatorType.equalsIgnoreCase("css")) {
			elements = driver.findElements(By.cssSelector(locatorValue));

		} else if (locatorType.equalsIgnoreCase("linkText")) {
			elements = driver.findElements(By.linkText(locatorValue));

		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			elements = driver.findElements(By.partialLinkText(locatorValue));

		} else if (locatorType.equalsIgnoreCase("class")) {
			elements = driver.findElements(By.className(locatorValue));

		} else if (locatorType.equalsIgnoreCase("tagName")) {
			elements = driver.findElements(By.tagName(locatorValue));

		} else if (locatorType.equalsIgnoreCase("name")) {
			elements = driver.findElements(By.name(locatorValue));

		} else {
			log.error("Invalid Locator Type: " + locatorType);
		}
		return elements;

	}

	public static void mouseMove(String locatorType, String locatorValue) {
		Actions actions = new Actions(UIKeyword.driver);
		actions.moveToElement(getWebElement(locatorType, locatorValue)).perform();
	}

	public static List<String> getTexts(String locatorType, String locatorValue) {
		List<WebElement> elements = getWebElements(locatorType, locatorValue);
		List<String> texts = new ArrayList<String>();
		for (WebElement ele : elements) {
			texts.add(ele.getText());

		}
		return texts;

	}

	public static void enterText(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public static void mouseMove(WebElement element) {
		Actions actions = new Actions(UIKeyword.driver);
		actions.moveToElement(element).perform();

	}

	public static void click(WebElement element) {
		element.click();

	}

	public static void enterText(WebElement element, String productName) {
		element.sendKeys(productName);
	}
}
