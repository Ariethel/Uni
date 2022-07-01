package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrelloDAO {

    public void doLoadChart(Carrello c){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO aggiunge VALUES (?,?,?)");
            ps.setString(1,c.getUsername());
            ps.setString(2,c.getPassword());
            ps.setString(3,c.getA_name());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> doRetriveById(String id){
        ArrayList<String> albumName = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM aggiunge WHERE u_email = (?)");
            ps.setString(1,id);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                albumName.add(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return albumName;
    }


    public void doEmpty(String id){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM aggiunge WHERE u_email = (?)");
            ps.setString(1,id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
