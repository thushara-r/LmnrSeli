package sauce_pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Trsaucepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"user-name\"]")
	WebElement username;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement loginbutton;


public Trsaucepage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void setvalues(String u,String p) 
{
	
	  driver.navigate().refresh();
	  username.sendKeys(u);
	  password.sendKeys(p);
	  
}
public void loginClick() {
    loginbutton.click();
}
}

