package lsystem;

import lsystem.ui.Screen;

import java.util.ArrayList;
import java.util.HashMap;

public class Overlord {
    private StringCreator stringCreator;
    private ImageLogic imageLogic;

    private String axiom;
    private HashMap<String, String[]> allRules;
    private int iterations;


    public Overlord(String start, HashMap<String, String[]> rules, int iter, Vector vc) {
        axiom = start;
        allRules = rules;
        iterations = iter;

        stringCreator = new StringCreator(axiom, extractProductionRules(allRules));
        imageLogic = new ImageLogic(stringCreator.iterator(iter), extractDrawingRules(allRules), vc);
    }


    public HashMap<String, String> extractProductionRules(HashMap<String, String[]> all) {
        HashMap<String, String> prodRules = new HashMap<>();

        for (String s : all.keySet()) {
            prodRules.put(s, all.get(s)[0]);
        }
        return prodRules;
    }


    public HashMap<String, String[]> extractDrawingRules(HashMap<String, String[]> all) {
        HashMap<String, String[]> drawRules = new HashMap<>();

        for (String s : all.keySet()) {
            String[] rules = new String[all.get(s).length-1];

            for (int i = 0; i < rules.length; i++) {
                rules[i] = all.get(s)[i+1];
            }

            drawRules.put(s, rules);
        }
        return drawRules;
    }


    public String getAxiom() {
        return axiom;
    }

    public HashMap<String, String[]> getAllRules() {
        return allRules;
    }


    public StringCreator getStringCreator() {
        return stringCreator;
    }

    public ImageLogic getImageLogic() {
        return imageLogic;
    }
}
