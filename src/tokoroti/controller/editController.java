/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tokoroti.model.produk;
import tokoroti.view.editView;

/**
 *
 * @author LENOVO
 */
public class editController {
    String id;
    produk p;
    editView view;

    public editController(editView view, produk p,  String id) throws SQLException {
        this.id = id;
        this.p = p;
        this.view = view;
        
        muatData(id);
        
        view.getSubmitBtn().addActionListener(e->{
            
            try {
                String img = view.getInputGambar().getText();
                String judul = view.getInputJudul().getText();
                String harga = view.getInputHarga().getText();
                String komposisi = view.getInputKomposisi().getText();
                String stock = view.getInputStock().getText();
                
                if(img.isEmpty() || judul.isEmpty() || harga.isEmpty() || komposisi.isEmpty() || stock.isEmpty()){
                    JOptionPane.showMessageDialog(null, "INPUTAN TIDAK BOLEH KOSONG !", "PERINGATAN !", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    int affectedRow = p.editProduct(id, img, judul, harga, komposisi, stock);
                    view.dispose();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(editController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
    
    private void muatData(String id) throws SQLException{
        
        ResultSet rs = p.getProductSpesifik(id);
        if(rs.next()){
            view.getLabelID().setText("ID Produk : " + Integer.toString(rs.getInt(1)));
            view.getInputGambar().setText(rs.getString(2));
            view.getInputJudul().setText(rs.getString(3));
            view.getInputHarga().setText(Double.toString(rs.getDouble(4)));
            view.getInputKomposisi().setText(rs.getString(5));
            view.getInputStock().setText(Integer.toString(rs.getInt(6)));
        }
        
    }
}
