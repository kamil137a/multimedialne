package jnativehookexample;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

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

	NetworkInterface network = NetworkInterface.getByInetAddress(ip);
        
	byte[] mac1 = network.getHardwareAddress();
        
	StringBuilder sb = new StringBuilder();
        
	for (int i = 0; i < mac1.length; i++) {
		sb.append(String.format("%02X%s", mac1[i], (i < mac1.length - 1) ? "-" : ""));
        }
        
        mac=sb.toString();
        return sb.toString();
	} catch (UnknownHostException e) {

		e.printStackTrace();

	} catch (SocketException e){

		e.printStackTrace();

	}
    return "";
    }
    
}
