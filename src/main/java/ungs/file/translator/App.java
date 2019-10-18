package ungs.file.translator;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws IOException {
		
		FileSource source = FileSourceFactory.getFileSource("src/main/resource/prueba.csv");
		ClazzDescriptor descriptor = new ClazzDescriptor("ungs.file.translator.Persona");
		InstanceGenerator instanceGenerator = new InstanceGenerator(descriptor);
		
		ContainsValidator validator = new ContainsValidator(source, descriptor);
		var atributos = descriptor.getAtributos();
		var header = source.readHeader();
		validator.validate();
		
		ObjectFileMapping ofm = new ObjectFileMapping(descriptor, source);
		var mapeo = ofm.getMapping();
		List<Object> objetos = instanceGenerator.getLista(mapeo, source.readRecords());
		
		Writer writer = new ConsoleWriter(descriptor);
		writer.write(objetos);
	}
}
