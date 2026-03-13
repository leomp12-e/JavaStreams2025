package fp.dam.java.streams;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;
import static java.util.function.Function.*;

public class BloqueA {
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y muestre en la consola
	 * las palabras que empiecen por 'k', 'ñ',  'w' 'x' o 'y'.
	 */
	
	public static void ejercicio01(Stream<String> secuencia) {
		secuencia.filter(s -> s.startsWith("k")
				|| s.startsWith("ñ")
				|| s.startsWith("w")
				|| s.startsWith("x")
				|| s.startsWith("y")).forEach(System.out::println);
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y retorne el resultado de
	 * agrupar las palabras de longitud mayor que 3 que comiencen por los mismos 3 caracteres.
	 */
	
	public static Map<String, List<String>> ejercicio02a(Stream<String> secuencia) {
		return secuencia
				.filter(s -> s.length() > 3)
				.collect(groupingBy(s -> s.substring(0, 3)));
	}
	
	public static Map<String, List<String>> ejercicio02b(Stream<String> secuencia) {
		return secuencia
				.filter(s -> s.length() > 3)
				.collect(groupingBy(
						s -> s.substring(0, 3),
						TreeMap::new,
						mapping(identity(), toList())));
	}
	
	public static Map<String, Set<String>> ejercicio02c(Stream<String> secuencia) {
		return secuencia
				.filter(s -> s.length() > 3)
				.collect(groupingBy(
						s -> s.substring(0, 3),
						TreeMap::new,
						mapping(identity(), toCollection(TreeSet::new))));
	}
	
	public static Map<String, Long> ejercicio02d(Stream<String> secuencia) {
		return secuencia
				.filter(s -> s.length() > 3)
				.collect(groupingBy(
						s -> s.substring(0, 3),
						TreeMap::new,
						mapping(Function.identity(), counting())));
	}
	
	
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y una longitud y muestre en la
	 * consola todos los palíndromos de esa longitud. Si la longitud es menor que 3 se lanzará la
	 * excepción IllegalArgumentException.
	 */
	
	public static void ejercicio03(Stream<String> secuencia, int longitud) {
		if (longitud < 3)
			throw new IllegalArgumentException();
		
//		secuencia
//			.filter(s -> s.length() == longitud)
//			.filter(s -> new StringBuilder(s).reverse().toString().toLowerCase().equals(s.toLowerCase()))
//			.forEach(System.out::println);
		
		secuencia
		.filter(s -> s.length() == longitud && new StringBuilder(s).reverse().toString().toLowerCase().equals(s.toLowerCase()))
		.forEach(System.out::println);
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y retorne por cada inicial presente en
	 * la secuencia, el número de palabras que comienzan por ella. Como posibles iniciales sólo se considerarán
	 * las letras de la 'a' a la 'z' (minúsculas). Las vocales con tilde se considerarán como vocales sin tilde.
	 */ 

	static Map<Character, Long> ejercicio04(Stream<String> secuencia) {
		return secuencia.collect(groupingBy(s -> s.toLowerCase().charAt(0), counting()));
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y retorne la longitud de la palabra o palabras
	 * mas largas.
	 */
	
	public static int ejercicio05(Stream<String> secuencia) {
		return secuencia.mapToInt(String::length).max().orElse(-1);
	}
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y retorne el número de palabras de cada
	 * longitud presente en la secuencia.
	 */
	
	
	
	/*
	 * Crea un método estático que acepte una secuencia de palabras y retorne una LinkedList que contenga las
	 * 20 palabras más largas de la secuencia. 
	 */
	
	public static List<String> ejercicio07(Stream<String> secuencia) {
		return secuencia
				.sorted(Comparator.comparingInt(String::length).reversed())
				.limit(20)
				.collect(toCollection(LinkedList::new));
	}
	
	
	
	public static void main(String[] args) {
//		ejercicio01(Datos.getPalabras());
//		ejercicio02b(Datos.getPalabras()).entrySet()
//				.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
		ejercicio04(Datos.getPalabras()).entrySet()
				.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
//		ejercicio03(Datos.getPalabras(), 5);
//		System.out.println(ejercicio07(Datos.getPalabras()));
	}
}