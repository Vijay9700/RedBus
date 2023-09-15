package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PnrStatusPage {
	
	public PnrStatusPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='err_main_header']")
	private WebElement invalidMessage;

	public WebElement getInvalidMessage() {
		return invalidMessage;
	}
	
	public String invalidPnrMessageText()
	{
		return getInvalidMessage().getText();
	}

	@FindBy(xpath = "//input[@name='pnrNo']")
	private WebElement enterPnrNumberTextfield;

	public WebElement getEnterPnrNumberTextfield() {
		return enterPnrNumberTextfield;
	}
	
	@FindBy(xpath = "//button[text()='Check Status']")
	private WebElement checkStatusButton;

	public WebElement getCheckStatusButton() {
		return checkStatusButton;
	}
	
}
