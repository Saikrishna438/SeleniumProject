package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumGrid {

	DesiredCapabilities Dcap = null;

	@Test
	public void Grid() throws MalformedURLException {

		Dcap = new DesiredCapabilities();

		Dcap.setBrowserName("firefox");

		Dcap.setPlatform(Platform.LINUX);
		
		//WebDriverManager.firefoxdriver().setup();

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.43.34:4444/wd/hub"), Dcap);

		driver.manage().window().maximize();
		
		driver.get("http://183.82.100.55/ranford2/");
		
		driver.close();

	}

}
