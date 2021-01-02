package generadordellaves;



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
import firmarpdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.misc.BASE64Encoder;
/**
 *
 * @author Navy
 */
public class MetodosLLaves {
    private KeyPairGenerator generador;
    private KeyPair llaves;
    private Signature firma;
    public MetodosLLaves () throws NoSuchAlgorithmException{
        //generador de la inscia del rsa
        generador = KeyPairGenerator.getInstance("RSA");
        //inicializar la llave
        generador.initialize(2048);
        ////creamos las llaves
        llaves = generador.genKeyPair();
    }
    public void guardarLlavePublica () throws FileNotFoundException, IOException {
        byte[] key = llaves.getPublic().getEncoded();
        FileOutputStream keyfos = new FileOutputStream("publicKey.key");
        keyfos.write(key);
        keyfos.close();
    }
    public void guardarLlavePrivada () throws FileNotFoundException, IOException {
        byte[] key = llaves.getPrivate().getEncoded();
        FileOutputStream keyfos = new FileOutputStream("privateKey.key");
        keyfos.write(key);
        keyfos.close();
    }
    
}
