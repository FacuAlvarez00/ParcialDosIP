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
			System.out.println("2 - Mostrar libros");
			System.out.println("3 - Buscar un libro por nombre");
			System.out.println("4 - Sacar un libro de la biblioteca");
			System.out.println("5 - Salir del programa");
			generarRenglonLargo();
			
			int opcionElegida = -1;		
			
			
			// comprobacion para que el programa no deje de ejecutarse en caso de que el usuario no eliga un numero
			while (true) {
				// chequeo la entrada del usuario
                try {
                    opcionElegida = scanner.nextInt();
                    scanner.nextLine(); 
                    break; 
                    // si se captura el error, osea se escribe algo que no sea un entero voy a recibir el mensaje 
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un numero que corresponda al menu.");
                    scanner.next(); 
                }
            }
			
           
            generarRenglonLargo();

			
			
			switch (opcionElegida){
			
			// Opcion 1 para agregar un libro a la biblioteca, se piden datos al usuario
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
				
				generarRenglonCorto();
				Libro nuevoLibro = new Libro(titulo, autor, añoPublicacion, genero);
                biblioteca.agregarLibro(nuevoLibro);  
                generarRenglonCorto();
                
                break;
                
                // Muestro el array de libros que esta en la biblioteca
			case 2:
                generarRenglonCorto();
				biblioteca.mostrarLibros();
                generarRenglonCorto();
			break;
               
				// Traigo el metodo para mostrar un libro
			case 3:
				System.out.print("Ingrese el nombre del libro a buscar: ");
				String nombreLibro = scanner.nextLine();
                generarRenglonCorto();
				biblioteca.buscarLibro(nombreLibro); 
                generarRenglonCorto();

				break;
				
				// Traigo el metodo para eliminar un libro
			case 4:
				System.out.print("Ingrese el nombre del libro a eliminar: ");
				titulo = scanner.nextLine();
                generarRenglonCorto();
				biblioteca.eliminarLibro(titulo); 
                generarRenglonCorto();
                break;
			
				/* En caso de qu el usuario ingrese 5 se va a cambiar la variable programa a false asi
                se termina el while y el programa */
			case 5:
				System.out.print("Saliendo de la biblioteca...");
				programa = false;
			break;
			
			
				// Si no se elige ningun numero entre 1 y 5 se va a recibir este mensaje
			default: 
				System.out.println("No elegiste ninguna de las opciones especificadas");
			
			}
			
			 if (opcionElegida != 5) {
	             System.out.print("¿Desea continuar en la biblioteca? (si/no): ");
	             String respuesta = scanner.nextLine().trim().toLowerCase();
	             generarRenglonLargo();
	             /* Uso trim para que no tenga en cuenta espacios en blanco accidentales,
	             fuerzo cualquier mayuscula a minuscula para optimizar el codigo al maximo */

	             if (respuesta.equals("no")) {
	                 programa = false;
		             generarRenglonLargo();
	                 System.out.println("Programa finalizado");
	                 System.out.print("Saliendo de la biblioteca...");}
	             
	             
	             }
		
		
		}
	
		
	scanner.close();
	// cierro el scanner para evitar cualquier tipo de problema


	}
	
	
	// metodo con bloque try-catch para atrapar el error de input erroneo asi el programa se sigue ejecutando
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
	
	// renglones para separar
	public static void generarRenglonLargo() {
		System.out.println("____________________________\n");
		}
		public static void generarRenglonCorto() {
		System.out.println("___________\n");
		}


}
