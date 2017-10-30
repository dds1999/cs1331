public class Restaurant {
	private String name;
	private Menu[] menu;

	public Restaurant(String name) {
		this.name = name;
	}
	public void takeOrder(String[] order) throws ItemNotAvailableException {
		//WHAT IF SOMEONE ORDERS FOOD THAT I DON'T SELL??
		for(String item : order) {
			if (containsOder(item)) {
				System.out.printf("Okay we sell %s%n", item);
			} else {
				throw new ItemNotAvailableException(item);
			}
		}
	}
	public static boolean containsOder(String item) {
		for (Menu m : Menu.values()) {
			// .values() gives array of everything in values
			if(m.valueOf().equals(item)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String name = "JamMcDonalds";
		Menu[] menu = 	{ Menu.BURGER, Menu.FRIES};
		Restaurant jam = new Restaurant(name);
		String[] order1 = {"burger", "fries"};
		String[] order2 = {"tacos", "fries"};
		try {
			jam.takeOrder(order1);
			jam.takeOrder(order2);
		} catch(ItemNotAvailableException e) {
			System.out.println(e);
		} finally {
			System.out.println("Have a nice day.");
		}
	}
}