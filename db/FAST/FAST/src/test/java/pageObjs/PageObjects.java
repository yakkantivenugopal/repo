package pageObjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
	
	public WebDriver driver;
	
	//All Page Objects should go here using locators
	
	private By Search=By.xpath("//input[@type='text']");
	private By SearchedText=By.xpath("//*[text()='1000ml Liquid in Bottle']");
	private By AddToCartButton = By.xpath("//*[text()='Add To Cart']");
	private By SelectQuantity = By.xpath("//*[@role='listbox']//li[3]");
	private By Cart = By.xpath("//span[text()='Cart']");
	private By RemoveItem = By.xpath("//img[@alt='close']");
	private By OkButton = By.xpath("//div[text()='Yes']");

	// This is constructor to initiate driver
	public PageObjects(WebDriver driver) {		
		this.driver=driver;		
	}
	
	
	//All getter methods for Locators

	public WebElement Search()
	{
		return driver.findElement(Search);
	}
	public WebElement SearchedText()
	{
		return driver.findElement(SearchedText);
	}
	public WebElement AddToCartButton()
	{
		return driver.findElement(AddToCartButton);
	}
	public WebElement SelectQuantity()
	{
		return driver.findElement(SelectQuantity);
	}
	public WebElement Cart()
	{
		return driver.findElement(Cart);
	}
	public WebElement RemoveItem()
	{
		return driver.findElement(RemoveItem);
	}
	public WebElement OkButton()
	{
		return driver.findElement(OkButton);
	}
}
