package com.redbus.generic.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.redbus.generic.webdriverutility.WebdriverUtility;
import com.redus.generic.fileutility.ExcelUtility;
import com.redus.generic.fileutility.FileUtility;



public class BaseClass {
	

	public WebdriverUtility wlib=new WebdriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public  WebDriver driver = null;
	public  static WebDriver sdriver = null;
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() throws Throwable
	{
		System.out.println("==Launch the BROWSER==");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
		   
		sdriver = driver;
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		System.out.println("==Close the BROWSER==");
        driver.quit();
	}

}
