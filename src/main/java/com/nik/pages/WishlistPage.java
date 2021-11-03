package com.nik.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	
	WebDriver driver;

	public WishlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBys(@FindBy(xpath="//*[contains(text(),'In Stock')]"))
	private List<WebElement> wishlistCount;
	
	@FindBys(@FindBy(xpath="//*/td[@class='product-price']"))
	private List<WebElement> priceList;
	
	@FindBy(linkText="Add to cart")
	private WebElement addToCart;
	
	@FindBy(xpath="//i[@class='la la-shopping-bag']")
	private WebElement clickCart;
	
	
	
	
	public List<WebElement> wishlistCount() {
		return wishlistCount;
	}
	
	public List<WebElement> priceList() {
		return priceList;
	}
	
	public WebElement addToCart() {
		return addToCart;
	}
	
	public WebElement clickCart() {
		return clickCart;
	}
	
	
	public void HoverOnProductImage(){
	    Actions actions = new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//i[@class='la la-shopping-bag']"));
		actions.moveToElement(menuOption).perform();
	    }
	
	public int findLowestPriceProduct(int[] array){

	    // add this
	    if (array.length == 0)
	        return -1;

	    int index = 0;
	    int min = array[index];

	    for (int i = 1; i < array.length; i++){
	        if (array[i] <= min){
	        min = array[i];
	        index = i;
	        }
	    }
	    return index;
	}
}
