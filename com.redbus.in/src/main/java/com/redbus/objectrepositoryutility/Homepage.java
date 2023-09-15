package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "rail_tickets_vertical")
	private WebElement trainTicketsLink;

	public WebElement getTrainTicketsLink() {
		return trainTicketsLink;
	}
	

}
