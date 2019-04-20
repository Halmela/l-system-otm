/*
 * Core of L-system
 * Applies production rules to each letter of axiom as many times as wanted
 */

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
            System.out.println(j+": "+ axiom);
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
        StringBuilder output = new StringBuilder();
        output.append("\nAxiom: " + axiom +"\n");
        output.append("Alphabet: ");
        alphabet.forEach(a -> output.append(a +", "));
        output.deleteCharAt(output.length()-2);
        output.append("\nRules of production: \n");

        for (String rule : productionRules.keySet()) {
            output.append("\t" + rule + " -> " + productionRules.get(rule) + "\n");
        }

        return output.toString();
    }
}
