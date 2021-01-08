/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.SignMethods;
import variables.ipPort;

/**
 *
 * @author Escuela
 */
public class Server {
    public static void main(String[] args){
        try {
            ipPort conexion = new ipPort();
            // TODO code application logic here
            Registry reg = LocateRegistry.createRegistry(conexion.getPort());
            SignMethods sm = new SignMethods();
            reg.rebind("sign", sm);
            System.out.println("Server ready");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
