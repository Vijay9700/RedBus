package com.redbus.traintest;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.redbus.generic.basetest.BaseClass;
import com.redbus.generic.listenerutility.ListenerImplementation;
import com.redbus.objectrepositoryutility.AddNewPassengerPage;
import com.redbus.objectrepositoryutility.Homepage;
import com.redbus.objectrepositoryutility.IrctcUsernamePage;
import com.redbus.objectrepositoryutility.RedrailPage;
import com.redbus.objectrepositoryutility.TrainsPage;
import com.redbus.objectrepositoryutility.TravellerInfoPage;

@Listeners(com.redbus.generic.listenerutility.ListenerImplementation.class)
public class TC_1 extends BaseClass {
	
	@Test
	public void searchTrain() throws Throwable {
		
		Assert.assertEquals(driver.getTitle().contains("Online Bus Ticket"), true);
		ListenerImplementation.test.log(Status.PASS, "HOME PAGE IS DISPLAYED");
		Homepage home=new Homepage(driver);
		
		home.getTrainTicketsLink().click();
		Assert.assertEquals(driver.getTitle().contains("redRail"), true);
		ListenerImplementation.test.log(Status.PASS, "RED RAIL PAGE IS DISPALYED");
		
		RedrailPage redrail=new RedrailPage(driver);
		redrail.getBookTrainTicketRadioButton().click();
		
		//choose from station
		redrail.getFromStationTextbox().sendKeys(elib.getDataFromExcel("Redbus_testdata", 1, 0));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"stn_name_code_wrap\"]")).click();
		
		//choose to station
		redrail.getToStationTextbox().sendKeys(elib.getDataFromExcel("Redbus_testdata", 1, 1));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='stn_name_code_wrap']")).click();
		Thread.sleep(3000);
		redrail.getCalendarIcon().click();
		redrail.getCalendarIcon().click();
		Thread.sleep(3000);
		
		//choose date
		String num=elib.getDataFromExcel("Redbus_testdata", 1, 2);
		WebElement date = driver.findElement(By.xpath("//div[contains(@class,'LTM')]/div[3]/span/div/span[text()='"+num+"']"));
		date.click();
		redrail.getSearchTrainButton().click();
		Assert.assertEquals(driver.getCurrentUrl().contains("railways/search"), true);
		ListenerImplementation.test.log(Status.PASS, "TRAINS PAGE IS DISPLAYED");
		
		//Choose train
		TrainsPage train=new TrainsPage(driver);
		train.getSleeperBerthLink().click();
		train.getOkGoAHeadButton().click();
		
		TravellerInfoPage info=new TravellerInfoPage(driver);
		info.getIrctcUsernameTextfield().click();
		
		//validate Irctc userame
		IrctcUsernamePage irctc=new IrctcUsernamePage(driver);
		irctc.getIrctcTextfield().sendKeys(elib.getDataFromExcel("Irctc", 1, 0));
		irctc.getCheckUsernameButton().click();
		ListenerImplementation.test.log(Status.PASS, "IRCTC USERNAME VERIFIED");
		
		//add new passenger
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		js.executeScript("arguments[0].click();",info.getAddNewPassengerButton() );
		Thread.sleep(1000);
		AddNewPassengerPage passenger=new AddNewPassengerPage(driver);
		passenger.getNameTextfield().sendKeys(elib.getDataFromExcel("User_Info", 1, 0));
		passenger.getAgeTextfield().sendKeys(elib.getDataFromExcel("User_Info", 1, 1));
		passenger.getMaleRadioButton().click();
		passenger.getAddPassengerButton().click();
		ListenerImplementation.test.log(Status.PASS, "PASSENGER ADDED SUCCESSFULLY");
		
		info.getEnterEmailTextfield().sendKeys(elib.getDataFromExcel("User_Info", 1, 2));
		info.getEnterYourPhonenumberTextfield().sendKeys(elib.getDataFromExcel("User_Info", 1, 3));
		info.getCityTextfield().sendKeys(elib.getDataFromExcel("User_Info", 1, 4));
		info.getCityTextfield().click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='each_drop_item']")).click();
		info.getProceedButton().click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle().contains("Payment"), true);
		ListenerImplementation.test.log(Status.PASS, "PAYMENT PAGE IS DISPLAYED");
		
	}
	
	

}
