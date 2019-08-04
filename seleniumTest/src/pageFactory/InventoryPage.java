package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

	WebDriver driver;

	@FindBy(className = "shopping_cart_link")
	WebElement goToCart;

	@FindBy(css = "a#item_4_title_link")
	WebElement linkItem4;

	@FindBy(css = "a#item_1_title_link")
	WebElement linkItem1;

	@FindBy(css = "a#item_3_title_link")
	WebElement linkItem3;

	@FindBy(className = "btn_primary")
	WebElement buttonAddToCartElement;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickGoToCart() {
		this.goToCart.click();
	}

	public void clickLinkElement4() {
		this.linkItem4.click();
	}

	public void clickLinkElement1() {
		this.linkItem1.click();
	}

	public void clickLinkElement3() {
		this.linkItem3.click();
	}

	public void clickButtonAddToCartElement() {

		this.buttonAddToCartElement.click();

	}

}
