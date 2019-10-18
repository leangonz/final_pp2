package ungs.file.translator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvSource extends FileSource {

	private static final String SEPARATOR = ",";

	public CsvSource(String paths) throws IOException {
		super(paths);
	}

	@Override
	public List<String> readHeader() {
		return lines.stream().findFirst().map(line -> Arrays.asList(line.split(SEPARATOR))).get().stream()
				.map(String::trim).collect(Collectors.toList());
	}

	@Override
	public List<List<String>> readRecords() {
		return lines.stream().skip(1).map(line -> Arrays.asList(line.split(SEPARATOR)))
				.map(x -> x.stream().map(String::trim).collect(Collectors.toList())).collect(Collectors.toList());
	}
}
