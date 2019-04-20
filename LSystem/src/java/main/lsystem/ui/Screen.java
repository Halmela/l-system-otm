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
        String[] f = new String[3];
        f[0] = "[";
        f[1] = "push";
        f[2] = "left";
        String[] d = new String[3];
        d[0] = "]";
        d[1] = "pop";
        d[2] = "right";
        allRules.put("0", z);
        allRules.put("1", o);
        allRules.put("[", f);
        allRules.put("]", d);

        int h = 1000;
        int w = 1000;
        double angle = 45;

        Vector vec = new Vector(w / 2, h, Math.toRadians(angle), 0, 0);

        Overlord over = new Overlord("0", allRules, 5, vec);
        System.out.println(over.getStringCreator());

        this.height = h;
        this.width = w;
        this.overi = over;

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
