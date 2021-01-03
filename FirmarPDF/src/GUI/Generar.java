package GUI;

import generadordellaves.MetodosLLaves;
import firmarpdf.MetodosLLaves2;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

import javax.swing.*;

public class Generar extends javax.swing.JFrame {

    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    Document doc;

    public Generar() throws NoSuchAlgorithmException {
        MetodosLLaves llaves = new MetodosLLaves();
        initComponents();

    }

    public String GuardarArchivo(File Archivo, java.security.PublicKey publica) {
        String mensaje = "";
        try {
            salida = new FileOutputStream(archivo);
            byte[] key = publica.getEncoded();
            salida.write(key);
            salida.close();
            mensaje = "Archivos Keys Guardado";
        } catch (Exception e) {
            System.out.println("[Error]: " + e);
        }
        return mensaje;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(514, 400));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(514, 75));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar");
        jPanel1.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sube los archivos que se te piden e ingresa tus archivos.");
        jPanel1.add(jLabel2);

        getContentPane().add(jPanel1);

        jPanel3.setMinimumSize(new java.awt.Dimension(512, 325));
        jPanel3.setPreferredSize(new java.awt.Dimension(512, 325));
        jPanel3.setLayout(new java.awt.GridLayout(5, 1));

        jLabel3.setText("Nombre");
        jPanel4.add(jLabel3);

        jTextField1.setText("jTextField1");
        jPanel4.add(jTextField1);

        jPanel3.add(jPanel4);

        jLabel4.setText("Edad");
        jPanel5.add(jLabel4);

        jTextField2.setText("jTextField2");
        jPanel5.add(jTextField2);

        jPanel3.add(jPanel5);

        jLabel5.setText("Mensaje");
        jPanel6.add(jLabel5);

        jTextField3.setText("jTextField3");
        jPanel6.add(jTextField3);

        jPanel3.add(jPanel6);

        jLabel6.setText("Firma");
        jPanel7.add(jLabel6);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel7.add(jScrollPane1);

        jPanel3.add(jPanel7);

        jButton1.setText("Volver");
        jPanel8.add(jButton1);

        jButton2.setText("Generar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2);

        jButton3.setText("Guardar Keys");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton3);

        jPanel3.add(jPanel8);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//guardar PDF
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            String nombre = jTextField1.getText();
            String edad = jTextField2.getText();
            String mensaje = jTextField3.getText();

            MetodosLLaves llaves = new MetodosLLaves();
            MetodosLLaves2 llaves2 = new MetodosLLaves2();
            //llaves.MetodosLLaves();
            llaves.MetodosLLaves();
            //llaves.guardarLlavePublica(llaves.MetodosLLaves().getPublic());
            //llaves.guardarLlavePrivada(llaves.MetodosLLaves().getPrivate());
            String firma = llaves2.FirmarDatoS(mensaje.getBytes(), llaves.MetodosLLaves().getPrivate());
            jTextArea1.setText(firma);

            if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                if (archivo.getName().endsWith("pdf")) {
                    //String msjkeys = GuardarArchivo(archivo, llaves.MetodosLLaves().getPublic());
                    try {
                        salida = new FileOutputStream(seleccionar.getSelectedFile());
                        doc = new Document();
                        PdfWriter.getInstance(doc, salida);
                        doc.open();
                        Font f = new Font();
                        f.setStyle(Font.BOLD);
                        f.setSize(15);
                        Paragraph paragraph = new Paragraph();
                        paragraph.add(new Paragraph("Firma:", f));
                        paragraph.add("\n" + firma+ "\n");
                        paragraph.add(new Paragraph("Nombre:", f));
                        paragraph.add( "\n" + nombre + "\n");
                        paragraph.add(new Paragraph("Edad:", f));
                        paragraph.add("\n" + edad + " años" + "\n");
                        paragraph.add(new Paragraph("Mensaje:", f));
                        paragraph.add("\n" + mensaje);
                        
                        doc.add(paragraph);
                        doc.close();
                        salida.close();
                    } catch (Exception e) {
                        System.out.println("[Error]: " + e);
                    }

                    if (mensaje != null) {
                        JOptionPane.showMessageDialog(null, "Archivo guardado con exito");

                    } else {
                        JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Favor de Guardar documento PDF");
                }
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Generar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            Logger.getLogger(Generar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton2ActionPerformed
//Guardar la publica
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith(".key")) {

                try {
                    MetodosLLaves llaves = new MetodosLLaves();
                    String msjkeys;
                    msjkeys = GuardarArchivo(archivo, llaves.MetodosLLaves().getPublic());

                    if (msjkeys != null) {
                        //JOptionPane.showMessageDialog(null, "Archivo guardado con exito");
                        JOptionPane.showMessageDialog(null, msjkeys);
                    } else {
                        JOptionPane.showMessageDialog(null, "Archivo No Compatible");
                    }
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Generar.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor de Guardar documento .key");
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Generar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Generar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Generar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Generar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Generar().setVisible(true);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Generar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
