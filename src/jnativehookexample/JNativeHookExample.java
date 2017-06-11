/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;



//import java.awt.Image;

import java.io.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Calendar;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 *
 * @author x
 */
public class JNativeHookExample extends Application{

    /**
     * @param args the command line arguments
     */
    
    public int index=0,indextxt=0;
    public String s,s1;
    
    public int mYear;
    public int mMonth ;
    public int mDay;
    public int mHour ;
    public int mMin;
    public int mSec;

    
    public static void main(String[] args) throws Exception  {
        // TODO code application logic here
        Application.launch(args);
        
        
        
        
        
        
        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
       // KeyListener keyListener = new KeyListener();
       // PrintScreen ps = new PrintScreen();
        //MouseListener mouseListener = new MouseListener();
        //MouseWheelListener mouseWheelListener = new MouseWheelListener();
        

        //GlobalScreen.addNativeKeyListener(keyListener);
        //GlobalScreen.addNativeMouseListener(mouseListener);
        //GlobalScreen.addNativeMouseMotionListener(mouseListener);
        //GlobalScreen.addNativeMouseWheelListener(mouseWheelListener);

        Timer timer = new Timer();
        timer.schedule(new PrintScreen(), 0, 10000);
  
        
        
        Timer timer2 = new Timer();
        timer2.schedule(new RunKL(), 0, 10000);
        
       
        
        
        
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MACaddress mac = new MACaddress();
        String s = mac.getmac();
        File folder = new File("C:\\\\Users\\\\PanTomek\\\\Desktop\\\\ThisOneFile\\" + s);
        TextArea textArea = new TextArea();
        Label label = new Label();
        File[] listOfFiles = folder.listFiles(new FilenameFilter() {
        public boolean accept(File folder, String name) {
        return name.toLowerCase().endsWith(".jpg");
        }
        });
        
        File[] listOfFiles1 = folder.listFiles(new FilenameFilter() {
            public boolean accept(File folder, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        
        
        
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            }
        }
        
        
        
        primaryStage.setTitle("Load Image");
        Pane root = new Pane();
        Image img = new Image("file:"+listOfFiles[index]) ;
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(720);
        imgView.setFitWidth(1200);
        
        s = listOfFiles[index].getName();
        s=s.substring(10,23);
        Calendar calendar = Calendar.getInstance();        
        calendar.setTimeInMillis(Long.valueOf(s));
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR);
        mMin = calendar.get(Calendar.MINUTE);
        mSec = calendar.get(Calendar.SECOND);
        //label.setText(Integer.toString(mHour)+":"+Integer.toString(mMin)+":"+Integer.toString(mSec)+ " " + Integer.toString(mDay) +"/"+ Integer.toString(mMonth) +"/"+ Integer.toString(mYear));
        s1 = listOfFiles1[indextxt].getName();
        s1 = s1.substring(5, 18);
        /*
        while(s.compareTo(s1)<0){
        indextxt++;            
        s1 = listOfFiles1[indextxt].getName();
        s1 = s1.substring(5, 18);           
        }
        
        */
        
        //label.setText(Integer.toString(indextxt));
        if (listOfFiles1[indextxt] != null) {
            textArea.setText(readFile(listOfFiles1[indextxt]));
        }
        
        
        
        
        Button button1 = new Button("->");
        Button button2 = new Button("<-");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                index++;
                if(index >= listOfFiles.length){
                index=0;
                }
                String s;
                s = listOfFiles[index].getName();
                s = s.substring(10, 23);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.valueOf(s));
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                mHour = calendar.get(Calendar.HOUR);
                mMin = calendar.get(Calendar.MINUTE);
                mSec = calendar.get(Calendar.SECOND);
                label.setText(Integer.toString(mHour) + ":" + Integer.toString(mMin) + ":" + Integer.toString(mSec) + " " + Integer.toString(mDay) + "/" + Integer.toString(mMonth) + "/" + Integer.toString(mYear));

                System.out.println(listOfFiles.length);
                System.out.println(index);
                Image img = new Image("file:"+listOfFiles[index]) ;
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(720);
                imgView.setFitWidth(1200);
                root.getChildren().add(imgView);
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                index--;
                if (index < 0) {
                    index = listOfFiles.length-1;
                }
                
              
                if (listOfFiles1[indextxt] != null) {
                    textArea.setText(readFile(listOfFiles1[indextxt]));
                }
                
                
                String s;
                s = listOfFiles[index].getName();
                s = s.substring(10, 23);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.valueOf(s));
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                mHour = calendar.get(Calendar.HOUR);
                mMin = calendar.get(Calendar.MINUTE);
                mSec = calendar.get(Calendar.SECOND);
                label.setText(Integer.toString(mHour) + ":" + Integer.toString(mMin) + ":" + Integer.toString(mSec) + " " + Integer.toString(mDay) + "/" + Integer.toString(mMonth) + "/" + Integer.toString(mYear));
                System.out.println(listOfFiles.length);
                System.out.println(index);
                Image img = new Image("file:" + listOfFiles[index]);
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(720);
                imgView.setFitWidth(1200);
                root.getChildren().add(imgView);
            }
        });
        
        
        textArea.setLayoutX(10);
        textArea.setLayoutY(720);        
        button1.setLayoutX(1000);
        button1.setLayoutY(720);     
        button2.setLayoutX(900);
        button2.setLayoutY(720);
        label.setLayoutX(650);
        label.setLayoutY(720);
        root.getChildren().add(imgView);
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(textArea);
        root.getChildren().add(label);        
        Scene scene = new Scene(root);
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
        

        
    }

    private String readFile(File file) {
      StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;
         
        try {
 
            bufferedReader = new BufferedReader(new FileReader(file));
             
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(text);
                stringBuffer.append(System.getProperty("line.separator"));
            }
 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JNativeHookExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JNativeHookExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(JNativeHookExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
         
        return stringBuffer.toString();
    
    }


}
