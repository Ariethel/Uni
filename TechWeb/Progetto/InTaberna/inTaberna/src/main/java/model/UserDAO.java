package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public ArrayList<Utente> doRetriveAllUsers() {
        ArrayList<Utente> utenti = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utente u = new Utente();
                u.setEmail(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setTipo(rs.getString(3));
                utenti.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }

    public ArrayList<Utente> doRetriveByEmail(String email) {
        ArrayList<Utente> utenti = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE email= " + email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utente u = new Utente();
                u.setEmail(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setTipo(rs.getString(3));
                utenti.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }

    public void doAddUser(String email, String password, String tipo){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO utente VALUES (" + email + "," + password + "," + tipo + ");");
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
