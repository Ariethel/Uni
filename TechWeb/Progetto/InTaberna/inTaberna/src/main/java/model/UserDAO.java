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
                Utente u = new Utente(rs.getString(1),rs.getString(2),rs.getString(3));
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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente u WHERE u.email= ?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utente u = new Utente(rs.getString(1), rs.getString(2), rs.getString(3));
                utenti.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }

    public boolean doCheckEmail(String email){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE email = ?");
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            boolean val = rs.next(); //True se la query restituisce qualche risultato
            if (val) {
                return true; // L'username e' gia' preso
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false; //username disponibile
    }

    public boolean doCheckAdmin(String email){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE email = ? AND tipo = ?");
            ps.setString(1,email);
            ps.setString(2,"admin");
            ResultSet rs = ps.executeQuery();
            boolean val = rs.next(); //True se la query restituisce qualche risultato
            if (val) {
                return true; // L'username e' gia' preso
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false; //username disponibile
    }

    public boolean doCheckPassword(String username, String password){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM utente WHERE email = ? AND pass = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            boolean val = rs.next();
            if (val) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }

    public void doAddUser(Utente utente){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO utente VALUES (?,?,?)");
            ps.setString(1, utente.getEmail());
            ps.setString(2, utente.getPassword());
            ps.setString(3,utente.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doUpdateUser(String id, String email,String pass, String tipo){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE utente SET email = (?), pass = (?), tipo = (?) WHERE email = (?)");
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, tipo);
            ps.setString(4,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doDeleteById(String id){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM utente WHERE email = (?)");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
