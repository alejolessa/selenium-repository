package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageFactory.LoginPage;

public class TestLogin extends SeleniumTestSuite {

	String baseUrl = "https://www.saucedemo.com/";
	LoginPage loginPage;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod() {
		if (driver != null)
			driver.quit();
	}

	@Test // (enabled = false)
	public void pageTitle() throws Exception {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test // (enabled = false)
	public void incorrectUser() throws Exception {
		loginPage = new LoginPage(driver);

		loginPage.setUserName("userIncorrect");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
		Assert.assertTrue(loginPage.existsErrorLogin());

	}

	@Test // (enabled = false)
	public void incorrectPsw() throws Exception {
		loginPage = new LoginPage(driver);

		loginPage.setUserName("standard_user");
		loginPage.setPassword("secret_sauce1");
		loginPage.clickLogin();
		Assert.assertTrue(loginPage.existsErrorLogin());
	}

	@Test // (enabled = false)
	public void correctUser() throws Exception {
		loginPage = new LoginPage(driver);

		loginPage.setUserName("standard_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();

	}
}
