package util;

public class StringFunctions {

	public static boolean isNullOrEmptyOrWhiteSpace(String author) {
		return author.equals(null) || author.trim().equals("");
	}
}