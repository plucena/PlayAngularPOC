package exception;

public final class ExceptionMessages {
	public static final String FIELD_IS_REQUIRED = "is required";

	public static String maxLength(int maxAllowed) {
		return String.format("have limit of %d characters", maxAllowed);
	} 
}