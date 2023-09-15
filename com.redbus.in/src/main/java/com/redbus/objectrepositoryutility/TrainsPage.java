package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainsPage {
	
	public TrainsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='www.redbus.in/railways/search/stationchange']")
	private WebElement sleeperBerthLink;

	public WebElement getSleeperBerthLink() {
		return sleeperBerthLink;
	}
	
	@FindBy(xpath = "//div[text()='OKAY, GO AHEAD']")
	private WebElement okGoAHeadButton;

	public WebElement getOkGoAHeadButton() {
		return okGoAHeadButton;
	}
	
	

}
