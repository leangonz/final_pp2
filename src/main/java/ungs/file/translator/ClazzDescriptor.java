package ungs.file.translator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClazzDescriptor {

	private Class<?> clazz;

	private Field[] atributos;

	public ClazzDescriptor(String clazzName) {
		try {
			this.clazz = Class.forName(clazzName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<String> getAtributos() {
		atributos = clazz.getDeclaredFields();
		return Arrays.stream(atributos).map(x -> x.getName()).collect(Collectors.toList());
	}
	
	public Constructor<?> getConstructor() throws NoSuchMethodException, SecurityException {
		return clazz.getConstructor();
	}
	
	public Field getField(String fieldName) throws NoSuchFieldException, SecurityException {
		return clazz.getDeclaredField(fieldName);
	}
	
}
