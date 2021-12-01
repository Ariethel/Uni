import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleJDBC {
	
	//Definisco alcune stringhe che mi servono per la connessione al database
	public final static String DB_URL = "JDBC:mysql://localhost/unisa2022";
	public final static String USER = "root";
	public final static String PASSWORD = "passwd";
	public final static String QUERY = "select nome,cognome,stipendio from impiegati"; //Query da effettuare
	
	public static void main(String[] args) {
		//Controllo sia caricato il driver per connettermi a MySQL
		try{
		    Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
		    e.printStackTrace();
		}
		
		
		
		try{ 
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD); //Creo la connessione
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY); //Eseguo la query e carico i risultati in rs
			while(rs.next()) { //stampo i vari risultati della query
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Cognome: " + rs.getString("cognome"));
				System.out.println("Stipendio: " + rs.getString("Stipendio"));

			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
		 
}

