package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoleDetailsPage {
	
	// Element Properties
	
	@FindBy(id = "btnRoles")
	WebElement newRole;
	
	@FindBy(xpath = "/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement home;
	
	// Element Method
	
	public void newRole() {
		
		newRole.click();
		
	}
	
	public void home() {

		home.click();

	}
	
}
