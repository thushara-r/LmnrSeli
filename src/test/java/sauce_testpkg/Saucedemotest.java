package sauce_testpkg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basepkg.Baseclass_sauce;
import sauce_pagepkg.Saucedemopage;
import utilities.Sauce_Xlutils;

public class Saucedemotest extends Baseclass_sauce  {
	

	    @Test
	    public void verifyLogin() throws Exception {

	        // Initialize the page object for SauceDemo
	    	Saucedemopage sauce = new Saucedemopage(driver);

	        // Path to the Excel file containing login credentials
	        String xl = "C:\\Users\\96596\\Desktop\\SWTesting\\sauce.xlsx";
	        String sheet = "Sheet1";

	        // Get the number of rows in the Excel sheet
	        int rowCount = Sauce_Xlutils.getRowCount(xl, sheet);

	        // Loop through each row in the Excel, starting from row 1 (skipping the header)
	        for (int i = 1; i <= rowCount; i++) {

	            // Read Username and Password from Excel
	            String userName = Sauce_Xlutils.getCellValue(xl, sheet, i, 0);
	            String pwd = Sauce_Xlutils.getCellValue(xl, sheet, i, 1);

	            // Log credentials for debugging
	            System.out.println("Username: " + userName);
	            System.out.println("Password: " + pwd);

	            // Enter Username and Password on the login page
	            sauce.setValues(userName, pwd);

	            // Click login button
	            sauce.loginClick();

	            // Expected URL after login
	            String expectedUrl = "https://www.saucedemo.com/inventory.html";
	            String actualUrl = driver.getCurrentUrl();

	            // Check if login is successful by comparing the URLs
	            if (actualUrl.equals(expectedUrl)) {
	                System.out.println("Login successful for user: " + userName);
	            } else {
	                System.out.println("Login failed for user: " + userName);
	            }

	            // Wait for 3 seconds before the next login
	            Thread.sleep(3000);
	        }

	        // After successful login, add all products to the cart and finish the checkout process
	        sauce.addtocart();
	        Thread.sleep(3000);

	        // Open the cart, checkout, fill in user info, and complete the order
	        sauce.cart_click();
	        Thread.sleep(1000);

	        sauce.checkout_click();
	        Thread.sleep(1000);
	        

	        // Fill in checkout info
	        sauce.setInformation("Ria", "Sharma", "6739876");
	        Thread.sleep(1000);

	        sauce.continue_click();
	        Thread.sleep(1000);

	        // Finish the checkout
	        sauce.finish_click();
	        Thread.sleep(1000);

	        // Return to home page and log out
	        sauce.backhome_click();
	        Thread.sleep(1000);
	        
	        sauce.menu_click();; // Open hamburger menu
	        Thread.sleep(1000);

	        sauce.logout_click(); // Logout
	        Thread.sleep(1000);
	    }

	    // Optional: Close the browser after the test is done
	    @AfterTest
	    public void teardown() {
	       if (driver != null) {
	            driver.quit();  // Close the browser
	       }
	    }
	    
	    
	}

