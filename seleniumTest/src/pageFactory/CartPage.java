package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	@FindBy(className = "btn_secondary")
	WebElement buttonContinueShopping;

	@FindBy(className = "btn_action")
	WebElement buttonCheckOut;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickContinueShopping() {
		this.buttonContinueShopping.click();
	}

	public void clickButtonCheckOut() {
		this.buttonCheckOut.click();
	}

}