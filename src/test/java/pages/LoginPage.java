package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	// Locators for the login page elements
	private By usernameField = By.id("userName");
	private By passwordField = By.id("password");
	private By loginButton = By.xpath("//*[@id='login']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Action method for entering username
	public void enterUsername(String username) {
		WebElement usernameElement = driver.findElement(usernameField);
		usernameElement.sendKeys(username);
	}

	// Action method for entering password
	public void enterPassword(String password) {
		WebElement passwordElement = driver.findElement(passwordField);
		passwordElement.sendKeys(password);
	}

	// Action method for clicking the login button
	public void clickLoginButton() {
		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
	}

}
