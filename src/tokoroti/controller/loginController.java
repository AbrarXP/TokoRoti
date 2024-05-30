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
import tokoroti.model.user;
import tokoroti.view.berandaView;
import tokoroti.view.loginView;

/**
 *
 * @author LENOVO
 */
public class loginController {
    user user;
    public loginController(loginView loginPage) {
        
        loginPage.getLoginBtn().addActionListener((var e)->{
            try {
                user = new user(0,"","","","");
                String tryUser =  loginPage.getInputUsername().getText();
                String tryPass =  loginPage.getInputPassword().getText();
                
                if(tryUser.isEmpty() || tryPass.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Username atau Password tidak boleh kosong !", "Peringatan !", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    
//                    Verifikasi user dan menyimpan data user jika ada
                     user = user.login(tryUser, tryPass);
                    if(user != null){                       
                        //                        memuat beranda
                        berandaView v = new berandaView();
                        v.setVisible(true);
                        
                        new berandaController(v, user);
                        loginPage.dispose();
                    }
                    else{
                        System.out.println("Gagal login !");
                    }
                }
               
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
}
