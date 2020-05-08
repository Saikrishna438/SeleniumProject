package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMWithDataProvider {

	WebDriver driver;

	AdminHomePage ahp;

	@BeforeTest
	public void login() throws InterruptedException {

		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();

		driver.get("http://183.82.100.55/ranford2/");

		// PageFactory

		RanfordHomePage rhp = PageFactory.initElements(driver, RanfordHomePage.class);

		rhp.login();

		Thread.sleep(2000);

	}

	@Test(priority = 1,dataProvider = "Bdata")
	public void branchCreation(String bn, String add1, String area, String zip, String cry, String st, String city) throws InterruptedException {

		ahp = PageFactory.initElements(driver, AdminHomePage.class);

		ahp.branch();

		Thread.sleep(2000);

		BranchDetailsPage bdp = PageFactory.initElements(driver, BranchDetailsPage.class);

		bdp.newBranch();

		Thread.sleep(2000);

		BranchCreationPage bcp = PageFactory.initElements(driver, BranchCreationPage.class);

		bcp.bsubmit(bn, add1, area, zip, cry, st, city);

		Thread.sleep(2000);

		// alert

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// home link

		bdp.home();

		Thread.sleep(2000);

	}
	
	@DataProvider
	public Object [][] Bdata(){
		
		Object [][] obj = new Object[2][7];
		
		obj[0][0] = "jublihills";
		obj[0][1] = "jublihills";
		obj[0][2] = "Madhapur";
		obj[0][3] = "45633";
		obj[0][4] = "INDIA";
		obj[0][5] = "GOA";
		obj[0][6] = "GOA";
		
		obj[1][0] = "Yousufguda";
		obj[1][1] = "yousufguda";
		obj[1][2] = "Basti";
		obj[1][3] = "45890";
		obj[1][4] = "INDIA";
		obj[1][5] = "Andhra Pradesh";
		obj[1][6] = "Hyderabad";
	
		return obj;
		
	}

	@Test(priority = 2,dataProvider = "Rdata")
	public void roleCreation(String rn,String rt) throws InterruptedException {

		ahp.role();

		Thread.sleep(2000);

		RoleDetailsPage rdp = PageFactory.initElements(driver, RoleDetailsPage.class);

		rdp.newRole();

		Thread.sleep(2000);

		RoleCreationPage rcp = PageFactory.initElements(driver, RoleCreationPage.class);

		rcp.rsubmit(rn,rt);

		Thread.sleep(2000);

		// alert

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// home link

		rdp.home();

		Thread.sleep(2000);

	}
	
	@DataProvider
	public Object [][] Rdata(){
		
		Object [][] obj = new Object[3][2];
		
		obj[0][0] = "managerhdfc";
		obj[0][1] = "E";
		
		obj[1][0] = "manageraxis";
		obj[1][1] = "E";
		
		obj[2][0] = "managericici";
		obj[2][1] = "E";
		
		return obj;
		
	}

	@Test(priority = 3,dataProvider = "Edata")
	public void empCreation(String en,String lpwd,String role,String bn) throws InterruptedException {

		ahp.emp();

		Thread.sleep(2000);

		EmployeeDetailsPage edp = PageFactory.initElements(driver, EmployeeDetailsPage.class);

		edp.newEmp();

		Thread.sleep(2000);

		EmployeeCreationPage ecp = PageFactory.initElements(driver, EmployeeCreationPage.class);

		ecp.esubmit(en,lpwd,role,bn);

		Thread.sleep(2000);

		// alert

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		// home link

		edp.home();

		Thread.sleep(2000);

	}
	
	@DataProvider
	public Object [][] Edata(){
		
		Object [][] obj = new Object[3][4];
		
		obj[0][0] = "Krishna";
		obj[0][1] = "krishn43";
		obj[0][2] = "Tapas";
		obj[0][3] = "Alugunur";
		
		obj[1][0] = "Kumar";
		obj[1][1] = "kumar56";
		obj[1][2] = "Tester";
		obj[1][3] = "Alugunur";
		
		obj[2][0] = "Ramesh";
		obj[2][1] = "ramedh34";
		obj[2][2] = "medicalcoder";
		obj[2][3] = "abc";
	
		return obj;
		
	}

	// logout & close app

	@AfterTest
	public void logoutClose() {

		ahp.logout();

		driver.close();

	}

}
