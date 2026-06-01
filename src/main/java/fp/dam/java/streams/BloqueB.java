package fp.dam.java.streams;

import static java.util.stream.Collectors.averagingInt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Set;
import static java.util.function.Function.*;
import java.util.regex.Pattern;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;


public class BloqueB {
	
	private static Pattern pattern = Pattern.compile("\\p{L}+|\\P{L}+");
	private static Pattern pattern2 = Pattern.compile("\\p{L}+");
	
	/*
	 * EJERCICIO 1
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas para extraer de cada una de ellas
	 * los elementos que la forman (palabras, uno o más caracteres alfabéticos seguidos,
	 * y no-palabras, todo lo que haya entre cada palabra) y almacenarlos en una lista.
	 * Finalmente se retornará una lista de listas que contenga todas las anteriores.
	 * 
	 *  s -> pattern.matcher(s).results().map(r -> r.group())
	 */
	
	static List<List<String>> ejercicio01(Stream<String> secuencia) {
//		return secuencia
//				.map(s -> pattern.matcher(s).results().map(r -> r.group()).toList())
//				.toList();
		
		return secuencia
				.map(s -> pattern
						.matcher(s)
						.results()
						.map(r -> r.group())
						.collect(toCollection(ArrayList::new)))
				.collect(toCollection(LinkedList::new));
	}
	
	/*
	 * EJERCICIO 2
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el máximo número
	 * de elementos contenidos en una línea.
	 */
	
	static OptionalLong ejercicio02(Stream<String> secuencia) {
		return secuencia
				.mapToLong(s -> pattern.matcher(s).results().map(r -> r.group()).count())
				.max();
	}
	
	/*
	 * EJERCICIO 3
	 * 
	 * Lo mismo que en el ejercicio anterior, pero aceptando una lista como la que retorna el metodo
	 * creado en el ejercicio 1.
	 */
	
	static OptionalLong ejercicio03(List<List<String>> lista) {
		return lista
				.stream()
				.mapToLong(l -> l.size())
				.max();
	}
	
	
	/*
	 * EJERCICIO 4
	 * 
	 * Crea un método estático que acepte una lista como la que retorna el ejercicio 1 y retorne una
	 * lista de cadenas que contenga las palabras y no-palabras en orden de aparición.
	 */
	
	static List<String> ejercicio04(List<List<String>> lista) {
		return null;
	}
	
	
	/*
	 * EJERCICIO 5
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y retorne una lista de cadenas
	 * que contenga las palabras y no-palabras en orden de aparición.
	 */
	
	static List<String> ejercicio05(Stream<String> secuencia) {
		return secuencia
				.flatMap(s -> pattern.matcher(s).results().map(r -> r.group()))
				.toList();
	}
	
	/*
	 * EJERCICIO 6
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el conjunto de palabras
	 * que se repiten.
	 */
	
	static Set<String> ejercicio06(Stream<String> secuencia) {
		return secuencia
				.flatMap(s -> pattern2.matcher(s).results().map(r -> r.group()))
				.collect(groupingBy(identity(), counting()))
				.entrySet()
				.stream()
				.filter(e -> e.getValue() > 1)
				.map(e -> e.getKey())
				.collect(toSet());
	}
	
	
	/*
	 * EJERCICIO 7
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y retorne la longitud media.
	 */
	
	static Collection<String> ejercicio07(Stream<String> secuencia) {
		return secuencia.sorted(Comparator.comparingInt(String::length).reversed())
		.limit(20).collect(toCollection(LinkedList::new));
	}
	
	/*
	 * EJERCICIO 8
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y retorne un mapa que asocie
	 * longitudes de palabra con el número de palabras de dicha longitud.
	 * Solo se tendrán en cuenta las diferentes longitudes de las palabras contenidas en la secuencia.
	 */
	
	static Map<Integer, Long> ejercicio08(Stream<String> secuencia) {
		return null;
	}
	
	/*
	 * EJERCICIO 9
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el total de palabras
	 * en la secuencia sin contar las repetidas.
	 */
	
	public static List<String> ejercicio09(Stream<String> secuencia, int longitud) {
		List<String> palabras = secuencia.toList();
		return palabras.stream().filter(s -> palabras.stream().anyMatch(null)).toList();
				}
	
	
	/*
	 * EJERCICIO 10
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y retorne el total de vocales
	 * y consonantes de la secuencia.
	 */
	
	static Map<Boolean, Long> ejercicio10(Stream<String> secuencia) {
		return null;
	}
	
	
	/*
	 * EJERCICIO 11
	 * 
	 * Crea un método estático que acepte una secuencia de cadenas y una longitud l, y retorne
	 * todas las subcadenas longitud l de cada palabra presentes en la secuencia cuya longitud
	 * sea mayor que l.
	 */
	
	static List<String> ejercicio11(Stream<String> secuencia, int l) {
		return null;
	}
	
	public static void main(String[] args) {
//		System.out.println(ejercicio01(Datos.getLineas()));
//		OptionalLong max = ejercicio02(Datos.getLineas());
//		if (max.isEmpty())
//			System.out.println("No se ha podido hallar el máximo");
//		else
//			System.out.println("Máximo = " + max.getAsLong());
		System.out.println(ejercicio03(ejercicio01(Datos.getLineas())));
//		System.out.println(ejercicio05(Datos.getLineas()));
		
	}
	
}