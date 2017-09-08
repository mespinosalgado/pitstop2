package cl.pitstop.dao.jdbc;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

/**
 * Class for providing a JDBC connection for use only with JasperReports
 *
 * @author David Orme&ntilde;o
 */
public class ConexionJDBCImpl extends ConexionJDBC{
	Statement statement;

	public ConexionJDBCImpl(){
		try{
			super.open();
			this.statement = (Statement) super.getConexion().createStatement();
		}catch(final SQLException e){
			e.printStackTrace();

		}catch(final ClassNotFoundException e){
			e.printStackTrace();
		}catch(final IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * Executes a SQL Query against JDBC conection.
	 *
	 * @param query
	 *            {@link String} SQL QueryString
	 * @return {@link ResultSet} containing the result of query or null if
	 *         exception caught
	 */
	@Override
	public ResultSet createSQLQuery(String query){
		try{
			final ResultSet rs = this.statement.executeQuery(query);
			return rs;
		}catch(final SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer executeUpdate(String query){
		try{
			return this.statement.executeUpdate(query);
		}catch(final SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}