package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CanzoneDAO {

    public ArrayList<Canzone> doRetriveByAlbumName(String a_name){
        ArrayList<Canzone> res = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM canzone WHERE a_titolo= (?)");
            ps.setString(1,a_name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Canzone a = new Canzone(rs.getString(1),rs.getString(2));
                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void doAddSong(String c_name, String a_name){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO canzone VALUES (?,?)");
            ps.setString(1,c_name);
            ps.setString(2,a_name);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
