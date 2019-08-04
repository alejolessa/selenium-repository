package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageFactory.LoginPage;
import pageFactory.InventoryPage;
import pageFactory.Inventory_ItemPage;
import pageFactory.CartPage;
import pageFactory.CheckOut_1Page;
import pageFactory.CheckOut_2Page;

public class TestInventory extends SeleniumTestSuite {

	String baseUrl = "https://www.saucedemo.com/";
	LoginPage loginPage;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckOut_1Page checkOut_1Page;
	Inventory_ItemPage inventory_ItemPage;
	CheckOut_2Page checkOut_2Page;

	@BeforeMethod
	public void beforeTest() {
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
	public void buyOneItem() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		inventoryPage = new InventoryPage(driver);
		inventoryPage.clickGoToCart();

		cartPage = new CartPage(driver);
		cartPage.clickContinueShopping();

		inventoryPage = new InventoryPage(driver);
		inventoryPage.clickLinkElement4();

		inventory_ItemPage = new Inventory_ItemPage(driver);
		inventory_ItemPage.clickButtonAddToCartElement();
		inventory_ItemPage.clickGoToCart();

		cartPage = new CartPage(driver);
		cartPage.clickButtonCheckOut();

		checkOut_1Page = new CheckOut_1Page(driver);
		checkOut_1Page.fillCheckOut();

		checkOut_2Page = new CheckOut_2Page(driver);
		checkOut_2Page.elementsVerification();

	}

	@Test // (enabled = false)
	public void buySeveralItems() throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");

		inventoryPage = new InventoryPage(driver);
		inventoryPage.clickLinkElement4();

		inventory_ItemPage = new Inventory_ItemPage(driver);
		inventory_ItemPage.clickButtonAddToCartElement();
		inventory_ItemPage.clickGoBack();

		inventoryPage = new InventoryPage(driver);
		inventoryPage.clickLinkElement3();

		inventory_ItemPage = new Inventory_ItemPage(driver);
		inventory_ItemPage.clickButtonAddToCartElement();
		inventory_ItemPage.clickGoBack();

		inventoryPage = new InventoryPage(driver);
		inventoryPage.clickLinkElement1();

		inventory_ItemPage = new Inventory_ItemPage(driver);
		inventory_ItemPage.clickButtonAddToCartElement();
		inventory_ItemPage.clickGoToCart();

		cartPage = new CartPage(driver);
		cartPage.clickButtonCheckOut();

		checkOut_1Page = new CheckOut_1Page(driver);
		checkOut_1Page.fillCheckOut();

		checkOut_2Page = new CheckOut_2Page(driver);
		checkOut_2Page.elementsVerification();
	}

}
