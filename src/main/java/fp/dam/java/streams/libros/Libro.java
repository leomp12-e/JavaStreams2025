package fp.dam.java.streams.libros;

import java.util.Objects;

public class Libro {

	private String titulo;
	private Autor autor;
	private String genero;
	private float precio;
	private int stock;
	
	public Libro(String titulo, Autor autor, String genero, float precio, int stock) {
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.precio = precio;
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getTitulo() {
		return titulo;
	}

	public Autor getAutor() {
		return autor;
	}
	
	public String getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		return titulo + " (" + genero + ")" + " (" + autor + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, genero, precio, stock, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(genero, other.genero)
				&& Float.floatToIntBits(precio) == Float.floatToIntBits(other.precio) && stock == other.stock
				&& Objects.equals(titulo, other.titulo);
	}
	
}