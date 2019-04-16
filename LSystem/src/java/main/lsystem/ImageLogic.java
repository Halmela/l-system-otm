package lsystem;

import lsystem.ui.Screen;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageLogic {
    private ArrayList<Vector> drawList;
    private HashMap<String, String[]> drawingRules;
    private Vector start;


    public ImageLogic(String word, HashMap<String, String[]> rules, Vector vec) {
        drawingRules = rules;
        start = vec;
        drawList = listCreator(word);
    }


	public ArrayList<String> listFromWord(String word) {
        ArrayList<String> list = new ArrayList<>();

        System.out.println(word);
        for (String s : word.split("")) {
            String[] rules = drawingRules.get(s);
            for (int i = 0; i < rules.length; i++) {
                list.add(rules[i]);
                System.out.println(rules[i]);
            }
        }

        return list;
	}


    public ArrayList<Vector> listCreator(String word) {
        ArrayList<Vector> list = new ArrayList<>();
        ArrayDeque<Vector> tmp = new ArrayDeque<>();

        double x = start.getStartX();
        double y = start.getStartY();
        double angle = 0;
        double angleChange = start.getAngle();
        int length = 5;

        for (String action : listFromWord(word)) {
            System.out.println(action);
            Vector vec = new Vector(x, y, angle, length);

            if (action.equals("forward")) {
                list.add(newVector(vec, angle, length));
            } else if (action.equals("push")) {
                tmp.add(list.get(list.size() - 1));
            } else if (action.equals("pop")) {
                vec = tmp.pop();
                x = vec.getEndX();
                y = vec.getEndY();
                angle = vec.getAngle();
                length = vec.getLength();
            } else if (action.equals("right")) {
                angle += angleChange;
            } else if (action.equals("left")) {
                angle += angleChange;
            }
        }
        return list;
    }


    public Vector newVector(Vector old, double angle, int length) {
        double x = old.getEndX();
        double y = old.getEndY();
        return new Vector(x, y, angle, length);
    }


    public HashMap<String, String[]> getDrawingRules() {
        return drawingRules;
    }

    public ArrayList<Vector> getDrawList() {
        return drawList;
    }
}

