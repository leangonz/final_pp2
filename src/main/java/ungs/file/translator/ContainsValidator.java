package ungs.file.translator;

public class ContainsValidator {

	private FileSource source;
	private ClazzDescriptor descriptor;

	public ContainsValidator(FileSource source, ClazzDescriptor descriptor) {
		this.source = source;
		this.descriptor = descriptor;
	}

	public void validate () {
		if(!descriptor.getAtributos().containsAll(source.readHeader())) throw new AttributesNotEnoughException();
	}
}
