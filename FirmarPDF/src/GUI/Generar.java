package GUI;
/*
 *                                                     ????
 *                                                   ,??????
 *                                                  @???????? ??,
 *                                               ??????????????????
 *                                             ??????????????????????
 *                                          ,@????????????????   ????
 *                                       ,????????????????????   ?????
 *                                    ,???????????????????????????????????
 *                                 ,@????????????????????????????????????????
 *                                ?????????????????????????????????????????????
 *                              ,????????????????????????????????????``?????????
 *                             ?????????????????????????                      ???
 *                           ,???????????????????????
 *                          ?????????????????????????@
 *                         ???????????????????????????
 *                        ????????????????????????????U
 *                       ??????????????????????????????
 *                      ???????????????????????????????
 *                     ??????????????????????????????????
 *                     ??????????????????????????????????@
 *                    ?????????????????????????????????????
 *                   ]??????????????????????????????????????
 *    ??             ????????????????????????????????????????
 *    ??            ]????????????????????????????????????????
 *    ??            ?????????????????????????????????????????
 *    ??            ?????????????????????????????????????????
 *    ??            ?????????????????????????????????????????L
 *    ??L           ?????????????????????????????????????????[
 *     ??           ??????????????????????????????????????????
 *     ??@          ??????????????????????????????????????????
 *      ???         ]?????????????????????????????????????????
 *       ??@         ?????????????????????????????????????????
 *        ????       ]????????????????????????????????????????
 *          ????      ????????????????????????????????????????
 *            ????     ???????????????????????????????????????
 *              "????, ]?????????????????????????????????????
 *                  ???????????????????????????????????????????,
 *                      "?????????????????????????????????????????

 */
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
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import firmarpdf.GeneradorDeClaves;
import java.io.*;
import java.security.KeyPair;
import java.security.PublicKey;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Generar extends javax.swing.JFrame {

    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    ObjectOutputStream obj;
    FileInputStream entrada;
    FileOutputStream salida;
    Document doc;
    MetodosLLaves llaves;
    MetodosLLaves2 llaves2;
<<<<<<< Updated upstream
    GeneradorDeClaves keys;
    PdfReader fondo ;
    PdfStamper stamper;
    private FileNameExtensionFilter filterPDF = new FileNameExtensionFilter("Archivos .pdf", "pdf");
    
    
    private FileNameExtensionFilter filterKEY = new FileNameExtensionFilter("Archivos .key", "key");
    public Generar() throws NoSuchAlgorithmException {
        llaves = new MetodosLLaves();
        llaves2 = new MetodosLLaves2();
        keys=new GeneradorDeClaves();
=======
    public Generar() throws NoSuchAlgorithmException {
        llaves = new MetodosLLaves();
        llaves2 = new MetodosLLaves2();
>>>>>>> Stashed changes
        initComponents();

    }

    public String GuardarPrivada(File Archivo, java.security.PrivateKey privada) {
        String mensaje = "";
        try {
<<<<<<< Updated upstream
            //obj = new ObjectOutputStream (new FileOutputStream(archivo));
            FileOutputStream fos = new FileOutputStream(Archivo);
            //obj.writeObject(privada.getEncoded());
            //obj.close();
            fos.write(privada.getEncoded());
            fos.close();
            mensaje = "Archivos Keys Guardado";
            
=======
            obj = new ObjectOutputStream (new FileOutputStream(archivo));
            obj.writeObject(publica);
            obj.close();
            mensaje = "Archivos Keys Guardado";
>>>>>>> Stashed changes
            /*salida = new FileOutputStream(archivo);
            byte[] key = publica.getEncoded();
            salida.write(key);
            salida.close();
            mensaje = "Archivos Keys Guardado";
            */
<<<<<<< Updated upstream
        } catch (Exception e) {
            System.out.println("[Error]: " + e);
        }
        return mensaje;
    }
    
       public String GuardarPublica(File Archivo, java.security.PublicKey publica) {
        String mensaje = "";
        try {
            FileOutputStream fos = new FileOutputStream(Archivo);
            fos.write(publica.getEncoded());
            fos.close();
            mensaje = "Archivos Keys Guardado";

=======
>>>>>>> Stashed changes
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
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        jTextField1.setMinimumSize(new java.awt.Dimension(100, 50));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel4.add(jTextField1);

        jLabel4.setText("Edad");
<<<<<<< Updated upstream
        jPanel4.add(jLabel4);
=======
        jPanel5.add(jLabel4);

        jTextField2.setMinimumSize(new java.awt.Dimension(100, 50));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel5.add(jTextField2);
>>>>>>> Stashed changes

        jTextField2.setMinimumSize(new java.awt.Dimension(100, 50));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 50));
        jPanel4.add(jTextField2);

        jLabel5.setText("Mensaje");
        jPanel4.add(jLabel5);

        jTextField3.setMinimumSize(new java.awt.Dimension(100, 50));
        jTextField3.setPreferredSize(new java.awt.Dimension(100, 50));
<<<<<<< Updated upstream
        jPanel4.add(jTextField3);
=======
        jPanel6.add(jTextField3);
>>>>>>> Stashed changes

        jPanel3.add(jPanel4);

        jButton4.setText("Enviar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);

        jButton3.setText("Guardar Priv");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);

<<<<<<< Updated upstream
        jButton7.setText("Guardar public");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);
=======
        jScrollPane1.setMinimumSize(new java.awt.Dimension(200, 60));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 60));
        jScrollPane1.setRequestFocusEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMinimumSize(new java.awt.Dimension(164, 50));
        jTextArea1.setPreferredSize(new java.awt.Dimension(164, 50));
        jScrollPane1.setViewportView(jTextArea1);
