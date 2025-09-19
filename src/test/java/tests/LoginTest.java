package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import base.BaseTest;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Login() {
		System.out.println("Running testLogin...");
		WebElement usernameField = driver.findElement(By.id("userName"));
		WebElement passwordField = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]"));
		usernameField.sendKeys("swamy");
		passwordField.sendKeys("Swamy@456789");
		loginButton.click();

	}

}
