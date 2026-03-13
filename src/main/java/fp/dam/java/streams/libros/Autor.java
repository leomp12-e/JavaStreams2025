package fp.dam.java.streams.libros;

import java.util.Comparator;
import java.util.Objects;

public class Autor implements Comparable<Autor> {

	private String nombre;
	private String apellidos;

	public Autor(String nombre) {
		this.nombre = nombre;
	}

	public Autor(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public String getNombreApellidos() {
		return nombre + " " + apellidos;
	}
	
	public String getApellidosNombre() {
		return apellidos + ", " + nombre;
	}

	public String toString() {
		return getApellidosNombre();
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(nombre, other.nombre);
	}

	private static Comparator<Autor> c = Comparator.comparing(Autor::getApellidos).thenComparing(Autor::getNombre);
	@Override
	public int compareTo(Autor o) {
//		int resultado = apellidos.compareTo(o.apellidos);
//		if (resultado == 0)
//			resultado = nombre.compareTo(o.nombre);
//		return resultado;
		return c.compare(this, o);
	}

		
}