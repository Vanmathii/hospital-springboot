package global.coda.hospital.exceptions;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The Class SystemException.
 * @author VC Thrown in case of system errors
 */
@ControllerAdvice
public class SystemException extends Exception {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new system exception.
	 */
	public SystemException() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Instantiates a new system exception.
	 * @param message the message
	 * @param cause the cause
	 * @param enableSuppression the enable suppression
	 * @param writableStackTrace the writable stack trace
	 */
	public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Instantiates a new system exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public SystemException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Instantiates a new system exception.
	 * @param message the message
	 */
	public SystemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Instantiates a new system exception.
	 * @param cause the cause
	 */
	public SystemException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Exception.
	 * @param exception the exception
	 * @return the response entity
	 */
	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<Object> exception(SystemException exception) {
		return new ResponseEntity<>("Bad request", HttpStatus.OK);
	}
}
