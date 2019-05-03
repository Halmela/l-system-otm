package lsystem.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import lsystem.domain.Overlord;
import lsystem.domain.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Screen extends Application{

    private int height;
    private int width;
    private Overlord overi;
    private Scanner scanner;

    public Screen() {

    }

    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Puutuotin (" + width + "x" + height + ")");
        Group root = new Group();
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        draw(overi.getImageLogic().getDrawList(), gc);

        ikkuna.setScene(new Scene(root));
        ikkuna.show();
    }


    public void init() {


        this.scanner = new Scanner(System.in);
        CLI cli = new CLI(scanner);

        this.overi = cli.command();
        this.width = cli.getWidth();
        this.height = cli.getHeight();
    }

    public static void main(String[] args) {
        launch(args);
    }

	/**
	 * Draws given list of vectors to a canvas
	 *
	 * @param	drawlist	ArrayList containing every vector
	 * @param 	gc			A canvas 
	 *
	 * @see lsystem.ImageLogic#drawListCreator(String) 
	 */

    public void draw(ArrayList<lsystem.domain.Vector> drawlist, GraphicsContext gc) {
        for (lsystem.domain.Vector vec : drawlist) {
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
