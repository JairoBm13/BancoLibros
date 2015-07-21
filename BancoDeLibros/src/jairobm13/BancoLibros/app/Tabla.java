package jairobm13.BancoLibros.app;

import java.util.ArrayList;

public class Tabla {
	
	//-----------------------------------
	// Atributos
	//-----------------------------------

	private String nombre;
	
	private ArrayList<String> columnas;
	
	private ArrayList<Libro> filas;

	//-----------------------------------
	// Constructor
	//-----------------------------------

	public Tabla(){
		
	}
	
	//-----------------------------------
	// Metodos
	//-----------------------------------


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
	 * @return the columnas
	 */
	public ArrayList<String> getColumnas() {
		return columnas;
	}

	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(ArrayList<String> columnas) {
		this.columnas = columnas;
	}

	/**
	 * @return the filas
	 */
	public ArrayList<Libro> getFilas() {
		return filas;
	}

	/**
	 * @param filas the filas to set
	 */
	public void setFilas(ArrayList<Libro> filas) {
		this.filas = filas;
	}	
	
	//-----------------------------------
	// Overrides
	//-----------------------------------

	public String toString(){
		return nombre + " - número filas " + filas.size(); 
	}
}
