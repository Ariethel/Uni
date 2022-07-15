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


    public ArrayList<Album> doGetLiveSearch(String str){
        ArrayList<Album> album = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM album WHERE a_titolo like '%"+str+"%'");
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



    public ArrayList<Album> doRetriveAllAlbums() {
        ArrayList<Album> album = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM album");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Album a = new Album(rs.getString(1),rs.getDouble(2),null,rs.getBoolean(4));
                album.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album;
    }


    public ArrayList<Album> doRetriveByTitle(String title) {
        ArrayList<Album> res = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM album WHERE a_titolo= ?");
            ps.setString(1,title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Album a = new Album(rs.getString(1),rs.getDouble(2),null,rs.getBoolean(4));
                res.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }


    public void doUpdateAlbum(String id, String title, Double prezzo){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE album SET a_titolo = (?), prezzo = (?), homepage = false WHERE a_titolo = (?)");
            ps.setString(1, title);
            ps.setDouble(2, prezzo);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doUpdateAlbumComplete(String id, String title, Double prezzo){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE album SET a_titolo = (?), prezzo = (?), homepage = true WHERE a_titolo = (?)");
            ps.setString(1, title);
            ps.setDouble(2, prezzo);
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public double doGetPrice(String name){
        double res = 0;
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT prezzo FROM album WHERE a_titolo= ?");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void doDeleteById(String id){
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM album WHERE a_titolo = (?)");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

