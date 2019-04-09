package lsystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class ImageLogic {
    private ArrayDeque<Vector> drawStack;
    private HashMap<String, String> drawingRules;

    public ImageLogic(StringCreator sC) {
        drawingRules = rulesFromAlphabet(sC.getAlphabet());

    }



    public HashMap<String, String> rulesFromAlphabet(ArrayList<String> alphabet) {
        HashMap<String, String> rules = new HashMap<>();

        for (String s:alphabet) {
            switch (s) {
                case "[":   rules.put("[", "push left");
                            break;
                case "]":   rules.put("]", "pop right");
                            break;
                case "-":   rules.put("-", "right");
                            break;
                case "+":   rules.put("+", "left");
                            break;
                case "X":   rules.put("X", "none");
                            break;
                case "Y":   rules.put("Y", "none");
                            break;
                case "0":   rules.put("0", "forward end");
                            break;
                default:    rules.put(s, "forward");
            }
        }
        return rules;
    }

    public HashMap<String, String> getDrawingRules() {
        return drawingRules;
    }
}
