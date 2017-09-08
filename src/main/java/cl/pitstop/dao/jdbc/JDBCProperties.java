package cl.pitstop.dao.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase que lee parametros de archivos properties para setear el driver,
 * usuario, password y url de la base de datos
 * 
 * @author David Orme&ntilde;o
 */
public class JDBCProperties{
	public static final String USER = "jdbc.user";
	public static final String PASS = "jdbc.pass";
	public static final String URL = "jdbc.url";
	public static final String DRIVER = "hibernate.driver";
	
	private String url;
	private String driver;
	private String user;
	private String pass;
	
	/**
	 * Inicializa las propiedades leyendo el archivo
	 * ApplicationResources.properties
	 * 
	 * @throws IOException
	 */
	public JDBCProperties() throws IOException{
		Properties p = new Properties();
		InputStream is = JDBCProperties.class.getResourceAsStream("/resources/pitstop.properties");
		p.load(is);
		is.close();
		this.url = p.getProperty(JDBCProperties.URL);
		this.driver = p.getProperty(JDBCProperties.DRIVER);
		this.user = p.getProperty(JDBCProperties.USER);
		this.pass = p.getProperty(JDBCProperties.PASS);
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getDriver(){
		return this.driver;
	}
	
	public void setDriver(String driver){
		this.driver = driver;
	}
	
	public String getUser(){
		return this.user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public String getPass(){
		return this.pass;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}
}
