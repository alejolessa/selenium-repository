package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(css = "input#user-name")
	WebElement inputUserName;

	@FindBy(css = "input#password")
	WebElement inputPassword;

	@FindBy(className = "error-button")
	WebElement buttonError;

	@FindBy(className = "btn_action")
	WebElement buttonLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {
		this.inputUserName.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		this.inputPassword.sendKeys(strPassword);
	}

	public boolean existsErrorLogin() {
		try {
			this.buttonError.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void clickLogin() {
		this.buttonLogin.click();
	}

	public void login(String usrName, String psw) {
		this.setUserName("standard_user");
		this.setPassword("secret_sauce");
		this.clickLogin();
	}
}
