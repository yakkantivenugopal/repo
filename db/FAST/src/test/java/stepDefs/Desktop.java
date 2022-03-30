package stepDefs;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import hooks.hooks;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.common;

public class Desktop extends common {
	WindowsDriver<WindowsElement> wdriver;
	
	public Desktop() throws IOException, InterruptedException {
		wdriver=common.initializeWDriver();
	}

	@Given("User clciks the New Email Button")
	public void clcikNewEmail() throws IOException, InterruptedException {
		
		 System.out.println("Outlook Opened");    
	     wdriver.findElementByName("New Email").click();
	     Thread.sleep(5000);   
	  
		
	}
	
	@When("User enters the Subject")
	public void enterTextInSubject() throws MalformedURLException, InterruptedException {
		Set<String> windowHandles = wdriver.getWindowHandles();
	       List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion	
	        wdriver.switchTo().window(windowHandlesList.get(0));
	        Thread.sleep(2000); 	 
	        wdriver.findElementByName("To").sendKeys("abhishek.kachroo@cyient.com");
	        wdriver.findElementByAccessibilityId("4101").sendKeys("This is Test Subject");
	   
	        Thread.sleep(2000);

		
	}
	@Then("Validate user can enter and Send message")
	public void validateBody() throws MalformedURLException, InterruptedException {
        wdriver.findElementByName("Message").sendKeys("This is Test Message Body");//4159
        Thread.sleep(2000);
        wdriver.findElementByName("Send").click();
       // wdriver.quit();
	
		 		
	}


}
