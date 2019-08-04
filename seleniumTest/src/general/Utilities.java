package general;

import java.util.ArrayList;

public class Utilities {

	public static ArrayList<ItemsToBuy> listItems = new ArrayList<ItemsToBuy>();
	public static ArrayList<ItemsToBuy> listItemsAux = new ArrayList<ItemsToBuy>();
	public static Double subTotal;
	public static Double taxTotal;

	public static Double calcularSubTotal() {
		Double total = 0.0;

		for (int i = 0; i < listItems.size(); i++) {
			total += listItems.get(i).getPrice();
		}
		subTotal = total;
		return total;
	}

	public static Double calcularTaxTotal() {
		Double total = 0.0;

		for (int i = 0; i < listItems.size(); i++) {
			total += listItems.get(i).getTax();
		}
		taxTotal = total;
		return total;
	}

	public static boolean compareLists() {

		if (listItems.size() == listItemsAux.size()) {
			while (listItemsAux.size() > 0) {
				for (int j = 0; j < listItems.size(); j++) {
					if (listItemsAux.get(0).getName().equalsIgnoreCase(listItems.get(j).getName())) {
						if ((Double.compare(listItemsAux.get(0).getPrice(), listItems.get(j).getPrice()) == 0)) {
							listItemsAux.remove(0);
							listItems.remove(j);
						}
					}
				}
			}
		}
		if (listItems.size() == 0 && listItemsAux.size() == 0) {
			return true;
		}
		return false;
	}

}
