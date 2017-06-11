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
    public String getmac(){
      InetAddress ip;
	try {

	ip = InetAddress.getLocalHost();
	//System.out.println("Current IP address : " + ip.getHostAddress());

	NetworkInterface network = NetworkInterface.getByInetAddress(ip);

	byte[] mac = network.getHardwareAddress();

	//System.out.print("Current MAC address : ");

	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < mac.length; i++) {
		sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
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
