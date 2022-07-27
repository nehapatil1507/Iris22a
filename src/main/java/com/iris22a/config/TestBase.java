package com.iris22a.config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keyword.UIKeyword;

public class TestBase {

	@Parameters("browser-name")
	@BeforeMethod
	public void setUp(@Optional String browserName) throws Exception {
		if (browserName == null) {
			browserName = "Chrome";
		}

		if (browserName.isEmpty()) {
			browserName = "Chrome";
			System.out.println("setting default browser as "+browserName);
		}
		UIKeyword.openBrowser(browserName);

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		UIKeyword.closeBrowser();
	}

}
