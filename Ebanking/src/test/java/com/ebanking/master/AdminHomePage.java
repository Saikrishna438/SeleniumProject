package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminHomePage {
	
		// Element Properties
		
		@FindBy(xpath = "//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")
		WebElement branch;
		
		@FindBy(xpath = "//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")
		WebElement role;
		
		@FindBy(xpath = "//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")
		WebElement emp;
		
		@FindBy(xpath = "//*[@id=\"Table_02\"]/tbody/tr/td[3]/a/img")
		WebElement logout;
		
		// Element methods
		
		public void branch() {
			
			branch.click();
			
		}
		
		public void role() {
			
			role.click();
			
		}
		
		public void emp() {
			
			emp.click();
			
		}
		
		public void logout() {
			
			logout.click();
			
		}
		
	

}
