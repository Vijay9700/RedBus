package com.redbus.traintest;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.redbus.generic.basetest.BaseClass;
import com.redbus.generic.listenerutility.ListenerImplementation;
import com.redbus.objectrepositoryutility.Homepage;
import com.redbus.objectrepositoryutility.PnrStatusPage;
import com.redbus.objectrepositoryutility.RedrailPage;
@Listeners(com.redbus.generic.listenerutility.ListenerImplementation.class )
public class TC_2 extends BaseClass {
	
	@Test
	public void validateInvalidPnr() throws InterruptedException
	{
		Assert.assertEquals(driver.getTitle().contains("Online Bus Ticket"), true);
		ListenerImplementation.test.log(Status.PASS, "HOME PAGE IS DISPLAYED");
		Homepage home=new Homepage(driver);
		
		home.getTrainTicketsLink().click();
		Assert.assertEquals(driver.getTitle().contains("redRail"), true);
		ListenerImplementation.test.log(Status.PASS, "RED RAIL PAGE IS DISPALYED");
		
		RedrailPage redrail=new RedrailPage(driver);
		redrail.getCheckPnrRadioButton().click();
		
		Thread.sleep(3000);
		PnrStatusPage pnr=new PnrStatusPage(driver);
		pnr.getEnterPnrNumberTextfield().sendKeys("4154052247");
		pnr.getCheckStatusButton().click();
		//Assert
		
		Assert.assertEquals(pnr.invalidPnrMessageText().equals("PNR Number doesn't exist"), true);
		ListenerImplementation.test.log(Status.PASS, "PNR IS VALIDATED");
	}

}
