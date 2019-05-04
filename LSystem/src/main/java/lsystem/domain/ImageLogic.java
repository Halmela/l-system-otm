/**
 * Class transforms given string to a list of vectors used for drawing
 */


package lsystem.domain;

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
        drawList = drawListCreator(word);
    }


	/*
	 * Transforms given word to a list of actions
	 */

	private ArrayList<String> listFromWord(String word) {
        ArrayList<String> list = new ArrayList<>();

        for (String s : word.split("")) {   // split word to letters
            String[] rules = drawingRules.get(s);

            for (int i = 0; i < rules.length; i++) {
                if (!rules[i].equals("none")) {
                    list.add(rules[i]);
                }
            }
        }

        return list;
	}


	/**
	 * Constructs the instructions for drawing an image 
	 * based on a given string and drawing rules
     *
	 * @param	word	A string that is constructed by StringCreator
	 *
	 * @return	A list containing vectors for drawing
	 */

    public ArrayList<Vector> drawListCreator(String word) {
        ArrayList<Vector> list = new ArrayList<>();
        ArrayDeque<Vector> tmp = new ArrayDeque<>();

        double x = start.getStartX();
        double y = start.getStartY();
        double angle = Math.toRadians(270);
        double angleChange = start.getAngle();
        double length = 20;
        String lastAction = "";

        for (String action : listFromWord(word)) {
            if (action.equals("forward")) {
                Vector vec = new Vector(x, y, angle, length, 1);
                x = vec.getEndX();
                y = vec.getEndY();

                if (lastAction.equals(action)) {
                    list.get(list.size() - 1).addLength(vec.getLength());
                } else {
                    list.add(vec);
                }

            } else if (action.equals("push")) {
                tmp.push(list.get(list.size() - 1));

            } else if (action.equals("pop")) {
                Vector vec = tmp.pop();
                x = vec.getEndX();
                y = vec.getEndY();
                angle = vec.getAngle();

            } else if (action.equals("right")) {
                angle += angleChange;

            } else if (action.equals("left")) {
                angle -= angleChange;

            } else if (action.equals("end")) {
                // list.get(list.size() - 1).addWidth(-0.5);
                list.get(list.size() - 1).addLength(-0.5 * list.get(list.size() - 1).getLength());
            }
            lastAction = action;
        }
        return list;
    }


    public HashMap<String, String[]> getDrawingRules() {
        return drawingRules;
    }

    public ArrayList<Vector> getDrawList() {
        return drawList;
    }

    public void stringArrayPrinter(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }
}

