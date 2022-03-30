package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;

public class common {	

	public static  WebDriver driver;
	public static WindowsDriver<WindowsElement> wdriver;
	public static AndroidDriver<AndroidElement> mdriver;
	public static Properties prop;
	
	public static AppiumDriverLocalService service;

	
	public static AppiumDriverLocalService startServer()
	{
		//
	boolean flag=checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	
	public static WebDriver initializeDriver() throws IOException
	{
		
	// prop= new Properties();
	 
	// FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties.properties");

	//prop.load(fis);
	// Thiis takes browser namr from Maven test command - mvn test -Dbrowser=chrome. And this would be sent thru jenkins build parameter
	//String browserName=System.getProperty("browser");
	//String browserName=prop.getProperty("browser");
	
	//if(browserName.equals("chrome"))
	//{
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		driver= new ChromeDriver();
			
		
	//}
	//else if (browserName.equals("firefox"))
	//{
	//	// driver= new FirefoxDriver();
		
	//}
	//else if (browserName.equals("IE"))
	//{
		//		IE code
	//}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}

/*
	public static WindowsDriver<WindowsElement> initializeWDriver() throws IOException {
		
		 
		
		DesiredCapabilities options = new DesiredCapabilities();
		//options.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		options.setCapability("app", "C:\\Windows\\System32\\notepad.exe");		
		options.setCapability("deviceName", "WindowsPC");
		wdriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), options);
		wdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		return wdriver;		
	}
*/
	
public static WindowsDriver<WindowsElement> initializeWDriver() throws IOException, InterruptedException {
		
		 try {
			
		DesiredCapabilities options = new DesiredCapabilities();
		options.setPlatform(Platform.WIN10);
		//options.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		options.setCapability("app", "C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.exe");		
		//options.setCapability("app", "Root");
		//options.setCapability("deviceName", "WindowsPC");
		wdriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), options);
		wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 }  catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
		
		 
		//WindowsElement newEmail = wdriver.findElementByName("New E-mail");
		  Thread.sleep(10000);
		  Set<String> windowHandles = wdriver.getWindowHandles();
	       List<String> windowHandlesList = new ArrayList<>(windowHandles); //Set to List Conversion
	        //5) Write to total window handle number to the console.
	        System.out.println("Total window number: " + windowHandlesList.size());
	        //6) Switch to second window
	        wdriver.switchTo().window(windowHandlesList.get(0));
				  
        //wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       // wdriver.findElementByName("To").sendKeys("<email>");
		return wdriver;		
	}
	
public static AndroidDriver<AndroidElement> initializeMobileDriver() throws MalformedURLException{
	    service=startServer();
		DesiredCapabilities cap = new DesiredCapabilities();
		File appDir = new File("driver");
		File app=new File(System.getProperty("user.dir")+"\\driver\\ApiDemos-debug.apk");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8N91R8AAT");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		AndroidDriver<AndroidElement> mdriver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		mdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return mdriver;	 
				
	}




	
	//public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	//{
	//	TakesScreenshot ts=(TakesScreenshot) driver;
	//	File source =ts.getScreenshotAs(OutputType.FILE);
	//	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	//	FileUtils.copyFile(source,new File(destinationFile));
	//	return destinationFile;


	//}

	//}


}
