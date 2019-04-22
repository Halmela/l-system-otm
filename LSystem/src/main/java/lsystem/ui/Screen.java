package lsystem.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import lsystem.Overlord;
import lsystem.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Screen extends Application{

    private int height;
    private int width;
    private Overlord overi;
    private Scanner reader;

    public Screen() {

    }

    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Tuhoan maailman");
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        draw(overi.getImageLogic().getDrawList(), gc);

        ikkuna.setScene(new Scene(root));
        ikkuna.show();
    }

    public void init() {


        this.reader = new Scanner(System.in);
        CLI cli = new CLI(reader);

        this.overi = cli.command();
        this.width = cli.getWidth();
        this.height = cli.getHeight();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void draw(ArrayList<lsystem.Vector> drawlist, GraphicsContext gc) {
        for (lsystem.Vector vec : drawlist) {
            gc.setLineWidth(vec.getWidth());
            gc.strokeLine(vec.getStartX(), vec.getStartY(), vec.getEndX(), vec.getEndY());
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}
