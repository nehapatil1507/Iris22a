package com.iris22a;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTshirtPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

public class MenTShirtsTests extends TestBase {
	UIKeyword keyword = new UIKeyword();

	@Test
	public void verifyIfSearchByPopularityYeildsProperResults() {
		UIKeyword.launchUrl(Environment.URL);
		
		HomePage home= new HomePage();

		//HomePage home = PageFactory.initElements(UIKeyword.driver, HomePage.class);
		home.hoverOnMenMenu();

		WaitFor.elementToBeClickable(home.menTShirt);
		home.clickOnMenTShirt();

		 MenTshirtPage menTshirt = new MenTshirtPage();
		//MenTshirtPage menTshirt = PageFactory.initElements(UIKeyword.driver, MenTshirtPage.class);

		WaitFor.elementToBeClickable(menTshirt.sortByFilter);

		menTshirt.selectPopularityFilter();
	}

}
