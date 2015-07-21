package jairobm13.BancoLibros.app;

import java.util.ArrayList;
import java.util.Observable;

import jairobm13.BancoLibros.consultas.ConsultaDAO;

public class BancoLibros extends Observable{

	//------------------------------------------------
	// Atributos
	//------------------------------------------------

	private ArrayList<Tabla> tablasLibros;
	
	private Tabla tablaActual;
	
	private ConsultaDAO dao;
	
	//------------------------------------------------
	// Constructor
	//------------------------------------------------
	
	public BancoLibros(){
		dao = new ConsultaDAO();
		tablaActual = null;
		tablasLibros = cargarInfoTablas();
	}

	//------------------------------------------------
	// Metodos
	//------------------------------------------------

	private ArrayList<Tabla> cargarInfoTablas(){
		return dao.darTablasSinDatos();
	}
	
	public void agregarLibroATablaActual(String nombre, String autor, String cantidad){
		dao.agregarNuevoLibro(nombre, autor, cantidad);
	}
	
	public void actualizarLibro(Libro book, String nombre, String autor, int cantidad){
		dao.actualizarLibro(book, nombre, autor, cantidad);
	}
	
	public void quitarLibro(Libro book){
		dao.eliminarLibro(book);
	}
	
	public boolean hacerPrestamo(Libro book, String estudiante, String codigo, String correo){
		return dao.hacerPrestamo(book, estudiante, codigo, correo);
	}
	
	public ArrayList<Libro> darDatosLibroActual(){
		return dao.darDatosLibro(tablaActual);
	}
	
	public ArrayList<Libro> darPretamosEstudiante(String codigo){
		return dao.darPrestamosEstudiante();
	}
	
	public void agregarPedidoAreserva(Libro book, String estudiante, String codigo, String correo, int puestoEnCola){
		dao.agregarPedidoEnCola(book, estudiante, codigo, correo, puestoEnCola);
	}
	
	public ArrayList<String> darEnEspera(){
		return dao.darEnEspera();
	}
	//------------------------------------------------
	// Setters And getters
	//------------------------------------------------
	
	/**
	 * @return the tablasLibros
	 */
	public ArrayList<Tabla> getTablasLibros() {
		return tablasLibros;
	}
	
	/**
	 * @param tablasLibros the tablasLibros to set
	 */
	public void setTablasLibros(ArrayList<Tabla> tablasLibros) {
		this.tablasLibros = tablasLibros;
	}
	
	/**
	 * @return the tablaActual
	 */
	public Tabla getTablaActual() {
		return tablaActual;
	}
	
	/**
	 * @param tablaActual the tablaActual to set
	 */
	public void setTablaActual(Tabla tablaActual) {
		this.tablaActual = tablaActual;
	}
}