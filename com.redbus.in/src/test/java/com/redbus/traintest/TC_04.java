package com.redbus.traintest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.redbus.generic.basetest.BaseClass;
import com.redbus.generic.listenerutility.ListenerImplementation;
import com.redbus.objectrepositoryutility.Homepage;
import com.redbus.objectrepositoryutility.RedrailPage;

//@Listeners(com.redbus.generic.listenerutility.ListenerImplementation.class)
public class TC_04 extends BaseClass {
	
	@Test
	public void fetchingTheAvailableTrains() throws Throwable {
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
		
		//click on search button
		redrail.getSearchTrainButton().click();
		
		//fetch all available trains
		List<WebElement> allTrains = driver.findElements(By.xpath("//div[@class='srp_train_name_code']"));
		String s1="";
		for (WebElement train : allTrains) {
			s1=s1+train.getText();
		}
		ListenerImplementation.test.log(Status.INFO, "AVAILABLE TRAIN NAMES--->"+s1);
	}

}
