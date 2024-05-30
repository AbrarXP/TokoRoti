/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.model;
import java.sql.*;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tokoroti.controller.connector;

/**
 *
 * @author LENOVO
 */
public class produk {
    private int id;
    private String judul;
    private double harga;
    private String komposisi;
    
    connector db;

    public produk() throws SQLException {
        db = new connector();
    }
    
    public ResultSet getProduct() throws SQLException{
        ResultSet rs;
        String SQL = "SELECT * FROM product";
        rs = db.st.executeQuery(SQL);
        return rs;
    }
    
    public ResultSet getProductSpesifik(String id) throws SQLException{
        ResultSet rs;
        String SQL = "SELECT * FROM product WHERE id = '"+id+"'";
        rs = db.st.executeQuery(SQL);
        return rs;
    }
    
    public int hapusProduct(String id){
         int affectedRow = 0;
         
         
        try {
            String SQL = "DELETE FROM `product` WHERE id = '"+id+"'";
            affectedRow = db.st.executeUpdate(SQL);
            
            if(affectedRow > 0){
                JOptionPane.showMessageDialog(null,"Berhasil Menghapus data !","Hapus Berhasil !",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(produk.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return affectedRow;
    }
    
    public int editProduct(String id, String img, String judul, String harga, String komposisi, String stock) throws SQLException{
        int affectedRow = 0;
        
        String SQL = "UPDATE `product` SET `img`='"+img+"',`judul`='"+judul+"',`harga`='"+harga+"',`komposisi`='"+komposisi+"',`stock`='"+stock+"' WHERE id ="+id+" ";
        affectedRow = db.st.executeUpdate(SQL);
        
        if(affectedRow > 0){
                JOptionPane.showMessageDialog(null,"Berhasil edit data !","SUKSES",JOptionPane.INFORMATION_MESSAGE);
        }
        
        return affectedRow;
    }
    
    public int tambahProduk(String img, String judul, String harga, String komposisi, String stock) throws SQLException{
        int affectedRow = 0;
        
        String imgKomplit = "/tokoroti/view/gambar/" + img;
        String SQL = "INSERT INTO `product`(`id`, `img`, `judul`, `harga`, `komposisi`, `stock`) VALUES (0,'"+imgKomplit+"','"+judul+"','"+harga+"','"+komposisi+"','"+stock+"')";
        affectedRow = db.st.executeUpdate(SQL);
        
        if(affectedRow > 0){
            JOptionPane.showMessageDialog(null,"Berhasil tambah data !","SUKSES",JOptionPane.INFORMATION_MESSAGE);
        }
        
        return affectedRow;
    }
    
    
}
