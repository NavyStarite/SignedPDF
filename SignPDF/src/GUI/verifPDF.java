/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import interfaz.Interfaz;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Escuela
 */
public class verifPDF extends javax.swing.JFrame {
private FileNameExtensionFilter filterPDF = new FileNameExtensionFilter("Archivos .pdf", "pdf");
private FileNameExtensionFilter filterKEY = new FileNameExtensionFilter("Archivos .key", "key");
    /**
     * Creates new form verifPDF
     */
    public verifPDF() {
        this.setTitle("Verificar PDF");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 428));
        setPreferredSize(new java.awt.Dimension(400, 428));
        getContentPane().setLayout(new java.awt.GridLayout(4, 1));

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Verificar PDF");
        jPanel1.add(jLabel1, "card2");

        getContentPane().add(jPanel1);

        jLabel5.setText("Llave Publica");
        jPanel6.add(jLabel5);

        jTextField4.setEditable(false);
        jTextField4.setToolTipText("");
        jTextField4.setMinimumSize(new java.awt.Dimension(200, 30));
        jTextField4.setName(""); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(200, 30));
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keySelector(evt);
            }
        });
        jPanel6.add(jTextField4);

        getContentPane().add(jPanel6);

        jLabel6.setText("PDF firmado");
        jPanel7.add(jLabel6);

        jTextField5.setEditable(false);
        jTextField5.setToolTipText("");
        jTextField5.setMinimumSize(new java.awt.Dimension(200, 30));
        jTextField5.setName(""); // NOI18N
        jTextField5.setPreferredSize(new java.awt.Dimension(200, 30));
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdfSelector(evt);
            }
        });
        jPanel7.add(jTextField5);

        getContentPane().add(jPanel7);

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        jButton2.setText("Generar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
            Interfaz i = (Interfaz)reg.lookup("sign");
            if (i.verificar(i.getpdfText(jTextField5.getText()), i.cargarPublicaKey(jTextField4.getText()))) {
                JOptionPane.showMessageDialog(null,"Es un archivo valido.");
            }
            else{
                JOptionPane.showMessageDialog(null,"El archivo no es valido, puede estar dañado, esta alterado o no es original.");
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null,"Servidor no disponible.");
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    //System.exit(1);
        } catch (NotBoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    //System.exit(1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Archivo no encontrado.");
            Logger.getLogger(genPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(genPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            JOptionPane.showMessageDialog(null,"Llave Invalida.");
            Logger.getLogger(genPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pdfSelector(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdfSelector
        try {
            JFileChooser filechoose = new JFileChooser();
            filechoose.setFileFilter(filterPDF);
            int opcion = filechoose.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {
                
                //Obtener ruta
                String ruta = filechoose.getSelectedFile().getPath();
                jTextField5.setText(ruta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_pdfSelector

    private void keySelector(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keySelector
        try {
            JFileChooser filechoose = new JFileChooser();
            filechoose.setFileFilter(filterKEY);
            int opcion = filechoose.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {
                
                //Obtener ruta
                String ruta = filechoose.getSelectedFile().getPath();
                jTextField4.setText(ruta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_keySelector

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
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
            java.util.logging.Logger.getLogger(verifPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(verifPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(verifPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(verifPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new verifPDF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
