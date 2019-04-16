package lsystem.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import lsystem.Overlord;

import java.util.ArrayList;



public class Screen extends Application{

    private int height;
    private int width;
    private Overlord overi;

    public Screen(int h, int w, Overlord over) {
        this.height = h;
        this.width = w;
        overi = over;
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

    public static void main(String[] args) {
        launch(Screen.class);
    }

    public void draw(ArrayList<lsystem.Vector> drawlist, GraphicsContext gc) {
        gc.setLineWidth(2);
        for (lsystem.Vector vec : drawlist) {
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
