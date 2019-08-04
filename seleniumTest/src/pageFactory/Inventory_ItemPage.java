package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestInventory;
import general.ItemsToBuy;
import general.Utilities;

public class Inventory_ItemPage extends TestInventory {

	public Inventory_ItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(className = "btn_primary")
	WebElement buttonAddToCartElement;

	@FindBy(className = "inventory_details_name")
	WebElement tagItemName;

	@FindBy(className = "inventory_details_price")
	WebElement tagItemPrice;

	@FindBy(className = "shopping_cart_link")
	WebElement linkGoToCart;

	@FindBy(className = "inventory_details_back_button")
	WebElement buttonBack;

	public void clickGoToCart() {
		this.linkGoToCart.click();
	}

	public void clickGoBack() {
		this.buttonBack.click();
	}

	public void clickButtonAddToCartElement() {
		String name = this.tagItemName.getText();
		String priceS = this.tagItemPrice.getText();
		priceS = priceS.replaceAll("[$]", "");
		Double price = Double.parseDouble(priceS);
		ItemsToBuy item = new ItemsToBuy(name, price);
		Utilities.listItems.add(item);
		this.buttonAddToCartElement.click();
	}

}
