package ungs.file.translator;

import java.io.IOException;

public class FileSourceFactory {

	private static final String CSV_EXTENSION = "csv";
	
	public static FileSource getFileSource (String path) throws IOException {
		String[] extension = path.split("\\.");
		if (CSV_EXTENSION.equals(extension[1])) {
			return new CsvSource(path);
		}
		return new NotSource(path);
	}
}
