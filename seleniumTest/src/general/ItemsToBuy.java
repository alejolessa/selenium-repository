package general;

import tests.TestInventory;

public class ItemsToBuy extends TestInventory {
	String name;
	Double price;
	Double tax;

	public ItemsToBuy() {
		this.name = "";
		this.price = 0.0;
		this.tax = 0.0;
	}

	public ItemsToBuy(String name, Double price) {
		this.name = name;
		this.price = price;

		if (name.equalsIgnoreCase("Sauce Labs Backpack")) {
			this.tax = 2.40;
		} else if (name.equalsIgnoreCase("Sauce Labs Bike Light")) {
			this.tax = 0.80;
		} else if (name.equalsIgnoreCase("Sauce Labs Bolt T-Shirt")) {
			this.tax = 1.28;
		} else if (name.equalsIgnoreCase("Sauce Labs Fleece Jacket")) {
			this.tax = 4.0;
		} else if (name.equalsIgnoreCase("Sauce Labs Onesie")) {
			this.tax = 0.64;
		} else if (name.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)")) {
			this.tax = 1.28;
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public Double getPrice() {
		return this.price;
	}

	public Double getTax() {
		return this.tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

}
