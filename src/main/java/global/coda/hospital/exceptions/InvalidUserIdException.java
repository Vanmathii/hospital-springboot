package global.coda.hospital.exceptions;

/**
 * The Class InvalidUserIdException.
 */
public class InvalidUserIdException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new invalid user id exception.
	 */
	public InvalidUserIdException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new invalid user id exception.
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public InvalidUserIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new invalid user id exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public InvalidUserIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new invalid user id exception.
	 * @param message the message
	 */
	public InvalidUserIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new invalid user id exception.
	 * @param cause the cause
	 */
	public InvalidUserIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
