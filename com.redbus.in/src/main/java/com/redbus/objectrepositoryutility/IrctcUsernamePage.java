package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IrctcUsernamePage {
	
	public IrctcUsernamePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "1")
	private WebElement irctcTextfield;

	public WebElement getIrctcTextfield() {
		return irctcTextfield;
	}
	
	@FindBy(xpath = "//div[text()='CHECK USERNAME']")
	private WebElement checkUsernameButton;

	public WebElement getCheckUsernameButton() {
		return checkUsernameButton;
	}
	
	@FindBy(xpath = "//span[@class='icon icon-cross']")
	private WebElement crossMark;

	public WebElement getCrossMark() {
		return crossMark;
	}
	

}
