/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti;

import tokoroti.controller.loginController;
import tokoroti.view.loginView;

/**
 *
 * @author LENOVO
 */
public class TokoRoti {

    
    public static void main(String[] args) {
        loginView v = new loginView();
        v.setVisible(true);
        
        new loginController(v);
    }
    
}
