package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(LoginTest.class);

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Login() {
		System.out.println("Running testLogin...");

		// Create an instance of LoginPage
		LoginPage loginPage = new LoginPage(driver);

		// Perform login actions using methods from LoginPage
		loginPage.enterUsername("swamy");
		log.info("username is entered");

		loginPage.enterPassword("Swamy@456789");
		log.info("password is entered");

		loginPage.clickLoginButton();
		log.info("loginButton is clicked");

	}

}
