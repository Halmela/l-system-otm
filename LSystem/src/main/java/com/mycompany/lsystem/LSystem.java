package com.mycompany.lsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class LSystem {
    private String axiom;
    private HashMap<String, String> productionRules;
    private ArrayList<String> alphabet;


    public LSystem(String axiom, HashMap productionRules) {
        this.axiom = axiom;
        this.productionRules = productionRules;
        this.alphabet = alphabetFromProductionRules();
    }


    private ArrayList<String> alphabetFromProductionRules() {
        ArrayList<String> alpha = new ArrayList<>();
        for (String rule : productionRules.values()) {
            for (String s : rule.split("")) {
                if (!alpha.contains(s)) {
                    alpha.add(s);
                }
            }
        }

        return alpha;
    }


    public String getAxiom() {
        return axiom;
    }

    public HashMap<String, String> getProductionRules() {
        return productionRules;
    }

    public ArrayList<String> getAlphabet() {
        return alphabet;
    }
}
