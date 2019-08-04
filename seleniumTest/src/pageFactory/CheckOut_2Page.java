package pageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import general.ItemsToBuy;
import general.Utilities;

public class CheckOut_2Page {
	WebDriver driver;

	@FindBy(css = "input#first-name")
	WebElement inputFirstName;

	@FindBy(xpath = "//*[@class='cart_item']")
	List<WebElement> elements;

	@FindBy(xpath = "//*[@class='summary_subtotal_label']")
	WebElement subTotal;

	@FindBy(xpath = "//*[@class='summary_tax_label']")
	WebElement taxTotal;

	@FindBy(xpath = "//*[@class='summary_total_label']")
	WebElement totalAmount;

	public CheckOut_2Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void elementsVerification() {
		subTotalVerification();
		taxTotalVerification();
		totalVerification();
		itemsVerification();

	}

	private void itemsVerification() {
		if (elements != null) {
			Assert.assertTrue(elements.size() == Utilities.listItems.size(), "Incorrect quantity elements in cart \n");

			java.util.Iterator<WebElement> program = elements.iterator();
			while (program.hasNext()) {
				String values = program.next().getText();
				String lines[] = values.split("\\r?\\n");
				String price = lines[3].replaceAll("[$]", "");
				ItemsToBuy item = new ItemsToBuy(lines[1], Double.parseDouble(price));
				Utilities.listItemsAux.add(item);
			}
			Assert.assertTrue(Utilities.compareLists(), "Incorrect elements in cart");
		}
	}

	private void subTotalVerification() {
		Double dblSubTotal = Double.parseDouble(subTotal.getText().substring(13));
		Assert.assertTrue(Double.compare(dblSubTotal, Utilities.calcularSubTotal()) == 0, "Incorrect SubTotal amount");
	}

	private void taxTotalVerification() {
		Double dblTaxTotal = Double.parseDouble(taxTotal.getText().substring(6));
		Assert.assertTrue(Double.compare(dblTaxTotal, Utilities.calcularTaxTotal()) == 0, "Incorrect SubTotal amount");
	}

	private void totalVerification() {
		Double dblTotal = Double.parseDouble(totalAmount.getText().substring(8));
		Double total = Math.round(Double.sum(Utilities.subTotal, Utilities.taxTotal) * 100.0) / 100.0;
		;
		Assert.assertTrue(Double.compare(dblTotal, total) == 0, "Incorrect SubTotal amount");
	}
}
