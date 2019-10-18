package ungs.file.translator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FileSource {

	protected final List<String> lines;

	public FileSource(String paths) throws IOException {
		Path path = Paths.get(paths);
		try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(path, Charset.forName("UTF-8")))) {
			lines = reader.lines().map(String::trim).collect(Collectors.toList());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public abstract List<String> readHeader();

	public abstract List<List<String>> readRecords();
}
