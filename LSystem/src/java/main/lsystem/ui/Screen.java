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


public class Screen extends Application{

    private int height;
    private int width;
    private Overlord overi;

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
        HashMap<String, String[]> allRules = new HashMap<>();

        String[] z = new String[3];
        z[0] = "1[0]0";
        z[1] = "forward";
        z[2] = "end";
        String[] o = new String[2];
        o[0] = "11";
        o[1] = "forward";
        allRules.put("0", z);
        allRules.put("1", o);

        int h = 1000;
        int w = 1000;
        double angle = 60;

        Vector vec = new Vector(w / 2, h, Math.toRadians(angle), 0);

        Overlord over = new Overlord("0", allRules, 2, vec);

        this.height = h;
        this.width = w;
        this.overi = over;

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
