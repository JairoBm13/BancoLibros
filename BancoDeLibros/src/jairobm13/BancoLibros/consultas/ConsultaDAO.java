package jairobm13.BancoLibros.consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jairobm13.BancoLibros.app.Libro;
import jairobm13.BancoLibros.app.Tabla;

public class ConsultaDAO {

	//-----------------------------------------------
	// Atributos
	//-----------------------------------------------
	private Connection conexion;

	private String usuario;

	private String clave;

	private String url;

	//-----------------------------------------------
	// Metodos
	//-----------------------------------------------
	private void inicializar(){
		try {
			url =  "jdbc:mysql://127.0.01:3306/BancoLibros";
			usuario = "root";
			clave = "admin";
			final String driver = "com.mysql.jdbc.Drive";
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void conectar(String url, String usuario, String clave){
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.01:3306/BancoLibros","root", "admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void desconectar(Connection connection){
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//-------------------------------------------------------
	// Consultas
	//-------------------------------------------------------

	public ArrayList<Tabla> darTablasSinDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarNuevoLibro(String nombre, String autor, String cantidad) {
		// TODO Auto-generated method stub

	}

	public void actualizarLibro(Libro book, String nombre, String autor, int cantidad) {
		// TODO Auto-generated method stub

	}

	public void eliminarLibro(Libro book) {
		// TODO Auto-generated method stub

	}

	public boolean hacerPrestamo(Libro book, String estudiante, String codigo, String correo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Libro> darDatosLibro(Tabla tablaActual) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Libro> darPrestamosEstudiante() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarPedidoEnCola(Libro book, String estudiante, String codigo, String correo, int puestoEnCola) {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> darEnEspera() {
		// TODO Auto-generated method stub
		return null;
	}

	//--------------------------------------------------------------
	// Generadores TODO
	//--------------------------------------------------------------

	/**
	 * Genera una cadena de texto que representa una sentencia SQL para seleccionar información.
	 * @param select
	 * @param tabla
	 * @param where
	 * @param order
	 * @param group
	 * @return
	 */
	private String generateQuery(ArrayList<String> select, String tabla, ArrayList<String> where, ArrayList<String> order, ArrayList<String> group){
		String query = "SELECT ";
		// Lista los atributos del registro que van a ser seleccionados
		Iterator<String> iteraSelect = select.iterator();
		while(iteraSelect.hasNext()){
			String act = iteraSelect.next();
			if(iteraSelect.hasNext()){
				query += act+", ";
			}
			else{
				query += act;
			}
		}

		// Indica de que tabla va a sacar los registros
		query += " FROM "+tabla+" ";

		// Lista las condiciones del por las que se va a seleccionar
		if(!where.isEmpty()){
			query += " WHERE ";
			Iterator<String> iteraWhere = where.iterator();
			while(iteraWhere.hasNext()){
				String act = iteraWhere.next();
				if(iteraWhere.hasNext()){
					query += act+"AND ";
				}
				else{
					query += act;
				}
			}
		}

		// Lista por que atributos se va a agrupar
		if(!group.isEmpty()){
			query += " GROUP BY ";
			Iterator<String> iteraGroup = group.iterator();
			while(iteraGroup.hasNext()){
				String act = iteraGroup.next();
				if(iteraGroup.hasNext()){
					query += act+", ";
				}
				else{
					query += act;
				}
			}
		}

		// Lista por que atributos se ordenara
		if(!order.isEmpty()){
			query += " ORDER BY ";
			Iterator<String> iteraOrder = order.iterator();
			while(iteraOrder.hasNext()){
				String act = iteraOrder.next();
				if(iteraOrder.hasNext()){
					query += act+", ";
				}
				else{
					query += act;
				}
			}
		}
		return query;
	}

	/**
	 * Genera una cadena de texto que representa una sentencia SQL para seleccionar información, para update.
	 * @param select
	 * @param tabla
	 * @param where
	 * @param order
	 * @param group
	 * @return
	 */
	private String generateQueryForUpdate(ArrayList<String> select, String tabla, ArrayList<String> where, ArrayList<String> order, ArrayList<String> group){
		String query = "SELECT ";
		// Lista los atributos del registro que van a ser seleccionados
		Iterator<String> iteraSelect = select.iterator();
		while(iteraSelect.hasNext()){
			String act = iteraSelect.next();
			if(iteraSelect.hasNext()){
				query += act+", ";
			}
			else{
				query += act;
			}
		}

		// Indica de que tabla va a sacar los registros
		query += " FROM "+tabla+" ";

		// Lista las condiciones del por las que se va a seleccionar
		if(!where.isEmpty()){
			query += " WHERE ";
			Iterator<String> iteraWhere = where.iterator();
			while(iteraWhere.hasNext()){
				String act = iteraWhere.next();
				if(iteraWhere.hasNext()){
					query += act+"AND ";
				}
				else{
					query += act;
				}
			}
		}

		// Lista por que atributos se va a agrupar
		if(!group.isEmpty()){
			query += " GROUP BY ";
			Iterator<String> iteraGroup = group.iterator();
			while(iteraGroup.hasNext()){
				String act = iteraGroup.next();
				if(iteraGroup.hasNext()){
					query += act+", ";
				}
				else{
					query += act;
				}
			}
		}

		// Lista por que atributos se ordenara
		if(!order.isEmpty()){
			query += " ORDER BY ";
			Iterator<String> iteraOrder = order.iterator();
			while(iteraOrder.hasNext()){
				String act = iteraOrder.next();
				if(iteraOrder.hasNext()){
					query += act+", ";
				}
				else{
					query += act;
				}
			}
		}

		//Indica que es para actualizar

		query += " FOR UPDATE";
		return query;
	}

	/**
	 * Genera una cadena de texto que representa una sentencia SQL de update
	 * @param tabla
	 * @param columns
	 * @param values
	 * @param where
	 * @return
	 */
	private String generateUpdate(String tabla, ArrayList<String> columns, ArrayList<String> values , ArrayList<String> where){
		String query = "UPDATE ";

		// Indica de que tabla que se va a actualizar
		query += tabla+" SET ";

		// Lista los atributos del registro que van a ser seleccionados
		Iterator<String> iteraColumns = columns.iterator();
		Iterator<String> iteraValues = values.iterator();
		while(iteraColumns.hasNext()){
			while(iteraValues.hasNext())
			{
				String col = iteraColumns.next();
				String val = iteraValues.next();
				if(iteraColumns.hasNext()&&iteraValues.hasNext()){
					query += col+" = "+val+", ";
				}
				else{
					query += col+" = "+val;
				}
			}

		}

		// Lista las condiciones del por las que se va a actualizar
		if(!where.isEmpty()){
			query += " WHERE ";
			Iterator<String> iteraWhere = where.iterator();
			while(iteraWhere.hasNext()){
				String act = iteraWhere.next();
				if(iteraWhere.hasNext()){
					query += act+"AND ";
				}
				else{
					query += act;
				}
			}
		}

		return query;
	}

	/**
	 * 
	 * @param tabla
	 * @param columns
	 * @param values
	 * @return
	 */
	private String generateInsert(String tabla, ArrayList<String> columns, ArrayList<String> values){
		String query = "INSERT INTO ";

		// Indica de que tabla que se va a insertar
		query += tabla+" ( ";

		// Lista las columnas en las que se va a insertar
		Iterator<String> iteraColumns = columns.iterator();
		while(iteraColumns.hasNext()){
			String act = iteraColumns.next();
			if(iteraColumns.hasNext()){
				query += act+", ";
			}
			else{
				query += act+" ) ";
			}
		}

		// Lista los atributos que se van a insertar
		query += " VALUES ( ";

		Iterator<String> iteraValues = values.iterator();
		while(iteraValues.hasNext()){
			String act = iteraValues.next();
			if(iteraValues.hasNext()){
				query += act+", ";
			}
			else{
				query += act+" ) ";
			}
		}
		return query;
	}

	private String pagination(String sentencia, int pagina, int cantidad){
		if(pagina==-1)
			return sentencia;
		else
			return "select * from "
			+ "( select  /*+FIRST_ROWS("+cantidad+") */a.*, rownum rnum "
			+ "from ("+sentencia+" order by codigo) a "
			+ "where rownum <= "+(pagina)*cantidad+") "
			+ "where rnum >="+(((pagina-1)*cantidad)+1);
	}
}
