package lsystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ImageLogic {
    private ArrayList<String> drawList;
    private HashMap<String, String[]> drawingRules;


    public ImageLogic(HashMap<String, String[]> drawingRules, String word) {
        drawingRules = drawingRules;
        drawList = listCreator(word);
    }


	public ArrayList<String> listCreator(String word) {
        ArrayList<String> list = new ArrayList<>();

        for (String s : word.split("")) {
            String[] rules = drawingRules.get(s);
            for (int i = 0; i < rules.length; i++) {
                list.add(rules[i]);
            }
        }

        return list;
	}



    public HashMap<String, String[]> getDrawingRules() {
        return drawingRules;
    }
}
