package lsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class StringCreator {
    private String axiom;
    private HashMap<String, String> productionRules;
    private ArrayList<String> alphabet;


    public StringCreator(String axiom, HashMap<String, String> productionRules) {
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


    public String ruleApplier(String word) {
        StringBuilder current = new StringBuilder();

        for (String s : word.split("")) {
            if (productionRules.keySet().contains(s)) {
                current.append(productionRules.get(s));
            } else
                current.append(s);
        }

        return current.toString();
    }


    public String iterator(int i) {
        String axiom = this.axiom;

        for (int j = 0; j < i; j++) {
            axiom = ruleApplier(axiom);
        }

        return axiom;
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

    @Override
    public String toString() {
        return "StringCreator{" +
                "axiom='" + axiom + '\'' +
                ", productionRules=" + productionRules +
                ", alphabet=" + alphabet +
                '}';
    }
}
