package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravellerInfoPage {
	
	public TravellerInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='1']")
	private WebElement irctcUsernameTextfield;

	public WebElement getIrctcUsernameTextfield() {
		return irctcUsernameTextfield;
	}
	
	@FindBy(xpath = "//div[@class='add_passenger_wrap']/div[3]")
	private WebElement addNewPassengerButton;

	public WebElement getAddNewPassengerButton() {
		return addNewPassengerButton;
	}
	
	@FindBy(xpath = "//input[@id='20']")
	private WebElement enterEmailTextfield;

	public WebElement getEnterEmailTextfield() {
		return enterEmailTextfield;
	}
	
	@FindBy(xpath = "//input[@id='21']")
	private WebElement enterYourPhonenumberTextfield;

	public WebElement getEnterYourPhonenumberTextfield() {
		return enterYourPhonenumberTextfield;
	}
	
	@FindBy(xpath = "//input[@id='200']")
	private WebElement cityTextfield;

	public WebElement getCityTextfield() {
		return cityTextfield;
	}
	
	@FindBy(xpath = "//div[text()='PROCEED']")
	private WebElement proceedButton;

	public WebElement getProceedButton() {
		return proceedButton;
	}
	

}
