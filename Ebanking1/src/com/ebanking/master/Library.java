package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class Library {

	WebDriver driver;

	String Expval, Actval;
	
	FileInputStream FIS;
	
	Properties PR;

	public void OpenApp(String url) throws InterruptedException, IOException {
		
		FIS = new FileInputStream("//home//nebulaa-1//eclipse-workspace//Ebanking//src//test//java//com//ebanking//properties//Rep.properties");
		
		PR = new Properties();
		
		PR.load(FIS);
		
		Expval = "Ranford Bank";

		// launch browser

		//WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		// url

		driver.get(url);

		Thread.sleep(3000);

		Actval = driver
				.findElement(By.xpath(
						"//*[@id=\"Form1\"]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span"))
				.getText();

		// comparission

		if (Actval.equalsIgnoreCase(Expval)) {

			System.out.println("Ranford Application launch");

		} else {

			System.out.println("Ranford Application Not launch");

		}

	}

	public void AdminLogin(String un, String pwd) throws InterruptedException {

		Expval = "Welcome to Admin";

		driver.findElement(By.id(PR.getProperty("uname"))).sendKeys(un);

		driver.findElement(By.id(PR.getProperty("pswd"))).sendKeys(pwd);

		driver.findElement(By.id(PR.getProperty("lgn"))).click();

		Thread.sleep(2000);

		Actval = driver
				.findElement(By.xpath(
						"/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font"))
				.getText();

		// comparison

		if (Actval.equalsIgnoreCase(Expval)) {

			System.out.println("Admin login Successfully");

		} else {

			System.out.println("Admin login failed");

		}

	}

	public void BranchCreation(String bname, String add1, String area, String zcode, String cry, String st, int cty ) throws InterruptedException {

		Expval = "Successfully";

		driver.findElement(By.xpath(PR.getProperty("bbutton"))).click();

		Thread.sleep(2000);

		driver.findElement(By.id(PR.getProperty("newbbutton"))).click();

		Thread.sleep(2000);

		driver.findElement(By.id(PR.getProperty("bname"))).sendKeys(bname);

		driver.findElement(By.name(PR.getProperty("badd1"))).sendKeys(add1);

		driver.findElement(By.name(PR.getProperty("barea"))).sendKeys(area);

		driver.findElement(By.id(PR.getProperty("bzip"))).sendKeys(zcode);

		// Select class for Dropdown

		Select ctry = new Select(driver.findElement(By.id(PR.getProperty("bctry"))));

		ctry.selectByVisibleText(cry);

		Select state = new Select(driver.findElement(By.id(PR.getProperty("bstate"))));

		state.selectByValue(st);

		Select city = new Select(driver.findElement(By.id(PR.getProperty("bcity"))));

		city.selectByIndex(cty);

		Thread.sleep(2000);

		// submit

		driver.findElement(By.id(PR.getProperty("bsubmit"))).click();

		Thread.sleep(2000);

		// alert

		Actval = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		if (Actval.contains(Expval)) {

			System.out.println("Branch Created Successfully");

		} else {

			System.out.println("Branch already exist");

		}

	}

	public void RoleCreation(String rname,String rdesc,String rtpe) throws InterruptedException {

		Expval = "Successfully";

		driver.findElement(By.xpath(PR.getProperty("rbutton"))).click();

		Thread.sleep(2000);

		driver.findElement(By.id(PR.getProperty("newrbutton"))).click();

		driver.findElement(By.id(PR.getProperty("rname"))).sendKeys(rname);

		driver.findElement(By.id(PR.getProperty("rdesc"))).sendKeys(rdesc);

		Select rtype = new Select(driver.findElement(By.id(PR.getProperty("rtype"))));

		rtype.selectByVisibleText(rtpe);

		Thread.sleep(3000);

		// submit

		driver.findElement(By.id(PR.getProperty("rsubmit"))).click();

		Thread.sleep(2000);

		// alert

		Actval = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		Thread.sleep(2000);

		if (Actval.contains(Expval)) {

			System.out.println("Role Created Successfully");

		} else {

			System.out.println("Role already exist");

		}

	}

	public void EmployeeCreation(String uname,String pwd,int erole,String ebranch) throws InterruptedException {
		
		Expval = "Successfully";

		driver.findElement(By.xpath(PR.getProperty("ebutton"))).click();

		driver.findElement(By.id(PR.getProperty("newebutton"))).click();

		Thread.sleep(2000);

		driver.findElement(By.id(PR.getProperty("ename"))).sendKeys(uname);

		driver.findElement(By.id(PR.getProperty("elpwd"))).sendKeys(pwd);

		Select role = new Select(driver.findElement(By.id(PR.getProperty("erole"))));

		role.selectByIndex(erole);

		Select branch = new Select(driver.findElement(By.id(PR.getProperty("ebranch"))));

		branch.selectByVisibleText(ebranch);

		Thread.sleep(3000);

		// submit

		driver.findElement(By.id(PR.getProperty("esubmit"))).click();

		Thread.sleep(2000);

		// alert

		Actval = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		Thread.sleep(3000);

		if (Actval.contains(Expval)) {

			System.out.println("Employee Created Successfully");

		} else {

			System.out.println("Employee already exist");

		}

	}

	public void HomeLink() throws InterruptedException {

		driver.findElement(By.xpath(PR.getProperty("home"))).click();

		Thread.sleep(3000);

	}

	public void AdminLogout() throws InterruptedException {

		Expval = "Ranford Bank";

		driver.findElement(By.xpath(PR.getProperty("logout"))).click();

		Actval = driver
				.findElement(By.xpath(
						"//*[@id=\"Form1\"]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span"))
				.getText();

		Thread.sleep(3000);

		// comparison

		if (Actval.equalsIgnoreCase(Expval)) {

			System.out.println("Admin Logout Successfully");

		} else {

			System.out.println("Admin Logout Failed");

		}

	}

	public String CloseApp() {

		driver.quit();

		System.out.println("Application Closed");
		
		return "Application Passed..!";

	}

}
