import java.sql.Connection;
import java.sql.DriverManager;

public class ExampleJDBC {
	
	//Definisco alcune stringhe che mi servono per la connessione al database
	public final String DB_URL = "JDBC:mysql://localhost/JDBCTUTORIAL";
	public final String USER = "Guest";
	public final String PASSWORD = "Guest123";
	public final String QUERY = "select id,first,last,age from employees"; //Query da effettuare
	
	public static void main(String[] args) {
		try{
			Connection conn = DriverManager.getConnection(DB_URL);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
