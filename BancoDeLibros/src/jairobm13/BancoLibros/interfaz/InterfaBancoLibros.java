package jairobm13.BancoLibros.interfaz;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import jairobm13.BancoLibros.app.BancoLibros;

public class InterfaBancoLibros extends JFrame implements Observer{
	
	//------------------------------------------------
	// Constantes
	//------------------------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7190918745714203133L;

	//------------------------------------------------
	// Atributos
	//------------------------------------------------

	private BancoLibros banco;
	
	private PanelActualizar panelActualizar;
	
	private PanelAgregar panelAgregar;
	
	private PanelBuscar panelBuscar;
	
	private PanelTabla panelTabla;
	
	//------------------------------------------------
	// Constructor
	//------------------------------------------------

	public InterfaBancoLibros(){
		banco = new BancoLibros();
		banco.addObserver(this);
	}
	//------------------------------------------------
	// Metodos
	//------------------------------------------------
	
	//------------------------------------------------
	// Implementaciones
	//------------------------------------------------
	
	public void update(Observable o, Object arg) {
		
	}
	
	public static void main(String[] args) {
		
	}
}