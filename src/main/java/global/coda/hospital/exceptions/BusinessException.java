package global.coda.hospital.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The Class BusinessException.
 * @author VC
 */
@ControllerAdvice
public class BusinessException extends Exception {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Exception.
	 * @param exception the exception
	 * @return the response entity
	 */
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<Object> exception(BusinessException exception) {
		return new ResponseEntity<>("Bad requested / Invalid details", HttpStatus.OK);
	}

	/**
	 * Instantiates a new business exception.
	 */
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new business exception.
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new business exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new business exception.
	 * @param message the message
	 */
	public BusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new business exception.
	 * @param cause the cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
