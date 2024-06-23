package libreria;

public class Libro {

	private String titulo;
	private String autor;
	private int añoPublicacion;
	private String genero;
	private int id;
	private static int contadorId = 1;
	
	public Libro(String titulo, String autor, int añoPublicacion, String genero) {
		this.id = contadorId++;
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		
	}
	
	public int getId() {
        return id;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAñoPublicacion() {
		return añoPublicacion;
	}

	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Libro [ID=" + id + ", nombre=" + titulo +  ", autor=" + autor + ", añoPublicacion="
				+ añoPublicacion + ", genero=" + genero + "]";
	}

	
}
