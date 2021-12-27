package com.vodefone.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase  {   //this class is the base "parent" for all class test "child" so it put all method which will repeat each testcase

	public static WebDriver driver;
	public static Properties prop;
	static String chromepath =System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";   //to get path for chrome
	static String firefoxpath =System.getProperty("user.dir")+"\\drivers\\geckodriver.exe";   // to get path for firefox
	static String InternetExplorerpath =System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe";  //to get path for internet explorer
	static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\vodefone\\configuration\\config.properties"; // to get path for config properties file

	public TestBase() throws IOException    //this is constructor for initilzation property file
	{
		prop=new Properties();
		FileInputStream file=new FileInputStream(configpath);
		prop.load(file);
	}

	@Parameters({"browser"})
	@BeforeSuite
	public void startdriver(@Optional("chrome") String browsername)  //this initilization method before any test
	{
		if(browsername.equalsIgnoreCase("chrome"))          // work with chrome driver
		{

		//	System.setProperty("webdriver.chrome.driver", chromepath);
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))   //work  with firefox driver
		{
			//System.setProperty("webdriver.gecko.driver", firefoxpath);
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("internetexplorer")) //work with internet explorer
		{
			//System.setProperty("webdriver.ie.driver", InternetExplorerpath);
			WebDriverManager.edgedriver().setup();
			driver=new InternetExplorerDriver();
		}

		driver.get(prop.getProperty("URL"));            //to get url from config.properties and open it in browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);      //implicit wait to make page load and element
	//	driver.manage().window().maximize();              //to maximize window
		Dimension size = new Dimension(1024,768);
		//Resize current window to the set dimension
		driver.manage().window().setSize(size);
	}

	@AfterMethod    //this method take screen shot when test fail and name it with method name and parameter of method
	public void takeScreenShotOnFailureAndClosebrowser(ITestResult testResult) throws IOException { 
		if (testResult.getStatus() == ITestResult.FAILURE) { 
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
					+ Arrays.toString(testResult.getParameters()) + ".png"));
		} 
	
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		
	}
	
	/*@AfterMethod  //this method take screenshot in failure but override picture if have more than fail 
	public void ScreenShotonFailureandclosedriver(ITestResult result  ) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("fail will take screenshot");
			Helper.takescreenshot(driver,  result.getName());
		}
		driver.quit();
	}*/
	/*@AfterMethod  //this method take screenshot for all testcases and name it with the data of run
	public void screenshot() throws IOException
	{
	if
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filename=new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		File dest=new File("filepath/"+filename);
		FileUtils.copyFile(src, dest);
		driver.quit();
	}*/

}
