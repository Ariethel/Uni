package model;

import com.mysql.cj.jdbc.Blob;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlbumDAO {
    public void doInsertAlbum(Album a){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO album VALUES(?,?,?,?)");
            ps.setString(1,a.getTitolo());
            ps.setDouble(2,a.getPrezzo());
            ps.setBlob(3, a.getImg());
            ps.setBoolean(4,a.isHomepage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Album> doGetHomePage() throws FileNotFoundException {
        ArrayList<Album> album = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM album WHERE homepage = TRUE ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Album a = new Album(rs.getString(1), rs.getDouble(2),null, rs.getBoolean(4));
                album.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }

    public byte[] load(String id) throws FileNotFoundException {
        byte[] bt = null;
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT copertina FROM album WHERE a_titolo = (?) ");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bt = rs.getBytes("copertina");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bt;
    }
}
