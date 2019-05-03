/**
 * Overlord handles piping rulesets and strings between classes in correct format
 */


package lsystem.domain;

import lsystem.ui.Screen;

import java.util.ArrayList;
import java.util.HashMap;

public class Overlord {
    private StringCreator stringCreator;
    private ImageLogic imageLogic;

    private LSystem lSystem;


    public Overlord(LSystem lSystem) {
        this.lSystem = lSystem;

        stringCreator = new StringCreator(lSystem.getAxiom(), extractProductionRules(lSystem.getRuleset()));
        imageLogic = new ImageLogic(stringCreator.iterator(lSystem.getIterations()), extractDrawingRules(lSystem.getRuleset()), lSystem.getStartVec());
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
            String[] rules = new String[all.get(s).length - 1];

            for (int i = 0; i < rules.length; i++) {
                rules[i] = all.get(s)[i + 1];
            }

            drawRules.put(s, rules);
        }
        return drawRules;
    }


    public LSystem getLSystem() {
        return this.lSystem;
    }


    public StringCreator getStringCreator() {
        return stringCreator;
    }

    public ImageLogic getImageLogic() {
        return imageLogic;
    }
}
