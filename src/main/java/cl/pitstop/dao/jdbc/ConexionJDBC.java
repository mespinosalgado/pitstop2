package cl.pitstop.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class for providing a JDBC connection for use only with JasperReports
 *
 * @author David Orme&ntilde;o
 */
public abstract class ConexionJDBC{
	private Connection conexion;
	private static JDBCProperties propiedades;

	/**
	 * Gets an active JDBC connection
	 *
	 * @throws ClassNotFoundException
	 *             - When drivers not found
	 * @throws SQLException
	 *             - If JDBC string got troubles
	 * @throws IOException
	 */
	public void open() throws ClassNotFoundException, SQLException, IOException{
		ConexionJDBC.propiedades = new JDBCProperties();
		Class.forName(ConexionJDBC.propiedades.getDriver());
		this.conexion = DriverManager.getConnection(ConexionJDBC.propiedades.getUrl(),
				ConexionJDBC.propiedades.getUser(), ConexionJDBC.propiedades.getPass());
	}

	/**
	 * Gets current connection
	 * @return {@link Connection}
	 */
	public Connection getConexion(){
		return this.conexion;
	}

	/**
	 * Closes the connection
	 * @throws SQLException
	 */
	public void close() throws SQLException{
		if(!this.conexion.isClosed()){
			this.conexion.close();
		}
	}

	/**
	 * Executes a SQL Select Query against JDBC conection.
	 *
	 * @param query
	 *            {@link String} SQL QueryString
	 * @return {@link ResultSet} containing the result of query or null if
	 *         exception caught
	 */
	public abstract ResultSet createSQLQuery(String query);

	/**
	 * Executes a SQL Update Query against JDBC conection.
	 *
	 * @param query
	 *            {@link String} SQL QueryString
	 * @return {@link Integer} as Statement.executeUpdate(String)
	 *
	 */
	public abstract Integer executeUpdate(String query);

}