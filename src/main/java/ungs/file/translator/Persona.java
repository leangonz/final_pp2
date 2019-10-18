package ungs.file.translator;

import java.time.LocalDate;

public class Persona {

	private String nombre;
	
	private String apellido;
	
	private LocalDate fechaNacimiento;
	
	private Boolean tieneDeuda;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getTieneDeuda() {
		return tieneDeuda;
	}

	public void setTieneDeuda(Boolean tieneDeuda) {
		this.tieneDeuda = tieneDeuda;
	}
	
}
