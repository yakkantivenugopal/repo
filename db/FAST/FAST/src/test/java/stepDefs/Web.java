package stepDefs;


import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.model.Log;

import hooks.hooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjs.PageObjects;
import utilities.common;
 
public class Web extends common {
	WebDriver driver = common.driver;
	PageObjects pg = new PageObjects(driver);
	private static Logger log = LogManager.getLogger(Web.class.getName());
	
	
	    	
	@Given("User searches the medicine")
	public void addToCart() throws InterruptedException {
		pg.Search().sendKeys("Dettol");
		Thread.sleep(2000);
		pg.SearchedText().click();
		Thread.sleep(2000);	
				
	}
 
	@When("User clicks on Add to Card Button")
	public void clickCartImage() throws InterruptedException {
		pg.AddToCartButton().click();
		Thread.sleep(3000);
		System.out.println("Clicked on Cart Image");
		}
 
	@Then("Validate user is navigated to Cart details page")
	public void Validation() throws InterruptedException {
		pg.SelectQuantity().click();
		Thread.sleep(3000);
		pg.Cart().click();
		Thread.sleep(2000);
		
		/*
		log.debug("I am debugging");
		log.error("print error message using Log4j");
		log.fatal("print error message using Log4j");		
		log.info("I am debugging info");
		log.warn("I am warn");
		*/
	}
	
	@Then("Remove cart items")
	public void RemoveeItems() throws InterruptedException {
		pg.RemoveItem().click();
		Thread.sleep(2000);
		pg.OkButton().click();
		Thread.sleep(3000);
		
	}
 
	
}