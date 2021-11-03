package com.nik.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {

	WebDriver driver;

	public ShopPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBys(@FindBy(xpath="//*[contains(text(),'Add to wishlist')]"))
	private List<WebElement> wishlist;
	
	@FindBy(xpath="(//i[@class='lar la-heart'])[1]")
	private WebElement wishlistIcon;
	
	public List<WebElement> addToWishlist() {
		return wishlist;
	}
	
	public WebElement wishlistIcon() {
		return wishlistIcon;
	}
}
