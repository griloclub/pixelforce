package utils;

public class FileNameFormatter {
	private static final String EXTENSION = ".csv";
	private static final String RESOURCES = "resources/";

	public static String format(String fileName) {
		return RESOURCES + fileName  + EXTENSION;
	}
}
