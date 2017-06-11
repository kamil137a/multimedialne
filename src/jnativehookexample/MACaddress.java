/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author PanTomek
 */
public class MACaddress {
    public String mac;
    
    public void setmac(String mac){
        this.mac=mac;
    }
    public String getcurrmac(){
    return this.mac;
    }
    public String getmac(){
      InetAddress ip;
	try {

	ip = InetAddress.getLocalHost();
	//System.out.println("Current IP address : " + ip.getHostAddress());

	NetworkInterface network = NetworkInterface.getByInetAddress(ip);

	byte[] mac1 = network.getHardwareAddress();

	//System.out.print("Current MAC address : ");

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < mac1.length; i++) {
		sb.append(String.format("%02X%s", mac1[i], (i < mac1.length - 1) ? "-" : ""));
        }
        mac=sb.toString();
        return sb.toString();
        //System.out.println(sb.toString());
	} catch (UnknownHostException e) {

		e.printStackTrace();

	} catch (SocketException e){

		e.printStackTrace();

	}
    return "";
    }
    
}
