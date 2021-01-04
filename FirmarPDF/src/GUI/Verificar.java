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
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Verificar extends javax.swing.JFrame {

    PdfReader reader;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .key y .pdf", "pdf", "key");

    public Verificar() {
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
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(514, 400));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(514, 75));
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Verificar");
        jPanel1.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sube los archivos que se te piden para verificar la autenticidad de tu pdf.");
        jPanel1.add(jLabel2);

        jButton3.setText("Elegir archivos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);

        getContentPane().add(jPanel1);

        jPanel2.setMinimumSize(new java.awt.Dimension(514, 270));
        jPanel2.setPreferredSize(new java.awt.Dimension(514, 270));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setPreferredSize(new java.awt.Dimension(257, 325));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Llave: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 271));

        jTextField1.setText("jTextField1");
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 210, 40));

        jPanel2.add(jPanel3);

        jPanel4.setPreferredSize(new java.awt.Dimension(257, 325));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("PDF:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jTextField2.setText("jTextField2");
        jTextField2.setMinimumSize(new java.awt.Dimension(200, 20));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 200, 40));

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2);

        jPanel5.setMinimumSize(new java.awt.Dimension(512, 55));
        jPanel5.setPreferredSize(new java.awt.Dimension(512, 55));

        jButton2.setText("Volver");
        jPanel5.add(jButton2);

        jButton1.setText("Verificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//verificar
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            String ruta = jTextField2.getText();
            if(ruta!=null){
            reader = new PdfReader(ruta);

            // pageNumber = 1
            String textFromPage = PdfTextExtractor.getTextFromPage(reader, 1);

            System.out.println(textFromPage);

            reader.close();
            }else{
                JOptionPane.showMessageDialog(null, "Porfavor ingresa el pdf");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed
//elegir
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            JFileChooser filechoose = new JFileChooser();
            filechoose.setFileFilter(filter);
            int opcion = filechoose.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {
                
                //Obtener nombre
                String name_pdf = filechoose.getSelectedFile().getName();
                //Obtener ruta
                String ruta = filechoose.getSelectedFile().getPath();
                jTextField2.setText(ruta);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Verificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Verificar().setVisible(true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
