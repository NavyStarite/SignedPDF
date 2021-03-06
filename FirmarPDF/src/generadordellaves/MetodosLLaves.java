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
import java.io.ObjectOutputStream;
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

    public MetodosLLaves() throws NoSuchAlgorithmException {
        //generador de la inscia del rsa
        generador = KeyPairGenerator.getInstance("RSA");
        //inicializar la llave
        generador.initialize(2048);
        ////creamos las llaves
        llaves = generador.genKeyPair();
    }

    public KeyPair MetodosLLaves() throws NoSuchAlgorithmException {
        //generador de la inscia del rsa
        generador = KeyPairGenerator.getInstance("RSA");
        //inicializar la llave
        generador.initialize(2048);
        ////creamos las llaves
        llaves = generador.genKeyPair();
        return llaves;
    }

    public void guardarLlavePublica(java.security.PublicKey publica) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        //byte[] key = llaves.getPublic().getEncoded();
        byte[] key = publica.getEncoded();
        FileOutputStream keyfos = new FileOutputStream("publicKey.key");
        keyfos.write(key);
        keyfos.close();
    }

    public void guardarLlavePrivada(java.security.PrivateKey privada) throws FileNotFoundException, IOException {
        //byte[] key = llaves.getPrivate().getEncoded();
        byte[] key = privada.getEncoded();
        FileOutputStream keyfos = new FileOutputStream("privateKey.key");
        keyfos.write(key);
        keyfos.close();
    }
    
    public void guardarLlavePublicaA() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        ObjectOutputStream keyfos=new ObjectOutputStream(new FileOutputStream("publicKey.key"));
        keyfos.writeObject(llaves.getPublic());
        keyfos.close();
    }

    public void guardarLlavePrivadaA() throws FileNotFoundException, IOException {
        //byte[] key = llaves.getPrivate().getEncoded();
        ObjectOutputStream keyfos=new ObjectOutputStream(new FileOutputStream("privateKey.key"));
        keyfos.writeObject(llaves.getPrivate());
        keyfos.close();
    }
    /*
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MetodosLLaves key = new MetodosLLaves();
        KeyPair k=key.MetodosLLaves();
        String ki=key.MetodosLLaves().toString();
        System.out.println(k.getPublic().getEncoded());
        
        
        System.out.println(k);
        System.out.println(ki);
    }
*/
}
