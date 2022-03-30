package hooks;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.common;



public class hooks extends common {
	WebDriver driver = common.driver;
	WebDriver wdriver = common.wdriver;
	static Process p;

	
  @Before ("@Web")
   public void setUp() throws IOException{ 
      System.out.println("Before Web Hooks");      
      driver =initializeDriver();
      driver.get("https://pharmeasy.in/");	
     }
  
   @Before("@Mobile") 
   public void setUp1() throws MalformedURLException{ 
      System.out.println("Before Mobile Hooks"); 
      mdriver =initializeMobileDriver();
   }
   
   @After("@Web") 
   public void tearDown(){ 
	  driver.close();
      System.out.print("After Hooks"); 
   } 
   @After("@Desktop") 
   public void closeApp() {   
	  
	   p.destroy();
	  // wdriver.quit();
	   System.out.print("After Hooks");
	   
   }
   @Before("@Desktop") 
   public void launchWinAppDriver() throws IOException {
	   

	   String command = "C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
	   ProcessBuilder builder = new ProcessBuilder(command).inheritIO();
	   p = builder.start();
		
	   System.out.print("Before Hooks - Start WebAppDriver");
	   
   }
}