/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signpdf;
import java.rmi.*;
import GUI.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Escuela
 */
public class SignPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        genPDF gen = new genPDF();
        verifPDF verif = new verifPDF();
        menu.runNow();
        gen.runNow();
        gen.setVisible(false);
        verif.runNow();
        verif.setVisible(false);
        
        
        
        
        
        verif.getM().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                men(evt);
            }

            private void men(ActionEvent evt) {
                verif.setVisible(false);
                menu.setVisible(true);
            }
        });
        gen.getM().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                men(evt);
            }

            private void men(ActionEvent evt) {
                gen.setVisible(false);
                menu.setVisible(true);
            }
        });
        menu.getV().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver(evt);
            }

            private void ver(ActionEvent evt) {
                verif.setVisible(true);
                menu.setVisible(false);
            }
        });
        menu.getG().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gen(evt);
            }

            private void gen(ActionEvent evt) {
                 gen.setVisible(true);
                menu.setVisible(false);
            }
        });

        

    }
    
}
