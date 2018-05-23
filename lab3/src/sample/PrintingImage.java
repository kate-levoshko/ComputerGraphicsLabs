package sample;

/**
 * Created by Levoshko on 4/6/2018.
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PrintingImage extends Application{

    private HeaderBitmapImage image;
    private int numberOfPixels;

    public PrintingImage()
    {}

    public PrintingImage(HeaderBitmapImage image)
    {
        this.image = image;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


    }

    private String returnPixelColor (int color)
    {
        String col = "BLACK";
        switch(color)
        {
            case 0: return "BLACK";     //BLACK;
            case 1: return "LIGHTCORAL";  //LIGHTCORAL;
            case 2: return "GREEN";     //GREEN
            case 3: return "BROWN";     //BROWN
            case 4: return "BLUE";      //BLUE;
            case 5: return "MAGENTA";   //MAGENTA;
            case 6: return "CYAN";      //CYAN;
            case 7: return "LIGHTGRAY"; //LIGHTGRAY;
            case 8: return "DARKGRAY";  //DARKGRAY;
            case 9: return "RED";       //RED;
            case 10:return "LIGHTGREEN";//LIGHTGREEN
            case 11:return "YELLOW";    //YELLOW;
            case 12:return "LIGHTBLUE"; //LIGHTBLUE;
            case 13:return "LIGHTPINK";    //LIGHTMAGENTA
            case 14:return "LIGHTCYAN";    //LIGHTCYAN;
            case 15:return "WHITE";    //WHITE;
        }
        return col;
    }

   //public static void main (String args[]) {launch(args);}

}
