package exception;

public class PersistenceException extends Exception {

	/**
	 * @see Exception#Exception(Throwable)
	 */
	public PersistenceException(Throwable ex) {
		super(ex);
	}
}
