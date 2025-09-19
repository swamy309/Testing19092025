package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(LoginTest.class);

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Login() {
		System.out.println("Running testLogin...");
		WebElement usernameField = driver.findElement(By.id("userName"));
		usernameField.sendKeys("swamy");
		log.info("username is entered");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Swamy@456789");
		log.info("password is entered");
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));
		loginButton.click();
		log.info("loginButton is clicked");
	}

}
