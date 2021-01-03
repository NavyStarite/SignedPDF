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
package firmarpdf;

import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Navy
 */
public class FirmarPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // TODO code application logic here
        
        // Prueba para ver si funcionan los metodos
        boolean valido = false;
        MetodosLLaves2 llaves = new MetodosLLaves2();
        byte[] dato = "Robin debe estar pensando en tony".getBytes(); 
        byte[] firmabytes = null;
        
        //firmabytes = llaves.FirmarDato(dato);
        System.out.println("Firmado");
        try {
            valido = llaves.Verificar(dato, firmabytes);
            if (valido) {
                System.out.println("Firma Correcta");
            }
            else{
                System.out.println("Firma Incorrecta");
            }
        } catch (SignatureException ex) {
            Logger.getLogger(FirmarPDF.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error o podria ser que sea firma incorrecta");
        }
    }
    
}
