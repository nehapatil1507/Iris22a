package com.iris22a.stepdefinition;

import java.awt.event.KeyEvent;
import java.util.List;

import org.testng.Assert;

import com.iris22a.keyword.UIKeyword;
import com.iris22a.pages.HomePage;
import com.iris22a.pages.MenTshirtPage;
import com.iris22a.util.Environment;
import com.iris22a.util.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	@And("url is launched")
	public void launchMyntraUrl() {
		UIKeyword.launchUrl(Environment.URL);

	}

	@When("user searches for polo t-shirt")
	public void searchPoloTShirt() {

		HomePage home = new HomePage();
		home.searchProduct("Polo");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);

	}
	

	@Then("all results should be related to polo")
	public void VerifyAllResults() {
		HomePage home = new HomePage();
		List<String> productTexts = home.getSearchResultTexts();
		for (String text : productTexts) {
			Assert.assertTrue(text.contains("Polo"), "Product is mismatched :" + text);

		}
	}

	@When("user hovers on men Menu")
	public void hoverOnMenMenu() {
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
	}

	@And("user clicks on men tshirt")
	public void clickOnMenTshirt() {
		HomePage home = new HomePage();
		WaitFor.elementToBeClickable(home.menTShirt);
		home.clickOnMenTShirt();
	}

	@Then("user selects popularity filter")
	public void selectPopularityFilter() {
		MenTshirtPage menTshirt = new MenTshirtPage();
		WaitFor.elementToBeClickable(menTshirt.sortByFilter);
		menTshirt.selectPopularityFilter();

	}

}
