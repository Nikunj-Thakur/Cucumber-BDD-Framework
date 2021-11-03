package com.nik.stepDefination;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.nik.pages.CartPage;
import com.nik.pages.HomePage;
import com.nik.pages.ShopPage;
import com.nik.pages.WishlistPage;
import com.nik.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {

	DriverManager context;
	HomePage homePage;
	ShopPage shopPage;
	WishlistPage wishlistPage;
	CartPage cartPage;
	Scenario scenario;

	public StepDefination(DriverManager context) {
		this.context = context;
	}

	@Before
	public void setUpScenario(Scenario scenario){
	    this.scenario = scenario; 
	}

	@Given("I add four differnt products to my wish list")
	public void i_add_four_differnt_products_to_my_wish_list() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		
		homePage = new HomePage(context.getDriver());
		shopPage = new ShopPage(context.getDriver());
		wishlistPage = new WishlistPage(context.getDriver());
		cartPage = new CartPage(context.getDriver());
		context.getDriver().get("https://testscriptdemo.com/");
		homePage.getShopTab().click();
		addScreenshot();

		for (int i = 0; i < 4; i++) {
			shopPage.addToWishlist().get(i).click();
			Thread.sleep(1000);
		}
		addScreenshot();

	}

	@When("I view my wish list table")
	public void i_view_my_wish_list_table() {
		// Write code here that turns the phrase above into concrete actions
		shopPage.wishlistIcon().click();
		addScreenshot();
	}

	@Then("I find total four selected items in my Wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Count of products added in Wishlist is " + wishlistPage.wishlistCount().size());
		Assert.assertEquals(4, wishlistPage.wishlistCount().size(),
				"Failed:The count of item selected in Wishlist is not 4");
		addScreenshot();
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() {
		// Write code here that turns the phrase above into concrete actions
		String []linkText =new String[wishlistPage.priceList().size()];
		int[] arr=new int[wishlistPage.priceList().size()];
		int i=0;
		for(WebElement a: wishlistPage.priceList())
		{
		   linkText[i]=a.getText();
		   System.out.println(linkText[i]);
		   if(linkText[i].length()>13) {
			   linkText[i]=linkText[i].substring(10, 12);
			   arr[i] = Integer.parseInt(linkText[i]);
		   }
		   else 
		   {
			   linkText[i]=linkText[i].substring(8, 10); 
			   arr[i] = Integer.parseInt(linkText[i]);
		   }
		   i++;
		}	
		
		System.out.println("Lowest Price of Product is " +arr[wishlistPage.findLowestPriceProduct(arr)]);
		
		/*System.out.println(wishlistPage.priceList().size());
		ArrayList<Integer> prices=new ArrayList<Integer>();
		for(int i=0;i<wishlistPage.priceList().size();i++){
			System.out.println(wishlistPage.priceList().get(i).getText());
			Integer priceInt = Integer.valueOf(wishlistPage.priceList().get(i).getText().replace("£", ""));
			prices.add(priceInt);
			}
			Integer minPrice = Collections.min(prices);
			System.out.println("Min Price is "+minPrice);*/
		
		addScreenshot();
	}

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		
		wishlistPage.addToCart().click();
		Thread.sleep(1000);
		wishlistPage.HoverOnProductImage();
		addScreenshot();
		wishlistPage.clickCart().click();
			
	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(cartPage.cartItemCheck().isDisplayed());
		addScreenshot();
	}

	@After
	public void tearDown() {
		context.getDriver().quit();
	}

	public void addScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) context.getDriver();
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

		scenario.attach(screenshot, "image/png", "");
	}

}
