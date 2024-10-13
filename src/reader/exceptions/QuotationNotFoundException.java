package reader.exceptions;

public class QuotationNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QuotationNotFoundException(String message) {
		super(message);
	}
}
