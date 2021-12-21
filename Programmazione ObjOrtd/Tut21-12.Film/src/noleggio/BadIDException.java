package noleggio;

import java.io.IOException;

public class BadIDException extends IOException {

	private static final long serialVersionUID = 753141829430311101L;

	public BadIDException() {
		
	}

	public BadIDException(String message) {
		super(message);
		
	}

	public BadIDException(Throwable cause) {
		super(cause);
		
	}

	public BadIDException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
