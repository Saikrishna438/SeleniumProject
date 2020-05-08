package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreationPage {
	
	// Element Properties
	
	@FindBy(id = "txtUname")
	WebElement ename;
	
	@FindBy(id = "txtLpwd")
	WebElement lpwd;
	
	@FindBy(id = "lst_Roles")
	WebElement erole;
	
	@FindBy(id = "lst_Branch")
	WebElement ebranch;
	
	@FindBy(id = "BtnSubmit")
	WebElement submit;
	
	// Element Method
	
	public void esubmit(String en,String pwd,String er,String ebn) {
		
		ename.sendKeys(en);
		
		lpwd.sendKeys(pwd);
		
		Select role = new Select(erole);
		
		role.selectByVisibleText(er);
		
		Select branch = new Select(ebranch);
		
		branch.selectByVisibleText(ebn);
		
		submit.click();
		
		
				
				
		
	}
	

}
