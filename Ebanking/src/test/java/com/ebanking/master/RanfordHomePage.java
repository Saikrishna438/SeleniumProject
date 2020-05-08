package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RanfordHomePage {

	// Element Properties
	
	@FindBy(id = "txtuId")
	WebElement Uname;
	
	@FindBy(id = "txtPword")
	WebElement Pwd;
	
	@FindBy(id = "login")
	WebElement login;
	
	// Element Method
	
	public void login() {
		
		Uname.sendKeys("Admin");
		
		Pwd.sendKeys("M1ndq");
		
		login.click();
		
	}
	
}
