/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tokoroti.model.produk;
import tokoroti.view.tambahView;

/**
 *
 * @author LENOVO
 */
public class tambahController {

    public tambahController(tambahView view, produk p) {
        view.getSubmitBtn().addActionListener(e->{
            try {
                System.out.println("Tambah btn tertekan !");
                String img = view.getInputGambar().getText();
                String judul = view.getInputJudul().getText();
                String harga = view.getInputHarga().getText();
                String komposisi = view.getInputKomposisi().getText();
                String stock = view.getInputStock().getText();
                
                if(img.isEmpty() || judul.isEmpty() || harga.isEmpty() || komposisi.isEmpty() || stock.isEmpty()){
                    JOptionPane.showMessageDialog(null, "INPUTAN TIDAK BOLEH KOSONG !", "PERINGATAN !", JOptionPane.WARNING_MESSAGE);
                }
                else{
                     p.tambahProduk(img, judul, harga, komposisi, stock);
                     view.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(tambahController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
