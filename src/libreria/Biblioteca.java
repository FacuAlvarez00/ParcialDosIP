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
	
	/* Metodo para agregar el libro a la biblioteca, con validaciones para que el usuario no pueda ingresar
	el libro sin todos los datos */
	public void agregarLibro(Libro libro) {
		if (libro != null) {
			if (libro.getTitulo().isEmpty() || libro.getTitulo().isBlank()) {
				System.out.println("Error al agregar el libro, tiene que haber un nombre");
				return;
			}
			if (libro.getAutor().isEmpty() || libro.getAutor().isBlank()) {
				System.out.println("Error al agregar el autor del libro, tiene que haber un nombre");
				return;
			}
			if (libro.getGenero().isEmpty() || libro.getGenero().isBlank()) {
				System.out.println("Error al agregar el genero, tiene que ingresar el nombre de un genero");
				return;
			}
			if (libro.getAñoPublicacion() < 0) {
				System.out.println("Error al agregar el año de publicación, tiene que ingresar un año");
				return;
			}
			this.libros.add(libro);
			System.out.println("Libro agregado correctamente.");
		} else {
			System.out.println("Error al agregar el libro. El libro no puede ser nulo.");
		}
	}
	
	
	
		// Metodo para encontrar un libro 
		private Libro buscarLibroPorNombre(String nombreLibro) {
			for (Libro libro : this.libros) {
				if (libro.getTitulo().equals(nombreLibro)) {
					return libro;
				}
			}
			return null;
		}
		
	
		// metodo para eliminar libros por nombre
		public void eliminarLibro(String nombreLibro) {
			Libro libroEliminado = buscarLibroPorNombre(nombreLibro);
			if (libroEliminado != null) {
				System.out.println("Borrando libro con los datos: " + libroEliminado);
				this.libros.remove(libroEliminado);
				System.out.println("Libro eliminado correctamente.");
			} else {
				System.out.println("No se encontró el libro con el nombre de: " + nombreLibro);
			}
		}
		
	
		
		// Metodo para encontrar libros por nombre
		public List<Libro> buscarLibro(String nombreLibro) {
			List<Libro> librosEncontrados = new ArrayList<>();
			for (Libro libro : this.libros) {
				if (libro.getTitulo().toLowerCase().contains(nombreLibro.toLowerCase())) {
					librosEncontrados.add(libro);
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
		
		// Metodo para listar los libros
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
