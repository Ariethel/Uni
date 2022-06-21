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
        Blob blob; //Blob che prendo dal db
        byte b[]; //Array di bytes
        File img = null;
        FileOutputStream fos = new FileOutputStream(img);
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM album WHERE homepage = TRUE ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                blob= (Blob) rs.getBlob("copertina"); //Prendo la copertina in formato blob dal db
                b=blob.getBytes(1,(int)blob.length()); //La trasformo in una stream di bytes
                fos.write(b); //Scrivo la copertina su un file
                FileInputStream in = new FileInputStream(img);
                Album a = new Album(rs.getString(1), rs.getDouble(2),in, rs.getBoolean(4));
                album.add(a);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return album;
    }
}
