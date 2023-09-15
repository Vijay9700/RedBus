package com.redbus.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPassengerPage {
	
	public AddNewPassengerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement nameTextfield;

	public WebElement getNameTextfield() {
		return nameTextfield;
	}
	
	@FindBy(id = "2")
	private WebElement ageTextfield;

	public WebElement getAgeTextfield() {
		return ageTextfield;
	}
	
	@FindBy(xpath = "//span[text()='Male']")
	private WebElement maleRadioButton;

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}
	
	@FindBy(xpath = "//span[text()='Female']")
	private WebElement femaleRadiobutton;

	public WebElement getFemaleRadiobutton() {
		return femaleRadiobutton;
	}
	
	@FindBy(xpath = "//span[text()='Others']")
	private WebElement othersRadiobutton;

	public WebElement getOthersRadiobutton() {
		return othersRadiobutton;
	}
	
	@FindBy(xpath = "//div[text()='Add Passengers']")
	private WebElement addPassengerButton;

	public WebElement getAddPassengerButton() {
		return addPassengerButton;
	}
	

}
