/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaz.Interfaz;
import java.io.File;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import variables.ipPort;

/**
 *
 * @author Escuela
 */
public class Menu extends javax.swing.JFrame {
    private ipPort conexion = new ipPort();
    /**
     * Creates new form Menu
     */
    public Menu(){
        this.setTitle("Menu");
        try {
            Registry reg = LocateRegistry.getRegistry(conexion.getIp(),conexion.getPort());
            Interfaz i = (Interfaz)reg.lookup("sign");
            i.makeDirectory(new File("Keys"));
            i.makeDirectory(new File("Docs"));
            initComponents();
        } catch (RemoteException ex) {
            
            JOptionPane.showMessageDialog(null,"Servidor no disponible");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (NotBoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bienvenido, ¿Que deseas hacer?");
        jLabel1.setMinimumSize(new java.awt.Dimension(399, 100));
        jLabel1.setPreferredSize(new java.awt.Dimension(399, 100));
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2);

        jPanel1.setMinimumSize(new java.awt.Dimension(399, 200));
        jPanel1.setPreferredSize(new java.awt.Dimension(399, 200));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Generar llaves");
        jButton1.setMaximumSize(new java.awt.Dimension(133, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(133, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(133, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setText("Generar PDF firmado");
        jPanel1.add(jButton2);

        jButton3.setText("Verificar PDF");
        jButton3.setMaximumSize(new java.awt.Dimension(133, 23));
        jButton3.setMinimumSize(new java.awt.Dimension(133, 23));
        jButton3.setPreferredSize(new java.awt.Dimension(133, 23));
        jPanel1.add(jButton3);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Registry reg = LocateRegistry.getRegistry(conexion.getIp(),conexion.getPort());
            Interfaz i = (Interfaz)reg.lookup("sign");
            i.guardarKey(i.getPrivate(), "Keys/privKey");
            JOptionPane.showMessageDialog(null,"Llave privada generada en la carpeta Keys.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar la llave privada.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Registry reg = LocateRegistry.getRegistry(conexion.getIp(),conexion.getPort());
            Interfaz i = (Interfaz)reg.lookup("sign");
            i.guardarKey(i.getPublic(), "Keys/pubKey");
            JOptionPane.showMessageDialog(null,"Llave publica generada en la carpeta Keys.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar la llave publica.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public JButton getV() {
        return jButton3;
    }

    public JButton getG() {
        return jButton2;
    }

    public void runNow() {
        this.setVisible(true);
    }
}
