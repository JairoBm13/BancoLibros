package jairobm13.BancoLibros.app;

public class Libro {
	
	//---------------------------------------------
	// Atributos
	//---------------------------------------------

	private String nombre;
	
	private String autor;
	
	private int cantidad;
	
	private String disponibilidad;
	
	//---------------------------------------------
	// Constructor
	//---------------------------------------------

	public Libro(){
		
	}
	
	//---------------------------------------------
	// Metodos
	//---------------------------------------------

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the disponibilidad
	 */
	public String isDisponibilidad() {
		return disponibilidad;
	}

	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	public void aumentarCantidadLibro(){
		cantidad++;
		disponibilidad = (cantidad>0) ? "Si" : "No";
	}
	
	public void disminuirCantidadLibro(){
		cantidad--;
		disponibilidad = (cantidad>0) ? "Si" : "No";
	}

	//---------------------------------------------
	//
	//---------------------------------------------
}