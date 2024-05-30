/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoroti.view.customClass;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author LENOVO
 */
public class customJButton extends JButton{
    private String idProduct;

    public customJButton(String idProduct) {
        this.idProduct = idProduct;
        this.setFocusable(false);
        this.setBackground(Color.WHITE);
    }

    public String getIdProduct() {
        return idProduct;
    }
}
