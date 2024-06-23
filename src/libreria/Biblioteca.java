package libreria;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;




public class Biblioteca {
	
	private List<Libro> libros; 
	
	
	public Biblioteca() {
		this.libros = new ArrayList<>();
	}
	
	public void agregarLibro(Libro libro) {
		if (libro != null) {
			// Validación de nombre
			if (libro.getTitulo().isEmpty() || libro.getTitulo().isBlank()) {
				System.out.println("Error al agregar el libro, tiene que haber un nombre");
				return;
			}
			// Validación de autor
			if (libro.getAutor().isEmpty() || libro.getAutor().isBlank()) {
				System.out.println("Error al agregar el autor del libro, tiene que haber un nombre");
				return;
			}
			// Validación del genero
			if (libro.getGenero().isEmpty() || libro.getGenero().isBlank()) {
				System.out.println("Error al agregar el genero, tiene que ingresar el nombre de un genero");
				return;
			}
			// Validación del año publicado
			if (libro.getAñoPublicacion() < 0) {
				System.out.println("Error al agregar el año de publicación, tiene que ingresar un año");
				return;
			}
			// Si las validaciones son correctas, se agrega el producto a la lista
			this.libros.add(libro);
			System.out.println("Libro agregado correctamente.");
		} else {
			System.out.println("Error al agregar el libro. El libro no puede ser nulo.");
		}
	}
	
		
	
		
		public void eliminarLibro(String nombreLibro) {
			Libro libroEliminado = buscarLibroPorNombre(nombreLibro);
			if (libroEliminado != null) {
				this.libros.remove(libroEliminado);
				System.out.println("Libro eliminado correctamente.");
			} else {
				System.out.println("No se encontró el producto con el nombre: " + nombreLibro);
			}
		}
		
		private Libro buscarLibroPorNombre(String nombreLibro) {
			for (Libro libro : this.libros) {
				if (libro.getTitulo() == nombreLibro) {
					return libro;
				}
			}
			return null;
		}
		
		public List<Libro> buscarLibro(String nombreLibro) {
			List<Libro> librosEncontrados = new ArrayList<>();
			for (Libro producto : this.libros) {
				if (producto.getTitulo().toLowerCase().contains(nombreLibro.toLowerCase())) {
					librosEncontrados.add(producto);
				}
			}
			if (librosEncontrados.isEmpty()) {
				System.out.println("No se encontraron libros con el nombre de: " + nombreLibro);
			} else {
				System.out.println("Libros encontrados:");
				for (Libro libro : librosEncontrados) {
					System.out.println(libro);
				}
			}
			return librosEncontrados;
		}
		
		// Metodo para mostrar los libros disponibles
		public void mostrarLibros() {
			if (this.libros.isEmpty()) {
				System.out.println("No hay libros en la biblioteca.");
					return;
			}
				System.out.println("Los libros disponibles actualmente son:");
				for (Libro libro : this.libros) {
					System.out.println(libro);
				}
	}
		
	

}
