package com.nik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	WebDriver driver;
	
	public  HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	By shopTab=By.xpath("//a[contains(text(),'Shop')]");
	
	@FindBy(xpath="//a[contains(text(),'Shop')]")
	private WebElement shopTab;
	
	public WebElement getShopTab() {
		return shopTab;
	}		

}
