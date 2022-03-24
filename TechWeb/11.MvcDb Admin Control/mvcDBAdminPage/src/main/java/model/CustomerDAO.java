package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A small table of banking customers for testing.
 */

public class CustomerDAO {


    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */

    public Customer doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, first_name, last_name, balance FROM utente WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBalance(rs.getDouble(4));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // la funzione seguente � inutile perch� il DB � riempito tramite tool esterno
    // sarebbe utile se l'applicazione fornisse un form per riempirlo. IDEA! aggiungi questa feature all'applicazione
    // � un buon modo per verificare la sua correttezza

    public void doSave(Customer customer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (id, first_name, last_name, balance) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setDouble(4, customer.getBalance());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Customer> doRetriveAll() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try(Connection conn = ConPool.getConnection()){
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Customer c = new Customer();
                c.setId(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setBalance(rs.getDouble(4));
                customers.add(c);
            }
        }
        return customers;
    }


}

