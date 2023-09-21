package com.redbus.traintest;

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
public class TC_3 extends BaseClass {
	
	@Test
	public void bookTrainForSameStation() throws Throwable
	{
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
		redrail.getToStationTextbox().sendKeys(elib.getDataFromExcel("Redbus_testdata", 1, 0));
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
		
		//validate alert
		String alertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(alertMessage.equals("Source and Destination are same"), true);
		ListenerImplementation.test.log(Status.PASS, "ALERT HAS BEEN VALIDATED-->THE ALERT MESSAGE IS-->"+alertMessage);
		
	}

}
