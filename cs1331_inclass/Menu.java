public enum Menu {
	BURGER("burger"),
	FRIES("fries");

	private String value;

	Menu(String value) {
		this.value = value;
	}

	public String valueOf() {
		return value;
	}
}