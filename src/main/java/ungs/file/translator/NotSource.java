package ungs.file.translator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NotSource extends FileSource {

	public NotSource(String paths) throws IOException {
		super(paths);
	}

	@Override
	public List<String> readHeader() {
		return new ArrayList<String>();
	}

	@Override
	public List<List<String>> readRecords() {
		return new ArrayList<List<String>>();
	}

}
