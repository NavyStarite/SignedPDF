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

package GUI;

/**
 *
 * @author Escuela
 */
public class Menu extends javax.swing.JFrame {

    /** Creates new form Menu */
    public Menu() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(514, 271));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("¿Que desea hacer?");
        jPanel2.add(jLabel1, "card2");

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Generar Llaves");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("Firmar PDF");
        jPanel3.add(jButton2);

        jButton3.setText("Verificar PDF");
        jPanel3.add(jButton3);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
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
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

}
