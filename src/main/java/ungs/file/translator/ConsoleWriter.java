package ungs.file.translator;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleWriter extends Writer {

	public ConsoleWriter(ClazzDescriptor descriptor) {
		this.descriptor = descriptor;
	}
	
	@Override
	public void write(List<Object> lista) {
		lista.stream().forEach(x -> this.mostrar(x));
	}

	private void mostrar(Object item) {
		var atributos = descriptor.getAtributos();
		var concat = atributos.stream().map(x -> this.getValue(x, item)).collect(Collectors.joining(" "));
		System.out.println(concat);
	}

	private String getValue(String attibuteName, Object item) {
		try {
			var field = descriptor.getField(attibuteName);
			field.setAccessible(true);
			return field.get(item).toString();
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		return "";
	}
}