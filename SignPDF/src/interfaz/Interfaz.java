/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.*;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

/**
 *
 * @author Navy
 */
public interface Interfaz extends Remote{
    public void makeDirectory(File dir) throws RemoteException;
    public String getpdfText(String nombre) throws RemoteException;
    public String getFirma(String pdfText) throws RemoteException;
    public String getMensaje(String pdfText) throws RemoteException;
    public String getEdad(String pdfText) throws RemoteException;
    public String getNombre(String pdfText) throws RemoteException;
    public PublicKey getPublic() throws RemoteException;
    public PrivateKey getPrivate() throws RemoteException;
    public PrivateKey cargarPrivadaKey(String archivo)  throws RemoteException, FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    public PublicKey cargarPublicaKey(String archivo)  throws RemoteException, FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException;
    public void guardarKey(Key llave, String archivo)  throws RemoteException, FileNotFoundException, IOException;
    public void crear(String nombre, int edad, String mensaje, String Name, PrivateKey privKey) throws RemoteException;
    public String firma(String pdfText, PrivateKey privKey) throws RemoteException;
  //  public byte[] firmabytes(String pdfText, PrivateKey privKey) throws RemoteException;
    public boolean verificar(String pdfText, PublicKey pubKey) throws RemoteException;
}
