package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedrailPage {
	
	public RedrailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='radio-button-outer red-border-radio']")
	private WebElement bookTrainTicketRadioButton;

	public WebElement getBookTrainTicketRadioButton() {
		return bookTrainTicketRadioButton;
	}
	
	@FindBy(id = "src")
	private WebElement fromStationTextbox;

	public WebElement getFromStationTextbox() {
		return fromStationTextbox;
	}
	
	@FindBy(id = "dst")
	private WebElement toStationTextbox;

	public WebElement getToStationTextbox() {
		return toStationTextbox;
	}
	
	@FindBy(xpath = "//div[@class='home_calendar']/img")
	private WebElement calendarIcon;

	public WebElement getCalendarIcon() {
		return calendarIcon;
	}
	
	@FindBy(xpath = "//button[text()='SEARCH TRAINS']")
	private WebElement searchTrainButton;

	public WebElement getSearchTrainButton() {
		return searchTrainButton;
	}
	
	@FindBy(xpath = "//div[@class='radio-button-inner false']")
	private WebElement checkPnrRadioButton;

	public WebElement getCheckPnrRadioButton() {
		return checkPnrRadioButton;
	}
	

}
