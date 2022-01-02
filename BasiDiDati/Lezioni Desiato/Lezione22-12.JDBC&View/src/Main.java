import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public class Main {
	static final String DB_URL = "jdbc:mysql://localhost/ufficio";
	static final String USER = "root";
	static final String PASS = "HLJ*2e6m";


	static final String QUERY1 = "select i1.nome\n"
			+ "from impiegati i1,impiegati i2\n"
			+ "where i1.cognome = i2.cognome and i1.nome != i2.nome and i1.dipart = \"Produzione\" and i2.dipart = \"Produzione\";";

	static final String QUERY2 = "select i.nome as nome, i.stipendio as stipendio\n"
			+ "from impiegati i\n"
			+ "where i.dipart = \"Amministrazione\" and i.stipendio > 40;";

	static final String QUERY3 = "select i.*\n"
			+ "from impiegati i\n"
			+ "order by i.nome,i.cognome;";


	static final String QUERY4 = "select i.*\n"
			+ "from impiegati i\n"
			+ "order by i.stipendio desc;";


	static final String QUERY5 = "select count(*) as conta\n"
			+ "from impiegati i\n"
			+ "group by i.dipart\n"
			+ "having i.dipart = \"Produzione\";";


	static final String QUERY6 = "select  count(distinct i.stipendio) as conta\n"
			+ "from impiegati i;";


	static final String QUERY7 = "select sum(i.stipendio) somma\n"
			+ "from impiegati i\n"
			+ "where i.dipart = \"Amministrazione\";";

	public static void main(String[] args) throws SQLException {

		//Query 1
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY1);){
			while (rs.next()) {
				System.out.println(rs.getString("Nome"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}


		//Query 2
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY2);){
			while (rs.next()) {
				System.out.println(rs.getString("Nome")+rs.getInt("stipendio"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}


		//Query 3
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY3);){
			while (rs.next()) {
				System.out.println(rs.getString("Nome")+rs.getString("Cognome"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}


		//Query 4
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY4);){
			while (rs.next()) {
				System.out.println(rs.getString("Nome") + rs.getString("Cognome") + rs.getInt("Stipendio"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}



		//Query 5
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY5);){
			while (rs.next()) {
				System.out.println(rs.getInt("conta"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}


		//Query 6
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY6);){
			while (rs.next()) {
				System.out.println(rs.getInt("conta"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}


		//Query 7
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY7);){
			while (rs.next()) {
				System.out.println(rs.getInt("somma"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
