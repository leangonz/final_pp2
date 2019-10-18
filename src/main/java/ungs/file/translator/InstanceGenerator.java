package ungs.file.translator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InstanceGenerator {

	private ClazzDescriptor descriptor;
	
	public InstanceGenerator(ClazzDescriptor descriptor) {
		this.descriptor = descriptor;
	}

	public List<Object> getLista(Map<String, Integer> mapeos, List<List<String>> records) {
		return records.stream().map(x -> generarObjeto(mapeos, x)).collect(Collectors.toList());
		
	}
	
	public Object generarObjeto(Map<String, Integer> mapeos, List<String> record) {
		try {
			Object instanciaCreada = descriptor.getConstructor().newInstance();
			mapeos.entrySet().stream()
					.forEach(x -> this.settearAtributo(x.getKey(), instanciaCreada, record.get(x.getValue())));
			return instanciaCreada;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				 | SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void settearAtributo(String fieldName, Object instanciaCreada, String value) {
		try {
			Field field = descriptor.getField(fieldName);
			field.setAccessible(true);
			settearByType(field, instanciaCreada, value);
		} catch (SecurityException | IllegalArgumentException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	private void settearByType(Field field, Object o, Object value) {
		try {
			if (field.getType().equals(String.class)) {
				field.set(o, value);
			} else if (field.getType().equals(LocalDate.class)) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				field.set(o, LocalDate.parse(value.toString(), formatter));
			} else if (field.getType().equals(Boolean.class)) {
				field.set(o, Boolean.valueOf(value.toString()));
			} else if (field.getType().equals(Integer.class)) {
				field.setInt(o, Integer.valueOf(value.toString()));
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
