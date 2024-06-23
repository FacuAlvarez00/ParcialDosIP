package libreria;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		boolean programa = true;
		boolean primeraVez = true;
		Biblioteca biblioteca = new Biblioteca();
		
		
		
	
		
		while (programa) {
			
			 if (primeraVez) {
	                System.out.println("Bienvenido a la biblioteca, eliga una de las siguientes opciones:");
	                primeraVez = false; // Cambia la variable después de la primera iteracion
	         }
			 
			 else {
	               System.out.println("Eliga una de las siguientes opciones");
	        }
			 
			System.out.println("1 - Agregar un libro a la biblioteca");
			System.out.println("2 - Sacar un libro de la biblioteca");
			System.out.println("3 - Buscar un libro por nombre");
			System.out.println("4 - Mostrar libros");
			System.out.println("5 - Salir del programa");
			System.out.println("");
			int opcionElegida = scanner.nextInt();		
			
            scanner.nextLine();

			
			
			switch (opcionElegida){
			case 1:
				System.out.println("Ingrese el titulo del libro: ");
				String titulo = scanner.nextLine();
			
				System.out.print("Ingrese el nombre del autor: ");
				String autor = scanner.nextLine(); 
			
				
				System.out.print("Ingrese el genero del producto: ");
				String genero = scanner.nextLine();
				
				
				
				// limpio el scanner porque voy a leer un entero ahora
				System.out.print("Ingrese el año de publicación del libro: ");
				int añoPublicacion = obtenerInt();
				scanner.nextLine();
				
			

				
				Libro nuevoLibro = new Libro(titulo, autor, añoPublicacion, genero);
                biblioteca.agregarLibro(nuevoLibro);  
                
                break;
                
				
			case 2:
				System.out.print("Ingrese el nombre del libro a eliminar: ");
				titulo = scanner.nextLine();
				scanner.nextLine(); 
				biblioteca.eliminarLibro(titulo); 
				
			break;
			
			case 3:
				System.out.print("Ingrese el nombre del libro a buscar: ");
				String nombreLibro = scanner.nextLine();
				biblioteca.buscarLibro(nombreLibro); 
				
				break;
				
		
			
			case 4:
				biblioteca.mostrarLibros();
			break;
				
			case 5:
				System.out.print("Saliendo de la biblioteca...");
				programa = false;
			break;
			
			default: 
				System.out.println("No elegiste ninguna de las opciones especificadas");
			
			}
			
			 if (opcionElegida != 5) {
	             System.out.print("¿Desea continuar en la biblioteca? (si/no): ");
	             String respuesta = scanner.nextLine().trim().toLowerCase();
	             /* Uso trim para que no tenga en cuenta espacios en blanco accidentales,
	             fuerzo cualquier mayuscula a minuscula para optimizar el codigo al maximo */

	             if (respuesta.equals("no")) {
	                 programa = false;
	                 System.out.println("Programa finalizado");
	                 System.out.print("Saliendo de la biblioteca...");}
	             
	             }
		
		
		}
	
		
	scanner.close();


	}
	
	private static int obtenerInt() {
		int i = 0;
		while (i == 0) {
		try {
		int nro = scanner.nextInt();
		i = nro;
		} catch (InputMismatchException e) {
		System.out.println("Estas intentado ingresar caracteres, porfavor ingresa un numero");
		scanner.next();
		System.out.print("Ingrese valor: ");
		}
		}
		return i;

		
	}
	
	public static void generarRenglonLargo() {
		System.out.println("____________________________\n");
		}
		public static void generarRenglonCorto() {
		System.out.println("___________\n");
		}

	
	

}