>>>>>>> Stashed changes

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField5.setText("jTextField5");
        jPanel6.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jButton5.setText("Seleccionar clave");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jTextField4.setText("jTextField4");
        jPanel6.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jButton6.setText("Seleccionar pdf");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 120, -1));

        jPanel3.add(jPanel6);

        jButton2.setText("Generar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2);

        jPanel7.add(jPanel8);

        jPanel3.add(jPanel7);

        jButton1.setText("Volver");
        jPanel3.add(jButton1);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//guardar PDF
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
<<<<<<< Updated upstream
        String nombre = jTextField1.getText();
        String edad = jTextField2.getText();
        String mensaje = jTextField3.getText();//trim
        String clavepriv = jTextField5.getText();
        String rutaarchivo = jTextField4.getText();
        //llaves2 = new MetodosLLaves2();
        //llaves.MetodosLLaves();
        //llaves.guardarLlavePublica(llaves.MetodosLLaves().getPublic());
        //llaves.guardarLlavePrivada(llaves.MetodosLLaves().getPrivate());
        
        
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith("pdf")) {
                //String msjkeys = GuardarArchivo(archivo, llaves.MetodosLLaves().getPublic());
                try {
                    //llaves.guardarLlavePublica(llaves.MetodosLLaves().getPublic());
                     salida = new FileOutputStream(seleccionar.getSelectedFile());
                     doc = new Document();
                    PdfWriter.getInstance(doc, new FileOutputStream(seleccionar.getSelectedFile()));

                    doc.open();
                    
                    String firma = llaves2.FirmarArchivo(archivo.getPath(), clavepriv);
                    
                   
                    Font f = new Font();
                    f.setStyle(Font.BOLD);
                    f.setSize(15);
                    Paragraph paragraph = new Paragraph();
                    paragraph.add(new Paragraph("Firma:", f));
                    paragraph.add(firma);//trim
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


    }//GEN-LAST:event_jButton2ActionPerformed
//Guardar la publica
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
=======
        try {

            String nombre = jTextField1.getText();
            String edad = jTextField2.getText();
            String mensaje = jTextField3.getText().trim();

            
            //llaves2 = new MetodosLLaves2();
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
                        //llaves.guardarLlavePublica(llaves.MetodosLLaves().getPublic());
                        salida = new FileOutputStream(seleccionar.getSelectedFile());
                        doc = new Document();
                        PdfWriter.getInstance(doc, salida);
                        doc.open();
                        Font f = new Font();
                        f.setStyle(Font.BOLD);
                        f.setSize(15);
                        Paragraph paragraph = new Paragraph();
                        paragraph.add(new Paragraph("Firma:", f));
                        paragraph.add(firma.trim());
                        paragraph.add(new Paragraph("Nombre:", f));
                        paragraph.add(nombre);
                        paragraph.add(new Paragraph("Edad:", f));
                        paragraph.add(edad);
                        paragraph.add(new Paragraph("Mensaje:", f));
                        paragraph.add(mensaje);
                        paragraph.add(new Paragraph("FIN", f));
                        doc.add(paragraph);
                        doc.close();
                        salida.close();
                    } catch (Exception e) {
                        System.out.println("[Error]: " + e);
                    }
>>>>>>> Stashed changes

        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith(".key")) {

                try {
                    String msjkeys;
                    msjkeys = GuardarPrivada(archivo, keys.generarClave().getPrivate());
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
//seleccionar clave privada
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                try {
            JFileChooser filechoose = new JFileChooser();
            filechoose.setFileFilter(filterKEY);
            int opcion = filechoose.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {
                
                //Obtener ruta
                String ruta = filechoose.getSelectedFile().getPath();
                jTextField5.setText(ruta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String nombre = jTextField1.getText();
        String edad = jTextField2.getText();
        String mensaje = jTextField3.getText();//trim
        //String clavepriv = jTextArea1.getText();
        //llaves2 = new MetodosLLaves2();
        //llaves.MetodosLLaves();
        //llaves.guardarLlavePublica(llaves.MetodosLLaves().getPublic());
        //llaves.guardarLlavePrivada(llaves.MetodosLLaves().getPrivate());
        
        
        if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith("pdf")) {
                //String msjkeys = GuardarArchivo(archivo, llaves.MetodosLLaves().getPublic());
                try {
                    //llaves.guardarLlavePublica(llaves.MetodosLLaves().getPublic());
                    salida = new FileOutputStream(seleccionar.getSelectedFile());
                    doc = new Document();
                    PdfWriter.getInstance(doc, salida);
                    doc.open();
                    
                    //String firma = llaves2.FirmarArchivo(archivo.getPath(), clavepriv);
                    
                    Font f = new Font();
                    f.setStyle(Font.BOLD);
                    f.setSize(15);
                    Paragraph paragraph = new Paragraph();
                    //paragraph.add(new Paragraph("Firma:", f));
                    //paragraph.add(firma);//trim
                    paragraph.add(new Paragraph("Nombre:", f));
                    paragraph.add(nombre);
                    paragraph.add(new Paragraph("Edad:", f));
                    paragraph.add(edad);
                    paragraph.add(new Paragraph("Mensaje:", f));
                    paragraph.add(mensaje);
                    paragraph.add(new Paragraph("FIN", f));
                    doc.add(paragraph);
                    //salida.close();
                    doc.close();
                    
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            JFileChooser filechoose = new JFileChooser();
            filechoose.setFileFilter(filterPDF);
            int opcion = filechoose.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {
                
                //Obtener nombre
                String name_pdf = filechoose.getSelectedFile().getName();
                //Obtener ruta
                String ruta = filechoose.getSelectedFile().getPath();
                jTextField4.setText(ruta);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            if (seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith(".key")) {

                try {
<<<<<<< Updated upstream
=======
                    
>>>>>>> Stashed changes
                    String msjkeys;
                    msjkeys = GuardarPublica(archivo, keys.generarClave().getPublic());
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
    }//GEN-LAST:event_jButton7ActionPerformed

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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
