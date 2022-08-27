package com.iris22a.config;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.iris22a.keyword.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class TestBase {

	private static final Logger log = Logger.getLogger(TestBase.class);

	//@Parameters("browser-name")

	
	//@BeforeMethod
	@Before
	public void setUp() throws Exception {
		String browserName = Environment.BROWSER;
		if (browserName == null) {
			browserName = "Chrome";
		}

		if (browserName.isEmpty()) {
			browserName = "Chrome";
			log.info("setting default browser as "+browserName);
		}
		UIKeyword.openBrowser(browserName);

	}
	
	
	//@AfterMethod
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		UIKeyword.closeBrowser();
	}

}
