/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author PanTomek
 */
public class PrintScreen extends TimerTask{
    

    
    
    /*
    
    public void getScreenshot() throws Exception {
      Toolkit tool = Toolkit.getDefaultToolkit();
      Dimension d = tool.getScreenSize();
      Rectangle rect = new Rectangle(d);
      Robot robot = new Robot();
      Thread.sleep(2000);
      File f = new File("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\screenshot"+System.currentTimeMillis()+".jpg");
      BufferedImage img = robot.createScreenCapture(rect);
      ImageIO.write(img,"jpeg",f);
}
*/
    @Override
    public void run() {
      MACaddress mac = new MACaddress();
      String s =mac.getmac();
      Toolkit tool = Toolkit.getDefaultToolkit();
      Dimension d = tool.getScreenSize();
      Rectangle rect = new Rectangle(d);
      Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(PrintScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

      File f = new File("C:\\Users\\PanTomek\\Desktop\\ThisOneFile\\"+s+"\\screenshot"+System.currentTimeMillis()+".jpg");
      BufferedImage img = robot.createScreenCapture(rect);
        try {
            ImageIO.write(img,"jpeg",f);
        } catch (IOException ex) {
            Logger.getLogger(PrintScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    


}
}