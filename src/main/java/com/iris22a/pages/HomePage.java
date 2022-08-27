package com.iris22a.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keyword.UIKeyword;

public class HomePage {
	private static final Logger log = Logger.getLogger(HomePage.class);

	// PageFactory
	@CacheLookup
	@FindBy(xpath = "//div[@class='desktop-navLink']/a[@href=\"/shop/men\"]")
	public WebElement menMenu;// By id ="menMenu"or name

	@FindBy(xpath = "//a[@href='/men-tshirts']")
	public WebElement menTShirt;

	@FindBy(xpath = "(//li[@class='desktop-oddColumnContent'])[1]/descendant:: a[contains(text(),'Casual')]")
	public WebElement casualShirts;

	@FindBy(css = "div.desktop-query>input.desktop-searchBar")
	public WebElement searchComponent;

	@FindBy(css = "h3.product-brand")
	public List<WebElement> productTexts;

	/*
	 * public HomePage() {
	 * 
	 * menMenu = UIKeyword.driver.findElement(By.xpath(
	 * "//div[@class='desktop-navLink']/a[@href=\"/shop/men\"]")); menTShirt =
	 * UIKeyword.driver.findElement(By.xpath("//a[@href='/men-tshirts']")); }
	 */

	public HomePage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}

	public void hoverOnMenMenu() {
		UIKeyword.mouseMove(menMenu);

	}

	public void clickOnMenTShirt() {
		UIKeyword.mouseMove(menTShirt);
	}

	public void searchProduct(String productName) {
		UIKeyword.enterText(searchComponent, productName);

	}

	public void clickOnCasualTShirts() {
		UIKeyword.mouseMove(menTShirt);
		casualShirts.click();
		log.info("Clicked On Casual Shirts");

	}

	public List<String> getSearchResultTexts() {
		List<String> productTexts= new ArrayList<String>();
		
		for (WebElement product : this.productTexts) {
			productTexts.add(product.getText());
			
		}
		
		return productTexts;

	}

}
