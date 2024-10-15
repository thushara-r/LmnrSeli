package sauce_testpkg;


import org.testng.annotations.Test;

import basepkg.Baseclass_sauce;
import sauce_pagepkg.Trsaucepage;

public class Trsaucetest extends Baseclass_sauce {
	
	@Test
	public void login() throws InterruptedException
	{
		Trsaucepage sauc= new Trsaucepage(driver);
		
		String u1= "standard_user";
		String p1="secret_sauce";
		 System.out.println("Username: "+u1 );
         System.out.println("Password: "+p1);
         sauc.setvalues(u1, p1);
         Thread.sleep(3000);
         sauc.loginClick();
	}
    
}
