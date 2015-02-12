package exception;

public class BusinessException extends Exception {

	/**
	 * @param string 
	 * @see Exception#Exception()
	 */
	public BusinessException(String message){
		super(message);
	}
	
	/**
	 * @see Exception#Exception(Throwable)
	 */
	public BusinessException(Throwable ex){
		super(ex);
	}
}
