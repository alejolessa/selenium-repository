package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_1Page {
	WebDriver driver;

	@FindBy(css = "input#first-name")
	WebElement inputFirstName;

	@FindBy(css = "input#last-name")
	WebElement inputLastName;

	@FindBy(css = "input#postal-code")
	WebElement inputPostalCode;

	@FindBy(className = "btn_primary")
	WebElement buttonContinue;

	public CheckOut_1Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setFirstName(String firstName) {
		this.inputFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		this.inputLastName.sendKeys(lastName);
	}

	public void setPostalCode(String postalCode) {
		this.inputPostalCode.sendKeys(postalCode);
	}

	public void clickContinue() {
		this.buttonContinue.click();
	}

	public void fillCheckOut() {
		this.setFirstName("My Name");
		this.setLastName("My Last Name");
		this.setPostalCode("RW1644");
		this.clickContinue();
	}

}
