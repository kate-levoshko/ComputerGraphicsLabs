package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Computer Graphics, First Lab");
        Group myRoot = new Group();
        Scene scene = new Scene(myRoot, 700, 430);

        Polygon downPolygon = new Polygon(273, 387, 520, 371, 464,254,186, 202); //створення фігури
        downPolygon.setFill(Color.rgb(0, 255, 0)); //Встановимо зелений колір
        myRoot.getChildren().add(downPolygon); //додавання фігури до кореневого контейнера

        Line middleLine = new Line (179,197, 464, 250);
        middleLine.setStrokeWidth(7.0);
        myRoot.getChildren().add(middleLine); //додавання фігури до кореневого контейнера

        Polygon upperPolygon = new Polygon(183, 194, 464, 246, 639, 177, 361, 54);
        upperPolygon.setFill(Color.rgb(0, 255, 0)); //Встановимо зелений колір
        myRoot.getChildren().add(upperPolygon); //додавання фігури до кореневого контейнера

        Line downLine = new Line (98,339, 237, 287);
        downLine.setStrokeWidth(14.0);
        downLine.setStrokeLineCap(StrokeLineCap.ROUND);
        myRoot.getChildren().add(downLine); //додавання фігури до кореневого контейнера

        Line upperLine = new Line (114,61, 233, 165);
        upperLine.setStrokeLineJoin(StrokeLineJoin.ROUND);
        upperLine.setStrokeWidth(14.0);
        myRoot.getChildren().add(upperLine); //додавання фігури до кореневого контейнера

        Polygon triangle = new Polygon(496, 252, 539, 338, 608, 228);
        triangle.setFill(Color.rgb(255, 255, 0)); //Встановимо жовтий колір
        myRoot.getChildren().add(triangle); //додавання фігури до кореневого контейнера

        Rectangle upperRec = new Rectangle(301,171,16,16);
        upperRec.setFill(Color.rgb(0, 128, 0));
        myRoot.getChildren().add(upperRec); //додавання фігури до кореневого контейнера

        Rectangle downRec = new Rectangle(273,273,16,16);
        downRec.setFill(Color.rgb(0, 128, 0));
        myRoot.getChildren().add(downRec); //додавання фігури до кореневого контейнера

        scene.setFill(Color.rgb(0, 128, 128)); //заповнення сцени кольором

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
