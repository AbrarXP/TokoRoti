/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import tokoroti.model.user;
import tokoroti.view.berandaView;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import tokoroti.model.produk;
import tokoroti.view.customClass.customJButton;
import tokoroti.view.editView;
import tokoroti.view.loginView;
import tokoroti.view.tambahView;

/**
 *
 * @author LENOVO
 */
public class berandaController {
    berandaView view;
    user user;
    produk p;
    
    public berandaController(berandaView view, user user) throws SQLException {
        p = new produk();
        this.view = view;
        this.user = user;
        
        refreshProduct();
        
//        Panel home Action Listener
        view.getJudulPanel().addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    JOptionPane.showMessageDialog(null, "Anda sudah di beranda","Informasi",JOptionPane.INFORMATION_MESSAGE);
                }
        });
        
//        Tambah produk button action listener
       view.getTambahProdukBtn().addActionListener(e->{
            tambahView v = new tambahView();
            v.setVisible(true);
            new tambahController(v, p);
            try {
                refreshProduct();
            } catch (SQLException ex) {
                Logger.getLogger(berandaController.class.getName()).log(Level.SEVERE, null, ex);
            }
       });
        
        
//        Refresh Button action listener
        view.getRefreshBtn().addActionListener(e->{
            try {
                refreshProduct();
            } catch (SQLException ex) {
                Logger.getLogger(berandaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
//        Logout Button action listener
        view.getLogoutBtn().addActionListener(e->{
            //Menghapus data user dan produk
            p = null;
            this.user = null;
            JOptionPane.showMessageDialog(null,"Berhasil Log out !", "SUKSES",JOptionPane.INFORMATION_MESSAGE );
            
            view.dispose();
            loginView v = new loginView();
            v.setVisible(true);
            new loginController(v);
        });
        
//      Memperbarui gambar profile picture
        view.getLabelProfilePicture().setIcon(new javax.swing.ImageIcon(getClass().getResource(user.getProfilePicture())));
        view.getLabelUsername().setText(user.getUsername());
    }
    
    
//    Refresh produk pada beranda
    public void refreshProduct() throws SQLException{
        
        view.getPanelScrollPane().removeAll();
        ResultSet rs = p.getProduct();
        while(rs.next()){
            generateProductCard(Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(3), Double.toString(rs.getDouble(4)), rs.getString(5),Integer.toString(rs.getInt(6)));
        }
        
        view.getPanelScrollPane().revalidate();
        view.getPanelScrollPane().repaint();
    }
    
    private void generateProductCard(String id, String img, String judul, String harga, String komposisi , String stock){
        
         customJButton editBtn;
         customJButton hapusBtn;
         javax.swing.JLabel jLabel1;
         javax.swing.JPanel jPanel1;
         javax.swing.JScrollPane jScrollPane1;
         javax.swing.JLabel labelHargaProduk;
         javax.swing.JLabel labelJudulProduk;
         javax.swing.JPanel panelFoto;
         javax.swing.JPanel productCard;
         javax.swing.JTextArea deskripsiTextArea;
         javax.swing.JLabel labelStock;
        
  
        productCard = new javax.swing.JPanel();
        panelFoto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelJudulProduk = new javax.swing.JLabel();
        labelHargaProduk = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        hapusBtn = new customJButton(id);
        editBtn = new customJButton(id);
        jScrollPane1 = new javax.swing.JScrollPane();
        deskripsiTextArea = new javax.swing.JTextArea();
        labelStock = new javax.swing.JLabel();

        view.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(img))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFotoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        labelJudulProduk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelJudulProduk.setText(judul);
        
             // Membuat instance DecimalFormat dengan pola
        DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
        String hargaFormat = decimalFormat.format(Double.parseDouble(harga));

        labelHargaProduk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelHargaProduk.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelHargaProduk.setText("Rp : " +hargaFormat);

        jPanel1.setBackground(new java.awt.Color(255, 225, 80));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 30, 5));

        hapusBtn.setText("Hapus");
        jPanel1.add(hapusBtn);

        editBtn.setText("Edit");
        jPanel1.add(editBtn);

        deskripsiTextArea.setEditable(false);
        deskripsiTextArea.setColumns(20);
        deskripsiTextArea.setLineWrap(true);
        deskripsiTextArea.setRows(5);
        deskripsiTextArea.setText(komposisi);
        deskripsiTextArea.setBorder(null);
        jScrollPane1.setViewportView(deskripsiTextArea);

        labelStock.setText("Stock : " + stock);

        javax.swing.GroupLayout productCardLayout = new javax.swing.GroupLayout(productCard);
        productCard.setLayout(productCardLayout);
        productCardLayout.setHorizontalGroup(
            productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(productCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productCardLayout.createSequentialGroup()
                        .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(productCardLayout.createSequentialGroup()
                                .addComponent(labelJudulProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelHargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productCardLayout.setVerticalGroup(
            productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelJudulProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHargaProduk))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        //        Menambahkan action listener untuk setiap product card yang di print

        //        Edit Button Action Listener
        editBtn.addActionListener(e ->{
            try {
                //            Membuka editView baru           
                editView v = new editView();
                v.setVisible(true);
                
                editController c = new editController(v, p, editBtn.getIdProduct());
            } catch (SQLException ex) {
                Logger.getLogger(berandaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        //      Hapus Button Action Listener
        hapusBtn.addActionListener(e->{
           try {
               p.hapusProduct(hapusBtn.getIdProduct());
               refreshProduct();
           } catch (SQLException ex) {
               Logger.getLogger(berandaController.class.getName()).log(Level.SEVERE, null, ex);
           }
        });

        view.getPanelScrollPane().add(productCard);
        System.out.println("Berhasil menambahkan Product card pada JscrollPane");
        System.out.println(id + img + judul + harga + stock +" Generate Product end\n");
     }
    
    
}