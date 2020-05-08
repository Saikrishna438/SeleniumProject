package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoleCreationPage {
	
	// Element Properties
	
	@FindBy(id = "txtRname")
	WebElement Rname;
	
	@FindBy(id = "lstRtypeN")
	WebElement Rtype;
	
	@FindBy(id = "btninsert")
	WebElement submit;
	
	// Element Method
	
	public void rsubmit(String rname,String rtype) {
		
		Rname.sendKeys(rname);
		
		Select rt = new Select(Rtype);
		
		rt.selectByVisibleText(rtype);
		
		submit.click();
		
	}

}
