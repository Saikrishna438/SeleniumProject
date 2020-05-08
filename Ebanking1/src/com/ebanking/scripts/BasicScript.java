package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicScript {

	public static void main(String[] args) throws Exception {

		String Expval = "Ranford Bank";

		// launch browser

		// WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		// url

		driver.get("http://183.82.100.55/ranford2/");

		Thread.sleep(3000);

		String Actval = driver
				.findElement(By.xpath(
						"//*[@id=\"Form1\"]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span"))
				.getText();

		// comparission

		if (Actval.equalsIgnoreCase(Expval)) {

			System.out.println("Ranford Application launch");

		} else {

			System.out.println("Ranford Application Not launch");

		}

		// Admin Login

		Expval = "Welcome to Admin";

		driver.findElement(By.id("txtuId")).sendKeys("Admin");

		driver.findElement(By.id("txtPword")).sendKeys("M1ndq");

		driver.findElement(By.id("login")).click();

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

		// Branch

		Expval = "Successfully";

		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("BtnNewBR")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("txtbName")).sendKeys("Hyderabad438");

		driver.findElement(By.name("txtAdd1")).sendKeys("Hyderabad 3-78/3");

		driver.findElement(By.name("txtArea")).sendKeys("Ameerpet");

		driver.findElement(By.id("txtZip")).sendKeys("50045");

		// Select class for Dropdown

		Select ctry = new Select(driver.findElement(By.id("lst_counrtyU")));

		ctry.selectByVisibleText("INDIA");

		Select state = new Select(driver.findElement(By.id("lst_stateI")));

		state.selectByValue("Andhra Pradesh");

		Select city = new Select(driver.findElement(By.id("lst_cityI")));

		city.selectByIndex(1);

		Thread.sleep(2000);

		// submit

		driver.findElement(By.id("btn_insert")).click();

		Thread.sleep(2000);

		// alert

		Actval = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		if (Actval.contains(Expval)) {

			System.out.println("Branch Created Successfully");

		} else {

			System.out.println("Branch already exist");

		}

		// role creation

		Expval = "Successfully";

		driver.findElement(By.xpath("//*[@id=\"Table_02\"]/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("btnRoles")).click();

		driver.findElement(By.id("txtRname")).sendKeys("Tester");

		driver.findElement(By.id("txtRDesc")).sendKeys("sexp tester");

		Select rtype = new Select(driver.findElement(By.id("lstRtypeN")));

		rtype.selectByVisibleText("E");

		Thread.sleep(3000);

		// submit

		driver.findElement(By.id("btninsert")).click();

		Thread.sleep(2000);

		// alert

		Actval = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		if (Actval.contains(Expval)) {

			System.out.println("Role Created Successfully");

		} else {

			System.out.println("Role already exist");

		}

		// employee creation

		Expval = "Successfully";

		driver.findElement(By.xpath("//*[@id=\"Table_02\"]/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();

		driver.findElement(By.id("BtnNew")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("txtUname")).sendKeys("Saikrishna");

		driver.findElement(By.id("txtLpwd")).sendKeys("saikrishna");

		Select role = new Select(driver.findElement(By.id("lst_Roles")));

		role.selectByIndex(1);

		Select branch = new Select(driver.findElement(By.id("lst_Branch")));

		branch.selectByVisibleText("abc");

		Thread.sleep(3000);

		// submit

		driver.findElement(By.id("BtnSubmit")).click();

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

		// home link

		driver.findElement(By.xpath("//*[@id=\"Table_01\"]/tbody/tr/td[1]/a/img")).click();

		Thread.sleep(3000);

		// admin logout

		Expval = "Ranford Bank";

		driver.findElement(By.xpath("//*[@id=\"Table_02\"]/tbody/tr/td[3]/a/img")).click();

		Actval = driver
				.findElement(By.xpath(
						"//*[@id=\"Form1\"]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span"))
				.getText();

		// comparison

		if (Actval.equalsIgnoreCase(Expval)) {

			System.out.println("Admin Logout Successfully");

		} else {

			System.out.println("Admin Logout Failed");

		}

		Thread.sleep(3000);

		// close browser

		driver.quit();

	}

}
