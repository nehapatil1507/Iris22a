package com.iris22a.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.iris22a.keyword.UIKeyword;

public class WaitFor {

	private static FluentWait<WebDriver> wait = null;

	static {
		wait = new FluentWait<WebDriver>(UIKeyword.driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Wait is finished and element is not loaded or available");
	}

	public static void elementToBePresent(By locator) {
		wait.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void elementToBePresent(String locatorType, String locatorValue) {
		wait.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
		// wait.until(ExpectedConditions.presenceOfElementLocated(UIKeyword.getWebElement(locatorType,
		// locatorValue)));
	}

	public static void elementToBeClickable(WebElement element) {
		// wait.until(ExpectedConditions.presenceOfElementLocated(element));
		wait.ignoring(NoSuchElementException.class, ElementNotInteractableException.class);
		//wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void time(int durationInSeconds) {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + (durationInSeconds * 1000);
		while (startTime <= endTime) {
			startTime = System.currentTimeMillis();

		}
	}

}
