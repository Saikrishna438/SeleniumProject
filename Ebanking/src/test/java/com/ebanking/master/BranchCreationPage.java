package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {
	
	// Element Properties
	
	@FindBy(id = "txtbName")
	WebElement bname;
	
	@FindBy(id = "txtAdd1")
	WebElement add1;
	
	@FindBy(id = "txtArea")
	WebElement area;
	
	@FindBy(id = "txtZip")
	WebElement zip;
	
	@FindBy(id = "lst_counrtyU")
	WebElement country;
	
	@FindBy(id = "lst_stateI")
	WebElement state;
	
	@FindBy(id = "lst_cityI")
	WebElement bcty;
	
	@FindBy(id = "btn_insert")
	WebElement submit;
	
	// Element Method
	
	public void bsubmit(String bn,String badd1,String barea,String bzip,String bcry,String bst,String bcity) {
		
		bname.sendKeys(bn);
		
		add1.sendKeys(badd1);
		
		area.sendKeys(barea);
		
		zip.sendKeys(bzip);
		
		Select cty = new Select(country);
		
		cty.selectByVisibleText(bcry);
		
		Select st = new Select(state);
		
		st.selectByVisibleText(bst);
		
		Select city = new Select(bcty);
		
		city.selectByVisibleText(bcity);
		
		submit.click();
			
	}

}
