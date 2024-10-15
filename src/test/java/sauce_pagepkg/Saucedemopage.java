package sauce_pagepkg;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemopage {
	
	   WebDriver driver; 

	    // Locating elements on the page
	    @FindBy(id = "user-name")
	    WebElement user;
	    
	    @FindBy(id = "password")
	    WebElement pass;
	    
	    @FindBy(name = "login-button")
	    WebElement login;
	    
	    // "Add to Cart" buttons for the products
	    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
	    List<WebElement> addtocartButtons;
	    
	    // Shopping cart button
	    @FindBy(id = "shopping_cart_container")
	    WebElement saucecart;
	    
	    // Checkout button
	    @FindBy(name = "checkout")
	    WebElement checkoutButton;
	    
	    // User information fields
	    @FindBy(id = "first-name")
	    WebElement firstname;
	    
	    @FindBy(id = "last-name")
	    WebElement lastname;
	    
	    @FindBy(id = "postal-code")
	    WebElement postalcode;
	    
	    // Continue and Finish buttons during checkout
	    @FindBy(id = "continue")
	    WebElement continueButton;

	    @FindBy(id = "finish")
	    WebElement finishButton;
	    
	    // Button to go back to the product page
	    @FindBy(id = "back-to-products")
	    WebElement backtohomeButton;
	    
	    // Hamburger menu icon
	    @FindBy(id = "react-burger-menu-btn")
	    WebElement hamburgermenuButton;
	    
	    // Logout button inside the hamburger menu
	    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
	    WebElement logout;

	    // Constructor to initialize PageFactory elements
	    public Saucedemopage(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Set username and password
	    public void setValues(String usrname, String pwd) {
	        driver.navigate().refresh();  // Refresh the page
	        user.clear();  // Clear existing input
	        pass.clear();  // Clear existing input
	        user.sendKeys(usrname);  // Enter username
	        pass.sendKeys(pwd);  // Enter password
	    }

	    // Click the login button
	    public void loginClick() {
	        login.click();
	    }

	    // Add all items to the cart
	    public void addtocart() {
	    	for (WebElement addbutton : addtocartButtons)
	    	{
	            addbutton.click();
	        }
	    }

	    // Click the shopping cart button
	    public void cart_click() {
	        saucecart.click();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 1000);");
	    }

	    // Scroll down and click the checkout button
	    public void checkout_click() {
	          // Scroll down
	        checkoutButton.click();
	    }

	    // Enter user information during checkout
	    public void setInformation(String fstname, String lstname, String pin) {
	        firstname.sendKeys(fstname);  // Enter first name
	        lastname.sendKeys(lstname);  // Enter last name
	        postalcode.sendKeys(pin);  // Enter postal code
	    }

	    // Click the continue button
	    public void continue_click() {
	        continueButton.click();
	    }

	    // Click the finish button to complete the order
	    public void finish_click() {
	        finishButton.click();
	    }

	    // Go back to the products page
	    public void backhome_click() {
	        backtohomeButton.click();
	    }

	    // Click the hamburger menu and log out
	    public void menu_click() {
	        hamburgermenuButton.click();  // Open the hamburger menu
	    }
	    public void logout_click() {
	        logout.click();  // Click logout
	    }
	    
	}


