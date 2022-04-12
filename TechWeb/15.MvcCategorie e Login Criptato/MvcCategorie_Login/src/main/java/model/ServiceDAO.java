package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceDAO {
    public ArrayList<Prodotto> doRetriveAllProd(){
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM prodotto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzo(rs.getDouble(4));
                prodotti.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotti;
    }

    public ArrayList<Categoria> doRetriveAllCat(){
        ArrayList<Categoria> categorie = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Categoria c = new Categoria();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.setDescrizione(rs.getString(3));
                categorie.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorie;
    }

    public ArrayList<Prodotto> doRetriveByCat(int id){
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        try (Connection conn = ConnPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT p.* FROM prodotto p,prod_cat pc WHERE pc.id_cat =" + id + " AND p.id_prod = pc.id_prod;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Prodotto p = new Prodotto();
                p.setId(rs.getInt(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzo(rs.getDouble(4));
                prodotti.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prodotti;
    }
}
