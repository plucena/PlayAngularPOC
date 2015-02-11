package exception;

public class BusinessException extends Exception {

	/**
	 * @see Exception#Exception()
	 */
	public BusinessException(){
		super();
	}
	
	/**
	 * @see Exception#Exception(Throwable)
	 */
	public BusinessException(Throwable ex){
		super(ex);
	}
}
