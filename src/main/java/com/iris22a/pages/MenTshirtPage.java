package com.iris22a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iris22a.keyword.UIKeyword;

public class MenTshirtPage {

	@FindBy(xpath="//div[@class='sort-sortBy']")
	public WebElement sortByFilter;
	
	@FindBy(xpath="//h4[contains(text(),'Country of Origin')]")
	public WebElement countryofOrigin;
	
	@FindBy(xpath="//*[contains(text(),'Popularity')]")
	public WebElement popularityFilter;

	/*public () {
		sortByFilter = UIKeyword.driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		countryoMenTshirtPagefOrigin = UIKeyword.driver.findElement(By.xpath("//h4[contains(text(),'Country of Origin')]"));
		popularityFilter = UIKeyword.driver
				.findElement(By.xpath("//div[@class='sort-sortBy']/span[contains(text(),'Popularity')]"));

	}*/
	public MenTshirtPage() {
		PageFactory.initElements(UIKeyword.driver, this);
	}

	public void clickOnSortBYFilter() {
		sortByFilter.click();
	}

	public void selectPopularityFilter() {
		UIKeyword.mouseMove(sortByFilter);
		UIKeyword.click(popularityFilter);

	}

	public void selectWhatsNewFilter() {

	}

	public void selectBetterDiscountFilter() {

	}
}
