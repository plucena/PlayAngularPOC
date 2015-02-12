package exception;

public class VOException extends Exception {

	/**
	 * @see Exception#Exception()
	 */
	public VOException(){
		super();
	}
	
	/**
	 * @throws Exception 
	 * @see Exception#Exception(String)
	 */
	public VOException(String field) throws VOException {
		super(String.format("%s %s", field, ExceptionMessages.FIELD_IS_REQUIRED).toString());
	}
	
	/**
	 * @see Exception#Exception(Throwable)
	 */
	public VOException(Throwable ex){
		super(ex);
	}
}
