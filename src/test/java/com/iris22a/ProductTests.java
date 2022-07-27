package com.iris22a;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.iris22a.config.TestBase;
import com.iris22a.keyword.UIKeyword;
import com.iris22a.pages.CasualShirtsPage;
import com.iris22a.pages.HomePage;
import com.iris22a.util.Environment;
import com.iris22a.util.PropUtil;
import com.iris22a.util.WaitFor;

public class ProductTests extends TestBase {
	@Test

	public void verifySearchResultForPoloMen() {
		PropUtil repo = new PropUtil();
		UIKeyword.launchUrl(Environment.URL);
		UIKeyword.enterText((repo.getLocator("search_products_txtBx")[0]), repo.getLocator("search_products_txtBx")[1],
				"polo men");
		UIKeyword.hitButton(KeyEvent.VK_ENTER);
		List<String> productTitles = UIKeyword.getTexts((repo.getLocator("product_titles_txt")[0]),
				repo.getLocator("product_titles_txt")[1]);
		for (String productTitle : productTitles) {
			Assert.assertTrue(productTitle.contains("Polo"), "Product title doesnt contains polo:" + productTitle);

		}

	}

	@Test
	public void verifyCategoryListForTopWears() {
		List<String> expected = new ArrayList<String>();
		expected.add("Tshirts");
		expected.add("Shirts");
		expected.add("Kurtas");
		expected.add("Sweatshirts");
		expected.add("Jackets");
		expected.add("Sweaters");
		expected.add("Blazers");

		PropUtil repo = new PropUtil();
		UIKeyword.launchUrl(Environment.URL);
		UIKeyword.mouseMove((repo.getLocator("men_menu")[0]), repo.getLocator("men_menu")[1]);
		UIKeyword.click((repo.getLocator("menu_topwear")[0]), repo.getLocator("menu_topwear")[1]);
		WaitFor.elementToBePresent((repo.getLocator("categories_text")[0]), repo.getLocator("categories_text")[1]);
		List<String> actualCategories = UIKeyword.getTexts((repo.getLocator("categories_text")[0]),
				repo.getLocator("categories_text")[1]);
		for (int i = 0; i < actualCategories.size(); i++) {
			actualCategories.set(i, actualCategories.get(i).split("\\(")[0]);

		}

		Assert.assertTrue(actualCategories.containsAll(expected),
				"List didnt match: expected:" + expected + "\n Actual: " + actualCategories);
	}

	@Test
	public void veifyItemCountOfCasualShirts() {
		UIKeyword.launchUrl(Environment.URL);
		HomePage home = new HomePage();
		home.hoverOnMenMenu();
		home.clickOnCasualTShirts();
		CasualShirtsPage casual = new CasualShirtsPage();
		int itemCount= casual.getItemCount();
		System.out.println(itemCount);

	}
}
