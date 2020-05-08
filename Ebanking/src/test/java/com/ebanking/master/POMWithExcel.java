package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class POMWithExcel {

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

	@Test
	public void branchCreation() throws InterruptedException, IOException {

		// To get testdata from excel file

		FileInputStream FIS = new FileInputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//Role.xlsx");

		// Workbook

		XSSFWorkbook WB = new XSSFWorkbook(FIS);

		// sheet

		XSSFSheet WS = WB.getSheet("Bdata");

		// RowCount

		int Rcount = WS.getLastRowNum();

		System.out.println("Bdata :" + Rcount);

		// Multiple iterations

		for (int i = 1; i <= Rcount; i++) {

			// Row

			XSSFRow WR = WS.getRow(i);

			// Cell

			XSSFCell WC = WR.getCell(0);

			XSSFCell WC1 = WR.getCell(1);

			XSSFCell WC2 = WR.getCell(2);

			XSSFCell WC3 = WR.getCell(3);

			XSSFCell WC4 = WR.getCell(4);

			XSSFCell WC5 = WR.getCell(5);

			XSSFCell WC6 = WR.getCell(6);

			XSSFCell WC7 = WR.createCell(7);

			// Cell values

			String bname = WC.getStringCellValue();

			String bAdd1 = WC1.getStringCellValue();

			String barea = WC2.getStringCellValue();

			String bzip = WC3.getStringCellValue();

			String bcountry = WC4.getStringCellValue();

			String bstate = WC5.getStringCellValue();

			String bcity = WC6.getStringCellValue();

			ahp = PageFactory.initElements(driver, AdminHomePage.class);

			ahp.branch();

			Thread.sleep(2000);

			BranchDetailsPage bdp = PageFactory.initElements(driver, BranchDetailsPage.class);

			bdp.newBranch();

			Thread.sleep(2000);

			BranchCreationPage bcp = PageFactory.initElements(driver, BranchCreationPage.class);

			bcp.bsubmit(bname, bAdd1, barea, bzip, bcountry, bstate, bcity);

			Thread.sleep(2000);

			// alert

			String Actval = driver.switchTo().alert().getText();

			WC7.setCellValue(Actval);

			driver.switchTo().alert().accept();

			Thread.sleep(2000);

			// home link

			bdp.home();

			Thread.sleep(2000);

		}

		// Results

		FileOutputStream FOS = new FileOutputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//Branch_Results.xlsx");

		WB.write(FOS);

		WB.close();

	}

	@Test(priority = 2)
	public void roleCreation() throws InterruptedException, IOException {

		// To get testdata from excel file

		FileInputStream FIS = new FileInputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//Role.xlsx");

		// Workbook

		XSSFWorkbook WB = new XSSFWorkbook(FIS);

		// sheet

		XSSFSheet WS = WB.getSheet("Rdata");

		// RowCount

		int Rcount = WS.getLastRowNum();

		System.out.println("Rdata :" + Rcount);

		// Multiple iterations

		for (int i = 1; i <= Rcount; i++) {

			// Row

			XSSFRow WR = WS.getRow(i);

			// Cell

			XSSFCell WC = WR.getCell(0);

			XSSFCell WC1 = WR.getCell(1);

			XSSFCell WC2 = WR.createCell(2);

			// Cell values

			String Rname = WC.getStringCellValue();

			String Rtype = WC1.getStringCellValue();

			ahp.role();

			Thread.sleep(2000);

			RoleDetailsPage rdp = PageFactory.initElements(driver, RoleDetailsPage.class);

			rdp.newRole();

			Thread.sleep(2000);

			RoleCreationPage rcp = PageFactory.initElements(driver, RoleCreationPage.class);

			rcp.rsubmit(Rname, Rtype);

			Thread.sleep(2000);

			// alert

			String Actval = driver.switchTo().alert().getText();

			WC2.setCellValue(Actval);

			driver.switchTo().alert().accept();

			Thread.sleep(2000);

			// home link

			rdp.home();

			Thread.sleep(2000);

		}

		// Results

		FileOutputStream FOS = new FileOutputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//Role_Results.xlsx");

		WB.write(FOS);

		WB.close();

	}

	@Test(priority = 3)
	public void empCreation() throws InterruptedException, IOException {

		// To get testdata from excel file

		FileInputStream FIS = new FileInputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//testdata//Role.xlsx");

		// Workbook

		XSSFWorkbook WB = new XSSFWorkbook(FIS);

		// sheet

		XSSFSheet WS = WB.getSheet("Edata");

		// RowCount

		int Rcount = WS.getLastRowNum();

		System.out.println("Edata :" + Rcount);

		// Multiple iterations

		for (int i = 1; i <= Rcount; i++) {

			// Row

			XSSFRow WR = WS.getRow(i);

			// Cell

			XSSFCell WC = WR.getCell(0);

			XSSFCell WC1 = WR.getCell(1);

			XSSFCell WC2 = WR.getCell(2);

			XSSFCell WC3 = WR.getCell(3);

			XSSFCell WC4 = WR.createCell(4);

			// Cell values

			String Ename = WC.getStringCellValue();

			String Lpwd = WC1.getStringCellValue();

			String Role = WC2.getStringCellValue();

			String Branch = WC3.getStringCellValue();

			ahp.emp();

			Thread.sleep(2000);

			EmployeeDetailsPage edp = PageFactory.initElements(driver, EmployeeDetailsPage.class);

			edp.newEmp();

			Thread.sleep(2000);

			EmployeeCreationPage ecp = PageFactory.initElements(driver, EmployeeCreationPage.class);

			ecp.esubmit(Ename, Lpwd, Role, Branch);

			Thread.sleep(2000);

			// alert

			String Actval = driver.switchTo().alert().getText();

			WC4.setCellValue(Actval);

			driver.switchTo().alert().accept();

			Thread.sleep(2000);

			// home link

			edp.home();

			Thread.sleep(2000);

		}

		// Results

		FileOutputStream FOS = new FileOutputStream(
				"//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//results//Emp_Results.xlsx");

		WB.write(FOS);

		WB.close();

	}

	// logout & close app

	@AfterTest
	public void logoutClose() {

		ahp.logout();

		driver.close();

	}
}