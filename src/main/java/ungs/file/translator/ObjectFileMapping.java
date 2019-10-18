package ungs.file.translator;

import java.util.Map;
import java.util.stream.Collectors;

public class ObjectFileMapping {

	private ClazzDescriptor descriptor;
	private FileSource fileSource;


	public ObjectFileMapping(ClazzDescriptor descriptor, FileSource fileSource) {
		this.descriptor = descriptor;
		this.fileSource = fileSource;
	}

	
	public Map<String, Integer> getMapping(){
		var header = fileSource.readHeader();
		return descriptor.getAtributos().stream().filter(x -> header.contains(x))
			.collect(Collectors.toMap(x -> x, x -> header.indexOf(x)));
		
	}
}
