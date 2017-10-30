public class ItemNotAvailableException extends Exception {
	private static final String MESSAGE = "Sorry, we do not sell ";

	public ItemNotAvailableException(String item) {
		super(MESSAGE + item);
		// because creation of exception is the same
	}
}