/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variables;

/**
 *
 * @author Escuela
 */
public class ipPort {
    private String ip = "189.130.207.34";
    private int port = 5357;
    
    private String iplocal = "127.0.0.1";
    private int portlocal = 1099;
    public ipPort(){
        //hacer local
        ip = iplocal;
        port = portlocal;
    }
    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }
    /**
     * @return the local ip
     */
    public String getIpLocal() {
        return iplocal;
    }

    /**
     * @return the local port
     */
    public int getPortLocal() {
        return portlocal;
    }
}
