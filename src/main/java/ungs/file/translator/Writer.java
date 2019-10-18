package ungs.file.translator;

import java.util.List;

public abstract class Writer {

	protected ClazzDescriptor descriptor;

	public Writer() {
		super();
	}

	public abstract void write(List<Object> lista);

}