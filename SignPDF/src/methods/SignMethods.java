/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.rmi.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import interfaz.Interfaz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Navy
 */
public class SignMethods extends UnicastRemoteObject implements Interfaz{
    KeyPairGenerator generador;
    KeyPair llaves;
    Signature sign;
    PrivateKey buffPrivate;
    byte[]firmabytes;
    //Constructor
    public SignMethods() throws RemoteException{
        super();
        try {
            generador = KeyPairGenerator.getInstance("RSA");
            generador.initialize(2048);
            llaves = generador.genKeyPair();
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            sign = Signature.getInstance("SHA256WithRSA", "BC");
            
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No existe el algoritmo ");
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            System.out.println("No existe el proveedor ");
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Verifica el contenido del pdf con la llave publica y el contenido del pdf
    @Override
    public boolean verificar(String pdfText, PublicKey pubKey) throws RemoteException{
        boolean verificado = false;
        try {
            //byte[] firmabytes = Base64.getDecoder().decode(getFirma(pdfText));          
            sign.initVerify(pubKey);
            sign.update((getNombre(pdfText)+getEdad(pdfText)+getMensaje(pdfText)).getBytes());
            verificado = sign.verify(firmabytes);
            System.out.println("Verificado: "+ verificado);
        } catch (InvalidKeyException | SignatureException ex) {
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        }      
        return verificado;
    }
    /*@Override
    //Genera una firma legibel en String
    public byte[] firmabytes(String pdfText, PrivateKey privKey) throws RemoteException{
        String firmado = "";
        try {
            sign.initSign(privKey);
            byte[] content = (getNombre(pdfText)+getEdad(pdfText)+getMensaje(pdfText)).getBytes();
            sign.update(content);
            firmaBytes = sign.sign();
            
            firmado = Base64.getEncoder().encodeToString(firmaBytes);
            System.out.println("Firma Generada");
        } catch (InvalidKeyException ex) {
            System.out.println("Llave Inavlida.");
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            System.out.println("Error al Firmar.");
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return firmaBytes;
    }*/
    public String firma(String pdfText, PrivateKey privKey) throws RemoteException{
        String firmado = "";
        try {
            sign.initSign(privKey);
            byte[] content = (getNombre(pdfText)+getEdad(pdfText)+getMensaje(pdfText)).getBytes();
            sign.update(content);
            firmabytes = sign.sign();
            
            firmado = Base64.getEncoder().encodeToString(firmabytes);
            System.out.println("Firma Generada");
        } catch (InvalidKeyException ex) {
            System.out.println("Llave Inavlida.");
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            System.out.println("Error al Firmar.");
            Logger.getLogger(SignMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return firmado;
    }
    @Override
    //Utiliza firma para meter la firma al pdf y crea el pdf con los requisitos de el formulario
    public void crear(String nombre, int edad, String mensaje, String Name, PrivateKey privKey) throws RemoteException{
        try {
            FileOutputStream file = new FileOutputStream(Name + ".pdf");
            Document doc = new Document();
            PdfWriter.getInstance(doc, file);
            doc.open();
            String pdfText = "Nombre:\n"+nombre+"\n-\nEdad:\n"+edad+"\n--\nMensaje:\n"+mensaje+"\n---";
            doc.add(new Paragraph(pdfText));
            doc.add(new Paragraph("\nFirma:\n" + this.firma(pdfText,privKey)+"\n--_-"));
            doc.close();
            System.out.println("Archivo Creado y Firmado.");
        } catch (Exception e) {
            System.out.println("Error al crear el PDF");
            e.printStackTrace();
        }
    }
    @Override
    //Guarda una llave, ya sea privada o publica
    public void guardarKey(Key llave, String archivo)  throws RemoteException, FileNotFoundException, IOException {
        //generarme un archivo .key
        byte[] llavepublic = llave.getEncoded();
        FileOutputStream fos = new FileOutputStream(archivo+".key");
        fos.write(llavepublic);
        fos.close();
        
    }
    @Override
    //Carga una llave publica
    public PublicKey cargarPublicaKey(String archivo)  throws RemoteException, FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        /*
        para poder exportar la llave publica es necesario codificarla mediante una codificacion
        certificada por X509 es para la certificacion de la llave
        */
        
        FileInputStream fis = new FileInputStream(archivo);
        //comprobacion si es valida 
        int numBytes = fis.available();
        byte[] bytes = new byte[numBytes];
        fis.read(bytes);
        fis.close();
        
        //para comprobar la llave
        KeyFactory keyfactory = KeyFactory.getInstance("RSA");
        //generar la subllaves
        KeySpec spec = new X509EncodedKeySpec(bytes);
        
        PublicKey llavePublic = keyfactory.generatePublic(spec);
        
        return llavePublic;
        
    }
    @Override
//Carga una llave privada
    public PrivateKey cargarPrivadaKey(String archivo)  throws RemoteException, FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        
        FileInputStream fis = new FileInputStream(archivo);
        //comprobacion si es valida 
        int numBytes = fis.available();
        byte[] bytes = new byte[numBytes];
        fis.read(bytes);
        fis.close();
        
        /*porque para la comprobacion de la llave privada, es necesario el 
        certificado por parte del estandar PKCS8 el cual nos dice el tipo 
        de codificacion que acepta una llave privada en RSA
        */
         //para comprobar la llave
        KeyFactory keyfactory = KeyFactory.getInstance("RSA");
        KeySpec spec = new PKCS8EncodedKeySpec(bytes);
        PrivateKey llavePrivate = keyfactory.generatePrivate(spec);
        return llavePrivate;
        
    }
    @Override
    //Envia la llave privada generada en esta instancia
    public PrivateKey getPrivate() throws RemoteException{
        return llaves.getPrivate();
    }
    @Override
    //Envia la llave publica generada en esta instancia
    //Un ejemplo de uso de este metodo es si neceitamos sacar una llave y guardarla luego con los metodos anteriores
    public PublicKey getPublic() throws RemoteException{
        return llaves.getPublic();
    }
    //Obtiene el dato basado en el formato con el que el pdf se creo
    //Nombre:  <mensaje>  -
    @Override
    public String getNombre(String pdfText) throws RemoteException{
        String nombre = StringUtils.substringBetween(pdfText, "Nombre:\n", "-").trim();
        return null;
    }
    //Obtiene el dato basado en el formato con el que el pdf se creo
    //Edad:  <mensaje>  --
    @Override
    public String getEdad(String pdfText) throws RemoteException{
        String edad = StringUtils.substringBetween(pdfText, "Edad:\n", "--").trim();
        return null;
    }
    @Override
    //Obtiene el dato basado en el formato con el que el pdf se creo
    //Mensaje:  <mensaje>  ---
    public String getMensaje(String pdfText) throws RemoteException{
        String Mensaje = StringUtils.substringBetween(pdfText, "Mensaje:\n", "---").trim();
        return null;
    }
    @Override
    //Obtiene el dato basado en el formato con el que el pdf se creo
    //Firma:  <firma>  --_-
    public String getFirma(String pdfText) throws RemoteException{
        ;
        String Firma = StringUtils.substringBetween(pdfText, "Firma:\n", "\n--_-");
        System.out.println(Firma);
        return null;
    }
    @Override
    //Obtiene el texto de un pdf
    public String getpdfText(String nombre) throws RemoteException{
            String pdfText ="";
        try{
            PdfReader lector = new PdfReader(nombre);
            int paginas = lector.getNumberOfPages();
            for (int i = 1; i <= paginas; i++) {
                pdfText = PdfTextExtractor.getTextFromPage(lector, i);
            }
        }catch(IOException e){
            System.out.println("Error de lectura");
            e.printStackTrace();
        }
        return pdfText;
    }
    @Override
    public void makeDirectory(File dir) throws RemoteException{
        if (!dir.exists()){
            dir.mkdirs();
        }
    }
  
}
